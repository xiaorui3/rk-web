package 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: 建议数据库
 * @Version: 1.0
 */



import 布卡.基础.ZY.ZY7_28.mepper.DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class ExaminationData implements DataBase {

    @Override
    public void insert() throws EX_Exception {
        throw new EX_Exception("请使用insert(String sql_1) 或 insert(String sql_1, String sql_2)！方法");
    }

    @Override
    public void insert(String sql_1) {

    }

    @Override
    public void insert(String sql_1, String sql_2) {

    }

    @Override
    public void update() throws EX_Exception {
        throw new EX_Exception("请使用update(String sql_1) 或 update(String sql_1, String sql_2)！方法");
    }

    @Override
    public void update(String sql_1) {

    }

    @Override
    public void update(String sql_1, String sql_2) {

    }

    @Override
    public void delete() throws EX_Exception {
        throw new EX_Exception("请使用delete(String sql_1) 或 delete(String sql_1, String sql_2)！方法");
    }

    @Override
    public void delete(String sql_1) {

    }

    @Override
    public void delete(String sql_1, String sql_2) {

    }

    @Override
    public Object[] select() throws EX_Exception {
        throw new EX_Exception("请使用select(String sql_1) 或 select(String sql_1, String sql_2)！方法");
        //return new Object[0];
    }

    @Override
    public Object[] select(String sql_1) {
        //Object[] obj = db.select("stuId='"+stuId+"'password='"+password+"'");
        //请求来的调用代码
        //实现sql代码读取并进行执行
        if ("*".equals(sql_1)) {

            return EX_TABLE.getTable().toArray(new Object[0]);
        }
        String[] split = sql_1.split("\\*");
        HashMap<String,String> map = new HashMap<>();
        String id="";
        String pwd="";
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("=");
            if (i==0){
                id=split1[1];
            }else{
                pwd=split1[1];
            }
        }
        System.out.println(id);
        System.out.println(pwd);


        return new Object[0];
    }

    @Override
    public Object[] select(String sql_1, String sql_2) {

        //Object[] obj = db.select("stuId='"+stuId+"'password='"+password+"'"，"?");
        //请求来的调用代码
        //实现sql代码读取并进行执行
        String[] split = sql_1.split("\\*");
        HashMap<String,String> map = new HashMap<>();
        String id="";
        String pwd="";
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("=");
            if (i==0){
                id=split1[1];
            }else{
                pwd=split1[1];
            }
        }
        System.out.println(id);
        System.out.println(pwd);
        ArrayList<EX_TABLE> table = EX_TABLE.getTable();
        String str="用户名或密码错误!";
        int k=-1;
        if (sql_2.equals("0")){
            System.out.println("学生");
        }else if(sql_2.equals("1")){
            System.out.println("教师");
            for (int i = 0; i < table.size(); i++) {
                String stuId = table.get(i).getStuId();
                if (stuId.equals(id)){
                    //System.out.println(str);
                    if (table.get(i).getPassword().equals(pwd)){
                        System.out.println("登录成功!");
                        k=i;
                        break;
                    }
                }
            }
            System.out.println(str);
        }
        Object[] o=null;
        try {
            o= new Object[1];
            o[0]=table.get(k);
            throw new EX_Exception("用户名不存在!");
        } catch (EX_Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            return o;
        }
    }
}

