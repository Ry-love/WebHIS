package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Registlevel
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-14 15:12
 */
@Data
@Entity
public class Registlevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String registCode;
    @Column
    private String registName;
    @Column
    private int sequenceNo;
    @Column
    private Double registFee;
    @Column
    private int registQuota;
    @Column
    private int delMark;

}
