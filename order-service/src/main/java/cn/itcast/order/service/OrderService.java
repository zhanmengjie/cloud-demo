package cn.itcast.order.service;

import cn.itcast.demo.clients.UserClient;
import cn.itcast.demo.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;
    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.findById(orderId);
        // 1.查询订单
//        String url ="http://userservice/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);

        /**
         * 使用feign实现远程调用
         */
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }
}
