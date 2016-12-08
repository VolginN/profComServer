package com.profCom.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by VolgiNN on 08.12.2016.
 */
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    public long id;

    @Column(name="firstName",nullable = false, length = 50)
    public String firstName;

    @Column(name="surName",nullable = false, length = 50)
    public String surName;

    @Column(name="lastName",nullable = false, length = 50)
    public String lastName;

    @Column(name="feePay")
    public boolean feePay;

    @Column(name="avatar")
    public byte[] avatar;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public boolean isFeePay() {
        return feePay;
    }
    public void setFeePay(boolean feePay) {
        this.feePay = feePay;
    }
    public byte[] getAvatar() {
        return avatar;
    }
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
