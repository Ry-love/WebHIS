package com.edu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Register
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 22:19
 */
@Data
@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int caseNumber;
    @Column
    private String realName;
    @ManyToOne
    @JoinColumn(name = "gender")
    private Constantitem gender;
    @Column
    private String idNumber;
    @Column
    private Date birthDate;
    @Column
    private int age;
    @Column
    private String ageType;
    @Column
    private String homeAddress;
    @Column
    private Date visitDate;
    @Column
    private String noon;
    @ManyToOne
    @JoinColumn(name = "deptID")
    private Department deptID;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User userID;
    @ManyToOne
    @JoinColumn(name = "registLeID")
    private Registlevel registLeID;
    @ManyToOne
    @JoinColumn(name = "settleID")
    private Settlecategory settleID;
    @Column
    private String isBook;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date registTime;
    @ManyToOne
    @JoinColumn(name = "registerID")
    private User registerID;
    @Column
    private int visitState;
}
