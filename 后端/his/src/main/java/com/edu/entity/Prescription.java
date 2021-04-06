package com.edu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Prescription
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 18:39
 */
@Data
@Entity
public class Prescription {
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
    @JoinColumn(name = "userID")
    private User userID;
    @Column
    private String prescriptionName;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date prescriptionTime;
    @Column
    private int prescriptionState;
}
