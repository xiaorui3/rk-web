package 布卡.基础.ZY.ZY7_24.Bus;

import 布卡.基础.ZY.ZY7_24.Person_Max.Person_Max;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bus {
    private String name;
    private Line Line;
    private List<Person_Max> passengers = new ArrayList<>();

    public void setPassengers(List<Person_Max> passengers) {
        this.passengers = passengers;
    }

    public List<Person_Max> getPassengers() {
        return passengers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Line getLine() {
        return Line;
    }

    public void setLine(Line line) {
        Line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(name, bus.name) && Objects.equals(Line, bus.Line) && Objects.equals(passengers, bus.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Line, passengers);
    }

    @Override
    public String toString() {
        return "当前公交车的名字是： "+this.name+"当前公交车的路线是: \n\t\t" +this.Line.toString();
    }
}
