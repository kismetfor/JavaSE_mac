package network1;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

 class UdpEchoServer {
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    //服务器的启动逻辑
    public void start() throws IOException {
        System.out.println("服务器启动!!!!");
        //网络编程，读写 socket 本质上也是 IO 因此异常为IO
        while (true) {
            //1.读取请求并解析

            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            //此处 receive 读取到UDP数据报
            socket.receive(requestPacket);
            //如果执行到 receive 的时候，此时还没有客户端发来请求呢~~ receive咋办，读啥??
            //先阻塞等待~~

            // 2.根据请求计算响应(对于回显服务器来说，这一步啥都不用做)

            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            String response = process(request);

            // 3.把响应返回到客户端，

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);

            //打印日志
            System.out.printf("[%s:%d] req: %s, resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException{
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();

    }
}
