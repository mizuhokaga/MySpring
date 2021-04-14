package com.yc.springframework;

import com.yc.springframework.stereotype.MyComponentScan;
import com.yc.springframework.stereotype.MyConfiguration;
import org.springframework.context.annotation.ComponentScan;


@MyConfiguration
@MyComponentScan(basePackages = {"com.yc.springframework.bean", "com.yc.springframework.biz","com.yc.springframework.dao"})
public class MyAppConfig {
}
