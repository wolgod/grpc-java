package client.service;


import yages.YagesSchema;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public class BaseSSLServiceImpl extends BaseSSLService {

    public BaseSSLServiceImpl(String host, int port) {
        super(host, port);
    }

    @Override
    public void sayHello(String str) {
/*        HelloRequest request = HelloRequest.newBuilder()
                .setName(str)
                .build();*/
        YagesSchema.Empty empty= YagesSchema.Empty.newBuilder().build();
        YagesSchema.Content response;
        response = blockingStub.ping(empty);
        System.out.println("message from Grpc-server: " + response.getText());
        System.out.println();
    }

    @Override
    public String reverse(String str) {
        YagesSchema.Content content= YagesSchema.Content.newBuilder().setText(str).build();
        YagesSchema.Content response;
        response = blockingStub.reverse(content);
        System.out.println("message from Grpc-server: " + response.getText());
        return response.getText();
    }

}
