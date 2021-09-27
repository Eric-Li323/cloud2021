package com.lyh.springcloud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author lyh
 * @date 2021/9/27
 */
@Configurable
public class GateWayConfig {

    //路由配置的第二种方法： 配置bean
    /**
     * 配置了一个id为route-name的路由规则，当访问地位为http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     * @Param: routeLocatorBuilder
     * @return org.springframework.cloud.gateway.route.RouteLocator
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_lyh",r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();
    }

}
