package com.george.spring_jwt_demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder
public class BaseResponse<D> {
    Boolean status;
    D data;
    String message;
}
