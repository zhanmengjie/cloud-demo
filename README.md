# cloud-demo
黑马-SpringCloud学习日记
1:Eureka注册中心
2:Ribbon 负载均衡
3:Nacos 注册中心
4:Feign 远程调用 ，性能优化
       -- 执行步骤
            - 1：引入Feign依赖
            - 2: 添加注解(@EnableFeignClients)
            - 3: 编写Feign的客户端 ,编写FeignClient接口
            - 4: 使用FeignClient中定义的方法代替RestTemplate
5:gateWay 网关
       -- 执行步骤:
            - 1：引入网关依赖，nacos服务发现依赖
            - 2：编写基础配置和路由规则
       -- 路由过滤器，默认过滤器(defaultFilter)，全局过滤器(globalFilter)
          排序规则:
            - 每一个过滤器都必须指定一个int类型的order值，**order值越小，优先级越高，执行顺序越靠前**。
            - GlobalFilter通过实现Ordered接口，或者添加@Order注解来指定order值，由我们自己指定
            - 路由过滤器和defaultFilter的order由Spring指定，默认是按照声明顺序从1递增。
            - 当过滤器的order值一样时，会按照 defaultFilter > 路由过滤器 > GlobalFilter的顺序执行
       -- 解决跨域问题
          配置文件：
            spring:
   cloud:
    gateway:
      # 。。。
      globalcors: # 全局的跨域处理
        add-to-simple-url-handler-mapping: true # 解决options请求被拦截问题
        corsConfigurations:
          '[/**]':
            allowedOrigins: # 允许哪些网站的跨域请求 
              - "http://localhost:8090"
            allowedMethods: # 允许的跨域ajax的请求方式
              - "GET"
              - "POST"
              - "DELETE"
              - "PUT"
              - "OPTIONS"
            allowedHeaders: "*" # 允许在请求中携带的头信息
            allowCredentials: true # 是否允许携带cookie
            maxAge: 360000 # 这次跨域检测的有效期
