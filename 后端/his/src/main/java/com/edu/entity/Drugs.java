package com.edu.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Drug
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 16:48
 */
@Data
@Entity
public class Drugs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String drugsCode;
    @Column
    private String drugsName;
    @Column
    private String drugsFormat;
    @Column
    private String drugsUnit;
    @Column
    private String manufacturer;
    @ManyToOne
    @JoinColumn(name = "drugsDosageID")
    private Constantitem drugsDosageID;
    @ManyToOne
    @JoinColumn(name = "drugsTypeID")
    private Constantitem drugsTypeID;
    @Column
    private Double drugsPrice;
    @Column
    private String mnemonicCode;
    @Column
    private Date creationDate;
    @Column
    private Date lastUpdateDate;
    @Column
    private int delMark;


}
