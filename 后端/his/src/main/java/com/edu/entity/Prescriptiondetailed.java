package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:PrescriptionDetailed
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 18:43
 */
@Data
@Entity
public class Prescriptiondetailed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "prescriptionID")
    private Prescription prescriptionID;
    @ManyToOne
    @JoinColumn(name = "drugsID")
    private Drugs drugsID;
    @Column
    private String drugsUsage;
    @Column
    private String dosage;
    @Column
    private String frequency;
    @Column
    private int amount;
    @Column
    private int state;
}
