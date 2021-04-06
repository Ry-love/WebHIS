package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Drugsdetailed
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 16:47
 */
@Data
@Entity
public class Drugsdetailed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "drugsTempID")
    private Drugstemplate drugsTempID;
    @ManyToOne
    @JoinColumn(name = "drugsID")
    private Drugs drugsID;
    @Column
    private String drugsUsage;
    @Column
    private String dosage;
    @Column
    private String frequency;
}
