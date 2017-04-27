package com.example.fadni.week4class;

/**
 * Created by Fadni on 13/04/2017.
 */

public class Idea {
    private String item;
    private String desc;

    Idea(String itemName, String itemDesc) {
        item = itemName;
        desc = itemDesc;
    }

    public String getIdea() {
        return item;
    }

    public String getDesc() {
        return desc;
    }
}
