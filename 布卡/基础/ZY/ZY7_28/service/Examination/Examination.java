package 布卡.基础.ZY.ZY7_28.service.Examination;

public interface Examination {
    public void insert() throws Exception;
    public void insert(String sql_1);
    public void insert(String sql_1,String sql_2);
    public void update() throws Exception;
    public void update(String sql_1);
    public void update(String sql_1,String sql_2);
    public void delete() throws Exception;
    public void delete(String sql_1);
    public void delete(String sql_1,String sql_2);
    public Object[] select() throws Exception;
    public Object[] select(String sql_1);
    public Object[] select(String sql_1,String sql_2);
}
