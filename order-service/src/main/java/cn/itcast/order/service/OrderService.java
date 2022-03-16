package cn.itcast.order.service;

import cn.blithe.feign.clients.UserClient;
import cn.blithe.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        User user = userClient.getUserById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }


   /* public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.利用 RestTemplate 发送http请求
        String url = "http://user-service/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        logger.info(url + user);
        order.setUser(user);
        // 4.返回
        return order;
    }*/
}
