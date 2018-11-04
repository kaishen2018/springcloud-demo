package com.softtek.irain.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Greeting implements Serializable {

    private long id = 0;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting(String content) {
        this.content = content;
    }
}
