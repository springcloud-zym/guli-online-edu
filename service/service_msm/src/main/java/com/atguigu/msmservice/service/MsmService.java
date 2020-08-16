package com.atguigu.msmservice.service;

import java.util.Map;

/**
 * @author
 * @date 2020/7/22-15:42
 */
public interface MsmService {
    boolean send(String code, String phone);
}
