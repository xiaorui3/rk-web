package stream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class name extends JFrame {
    JButton jb=new JButton("点击开始");
    public name() {
        jie();
        this.setVisible(true);
    }
    public void jie(){
        this.setSize(150*2,300*2);
        this.setTitle("圣诞树");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        jb.setBounds(100,100,100,50);
        this.getContentPane().add(jb);
        jb.addActionListener(this::actionPerformed);
        TextField textField =new TextField();
        add(textField);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==jb){
            new MyFrame();
            System.out.println("6");
        }
    }
}
