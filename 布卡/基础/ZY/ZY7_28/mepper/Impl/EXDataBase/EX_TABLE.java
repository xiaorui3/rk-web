package 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EX_TABLE {
    private String name;
    private String age;
    private String stuId;
    private String password;
    private int fraction;
    private String topic;
    private String[] options;
    // 新增题目答案属性
    private String answer;
    private int position;
    private Data time;

    private static ArrayList<EX_TABLE> table =new ArrayList<>();

    // 新增answer的getter和setter
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // 其他原有getter和setter方法保持不变...
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Data getTime() {
        return time;
    }

    public void setTime(Data time) {
        this.time = time;
        this.time = time;
    }

    @Override
    public String toString() {
        return "EX_TABLE{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", stuId='" + stuId + '\'' +
                ", password='" + password + '\'' +
                ", fraction=" + fraction +
                ", topic='" + topic + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answer='" + answer + '\'' +  // 新增答案属性展示
                ", position=" + position +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EX_TABLE exTable = (EX_TABLE) o;
        return fraction == exTable.fraction && position == exTable.position && Objects.equals(name, exTable.name) && Objects.equals(age, exTable.age) && Objects.equals(stuId, exTable.stuId) && Objects.equals(password, exTable.password) && Objects.equals(topic, exTable.topic) && Objects.deepEquals(options, exTable.options) && Objects.equals(answer, exTable.answer) && Objects.equals(time, exTable.time);
    }

    public EX_TABLE(String stuId, String password) {
        this.stuId = stuId;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, stuId, password, fraction, topic, Arrays.hashCode(options), answer, position, time);
    }

    public EX_TABLE() {

    }

    public static ArrayList<EX_TABLE> getTable() {
        return table;
    }

    public static void setTable(ArrayList<EX_TABLE> table) {
        EX_TABLE.table = table;
    }

    public static void start() {
        File teacherFile = new File("布卡\\基础\\ZY\\ZY7_28\\mepper\\Impl\\EXDataBase\\terchaers.xiaorui");
        FileReader fis = null;
        BufferedReader br = null;
        try {
            fis = new FileReader(teacherFile);
            br = new BufferedReader(fis);
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("-");
                if (info.length == 2) {
                    table.add(new EX_TABLE(info[0], info[1]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("教师信息加载失败", e);
        } finally {
            closeResources(br, fis);
        }

        File topicFile = new File("布卡\\基础\\ZY\\ZY7_28\\mepper\\Impl\\EXDataBase\\topic.xiaorui");
        try {
            fis = new FileReader(topicFile);
            br = new BufferedReader(fis);
            String topicContent = "";
            String answer = "";
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.startsWith("答案：")) {
                    answer = line.substring(3).trim();

                    if (!topicContent.isEmpty()) {
                        parseAndSaveQuestion(topicContent, answer);
                        topicContent = "";
                        answer = "";
                    }
                } else {
                    topicContent += (topicContent.isEmpty() ? "" : "\n") + line;
                }
            }

            if (!topicContent.isEmpty() && !answer.isEmpty()) {
                parseAndSaveQuestion(topicContent, answer);
            }

        } catch (IOException e) {
            throw new RuntimeException("题目加载失败", e);
        } finally {
            closeResources(br, fis);
        }
    }

    private static void closeResources(BufferedReader br, FileReader fis) {
        try {
            if (br != null) br.close();
            if (fis != null) fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseAndSaveQuestion(String content, String answer) {
        String[] lines = content.split("\n");
        if (lines.length == 0) return;

        String firstLine = lines[0].trim();
        String topicText = firstLine.replaceAll("^\\d+\\.\\s*", "");

        List<String> optionsList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String optLine = lines[i].trim();
            if (optLine.matches("^[A-D]\\..+")) {
                optionsList.add(optLine.substring(2).trim());
            }
        }

        EX_TABLE question = new EX_TABLE(
                0,
                "",
                "",
                "",
                "",
                0,
                topicText,
                optionsList.toArray(new String[0]),
                answer,
                null
        );
        table.add(question);
    }

    public EX_TABLE(int position, String name, String age, String stuId, String password,
                    int fraction, String topic, String[] options, String answer, Data time) {
        this.position = position;
        this.name = name;
        this.age = age;
        this.stuId = stuId;
        this.password = password;
        this.fraction = fraction;
        this.topic = topic;
        this.options = options;
        this.answer = answer;
        this.time = time;
    }
}