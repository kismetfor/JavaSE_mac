package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    public UdpEchoClient( String serverIP, int serverPort) throws IOException {
        this.socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    public void start() throws IOException{
        System.out.println("客户端启动");
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (!sc.hasNext()) break;
            String request = sc.next();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIP),
                    serverPort);
            socket.send(requestPacket);


            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(),
                    0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException{
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
