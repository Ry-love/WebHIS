package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Department
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-14 15:06
 */
@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String deptCode;
    @Column
    private String deptName;
    @ManyToOne
    @JoinColumn(name = "deptCategoryID")
    private Constantitem deptCategoryID;
    @Column
    private int deptType;
    @Column
    private int delMark;
}
