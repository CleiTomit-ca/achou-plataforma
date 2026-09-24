package com.dev.v1.achou_api.model.enums;

public enum Role {
    CUSTOMER("CUSTOMER"),
    PROVIDER("PROVIDER"),
    ADMIN("ADMIN");

    final String name;

    Role(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
