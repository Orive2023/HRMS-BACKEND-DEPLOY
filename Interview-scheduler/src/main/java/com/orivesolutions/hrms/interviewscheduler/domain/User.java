package com.orivesolutions.hrms.interviewscheduler.domain;

import com.orivesolutions.hrms.interviewscheduler.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(name = "emailId", unique = true, nullable = false)
    private String emailId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;

    @Column
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private String profileUrl;

    @Column(name = "forgetToken")
    private String forgetToken;

    @Column
    private Integer otp;

}
