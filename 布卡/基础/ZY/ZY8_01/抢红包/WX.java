package 布卡.基础.ZY.ZY8_01.抢红包;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WX {
/*    模拟一个抢红包的小例子

    微信类----->	有一个红包	10元		随机分成5份
    每份都有钱	0.01		容器里[5]
    用户类----->	线程			5个用户线程，抢红包
    锁	5刚好是五个不一样的
			8个人抢红包		3个人抢不到*/
    private double round(double value, int scale) {
        return new BigDecimal(value).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
    public List<Double> hongBao(double total, int count) {
        List<Double> redPackets = new ArrayList<>();
        if (total <= 0 || count <= 0 || total < count * 0.01) {
            throw new IllegalArgumentException("输入参数不合法，总金额必须大于红包个数乘以0.01");
        }

        Random random = new Random();
        double remaining = total;
        int remainingCount = count;
        for (int i = 0; i < count - 1; i++) {
            double min = 0.01;
            double max = remaining - 0.01 * (remainingCount - 1);
            double money = min + random.nextDouble() * (max - min);
            money = round(money, 2);
            redPackets.add(money);
            remaining -= money;
            remainingCount--;
        }
        redPackets.add(round(remaining, 2));

        return redPackets;
    }

}
