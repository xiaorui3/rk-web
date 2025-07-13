package stream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //获取文本内容
            TextField field=(TextField)e.getSource();//返回一个对象
            System.out.println(field.getText());
            new MyFrame2(field.getText());
        }
}
