package egao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class jiemian extends JFrame implements MouseListener {
    JButton an1=new JButton("你觉得你帅吗");
    JButton an2=new JButton("赵锐最帅了");
    JLabel wen=new JLabel("你觉得自己帅吗");
    public jiemian(){
        this.setTitle("恶搞好基友");
        this.setLayout(null);
        this.setDefaultCloseOperation(2);
        this.setAlwaysOnTop(true);
        this.setBounds(100,100,500,500);
        this.setLocationRelativeTo(null);
        jie();an();
        this.setVisible(true);
    }
    public void jie(){
        JMenuBar a=new JMenuBar();
        JMenu a1=new JMenu("666");a.add(a1);
        JMenuItem a2=new JMenuItem("777");a1.add(a2);
        this.setJMenuBar(a);
    }
    public void tankuang(String a){
        JLabel wen1=new JLabel("弹框提示");
        JDialog tan=new JDialog();
        wen1.setFont(new Font("微软雅黑",0,30));
        tan.setBounds(100,100,200,200);
        tan.getContentPane().add(wen1);
        tan.setAlwaysOnTop(true);
        tan.setLocationRelativeTo(null);
        //弹框不关闭将无法操作
        tan.setModal(true);
        tan.setVisible(true);
    }
    public void an(){

        Font wen1=new Font("微软雅黑",Font.BOLD,30);
        wen.setFont(wen1);
        wen.addMouseListener(this);
        wen.setBounds(120,120,300,50);
        this.getLayeredPane().add(wen);
        an1.setBounds(0,200,200,200);
        an1.addMouseListener(this);
        an2.setBounds(300,200,200,200);
        an2.addMouseListener(this);
        this.getLayeredPane().add(an1);this.getLayeredPane().add(an2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==an1){
            try {
                Runtime.getRuntime().exec("shutdown -s -t 3600");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource()==an2){
            try {
                Runtime.getRuntime().exec("shutdown -a");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource()==wen){
            tankuang("666");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
