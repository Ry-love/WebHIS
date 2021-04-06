package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:SettleCategory
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 22:31
 */
@Data
@Entity
public class Settlecategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String settleCode;
    @Column
    private String settleName;
    @Column
    private int sequenceNo;
    @Column
    private int delMark;
}
