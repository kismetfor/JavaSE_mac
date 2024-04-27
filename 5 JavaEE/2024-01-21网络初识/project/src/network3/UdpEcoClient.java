package network3;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

 class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int ServerPort;


    public UdpEchoClient(String serverIp, int ServerPort) throws SocketException {
        this.serverIp = serverIp;
        this.ServerPort = ServerPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException, InterruptedException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //1.从控制台读取要发送的请求数据
            if (!scanner.hasNext()) break;
            String request = scanner.next();
            //2. 构造请求并发送
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), ServerPort);
            socket.send(requestPacket);
            Thread.sleep(100);

            //3. 读取服务器的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            //4. 把响应显示到服务器上
            String response = new String(responsePacket.getData(), 0,
                    responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }

}
