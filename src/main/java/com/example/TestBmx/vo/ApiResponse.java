package com.example.TestBmx.vo;

import lombok.Data;

@Data
public class ApiResponse<T> {
	
	private Integer status;
	private String message;
    private T data;
    
    public ApiResponse(Integer status, String message, T data) {}
    
    public ApiResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}