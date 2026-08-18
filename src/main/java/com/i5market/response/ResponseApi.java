package com.i5market.response;

public record ResponseApi<T> (
        String message,
        T data
) {
}