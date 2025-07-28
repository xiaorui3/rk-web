package 布卡.基础.ZY.ZY7_28.service.Examination;

import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.EX_TABLE;
import 布卡.基础.ZY.ZY7_28.service.Examination.Impl.ExaminationUI;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: 考试系统启动主方法
 * @Version: 1.0
 */


public class APP {
    public static void main(String[] args) {
        EX_TABLE.start();
        ExaminationUI_In examinationUI_in = new ExaminationUI();
        examinationUI_in.start();
    }
}
