package computer;

public class TestMain {
    public static void main(String[] args) {
        //1.学生，机房
        Room room = new Room();     //电脑就在机房里，已经创建啦
        Student student1 = new Student("赵锐");
        //2.做事
        room.open(student1);
        Student student2 = new Student("韩驰");
        room.open(student2);
        Student student3 = new Student("王艺凡");
        room.open(student3);
        Student student4 = new Student("刘鑫洋");
        room.open(student4);
        Student student5 = new Student("郑中拓");
        room.open(student5);
    }
}
