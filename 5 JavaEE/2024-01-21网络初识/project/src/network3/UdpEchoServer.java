package network3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //算是单例模式中的懒汉模式
    //不调用构造方法就不初始化一个对象
    DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        //服务器需要指定端口号,方便客户端找得到端口进行来连接
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        while (true) {
            System.out.println("服务器启动!!!");
            //三种new DatagramPacket的方法, 这是用于接收信息的数据包, 因此给个空的方便存储
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);

            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getAddress(), requestPacket.getPort());
            socket.send(responsePacket);

            System.out.printf("[%s %d] req: %s , resp: %s \n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        if (request.equals("吃了吗")) {
            return "没吃";
        } else if (request.equals("原神")) {
            return "启动";
        }
        return "玩原神玩的";
    }

    public static void main(String[] args) throws IOException{
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
