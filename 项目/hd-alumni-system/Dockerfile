FROM docker.1ms.run/node:18-alpine

# 设置工作目录
WORKDIR /app

# 复制依赖文件（利用缓存优化）
COPY ./hd-alumni-system/package.json ./hd-alumni-system/package-lock.json ./
EXPOSE 5173
# 安装依赖
RUN npm ci


# 复制源代码
COPY ./hd-alumni-system .

# 构建项目（如果是生产环境构建，开发环境可省略但这里按需求保留）
RUN npm run build

# 暴露开发服务器端口（根据你的项目配置，通常是3000/8080等）

# 启动开发服务器（使用npm run dev）
CMD ["npm", "run", "dev"]