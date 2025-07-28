package 布卡.基础.ZY.ZY7_28.service.Examination.Impl;

import 布卡.基础.ZY.ZY7_28.mepper.DataBase;
import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.EX_Exception;
import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.EX_TABLE;
import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.ExaminationData;
import 布卡.基础.ZY.ZY7_28.service.Examination.Exadmination_Super;
import 布卡.基础.ZY.ZY7_28.service.Examination.ExaminationUI_In;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: 教师UI界面端、
 * @Version: 1.0
 */


public class TeacherUI extends Exadmination_Super implements ExaminationUI_In {
    private int getNextQuestionNum() {
        ArrayList<EX_TABLE> table = EX_TABLE.getTable();
        int count = 0;
        for (EX_TABLE item : table) {
            if (item.getTopic() != null) {
                count++;
            }
        }
        return count + 1;
    }

    /**
     * 格式化题目字符串
     */
    private String formatQuestion(int num, String topic, String a, String b, String c, String d, String answer) {
        StringBuilder sb = new StringBuilder();
        sb.append(num).append(". ").append(topic).append("\n");
        sb.append("A. ").append(a).append("\n");
        sb.append("B. ").append(b).append("\n");
        sb.append("C. ").append(c).append("\n");
        sb.append("D. ").append(d).append("\n");
        sb.append("答案：").append(answer).append("\n\n");
        return sb.toString();
    }

    /**
     * 将题目写入文件
     */
    private void writeQuestionToFile(String question) throws IOException {
        File topicFile = new File("布卡\\基础\\ZY\\ZY7_28\\mepper\\Impl\\EXDataBase\\topic.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(topicFile, true))) {
            bw.write(question);
        }
    }

    /**
     * 将题目添加到内存集合
     */
    private void addQuestionToMemory(int num, String topic, String[] options, String answer) {
        EX_TABLE newQuestion = new EX_TABLE(
                num,      // position
                "",       // name
                "",       // age
                "",       // stuId
                "",       // password
                0,        // fraction
                topic,    // topic
                options,  // options
                answer,   // answer
                null      // time
        );
        EX_TABLE.getTable().add(newQuestion);
    }
    @Override
    public void start() {
        super.clear();
        System.out.println("============   欢迎进入教师考试系统    ============");
        System.out.println("============       请登录           ============");
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名:");
        String stuId = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();

        boolean flag = false;
        DataBase db =new ExaminationData();
        Object[] obj = db.select("stuId="+stuId+"*password="+password+"","1");//教师

        /*ArrayList<EX_TABLE> table = EX_TABLE.getTable();
        for (EX_TABLE exTable : table) {
            System.out.println(exTable);
        }*/
        System.out.println(obj[0]);
        //Scanner sc =new Scanner(System.in);
        int m=0;
        if (obj[0]!=null){
            System.out.println("============     1.添加考试题        ============");
            System.out.println("============     2.修改考试题        ============");
            System.out.println("============     3.删除考试题        ============");
            System.out.println("============     4.查询考试题        ============");
           // System.out.println("============     5.学生注册令牌生成    ============");
            System.out.println("============     5.退出系统           ============");

            System.out.println("============     请输入你的选择       ============");
            String next = sc.next();
            switch (next) {
                case "1":
                    int k = -1;
                    while (true) {
                        if (k == 1) {
                            break;
                        }
                        System.out.println("============     0.返回上一级        ==========");
                        System.out.println("============     1.继续添加        ==========");
                        String next2 = sc.next();
                        sc.nextLine();
                        switch (next2) {
                            case "0":
                                k = 1;
                                break;
                            case "1":
                                try {
                                    int newQuestionNum = getNextQuestionNum();

                                    System.out.println("请输入第" + newQuestionNum + "题的题目内容:");
                                    String topicContent = sc.nextLine();

                                    System.out.println("请输入选项A:");
                                    String optionA = sc.nextLine();

                                    System.out.println("请输入选项B:");
                                    String optionB = sc.nextLine();

                                    System.out.println("请输入选项C:");
                                    String optionC = sc.nextLine();

                                    System.out.println("请输入选项D:");
                                    String optionD = sc.nextLine();

                                    System.out.println("请输入正确答案(A/B/C/D):");
                                    String answer = sc.nextLine().toUpperCase();

                                    if (!answer.matches("[ABCD]")) {
                                        System.out.println("答案格式错误，请输入A/B/C/D!");
                                        break;
                                    }

                                    String questionStr = formatQuestion(newQuestionNum, topicContent,
                                            optionA, optionB, optionC, optionD, answer);

                                    writeQuestionToFile(questionStr);

                                    addQuestionToMemory(newQuestionNum, topicContent,
                                            new String[]{optionA, optionB, optionC, optionD}, answer);

                                    System.out.println("题目添加成功!");
                                } catch (IOException e) {
                                    System.out.println("添加失败: " + e.getMessage());
                                }
                                break;
                            default:
                                System.out.println("输入错误！请重新输入！");
                        }
                    }
                    break;
                case "2":
                    int k2=-1;
                    //DataBase db1 =new ExaminationData();
                    while(true){
                        if (k2==1){
                            break;
                        }
                        System.out.println("============     0.返回上一级        ==========");
                        System.out.println("============     1.继续删除        ==========");
                        String next2 = sc.next();
                        switch (next2){
                            case "0":
                                k2=1;
                                break;
                            case "1":
                                //db.insert(sql_1);
                                try {
                                    throw new EX_Exception("暂未实现！！");
                                } catch (EX_Exception e) {
                                    throw new RuntimeException(e);
                                }
                            default:
                                System.out.println("输入错误！请重新输入！");
                        }
                    }
                    break;
                case "3":
                    int k3 = -1;
                    while (true) {
                        if (k3 == 1) {
                            break;
                        }
                        System.out.println("============     0.返回上一级        ==========");
                        System.out.println("============     1.继续删除        ==========");
                        String next2 = sc.next();
                        switch (next2) {
                            case "0":
                                k3 = 1;
                                break;
                            case "1":
                                ArrayList<EX_TABLE> table = EX_TABLE.getTable();
                                ArrayList<EX_TABLE> validQuestions = new ArrayList<>();
                                for (EX_TABLE item : table) {
                                    if (item.getTopic() != null) {
                                        validQuestions.add(item);
                                    }
                                }

                                if (validQuestions.isEmpty()) {
                                    System.out.println("没有可删除的题目！");
                                    break;
                                }

                                System.out.println("当前存在的题目：");
                                for (int i = 0; i < validQuestions.size(); i++) {
                                    EX_TABLE question = validQuestions.get(i);
                                    System.out.println((i + 1) + ". " + question.getTopic());
                                }

                                System.out.println("请输入要删除的题目编号：");
                                String deleteNumStr = sc.next();
                                int deleteNum;
                                try {
                                    deleteNum = Integer.parseInt(deleteNumStr);
                                } catch (NumberFormatException e) {
                                    System.out.println("输入错误！请输入数字编号！");
                                    break;
                                }
                                if (deleteNum < 1 || deleteNum > validQuestions.size()) {
                                    System.out.println("编号超出范围！请输入1-" + validQuestions.size() + "之间的编号！");
                                    break;
                                }
                                EX_TABLE toDeleteQuestion = validQuestions.get(deleteNum - 1);
                                table.remove(toDeleteQuestion);
                                File topicFile = new File("布卡\\基础\\ZY\\ZY7_28\\mepper\\Impl\\EXDataBase\\topic.txt");
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(topicFile, false))) { // 覆盖写入
                                    for (int i = 0; i < validQuestions.size(); i++) {
                                        if (i == deleteNum - 1) {
                                            continue;
                                        }
                                        EX_TABLE remainingQ = validQuestions.get(i);
                                        String[] options = remainingQ.getOptions();
                                        // 重新编号（保持连续）
                                        String questionStr = formatQuestion(
                                                i + 1,  // 新编号（因为删除了一个，后续编号自动减1）
                                                remainingQ.getTopic(),
                                                options[0],
                                                options[1],
                                                options[2],
                                                options[3],
                                                remainingQ.getAnswer()
                                        );
                                        bw.write(questionStr);
                                    }
                                    System.out.println("题目删除成功！已更新到文件！");
                                } catch (IOException e) {
                                    System.out.println("删除失败：文件写入错误 - " + e.getMessage());
                                }
                                break;
                            default:
                                System.out.println("输入错误！请重新输入！");
                        }
                    }
                    break;
                case "4":
                    int k4=-1;
                    //DataBase db1 =new ExaminationData();
                    while(true){
                        if (k4==1){
                            break;
                        }
                        System.out.println("============     0.返回上一级        ==========");
                        System.out.println("============     1.继续查询          ==========");
                        String next2 = sc.next();
                        System.out.println("next2: "+next2);
                        switch (next2){
                            case "0":
                                k4=1;
                                break;
                            case "1":
                                //db.insert(sql_1);
                                /*try {
                                    throw new EX_Exception("暂未实现！！");
                                } catch (EX_Exception e) {
                                    throw new RuntimeException(e);
                                }*/
                                Object[] select = db.select("*");
                                int ti=0;
                                for (int i = 0; i < select.length; i++) {
                                    EX_TABLE table = (EX_TABLE) select[i];
                                   // System.out.println(table.toString());
                                    if (table.getTopic() != null) {
                                        System.out.println((++ti) + " . " + table.getTopic());
                                        String[] options = table.getOptions();
                                        for (String s: options){
                                            System.out.println(s);
                                        }
                                        System.out.println("答案是："+table.getAnswer());
                                    } else {
                                        //System.out.print("");
                                    }
                                }
                                break;
                            default:
                                System.out.println("输入错误！请重新输入！");
                        }
                    }
                    break;
                case "5":
                    try {
                        throw new EX_Exception("再见！！");
                    } catch (EX_Exception e) {
                        throw new RuntimeException(e);
                    }
            }
            m=1;
        }
        else{
            try {
                throw new EX_Exception("你的用户名和密码错误！");
            } catch (EX_Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (m==1){
            start();
        }
    }
}
