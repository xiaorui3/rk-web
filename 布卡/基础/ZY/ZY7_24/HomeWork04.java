package 布卡.基础.ZY.ZY7_24;

import 布卡.基础.ZY.ZY7_24.Bus.*;
import 布卡.基础.ZY.ZY7_24.Person_Max.Person_Max;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeWork04 {
    // 线程安全的公交车计数器
    private static final AtomicInteger busCounter = new AtomicInteger(1);
    // 线程池，最多10辆公交车
    private static final ExecutorService busPool = Executors.newFixedThreadPool(10);
    // 定时调度器
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    // 车辆状态监控
    private static final Map<Integer, BusStatus> busStatusMap = new ConcurrentHashMap<>();
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
        // 启动状态监控
        scheduler.scheduleAtFixedRate(HomeWork04::displayBusStatus, 0, 5, TimeUnit.SECONDS);
        // 每隔30秒发一辆新车
        scheduler.scheduleAtFixedRate(HomeWork04::dispatchNewBus, 0, 30, TimeUnit.SECONDS);

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
                System.out.println("ID | 状态 | 线路       | 方向 | 当前站点/总站点 | 当前乘客 | 进度条");
                System.out.println("------------------------------------------------------");

                busStatusMap.values().stream()
                        .sorted(Comparator.comparingInt(BusStatus::getBusId))
                        .forEach(status -> {
                            String color = COLORS[status.getBusId() % COLORS.length];
                            String reset = RESET;

                            int progress = (int) ((double) status.getCurrentStationIndex() /
                                    status.getTotalStations() * 20);
                            String progressBar = color + "[";
                            for (int i = 0; i < 20; i++) {
                                progressBar += (i < progress) ? "■" : "□";
                            }
                            progressBar += "]" + reset;

                            System.out.printf(
                                    "%2d | %s%-7s%s | %s%-10s%s | %s%-3s%s | %2d/%-2d | %3d人   | %s\n",
                                    status.getBusId(),
                                    color, status.getStatus(), reset,
                                    color, status.getRouteName(), reset,
                                    color, status.getDirection(), reset,
                                    status.getCurrentStationIndex() + 1, status.getTotalStations(),
                                    status.getPassengerCount(),
                                    progressBar
                            );
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

                busStatusMap.put(busId, new BusStatus(busId, "发车", lineName,
                        isForward ? "正向" : "反向", 0, 0, 0));

                busPool.execute(new BusRunnable(busId, lineName, isForward));
            }
        }
    }

    static class BusStatus {
        private final int busId;
        private volatile String status;
        private final String routeName;
        private final String direction;
        private volatile int currentStationIndex;
        private final int totalStations;
        private volatile int passengerCount;

        public BusStatus(int busId, String status, String routeName,
                         String direction, int currentStationIndex,
                         int totalStations, int passengerCount) {
            this.busId = busId;
            this.status = status;
            this.routeName = routeName;
            this.direction = direction;
            this.currentStationIndex = currentStationIndex;
            this.totalStations = totalStations;
            this.passengerCount = passengerCount;
        }

        // Getters and setters
        public int getBusId() { return busId; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getRouteName() { return routeName; }
        public String getDirection() { return direction; }
        public int getCurrentStationIndex() { return currentStationIndex; }
        public void setCurrentStationIndex(int index) { currentStationIndex = index; }
        public int getTotalStations() { return totalStations; }
        public int getPassengerCount() { return passengerCount; }
        public void setPassengerCount(int count) { passengerCount = count; }
    }

    static class BusRunnable implements Runnable {
        private final int busId;
        private final String routeName;
        private final boolean isForward;
        private int totalRevenue = 0;
        private List<String> stations;
        private int passengerCount = 0;

        public BusRunnable(int busId, String routeName, boolean isForward) {
            this.busId = busId;
            this.routeName = routeName;
            this.isForward = isForward;
        }

        @Override
        public void run() {
            try {
                Line line = createLine();
                stations = new ArrayList<>(line.getStations());
                if (!isForward) {
                    Collections.reverse(stations);
                }

                // 初始化状态
                BusStatus status = busStatusMap.get(busId);
                status.setStatus("运行中");
                status.setCurrentStationIndex(0);
                status.setPassengerCount(0);
                status.setPassengerCount(0);

                Bus bus = new Bus();
                bus.setName(routeName + "-" + busId + "号车");
                bus.setLine(line);

                // 显示发车信息
                synchronized (System.out) {
                    String color = COLORS[busId % COLORS.length];
                    System.out.println(color + "\n★ " + bus.getName() + " 从【" + stations.get(0) + "】发车" +
                            " 方向: " + (isForward ? "正向" : "反向") + RESET);
                }

                List<Person_Max> currentPassengers = new ArrayList<>();

                // 遍历所有站点
                for (int i = 0; i < stations.size(); i++) {
                    String station = stations.get(i);

                    // 更新状态
                    status.setCurrentStationIndex(i);
                    status.setPassengerCount(currentPassengers.size());

                    // 显示到站信息
                    synchronized (System.out) {
                        String color = COLORS[busId % COLORS.length];
                        System.out.println(color + "--------------------------------------------------" + RESET);
                        System.out.println(color + "[" + new Date() + "] " + bus.getName() +
                                " 到达站点: " + station + RESET);
                        System.out.println(color + "方向: " + (isForward ? "正向" : "反向") + RESET);
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

                    synchronized (System.out) {
                        String color = COLORS[busId % COLORS.length];
                        if (!toGetOff.isEmpty()) {
                            System.out.println(color + "本站下车: " + toGetOff.size() + " 人" + RESET);
                        }
                        System.out.println(color + "车上乘客: " + currentPassengers.size() + " 人" + RESET);
                    }

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

                        synchronized (System.out) {
                            String color = COLORS[busId % COLORS.length];
                            System.out.println(color + "本站上车: " + newPassengers + " 人" + RESET);
                            System.out.println(color + "本站收入: " + stationRevenue + " 元" + RESET);
                        }
                    }

                    // 终点站处理
                    if (i == stations.size() - 1) {
                        status.setStatus("到达终点");
                        synchronized (System.out) {
                            String color = COLORS[busId % COLORS.length];
                            System.out.println(color + "\n★ " + bus.getName() + " 到达终点站: " + station + RESET);
                            System.out.println(color + "所有乘客下车: " + currentPassengers.size() + " 人" + RESET);
                            System.out.println(color + "本次运营总收入: " + totalRevenue + " 元" + RESET);
                            System.out.println(color + "车辆结束运营\n" + RESET);
                        }
                    }

                    // 更新乘客数量
                    status.setPassengerCount(currentPassengers.size());

                    // 模拟行车时间
                    TimeUnit.SECONDS.sleep(15);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 从状态监控中移除
                busStatusMap.remove(busId);
            }
        }

        private Line createLine() {
            Line line;
            if ("1路".equals(routeName)) {
                line = new HarbinBusLine1();
            } else {
                line = new HarbinBusLine2();
            }
            // 添加这行初始化站点
            line.initStations();
            return line;
        }
    }
}