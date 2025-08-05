import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class service {
    public static void main(String[] args) throws IOException {
        ServerSocket ss =new ServerSocket(8888);
       // Socket accept = ss.accept();
        //System.out.println(accept);
        //System.out.println(accept.getLocalSocketAddress());
        //System.out.println(accept.getInetAddress());
        //System.out.println(accept.getLocalAddress());
        //连接池
        //ThreadFactory threadFactory = new ThreadFactory(){
        //    @Override
        //    public Thread newThread(Runnable r) {
        //        Thread t = new Thread(r);
        //    }
        //}
        ThreadPoolExecutor tpe =new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.AbortPolicy());
        //System.out.println();
        //BufferedReader br =new BufferedReader(new InputStreamReader(accept.getInputStream()));
        //ArrayList<SocketAddress> as =new ArrayList<>();
        ArrayList<Socket> as =new ArrayList<>();//ArrayList 是线程不安全的 没有解决方案
        for (int i = 0; i < 5; i++) {
            tpe.execute(new Runnable(){

                @Override
                public void run() {
                    Socket accept =null;
                    try {
                        accept= ss.accept();
                        //as.add(accept.getRemoteSocketAddress());
                        as.add(accept);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    InputStream inputStream = null;
                    try {
                        inputStream = accept.getInputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    byte[] buffer = new byte[1024];
                    while(true){
                        int len = 0;
                        try {
                            len = inputStream.read(buffer);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        String s = new String(buffer,0,len);
                        System.out.println("来自: "+accept.getRemoteSocketAddress()+"的消息: "+s);
                        String ss=new String("来自: "+accept.getRemoteSocketAddress()+"的消息: "+s);
                        try {
                            //for (int i1 = 0; i1 < as.size(); i1++) {
                            //    //if (as.get(i1)==accept.getRemoteSocketAddress()){
                            //    //    OutputStream outputStream = accept.getOutputStream();
                            //    //    outputStream.write(ss.getBytes());
                            //    //    outputStream.flush();
                            //    //}
                            //    if (!(as.get(i1).equals(accept.getRemoteSocketAddress()))){
                            //        OutputStream os = as.get(i1).getOutputStream();
                            //        os.write(ss.getBytes());
                            //        os.flush();
                            //    }
                            //}
                            for (Socket client : as) {
                                if (client != accept) {
                                    OutputStream os = client.getOutputStream();
                                    os.write(ss.getBytes());
                                    os.flush();
                                }
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        //System.out.println();
                        //System.out.println();
                        //System.out.println(br.readLine());
                    }
                }
            });
        }
        System.out.println("服务器启动成功！"+"已经启动"+tpe.getActiveCount()+"条线程");

    }
}
