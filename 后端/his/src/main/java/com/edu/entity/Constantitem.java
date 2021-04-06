package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Constantitem
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-14 14:53
 */
@Data
@Entity
public class Constantitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "constantTypeID")
    private Constanttype constantTypeID;
    @Column
    private String constantCode;
    @Column
    private String constantName;
    @Column
    private int delMark;
}
