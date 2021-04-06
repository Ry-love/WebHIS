package com.edu.entity;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Disease
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 10:13
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String diseaseCode;
    @Column
    private String diseaseName;
    @Column
    private String diseaseICD;
    @ManyToOne
    @JoinColumn(name = "diseCategoryID")
    private Disecategory diseCategoryID;
    @Column
    private int delMark;

}
