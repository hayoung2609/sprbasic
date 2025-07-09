package org.example.sprbasic.repository;

import org.example.sprbasic.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
// Jpa는 Board라는 Entity와 관련있다.(위처럼 상속만해도 사용 가능)   <generic>에는 class 자료형만 가능.

}
