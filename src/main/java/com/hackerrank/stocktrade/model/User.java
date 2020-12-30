package com.hackerrank.stocktrade.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "TRADE")
public class User {
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name")
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
