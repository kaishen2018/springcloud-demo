package com.softtek.irain.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by kaishen on 06/09/2018.
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userName;

    @Column(columnDefinition = "varchar(255) comment '居住地址'")
    private String homeAddress;

    private Long homeTel;

}