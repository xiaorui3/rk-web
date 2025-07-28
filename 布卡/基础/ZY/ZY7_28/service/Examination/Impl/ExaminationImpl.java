package 布卡.基础.ZY.ZY7_28.service.Examination.Impl;

import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.ExaminationData;
import 布卡.基础.ZY.ZY7_28.service.Examination.Examination;

public class ExaminationImpl implements Examination {
    @Override
    public void insert() throws Exception {
        new ExaminationData().insert();
    }

    @Override
    public void insert(String sql_1) {

    }

    @Override
    public void insert(String sql_1, String sql_2) {

    }

    @Override
    public void update() throws Exception {

    }

    @Override
    public void update(String sql_1) {

    }

    @Override
    public void update(String sql_1, String sql_2) {

    }

    @Override
    public void delete() throws Exception {

    }

    @Override
    public void delete(String sql_1) {

    }

    @Override
    public void delete(String sql_1, String sql_2) {

    }

    @Override
    public Object[] select() throws Exception {
        return new Object[0];
    }

    @Override
    public Object[] select(String sql_1) {
        return new Object[0];
    }

    @Override
    public Object[] select(String sql_1, String sql_2) {
        return new Object[0];
    }

    public static void main(String[] args) {
        new ExaminationUI().start();

    }
}
