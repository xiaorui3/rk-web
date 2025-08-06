import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("45.207.195.154", 8890);
        System.out.println("已连接到服务器"+socket.getInetAddress().getHostAddress());
        //BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        OutputStream outputStream = socket.getOutputStream();
        //System.out.println(socket.getLocalSocketAddress());
        Scanner sc =new Scanner(System.in);
        String s=null;
        new Thread(() -> {
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    String msg = new String(buffer, 0, len);
                    System.out.println("\n" + msg);
                    System.out.print(socket.getLocalSocketAddress() + "的消息: ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        while(true){
            System.out.print(socket.getLocalSocketAddress()+"的消息: ");
            s = sc.nextLine();
            byte[] bytes1 = s.getBytes();
            outputStream.write(bytes1);
            outputStream.flush();
        }
    }
}
