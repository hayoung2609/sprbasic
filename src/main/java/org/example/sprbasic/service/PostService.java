package org.example.sprbasic.service;

import java.util.List;
import java.util.Map;

public interface PostService {
    Map<String, Object> create(Map<String, Object> param);
    List<Map<String, Object>> list();
    Map<String, Object> detail(int id);
    Map<String, Object> update(Map<String, Object> param);
    Map<String, Object> delete(int id);
}
