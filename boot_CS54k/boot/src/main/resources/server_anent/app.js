// 全局变量
let currentServerId = null;
let cpuChart, memoryChart, diskChart, networkChart;
let updateInterval;
let apiBaseUrl = 'http://45.207.208.85:5000'; // 修改为您的监控中心地址

// 初始化图表
function initCharts() {
    const chartOptions = {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: {
                position: 'top',
            },
            tooltip: {
                mode: 'index',
                intersect: false,
            }
        },
        scales: {
            x: {
                grid: {
                    display: false
                }
            },
            y: {
                beginAtZero: true,
                grid: {
                    color: 'rgba(0, 0, 0, 0.05)'
                }
            }
        },
        interaction: {
            mode: 'nearest',
            axis: 'x',
            intersect: false
        }
    };

    // CPU图表
    const cpuCtx = document.getElementById('cpuChart').getContext('2d');
    cpuChart = new Chart(cpuCtx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [{
                label: 'CPU使用率',
                data: [],
                borderColor: 'rgba(13, 110, 253, 1)',
                backgroundColor: 'rgba(13, 110, 253, 0.1)',
                borderWidth: 2,
                tension: 0.2,
                fill: true,
                pointRadius: 0
            }]
        },
        options: chartOptions
    });

    // 内存图表
    const memoryCtx = document.getElementById('memoryChart').getContext('2d');
    memoryChart = new Chart(memoryCtx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [{
                label: '内存使用',
                data: [],
                borderColor: 'rgba(23, 162, 184, 1)',
                backgroundColor: 'rgba(23, 162, 184, 0.1)',
                borderWidth: 2,
                tension: 0.2,
                fill: true,
                pointRadius: 0
            }]
        },
        options: chartOptions
    });

    // 磁盘图表
    const diskCtx = document.getElementById('diskChart').getContext('2d');
    diskChart = new Chart(diskCtx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [
                {
                    label: '读取',
                    data: [],
                    borderColor: 'rgba(40, 167, 69, 1)',
                    backgroundColor: 'rgba(40, 167, 69, 0.1)',
                    borderWidth: 2,
                    tension: 0.2,
                    pointRadius: 0
                },
                {
                    label: '写入',
                    data: [],
                    borderColor: 'rgba(220, 53, 69, 1)',
                    backgroundColor: 'rgba(220, 53, 69, 0.1)',
                    borderWidth: 2,
                    tension: 0.2,
                    pointRadius: 0
                }
            ]
        },
        options: chartOptions
    });

    // 网络图表
    const networkCtx = document.getElementById('networkChart').getContext('2d');
    networkChart = new Chart(networkCtx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [
                {
                    label: '发送',
                    data: [],
                    borderColor: 'rgba(255, 193, 7, 1)',
                    backgroundColor: 'rgba(255, 193, 7, 0.1)',
                    borderWidth: 2,
                    tension: 0.2,
                    pointRadius: 0
                },
                {
                    label: '接收',
                    data: [],
                    borderColor: 'rgba(111, 66, 193, 1)',
                    backgroundColor: 'rgba(111, 66, 193, 0.1)',
                    borderWidth: 2,
                    tension: 0.2,
                    pointRadius: 0
                }
            ]
        },
        options: chartOptions
    });
}

// 加载服务器列表
function loadServers() {
    fetch(`${apiBaseUrl}/api/servers`)
        .then(response => {
            if (!response.ok) {
                throw new Error('网络响应不正常');
            }
            return response.json();
        })
        .then(servers => {
            updateLastUpdated();
            renderServerList(servers);

            // 默认加载第一个服务器
            if (servers.length > 0 && !currentServerId) {
                loadServerMetrics(servers[0].id);
            }
        })
        .catch(error => {
            console.error('加载服务器列表失败:', error);
            document.getElementById('serverList').innerHTML = `
                <div class="list-group-item text-danger">
                    <i class="bi bi-exclamation-triangle-fill"></i> 无法连接到监控服务
                </div>
            `;
        });
}

// 渲染服务器列表
function renderServerList(servers) {
    const serverList = document.getElementById('serverList');
    serverList.innerHTML = '';

    if (servers.length === 0) {
        serverList.innerHTML = `
            <div class="list-group-item text-muted">
                没有可用的服务器
            </div>
        `;
        return;
    }

    servers.forEach(server => {
        const isActive = server.id === currentServerId;
        const isOnline = isServerOnline(server.last_seen);

        const serverItem = document.createElement('a');
        serverItem.href = '#';
        serverItem.className = `list-group-item list-group-item-action ${isActive ? 'active' : ''}`;
        serverItem.innerHTML = `
            <div class="d-flex w-100 justify-content-between">
                <h6 class="mb-1">
                    <span class="status-indicator ${isOnline ? 'status-online' : 'status-offline'}"></span>
                    ${server.name || server.id}
                </h6>
                <small>${formatDateTime(server.last_seen)}</small>
            </div>
            <p class="mb-1 text-muted">${server.ip || 'IP未记录'}</p>
        `;
        serverItem.addEventListener('click', (e) => {
            e.preventDefault();
            loadServerMetrics(server.id);
        });

        serverList.appendChild(serverItem);
    });
}

// 加载服务器指标数据
function loadServerMetrics(serverId) {
    currentServerId = serverId;

    // 高亮选中的服务器
    document.querySelectorAll('#serverList .list-group-item').forEach(item => {
        item.classList.toggle('active', item.textContent.includes(serverId));
    });

    fetch(`${apiBaseUrl}/api/metrics/${serverId}?limit=60`)
        .then(response => {
            if (!response.ok) {
                throw new Error('网络响应不正常');
            }
            return response.json();
        })
        .then(metrics => {
            if (metrics.length === 0) {
                document.getElementById('detailTitle').textContent = `无数据 - ${serverId}`;
                return;
            }

            document.getElementById('detailTitle').textContent = `${serverId} - 监控数据`;
            updateCurrentMetrics(metrics[metrics.length - 1]);
            updateCharts(metrics);
            updateProcessTable(metrics[metrics.length - 1].top_processes);
        })
        .catch(error => {
            console.error('加载指标数据失败:', error);
            document.getElementById('detailTitle').textContent = `加载失败 - ${serverId}`;
        });
}

// 更新当前指标值
function updateCurrentMetrics(metric) {
    document.getElementById('currentCpu').textContent = `${metric.cpu_percent.toFixed(1)}%`;
    document.getElementById('currentMem').textContent = `${metric.mem_percent.toFixed(1)}%`;
    document.getElementById('currentDiskRead').textContent = `${(metric.disk_read / 1024).toFixed(1)} KB/s`;
    document.getElementById('currentNetSent').textContent = `${(metric.net_sent / 1024).toFixed(1)} KB/s`;
}

// 更新所有图表
function updateCharts(metrics) {
    const labels = metrics.map(m => formatTime(m.timestamp));

    // CPU图表
    updateChart(cpuChart, labels,
        metrics.map(m => m.cpu_percent),
        'CPU使用率');

    // 内存图表
    updateChart(memoryChart, labels,
        metrics.map(m => m.mem_percent),
        '内存使用');

    // 磁盘图表 (转换为KB)
    updateMultiDatasetChart(diskChart, labels,
        [
            metrics.map(m => m.disk_read / 1024),
            metrics.map(m => m.disk_write / 1024)
        ],
        ['读取', '写入']
    );

    // 网络图表 (转换为KB)
    updateMultiDatasetChart(networkChart, labels,
        [
            metrics.map(m => m.net_sent / 1024),
            metrics.map(m => m.net_recv / 1024)
        ],
        ['发送', '接收']
    );
}

// 更新单数据集图表
function updateChart(chart, labels, data, label) {
    chart.data.labels = labels;
    chart.data.datasets[0].data = data;
    chart.data.datasets[0].label = label;
    chart.update();
}

// 更新多数据集图表
function updateMultiDatasetChart(chart, labels, dataArray, labelsArray) {
    chart.data.labels = labels;
    dataArray.forEach((data, i) => {
        chart.data.datasets[i].data = data;
        chart.data.datasets[i].label = labelsArray[i];
    });
    chart.update();
}

// 更新进程表格
function updateProcessTable(processes) {
    const tableBody = document.getElementById('processTable');

    if (!processes || processes.length === 0) {
        tableBody.innerHTML = `
            <tr>
                <td colspan="4" class="text-center py-4">没有进程数据</td>
            </tr>
        `;
        return;
    }

    tableBody.innerHTML = '';

    processes.slice(0, 10).forEach(proc => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${proc.pid}</td>
            <td>${proc.name || '未知'}</td>
            <td>${proc.cpu_percent.toFixed(1)}%</td>
            <td>${proc.memory_percent.toFixed(1)}%</td>
        `;
        tableBody.appendChild(row);
    });
}

// 更新最后更新时间
function updateLastUpdated() {
    const now = new Date();
    document.getElementById('lastUpdated').textContent =
        `最后更新: ${now.toLocaleTimeString()}`;
}

// 检查服务器是否在线
function isServerOnline(lastSeen) {
    if (!lastSeen) return false;
    const lastSeenDate = new Date(lastSeen);
    const now = new Date();
    return (now - lastSeenDate) < 5 * 60 * 1000; // 5分钟内活跃视为在线
}

// 格式化时间
function formatTime(timestamp) {
    const date = new Date(timestamp);
    return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
}

// 格式化日期时间
function formatDateTime(timestamp) {
    if (!timestamp) return '未知';
    const date = new Date(timestamp);
    return date.toLocaleString([], {
        month: 'short',
        day: 'numeric',
        hour: '2-digit',
        minute: '2-digit'
    });
}

// 页面加载完成后初始化
document.addEventListener('DOMContentLoaded', () => {
    initCharts();
    loadServers();

    // 每30秒刷新一次数据
    updateInterval = setInterval(() => {
        loadServers();
        if (currentServerId) {
            loadServerMetrics(currentServerId);
        }
    }, 30000);
});