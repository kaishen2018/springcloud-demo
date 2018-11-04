package com.softtek.irain.vo;

import lombok.Data;

/**
 * Created by kaishen on 06/09/2018.
 */
@Data
public class ServerResult<T> {
    private String code;
    private String message;
    private T data;

    public ServerResult(
            String code, String
            message,
            T obj)

    {
        this.code = code;
        this.message = message;
        this.data = obj;
    }

}
