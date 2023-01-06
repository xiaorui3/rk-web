package stream;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
        public MyFrame(){
            jie();
            TextField textField=new TextField();
            textField.setBounds(50,0,50,50);
            //textField.setSize(45,45);
            this.add(textField);
            //监听这个文本框输入的文字
            MyActionListener2 myActionListener2=new MyActionListener2();
            //按下enter就会触发这个输入框的内容
            textField.addActionListener(myActionListener2);
            //pack();
        }
        public void jie(){
            this.setLayout(null);
            this.setSize(200,320);
            //this.setPreferredSize
            this.setTitle("请输入圣诞树的长度");
            this.setDefaultCloseOperation(2);
            this.setAlwaysOnTop(true);
            this.setLocationRelativeTo(null);
            wenben();
            //this.setLayout(null);
            setVisible(true);
        }
        public void wenben(){
            JLabel jl=new JLabel("请输入圣诞树的长度");
            jl.setBounds(30,60,150,50);
            this.add(jl);
        }
}
