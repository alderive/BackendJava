package com.example.TestBmx.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ApiResponse2 {
    private Map<String, Object> userMap = new HashMap<>();
    
    public ApiResponse2(final Map<String, Object> userMap) {}
    public ApiResponse2() {}


}