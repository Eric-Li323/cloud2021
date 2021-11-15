package com.lyh.springcloud.service.impl;

import com.lyh.springcloud.dao.OrderDao;
import com.lyh.springcloud.domain.Order;
import com.lyh.springcloud.service.AccountService;
import com.lyh.springcloud.service.OrderService;
import com.lyh.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyh
 * @date 2021/11/11
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /*
    * 创建订单-> 调用库存服务扣减库存-> 调用账号服务扣减账号余额-> 修改订单状态
    * 简单说： 下订单-> 减库存-> 减余额-> 改状态
    */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)  //全局事务回滚 参数name起什么名称都可以，具有唯一性即可
    public void create(Order order) {
        log.info("------>开始新建订单");
        //1 新建订单
        orderDao.create(order);

        log.info("------->订单微服务开始调用库存，做扣减Count");
        //2 扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务开始调用库存，做扣减end");

        log.info("------->订单微服务开始调用库存，做扣减Money");
        //3 扣减账号
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->订单微服务开始调用库存，做扣减end");

        //4 修改订单状态，从零到1， 1表示已经完成
        log.info("------>修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------>修改订单状态结束");

        log.info("------>下订单结束了，O(∩_∩)O哈哈~");

    }
}
