package 布卡.基础.ZY.ZY7_28.mepper;

import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.EX_Exception;

public interface DataBase {
    public abstract void insert() throws EX_Exception;
    public abstract void insert(String sql_1);
    public abstract void insert(String sql_1,String sql_2);
    public abstract void update() throws EX_Exception;
    public abstract void update(String sql_1);
    public abstract void update(String sql_1,String sql_2);
    public abstract void delete() throws EX_Exception;
    public abstract void delete(String sql_1);
    public abstract void delete(String sql_1,String sql_2);
    public abstract Object[] select() throws EX_Exception;
    public abstract Object[] select(String sql_1);
    public abstract Object[] select(String sql_1,String sql_2);

}
