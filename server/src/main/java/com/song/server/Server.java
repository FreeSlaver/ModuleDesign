package com.song.server;

import com.song.server.route.user.UserLoginRoute;
import com.song.server.route.user.UserLogoutRoute;
import com.song.server.route.user.UserLogupRoute;
import com.song.server.route.user.UserQueryRoute;
import com.song.server.service.ConfigService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spark.Spark;

import static spark.Spark.*;


/**
 * Created by 00013708 on 2017/8/3.
 */
public class Server {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        ConfigService configService = context.getBean(ConfigService.class);


        Spark.port(configService.getServerPort());
        Spark.threadPool(configService.getMaxThreads(), configService.getMinThreads(),
                configService.getIdleTimeoutMillis());

        //我们这里都是一个请求路径对应一个route，
        Spark.staticFileLocation("/public");


        path("/user", () -> {
            //before("/*", (q, a) -> log.info("Received api call"));
            post("/logup",context.getBean(UserLogupRoute.class));
            post("/login",     context.getBean(UserLoginRoute.class));
            get("/logout",    context.getBean(UserLogoutRoute.class));
            get("/query", context.getBean(UserQueryRoute.class));
        });
        //我想搞成那种瀑布流的，先填写基本信息，然后填写项目信息，最后填技术栈，
        //很明显的是，每次到下一步都应该是提交操作，保存到数据库，和uid建立关联。

    }
}
