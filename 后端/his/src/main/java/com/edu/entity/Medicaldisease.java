package com.edu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
 *@PackageName:com.edu.entity
 *@ClassName:MedicalDisease
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 10:10
 */
@Data
@Entity
public class Medicaldisease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "medicalID")
    private Medicalrecord medicalID;
    @ManyToOne
    @JoinColumn(name = "registID")
    private Register registID;
    @ManyToOne
    @JoinColumn(name = "diseaseID")
    private Disease diseaseID;
    @Column
    private int diagnoseType;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date getSiskDate;
    @Column
    private int diagnoseCate;

}
