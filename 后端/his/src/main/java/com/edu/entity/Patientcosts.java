package com.edu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Patientcosts
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 22:46
 */
@Data
@Entity
public class Patientcosts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "registID")
    private Register registID;
    @ManyToOne
    @JoinColumn(name = "invoiceID")
    private Invoice invoiceID;
    @ManyToOne
    @JoinColumn(name = "itemID")
    private Expenseclass itemID;
    @Column
    private int itemType;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "deptID")
    private Department deptID;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;
    @ManyToOne
    @JoinColumn(name = "createOperID")
    private User createOperID;
    @Column
    private Date payTime;
    @ManyToOne
    @JoinColumn(name = "registerID")
    private User registerID;
    @ManyToOne
    @JoinColumn(name = "feeType")
    private Constantitem feeType;
    @Column
    private int backID;

}
