package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    public UdpEchoClient(int port) throws SocketException {
        socket = new DatagramSocket();
    }


    public void start() throws IOException {
        while (true) {
            //1.读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            // 2.根据请求计算响应(对于回显服务器来说，这一步啥都不用做)
            
            // 3.把响应返回到客户端，

        }
    }
}
