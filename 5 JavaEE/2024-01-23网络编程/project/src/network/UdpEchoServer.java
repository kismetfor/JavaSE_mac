package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        while (true) {
            System.out.println("服务器启动!!!");
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);

            String request = new String(requestPacket.getData(),
                    0, requestPacket.getLength());
            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);

            System.out.printf("[%s %d] req: %s, resp: %s", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        if (request.equals("懂了")) {
            return "我也是";
        }
        return "你好";
    }

    public static void main(String[] args) throws IOException{
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
