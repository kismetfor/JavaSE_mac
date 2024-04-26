package network1;

import java.net.DatagramSocket;
import java.net.SocketException;

public class DdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;


    public DdpEchoClient(String serverIp, int serverPort) throws SocketException{
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public void start() {
        System.out.println("客户端启动");
        while (true) {
            //从控制台读取要发送的请求数据
        }
    }
    public static void main(String[] args) {

    }
}
