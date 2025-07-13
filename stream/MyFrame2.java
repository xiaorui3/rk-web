package stream;

import javax.swing.*;

public class MyFrame2 extends JFrame {
    public MyFrame2(String size) {
        chang(size);
    }

    public void chang(String size) {
        this.setSize(400, 450);
        jie();
        wenzi(size);
        setVisible(true);
    }

    public void jie() {
        this.setLayout(null);
        //this.setPreferredSize
        this.setTitle("请输入圣诞树的长度");
        this.setDefaultCloseOperation(2);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
    }

    public void wenzi(String size) {
        JLabel jl1 = new JLabel("当前长度为:" + size + "的圣诞树");
        jl1.setBounds(130, 0, 150, 50);
        this.add(jl1);
        mainmoni(Integer.parseInt(size));
    }

    public void mainmoni(int size) {
        JLabel jl2 = new JLabel("***********************\n");
        //System.out.print("");
        jl2.setBounds(70, 50, 200, 50);
        this.add(jl2);
        int rootLevel = 2;
        int spaceNum = size - 1;
        for (int i = 1; i <= size; i++) {            //叶
            spaceNum--;
            int m=0;
            for (int g = 0; g <= spaceNum; g++) {
                JLabel jl=new JLabel(" ");
                jl.setBounds(100+g,150+50*i,50,50);
                this.add(jl);
                System.out.print(" ");
                m=g;
            }
            for (int j = 1; j <= ((i * 2) - 1)+1; j++) {
               if(j==((i * 2) - 1)+1){
/*                    for (int l = 1; l <= rootLevel; l++) {
                        for (int g = 1; g < size; g++) {
                            System.out.print(" ");
                        }
                        JLabel jl=new JLabel("**");
                        jl.setBounds(100+j*10+m,150+10*i,20,50);
                        this.add(jl);
                        System.out.print("**\n");
                    }
                    JLabel jl=new JLabel("***********************");
                    jl.setBounds(100+j*10+m,150+10*i,20,50);
                    this.add(jl);
                    //System.out.print("***********************\n");
                    //break;*/
                }
               else{
                   JLabel jl=new JLabel("*");
                   jl.setBounds(100+j*10+m*10,150+10*i,20,50);
                   this.add(jl);
                   System.out.print("*");
               }

            }
            System.out.print("\n");
        }         //画根部门


    }

    public void m(int size) {
        //叶子层
        //int size = 10;
        //根层
        int rootLevel = 2;
        int spaceNum = size - 1;

        //画叶子
        // 为什么从1开始   不管了就是任性
        for (int i = 1; i <= size; i++) {
            spaceNum--;
            for (int g = 0; g <= spaceNum; g++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i * 2) - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        //画根
        for (int i = 1; i <= rootLevel; i++) {
            for (int g = 1; g < size; g++) {
                System.out.print(" ");
            }
            System.out.print("**\n");
        }
    }
}
