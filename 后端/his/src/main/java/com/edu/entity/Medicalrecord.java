package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Medicalrecord
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 10:03
 */
@Data
@Entity
public class Medicalrecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int caseNumber;
    @ManyToOne
    @JoinColumn(name = "registID")
    private Register registID;
    @Column
    private String readme;
    @Column
    private String present;
    @Column
    private String presentTreat;
    @Column
    private String history;
    @Column
    private String allergy;
    @Column
    private String physique;
    @Column
    private String proposal;
    @Column
    private String careful;
    @Column
    private String checkResult;
    @Column
    private String diagnosis;
    @Column
    private String handling;
    @Column
    private String caseState;
}
