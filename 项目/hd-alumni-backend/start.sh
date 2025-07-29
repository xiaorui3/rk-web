#!/bin/bash

# 启动MySQL服务
/usr/local/bin/docker-entrypoint.sh mysqld &

# 等待MySQL启动（最多等待30秒）
count=0
while ! mysqladmin ping -h localhost --silent; do
    ((count++))
    if [ $count -ge 30 ]; then
        echo "MySQL启动超时"
        exit 1
    fi
    sleep 1
done

# 启动Java应用
java -jar /app/app.jar
