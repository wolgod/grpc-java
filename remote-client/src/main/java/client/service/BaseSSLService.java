package client.service;


import client.grpc.EchoGrpc;
import io.grpc.Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public abstract class BaseSSLService {

    protected final ManagedChannel channel;
    protected final EchoGrpc.EchoBlockingStub blockingStub;

    public BaseSSLService(String host, int port) {
        TlsChannelCredentials.Builder tlsBuilder = TlsChannelCredentials.newBuilder();
        try {
            tlsBuilder.trustManager(new File("xxxxx.pem"));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        channel = Grpc.newChannelBuilderForAddress(host, port,tlsBuilder.build())
                 // 传输的数据大于4MB时，需要指定此参数
                .maxInboundMessageSize(Integer.MAX_VALUE)
                .build();
        blockingStub = EchoGrpc.newBlockingStub(channel);
    }

    public void shutdown() {
        try {
            channel.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void sayHello(String str);
    public abstract String reverse(String str);

}
