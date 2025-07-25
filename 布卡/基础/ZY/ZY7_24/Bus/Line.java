package 布卡.基础.ZY.ZY7_24.Bus;

import java.util.ArrayList;
import java.util.List;

public abstract class Line {
    protected List<String> stations = new ArrayList<>();

    public abstract void initStations();
    public List<String> getStations() {
        return stations;
    }

    public String getRunLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stations.size(); i++) {
            sb.append(stations.get(i));
            if (i < stations.size() - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        int stationCount = stations.size();
        String stationStr = getRunLine();
        return "【公交线路信息】\n" +
                //"当前站点："+stations+"\n"+
                "站点总数：" + stationCount + " 个\n" +
                "站点依次为：" + stationStr;
    }
}
