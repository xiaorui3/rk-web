package 布卡.基础.ZY.ZY8_08;

public class Car {
    public String td;
    private String name;
    private int id;
    public Car(String td, String name,int id) {
        this.td = td;
        this.name = name;
        this.id = id;
    }

    public Car() {
    }

    public String getTd() {
        return td;
    }

    @Override
    public String toString() {
        return "Car{" +
                "td='" + td + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void setTd(String td) {
        this.td = td;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private void carBay(String name){
        System.out.println("购买"+name+"车");
    }



}
