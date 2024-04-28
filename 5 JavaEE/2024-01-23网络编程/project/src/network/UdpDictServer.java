package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer {
    private HashMap<String, String> hashMap = new HashMap<>();


    @Override
     public String process(String request) {
        // 根据请求查询字典
        String result = hashMap.get(request);
        if (result != null) {
            return result;
        } else {
            return "对不起，找不到这个单词的翻译";
        }
    }

    public UdpDictServer(int port) throws SocketException {
        super(port);
        initializeDictionary();
    }

    private void initializeDictionary() {
        hashMap.put("cat", "猫");
        hashMap.put("dog", "狗");
        hashMap.put("chicken", "坤坤");
        hashMap.put("young", "年轻人");
        hashMap.put("elderly", "过了中年的");
        hashMap.put("absent", "缺席的");
        hashMap.put("ache", "疼痛");
        hashMap.put("address", "地址");
        hashMap.put("against", "逆着，反对");
        hashMap.put("attend", "出席");
        hashMap.put("blank", "空白的");
        hashMap.put("blue", "忧伤的");
        hashMap.put("build", "建筑");
        hashMap.put("cause", "促使，引起");
        hashMap.put("cloudy", "阴的，多云的");
        hashMap.put("coach", "教练");
        hashMap.put("count", "计算，数");
        hashMap.put("course", "课程");
        hashMap.put("cover", "覆盖");
        hashMap.put("cross", "跨越，横穿");
        hashMap.put("desert", "沙漠");
        hashMap.put("deal", "处理，解决");
        hashMap.put("develop", "发展");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
