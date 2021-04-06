package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:User
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-14 12:16
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String realName;
    @Column
    private int useType;
    @ManyToOne
    @JoinColumn(name = "docTitleID")
    private Constantitem docTitleID;
    @Column
    private String isScheduling;
    @ManyToOne
    @JoinColumn(name = "deptID")
    private Department deptID;
    @ManyToOne
    @JoinColumn(name = "registLeID")
    private Registlevel registLeID;
    @Column
    private int delMark;
}
