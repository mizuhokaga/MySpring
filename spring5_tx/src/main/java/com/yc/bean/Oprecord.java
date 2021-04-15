package com.yc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Oprecord {
    private Integer id;
    private Integer accountid;
    private Double opomoney;
    private Timestamp optime;       //可能有问题
    private String optype;          //可能有问题
    private String transferid;
}
