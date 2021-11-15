package com.lyh.springcloud.service;

import java.math.BigDecimal;

/**
 * @author lyh
 * @date 2021/11/15
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
