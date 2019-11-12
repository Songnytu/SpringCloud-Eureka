package com.tutu.consumer.web;

import com.tutu.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        //user-service是之前在yaml配置的名字,可以同一个服务，启动多个，后面负载均衡要用所以用List集合
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从(服务列表)实例当中取出ip和端口
        ServiceInstance instance = instances.get(0);  //这个地方以后要自己写动态获取服务算法
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        User user = restTemplate.getForObject(url,User.class);
        return user;
    }
}
