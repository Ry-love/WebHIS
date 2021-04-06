package com.edu.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Expenseclass
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 22:49
 */
@Data
@Entity
public class Expenseclass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String expCode;
    @Column
    private String expName;
    @Column
    private int delMark;

}
