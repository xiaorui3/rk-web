package 布卡.基础.ZY.ZY7_13;

public class computer {
    String System_commputer;
    String CPU;
    String Memory;
    String Disk;
    String Video;
    String Power;
    int Price;// 价格
    public computer(String system, String cpu, String memory, String disk, String video, String power, int price) {
        this.System_commputer = system;
        this.CPU = cpu;
        this.Memory = memory;
        this.Disk = disk;
        this.Video = video;
        this.Power = power;
        this.Price = price;


    }


    public String getSystem_commputer() {
        return System_commputer;
    }

    public void setSystem_commputer(String system_commputer) {
        System_commputer = system_commputer;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getDisk() {
        return Disk;
    }

    public void setDisk(String disk) {
        Disk = disk;
    }

    public String getPower() {
        return Power;
    }

    public void setPower(String power) {
        Power = power;
    }
    public void show() {
        System.out.println("电脑系统：" + System_commputer);
        System.out.println("CPU：" + CPU);
        System.out.println("内存：" + Memory);
        System.out.println("硬盘：" + Disk);
        System.out.println("显卡：" + Video);
        System.out.println("电源：" + Power);
        System.out.println("价格：" + Price);
    }
}
