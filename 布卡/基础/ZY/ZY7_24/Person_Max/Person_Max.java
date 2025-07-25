package 布卡.基础.ZY.ZY7_24.Person_Max;

import java.util.Objects;

public class Person_Max {
    private String name;
    private int age;
    private String busName;
    private String endBusStation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getEndBusStation() {
        return endBusStation;
    }

    public void setEndBusStation(String endBusStation) {
        this.endBusStation = endBusStation;
    }

    public Person_Max() {
    }

    public Person_Max(String name, int age, String busName, String endBusStation) {
        this.name = name;
        this.age = age;
        this.busName = busName;
        this.endBusStation = endBusStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_Max personMax = (Person_Max) o;
        return age == personMax.age && Objects.equals(name, personMax.name) && Objects.equals(busName, personMax.busName) && Objects.equals(endBusStation, personMax.endBusStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, busName, endBusStation);
    }

    @Override
    public String toString() {
        return "Person_Max{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", busName='" + busName + '\'' +
                ", endBusStation='" + endBusStation + '\'' +
                '}';
    }
}
