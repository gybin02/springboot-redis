### SpringBoot Redis 测试

#### Redis 教程：
http://www.runoob.com/redis

#### 问题：
##### 1.redis.clients.jedis.JedisPoolConfig 找不到这个类
```
//Spring-data-redis 依赖如下：
+--- org.springframework.boot:spring-boot-starter-data-redis -> 2.1.4.RELEASE
|    +--- org.springframework.boot:spring-boot-starter:2.1.4.RELEASE
|    |    +--- org.springframework.boot:spring-boot:2.1.4.RELEASE
|    |    |    +--- org.springframework:spring-core:5.1.6.RELEASE
|    |    |    |    \--- org.springframework:spring-jcl:5.1.6.RELEASE
|    |    |    \--- org.springframework:spring-context:5.1.6.RELEASE
|    |    |         +--- org.springframework:spring-aop:5.1.6.RELEASE
|    |    |         |    +--- org.springframework:spring-beans:5.1.6.RELEASE
|    |    |         |    |    \--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    |         |    \--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    |         +--- org.springframework:spring-beans:5.1.6.RELEASE (*)
|    |    |         +--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    |         \--- org.springframework:spring-expression:5.1.6.RELEASE
|    |    |              \--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    +--- org.springframework.boot:spring-boot-autoconfigure:2.1.4.RELEASE
|    |    |    \--- org.springframework.boot:spring-boot:2.1.4.RELEASE (*)
|    |    +--- org.springframework.boot:spring-boot-starter-logging:2.1.4.RELEASE
|    |    |    +--- ch.qos.logback:logback-classic:1.2.3
|    |    |    |    +--- ch.qos.logback:logback-core:1.2.3
|    |    |    |    \--- org.slf4j:slf4j-api:1.7.25 -> 1.7.26
|    |    |    +--- org.apache.logging.log4j:log4j-to-slf4j:2.11.2
|    |    |    |    +--- org.slf4j:slf4j-api:1.7.25 -> 1.7.26
|    |    |    |    \--- org.apache.logging.log4j:log4j-api:2.11.2
|    |    |    \--- org.slf4j:jul-to-slf4j:1.7.26
|    |    |         \--- org.slf4j:slf4j-api:1.7.26
|    |    +--- javax.annotation:javax.annotation-api:1.3.2
|    |    \--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    +--- org.springframework.data:spring-data-redis:2.1.6.RELEASE
|    |    +--- org.springframework.data:spring-data-keyvalue:2.1.6.RELEASE
|    |    |    +--- org.springframework.data:spring-data-commons:2.1.6.RELEASE
|    |    |    |    +--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    |    |    +--- org.springframework:spring-beans:5.1.6.RELEASE (*)
|    |    |    |    \--- org.slf4j:slf4j-api:1.7.25 -> 1.7.26
|    |    |    +--- org.springframework:spring-context:5.1.6.RELEASE (*)
|    |    |    +--- org.springframework:spring-tx:5.1.6.RELEASE
|    |    |    |    +--- org.springframework:spring-beans:5.1.6.RELEASE (*)
|    |    |    |    \--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    |    \--- org.slf4j:slf4j-api:1.7.25 -> 1.7.26
|    |    +--- org.springframework:spring-tx:5.1.6.RELEASE (*)
|    |    +--- org.springframework:spring-oxm:5.1.6.RELEASE
|    |    |    +--- org.springframework:spring-beans:5.1.6.RELEASE (*)
|    |    |    \--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    +--- org.springframework:spring-aop:5.1.6.RELEASE (*)
|    |    +--- org.springframework:spring-context-support:5.1.6.RELEASE
|    |    |    +--- org.springframework:spring-beans:5.1.6.RELEASE (*)
|    |    |    +--- org.springframework:spring-context:5.1.6.RELEASE (*)
|    |    |    \--- org.springframework:spring-core:5.1.6.RELEASE (*)
|    |    \--- org.slf4j:slf4j-api:1.7.25 -> 1.7.26
|    \--- io.lettuce:lettuce-core:5.1.6.RELEASE
|         +--- io.netty:netty-common:4.1.33.Final -> 4.1.34.Final
|         +--- io.netty:netty-handler:4.1.33.Final -> 4.1.34.Final
|         |    +--- io.netty:netty-common:4.1.34.Final
|         |    +--- io.netty:netty-buffer:4.1.34.Final
|         |    |    \--- io.netty:netty-common:4.1.34.Final
|         |    +--- io.netty:netty-transport:4.1.34.Final
|         |    |    +--- io.netty:netty-common:4.1.34.Final
|         |    |    +--- io.netty:netty-buffer:4.1.34.Final (*)
|         |    |    \--- io.netty:netty-resolver:4.1.34.Final
|         |    |         \--- io.netty:netty-common:4.1.34.Final
|         |    \--- io.netty:netty-codec:4.1.34.Final
|         |         +--- io.netty:netty-common:4.1.34.Final
|         |         +--- io.netty:netty-buffer:4.1.34.Final (*)
|         |         \--- io.netty:netty-transport:4.1.34.Final (*)
|         +--- io.netty:netty-transport:4.1.33.Final -> 4.1.34.Final (*)
|         \--- io.projectreactor:reactor-core:3.2.8.RELEASE
|              \--- org.reactivestreams:reactive-streams:1.0.2

``` 
需要补上：
```
    implementation group: 'redis.clients', name: 'jedis', version: '2.9.0'
//不能使用最新 3.0 版本 ；会报错： 找不到类：redis.clients.util.Pool 
    implementation group: 'redis.clients', name: 'jedis', version: '3.0.1'
```
#####. 提示:Caused by: java.net.ConnectException: Connection refused 

https://www.cnblogs.com/liusxg/p/5712493.html

redis默认只允许本地访问，要使redis可以远程访问可以修改redis.conf: 去除bind

同时重启redis服务器；
```
//下面的命令停止/启动/重启redis
/etc/init.d/redis-server stop
/etc/init.d/redis-server start
/etc/init.d/redis-server restart



//mac 安装并测试
 brew install redis
//测试远程连接 redis
redis-cli -h 45.77.131.205 -p 6379

测试发现可以远程连接上 redis。
```


### junit远程连接redis，还是连不上 sad。 可能原因：
1. spring 配置不对 


