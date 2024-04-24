import java.io.*;

public class IODemo6 {
    public static void main(String[] args) throws IOException {
//        使用OutPutStream写文件
        try (OutputStream outputStream = new FileOutputStream("test.txt", true)){
//            byte[] buffer = new byte[] {97,98,99,100,101,102};
//            outputStream.write(buffer);
            String data = "New data to append\n";
            outputStream.write(data.getBytes());
        }
    }
}
