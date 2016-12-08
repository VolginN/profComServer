package com.profCom.entity;

import javax.persistence.*;

/**
 * Created by VolgiNN on 08.12.2016.
 */
@Entity
@Table(name="Password")
public class Password {

    @Id
    @Column(name="login",nullable = false)
    public String login;

    @Column(name="password",nullable = false)
    public String password;

    @OneToOne
    @JoinColumn(name="id")
    public User user;
}
