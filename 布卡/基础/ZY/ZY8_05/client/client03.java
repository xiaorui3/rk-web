import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class client03 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("192.168.3.79",9999);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("test".getBytes());
            outputStream.flush();
        } catch (IOException e) {
           // System.out.println(socket.getInetAddress().getHostAddress()+"没有");
        }

        try {
            socket = new Socket("192.168.3.60",9999);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("test".getBytes());
            outputStream.flush();
        } catch (IOException e) {
          //  System.out.println(socket.getInetAddress().getHostAddress()+"没有");
        }

        try {
            socket = new Socket("192.168.3.107",9999);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("test".getBytes());
            outputStream.flush();
        } catch (IOException e) {
           // System.out.println(socket.getInetAddress().getHostAddress()+"没有");
        }

        try {
            socket = new Socket("192.168.3.110",9999);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("test".getBytes());
            outputStream.flush();
        } catch (IOException e) {
         //   System.out.println(socket.getInetAddress().getHostAddress()+"没有");
        }


    }
}
