package org.example.sprbasic.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages={"org.example.sprbasic.mapper"}, sqlSessionFactoryRef="sqlSessionFactory")
//베이스 페키지는 내 자바 메퍼 파일의 위치를 설명해주는 것 입니다!
public class MybatisConfig {
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("org.example.sprbasic.dto"); //dto 있는 패키지 주소 적는 곳!!!
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/*.xml"));
        // 자바 메퍼 파일이랑 연결될 xml 파일의 위치를 알려주는 코드!
        return sqlSessionFactoryBean.getObject();
    }
}
