package 布卡.基础.ZY.ZY7_24;

import 布卡.基础.ZY.ZY7_24.Bus.*;
import 布卡.基础.ZY.ZY7_24.Person_Max.Person_Max;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWork04 {
    private static final int CAR_TIME=2;
    // 线程安全的公交车计数器
    private static final AtomicInteger busCounter = new AtomicInteger(1);
    // 线程池，最多10辆公交车
    private static final ExecutorService busPool = Executors.newFixedThreadPool(10);
    // 定时调度器
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    // 车辆状态监控
    private static final Map<Integer, BusStatus> busStatusMap = new ConcurrentHashMap<>();
    // 线路信息缓存
    private static final Map<String, List<String>> lineStationsCache = new ConcurrentHashMap<>();
    // 颜色代码
    private static final String[] COLORS = {
            "\u001B[31m", // 红
            "\u001B[32m", // 绿
            "\u001B[33m", // 黄
            "\u001B[34m", // 蓝
            "\u001B[35m", // 紫
            "\u001B[36m", // 青
            "\u001B[37m", // 白
            "\u001B[91m", // 亮红
            "\u001B[92m", // 亮绿
            "\u001B[93m"  // 亮黄
    };
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        // 预加载线路信息
        preloadLineStations();

        // 启动状态监控
        scheduler.scheduleAtFixedRate(HomeWork04::displayBusStatus, 0, 1, TimeUnit.SECONDS);
        // 每隔30秒发一辆新车
        scheduler.scheduleAtFixedRate(HomeWork04::dispatchNewBus, 0, 2, TimeUnit.SECONDS);

        // 1小时后关闭调度器
        scheduler.schedule(() -> {
            scheduler.shutdown();
            busPool.shutdown();
            try {
                if (!busPool.awaitTermination(1, TimeUnit.MINUTES)) {
                    busPool.shutdownNow();
                }
            } catch (InterruptedException e) {
                busPool.shutdownNow();
            }
            System.out.println("系统运行结束");
        }, 1, TimeUnit.HOURS);
    }

    // 预加载线路信息
    private static void preloadLineStations() {
        Line line1 = new HarbinBusLine1();
        line1.initStations();
        lineStationsCache.put("1路", line1.getStations());

        Line line2 = new HarbinBusLine2();
        line2.initStations();
        lineStationsCache.put("336路", line2.getStations());
    }

    private static void displayBusStatus() {
        synchronized (System.out) {
            // 清屏
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("==================== 实时公交监控系统 ====================");
            System.out.println("时间: " + new Date());
            System.out.println("运行车辆: " + busStatusMap.size() + "/10");
            System.out.println("------------------------------------------------------");

            if (busStatusMap.isEmpty()) {
                System.out.println("暂无运行车辆");
            } else {
                System.out.println("ID | 状态 | 线路       | 方向 | 当前站点 | 下一站 | 当前乘客 | 下一站下车 | 累计下车");
                System.out.println("------------------------------------------------------");

                busStatusMap.values().stream()
                        .sorted(Comparator.comparingInt(BusStatus::getBusId))
                        .forEach(status -> {
                            String color = COLORS[status.getBusId() % COLORS.length];
                            String reset = RESET;

                            System.out.printf(
                                    "%2d | %s%-7s%s | %s%-10s%s | %s%-3s%s | %s%-15s%s | %s%-15s%s | %3d人   | %3d人   | %3d人   \n",
                                    status.getBusId(),
                                    color, status.getStatus(), reset,
                                    color, status.getRouteName(), reset,
                                    color, status.getDirection(), reset,
                                    color, status.getCurrentStation(), reset,
                                    color, status.getNextStation(), reset,
                                    status.getPassengerCount(),
                                    status.getNextStationOff(),
                                    status.getTotalOffCount()
                            );
                        });

                // 显示车辆路线图
                System.out.println("\n==================== 车辆路线信息 ====================");
                busStatusMap.values().stream()
                        .sorted(Comparator.comparingInt(BusStatus::getBusId))
                        .forEach(status -> {
                            String color = COLORS[status.getBusId() % COLORS.length];
                            String reset = RESET;

                            System.out.print(color + "[" + status.getBusId() + "号车] " +
                                    status.getRouteName() + "(" + status.getDirection() + "): ");

                            List<String> stations = status.getFullRoute();
                            for (int i = 0; i < stations.size(); i++) {
                                if (i == status.getCurrentStationIndex()) {
                                    System.out.print(color + "【" + stations.get(i) + "】" + reset);
                                } else {
                                    System.out.print(stations.get(i));
                                }

                                if (i < stations.size() - 1) {
                                    System.out.print(" → ");
                                }
                            }
                            System.out.println();
                        });
            }
            System.out.println("======================================================");
        }
    }

    private static void dispatchNewBus() {
        synchronized (HomeWork04.class) {
            if (busStatusMap.size() < 10) {
                int busId = busCounter.getAndIncrement();
                int lineChoice = new Random().nextInt(2) + 1;
                String lineName = lineChoice == 1 ? "1路" : "336路";
                boolean isForward = new Random().nextBoolean();

                // 获取线路完整站点
                List<String> fullRoute = new ArrayList<>(lineStationsCache.get(lineName));
                if (!isForward) {
                    Collections.reverse(fullRoute);
                }

                busStatusMap.put(busId, new BusStatus(
                        busId, "发车", lineName,
                        isForward ? "正向" : "反向",
                        fullRoute.get(0), // 当前站点
                        fullRoute.size() > 1 ? fullRoute.get(1) : "终点站", // 下一站
                        0, 0, 0,
                        fullRoute
                ));

                busPool.execute(new BusRunnable(busId, lineName, isForward, fullRoute));
            }
        }
    }

    static class BusStatus {
        private final int busId;
        private volatile String status;
        private final String routeName;
        private final String direction;
        private volatile String currentStation;
        private volatile String nextStation;
        private volatile int passengerCount;
        private volatile int nextStationOff;
        private volatile int totalOffCount;
        private final List<String> fullRoute;
        private volatile int currentStationIndex;

        public BusStatus(int busId, String status, String routeName,
                         String direction, String currentStation, String nextStation,
                         int passengerCount, int nextStationOff, int totalOffCount,
                         List<String> fullRoute) {
            this.busId = busId;
            this.status = status;
            this.routeName = routeName;
            this.direction = direction;
            this.currentStation = currentStation;
            this.nextStation = nextStation;
            this.passengerCount = passengerCount;
            this.nextStationOff = nextStationOff;
            this.totalOffCount = totalOffCount;
            this.fullRoute = fullRoute;
            this.currentStationIndex = 0;
        }

        // Getters and setters
        public int getBusId() { return busId; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getRouteName() { return routeName; }
        public String getDirection() { return direction; }
        public String getCurrentStation() { return currentStation; }
        public void setCurrentStation(String station) { currentStation = station; }
        public String getNextStation() { return nextStation; }
        public void setNextStation(String station) { nextStation = station; }
        public int getPassengerCount() { return passengerCount; }
        public void setPassengerCount(int count) { passengerCount = count; }
        public int getNextStationOff() { return nextStationOff; }
        public void setNextStationOff(int count) { nextStationOff = count; }
        public int getTotalOffCount() { return totalOffCount; }
        public void setTotalOffCount(int count) { totalOffCount = count; }
        public List<String> getFullRoute() { return fullRoute; }
        public int getCurrentStationIndex() { return currentStationIndex; }
        public void setCurrentStationIndex(int index) { currentStationIndex = index; }
    }

    static class BusRunnable implements Runnable {
        private final int busId;
        private final String routeName;
        private final boolean isForward;
        private final List<String> stations;
        private int totalRevenue = 0;
        private int passengerCount = 0;
        private int totalOffCount = 0;

        public BusRunnable(int busId, String routeName, boolean isForward, List<String> stations) {
            this.busId = busId;
            this.routeName = routeName;
            this.isForward = isForward;
            this.stations = stations;
        }

        @Override
        public void run() {
            try {
                BusStatus status = busStatusMap.get(busId);
                status.setStatus("运行中");

                Bus bus = new Bus();
                bus.setName(routeName + "-" + busId + "号车");

                List<Person_Max> currentPassengers = new ArrayList<>();

                // 遍历所有站点
                for (int i = 0; i < stations.size(); i++) {
                    String station = stations.get(i);

                    // 更新状态
                    status.setCurrentStationIndex(i);
                    status.setCurrentStation(station);

                    // 设置下一站
                    if (i < stations.size() - 1) {
                        status.setNextStation(stations.get(i + 1));
                    } else {
                        status.setNextStation("终点站");
                    }

                    // 乘客下车
                    List<Person_Max> toGetOff = new ArrayList<>();
                    for (Person_Max p : currentPassengers) {
                        if (p.getEndBusStation().equals(station)) {
                            toGetOff.add(p);
                        }
                    }
                    currentPassengers.removeAll(toGetOff);
                    passengerCount -= toGetOff.size();
                    totalOffCount += toGetOff.size();
                    status.setTotalOffCount(totalOffCount);

                    // 计算下一站下车乘客数
                    int nextStationOff = 0;
                    if (i < stations.size() - 1) {
                        String nextStation = stations.get(i + 1);
                        for (Person_Max p : currentPassengers) {
                            if (p.getEndBusStation().equals(nextStation)) {
                                nextStationOff++;
                            }
                        }
                    }
                    status.setNextStationOff(nextStationOff);

                    // 非终点站可上车
                    if (i < stations.size() - 1) {
                        int pNum = 1 + new Random().nextInt(10); // 控制乘客数量
                        int stationRevenue = 0;
                        int newPassengers = 0;

                        for (int j = 0; j < pNum; j++) {
                            int offset = 1 + new Random().nextInt(stations.size() - i - 1);
                            int destIndex = i + offset;
                            String destStation = stations.get(destIndex);

                            String personName = "乘客-" + (j + 1);
                            int personAge = 1 + new Random().nextInt(100);

                            Person_Max person = new Person_Max(personName, personAge,
                                    bus.getName(), destStation);
                            currentPassengers.add(person);
                            newPassengers++;

                            // 计算票价
                            if (personAge >= 60 && personAge < 70) {
                                stationRevenue += 1; // 半价老人卡
                            } else if (personAge >= 70) {
                                // 免费老人卡
                            } else if (personAge <= 20) {
                                stationRevenue += 1; // 学生卡
                            } else {
                                stationRevenue += 2; // 全价票
                            }
                        }

                        passengerCount += newPassengers;
                        totalRevenue += stationRevenue;
                    }

                    // 更新乘客数量
                    status.setPassengerCount(currentPassengers.size());

                    // 终点站处理
                    if (i == stations.size() - 1) {
                        status.setStatus("到达终点");
                        totalOffCount += currentPassengers.size();
                        status.setTotalOffCount(totalOffCount);
                        status.setPassengerCount(0);
                        status.setNextStation("--");
                    }

                    // 模拟行车时间
                    TimeUnit.SECONDS.sleep(CAR_TIME);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 从状态监控中移除
                busStatusMap.remove(busId);
            }
        }
    }
}