package org.example.sprbasic.service.Impl;

import org.example.sprbasic.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    int tempId = 0;
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        String title = (String) param.get("title");
        String content = (String) param.get("content");
        String author = (String) param.get("author");

        Map<String, Object> post = new HashMap<>();
        post.put("id", ++tempId);
        post.put("title", title);
        post.put("content", content);
        post.put("author", author);
        list.add(post);

        Map<String, Object> returnVal = new HashMap<>();
        returnVal.put("id", tempId);
        returnVal.put("code", 200);

        return returnVal;
    }

    @Override
    public List<Map<String, Object>> list() {
        return list;
    }

    public Map<String, Object> get(int id) {
        for(Map<String, Object> each : list) {
            int eachId = Integer.parseInt(each.get("id") + "");
            if(eachId == id) {
                return each;
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> detail(int id) {
        return get(id);
    }

    @Override
    public Map<String, Object> update(Map<String, Object> param) {
        int code = 0;
        int id = Integer.parseInt(param.get("id") + "");
        Map<String, Object> tempPost = get(id);
        if (tempPost != null) {
            code = 200;
            String title = (String) param.get("title");
            String content = (String) param.get("content");
            String author = (String) param.get("author");
            tempPost.put("title", title);
            tempPost.put("content", content);
            tempPost.put("author", author);
        }
        Map<String, Object> returnValue = new HashMap<>();
        returnValue.put("code", code);
        return returnValue;
    }

    @Override
    public Map<String, Object> delete(int id){
        int code = 0;
        int tempI = -1;
        for(int i=0; i<list.size(); i++){
            if((int) list.get(i).get("id") == id){
                tempI = i;
            }
        }
        if(tempI != -1){
            code = 200;
            list.remove(tempI);
        }
        Map<String, Object> returnValue = new HashMap<>();
        returnValue.put("code", code);
        return returnValue;
    }
}
