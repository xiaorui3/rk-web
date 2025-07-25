package 布卡.基础.ZY.ZY7_24;

import 布卡.基础.ZY.ZY7_24.Bus.Bus;
import 布卡.基础.ZY.ZY7_24.Bus.Line;
import 布卡.基础.ZY.ZY7_24.Bus.HarbinBusLine1;
import 布卡.基础.ZY.ZY7_24.Person_Max.Person_Max;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HomeWork03 {
    public static void main(String[] args) {
        Line l =new HarbinBusLine1();
        l.initStations();
        List<String> ll=l.getStations();
        Bus bus = new Bus();
        bus.setName("1路公交");
        bus.setLine(l);
        System.out.println("=====================================");
        System.out.println("本次列车 "+bus.getName()+" 始发站: "+ll.get(0)+" 终点站: "+ll.get(ll.size()-1));
        int maNei=0;
        List<LinkedList<Person_Max>> listPerson=new ArrayList<>();
        List<Person_Max> currentPassengers = new ArrayList<>();
        for (int i=0; i<ll.size();i++) {
            System.out.println();
            System.out.println("=====================================");
            String station=ll.get(i);
            System.out.println(l.toString());
            System.out.println("当前到站: "+station);
            List<Person_Max> toGetOff = new ArrayList<>();
            for (Person_Max p : currentPassengers) {
                if (p.getEndBusStation().equals(station)) {
                    toGetOff.add(p);
                }
            }
            currentPassengers.removeAll(toGetOff);
            System.out.println("本站下车: " + toGetOff.size() + " 人");
            if (i<ll.size()-1) {
                int pNum=(int)(1+(Math.random()*1000));
                System.out.println("预计上车: "+pNum+" 人");
                LinkedList<Person_Max> linkedPerson=new LinkedList<>();
                int maxOffset = ll.size()-i-1;
                int miniLodPersons=0;
                int plusLodPersons=0;
                int plusStudents=0;
                int maNeiTest=0;
                for (int j = 0; j < pNum; j++) {
                    int offset = (int) (1 + Math.random() * maxOffset);
                    int destIndex = i + offset;
                    String personStation = ll.get(destIndex);
                    String personName="在第 "+(i+1)+" 站 - "+station+" 上车的"+(j+1)+"号旅客";
                    int personAge=(int)(1+(Math.random()*100));
                    Person_Max person = new Person_Max(personName,personAge, bus.getName(),personStation);
                    linkedPerson.add(person);
                    currentPassengers.add(person);
                    if (personAge>=60&&personAge<70){
                        miniLodPersons+=1;
                        maNeiTest+=1;
                    }else if (personAge>=70){
                        plusLodPersons+=1;
                        maNeiTest+=0;
                    }else if (personAge<=20){
                        plusStudents+=1;
                        maNeiTest+=1;
                    }else{
                        maNeiTest+=2;
                    }
                }
                maNei+=maNeiTest;
                System.out.println("当前站点有: \n"+miniLodPersons+"个老人使用了半价老人卡");
                System.out.println(""+plusLodPersons+"个老人使用了免费老人卡");
                System.out.println(""+plusStudents+"个学生使用了学生卡");
                int maxPerson=miniLodPersons+plusLodPersons+plusStudents;
                System.out.println("有"+maxPerson+"人使用了优惠");
                System.out.println("当前路程获得了 "+maNeiTest+"元");

                listPerson.add(linkedPerson);
            } else {
                System.out.println("已到达终点站，禁止上车");
            }
            System.out.println();
            System.out.println("=====================================");
        }
        System.out.println("终点站所有乘客下车，共 "+currentPassengers.size()+" 人");
        currentPassengers.clear();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("当前车次所挣的钱是: "+maNei+"元");
    }
}