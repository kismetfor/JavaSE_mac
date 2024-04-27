package network3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        while (true) {
            System.out.println("服务器启动!!!");
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
