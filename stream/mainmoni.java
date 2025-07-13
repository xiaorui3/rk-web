package stream;

import javax.swing.*;
import java.util.Scanner;
public class mainmoni{
    public static void main(String[] args) {
        mainmoni(5);
    }
    public static void mainmoni(int size) {
        System.out.print("***********************\n");
        int rootLevel = 2;
        int spaceNum = size - 1;
        for (int i = 1; i <= size; i++) {            //Ò¶
            spaceNum--;
            for (int g = 0; g <= spaceNum; g++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i * 2) -1); j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }         //»­¸ù²¿ÃÅ
        for (int i = 1; i <= rootLevel; i++) {
            for (int g = 1; g < size; g++) {
                System.out.print(" ");
            }
            System.out.print("**\n");
        }
        System.out.print("***********************\n");
    }
}

