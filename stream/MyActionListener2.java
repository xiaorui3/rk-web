package stream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //��ȡ�ı�����
            TextField field=(TextField)e.getSource();//����һ������
            System.out.println(field.getText());
            new MyFrame2(field.getText());
        }
}
