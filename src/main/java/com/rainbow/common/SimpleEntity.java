package com.rainbow.common;

import java.io.Serializable;

/**
 * Created by rainbow on 2016/7/28.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class SimpleEntity implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
