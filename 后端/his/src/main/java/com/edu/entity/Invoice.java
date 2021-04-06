package com.edu.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Invoice
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 22:15
 */
@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer invoiceNum;
    @Column
    private Double money;
    @Column
    private int state;
    @Column
    private Date creationTime;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User userID;
    @ManyToOne
    @JoinColumn(name = "registID")
    private Register registID;
    @ManyToOne
    @JoinColumn(name = "feeType")
    private Constantitem feeType;
    @Column
    private Integer back;
    @Column
    private int dailyState;

}
