package com.example.kyc_verification.Model;

public class Documents {

    String name;

    @Override
    public String toString() {
        return "Documents{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Documents(String name) {
        this.name = name;
    }
}
