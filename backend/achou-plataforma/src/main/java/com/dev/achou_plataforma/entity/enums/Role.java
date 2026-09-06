package com.dev.achou_plataforma.entity.enums;

public enum Role {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER"),
    SERVICE_PROVIDER("SERVICE_PROVIDER");

    final String name;
    Role(String name){
        this.name = name;
    }
}
