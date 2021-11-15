package com.lyh.springcloud.service;

/**
 * @author lyh
 * @date 2021/11/15
 */
public interface StorageService {
    void decrease(Long productId, Integer count);

}
