package com.app.stefanp.model;

import org.springframework.transaction.ReactiveTransaction;

public enum Status
{
    REGISTERED("REGISTERED"),
    PROCESSING("PROCESSING"),
    REJECTED("REJECTED"),
    COMPLETED("COMPLETED");

    private String name;

    Status(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }


}
