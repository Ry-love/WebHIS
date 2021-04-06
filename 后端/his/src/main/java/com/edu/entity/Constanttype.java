package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Constanttype
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-14 15:02
 */
@Data
@Entity
public class Constanttype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String constantTypeCode;
    @Column
    private String constantTypeName;
    @Column
    private int delMark;
}
