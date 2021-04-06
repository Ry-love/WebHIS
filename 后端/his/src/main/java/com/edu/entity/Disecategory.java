package com.edu.entity;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Disecategory
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 10:16
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Disecategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String dicaCode;
    @Column
    private String dicaName;
    @Column
    private int  sequenceNo;
    @Column
    private int dicaType;
    @Column
    private int delMark;

}
