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
    private Double opmoney;//TODO
    private Timestamp optime;//TODO
    private String optype;
    private String transferid;
}
