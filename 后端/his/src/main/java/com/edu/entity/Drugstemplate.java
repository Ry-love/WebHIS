package com.edu.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
 *@PackageName:com.edu.entity
 *@ClassName:Drugstemplate
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 16:44
 */
@Data
@Entity
public class Drugstemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User userID;
    @Column
    private Date creationTime;
    @Column
    private int scope;
    @Column
    private int delMark;
}
