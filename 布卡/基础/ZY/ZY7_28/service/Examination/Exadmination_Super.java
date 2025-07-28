package 布卡.基础.ZY.ZY7_28.service.Examination;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: UI界面通用父类
 * @Version: 1.0
 */


public class Exadmination_Super {
    public void clear(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
