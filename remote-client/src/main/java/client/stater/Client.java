package client.stater;

import client.service.BaseSSLService;
import client.service.BaseSSLServiceImpl;
import client.service.BaseService;
import client.service.BaseServiceImpl;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public class Client {
    public static void main(String[] args) {
//        BaseSSLService client = new BaseSSLServiceImpl("grpctest2.bitautotech.com:443");
//        client.sayHello("我是一名保安，保卫一方平安，爱吃小熊饼干，喜欢业主晓丹");
//        client.reverse("shaoheshan");
//
//        client.shutdown();

        BaseService client = new BaseServiceImpl("grpctest2.bitautotech.com",9081);
        client.sayHello("我是一名保安，保卫一方平安，爱吃小熊饼干，喜欢业主晓丹");
        client.reverse("shaoheshan");

        client.shutdown();
    }
}
