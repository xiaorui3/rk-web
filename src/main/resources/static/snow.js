// 动态雪花生成系统
function createSnowflake() {
    const snow = document.createElement('div');
    snow.className = 'snowflake';
    
    // 随机属性
    const size = Math.random() * 10 + 5;
    const startX = Math.random() * 100;
    const duration = Math.random() * 5 + 5;
    
    snow.style.cssText = `
        width: ${size}px;
        height: ${size}px;
        background: rgba(255,255,255,0.8);
        border-radius: 50%;
        position: fixed;
        top: -20px;
        left: ${startX}%;
        pointer-events: none;
        animation: snowFall ${duration}s linear infinite;
        filter: blur(${size/5}px);
    `;

    document.body.appendChild(snow);

    // 动画结束后移除
    setTimeout(() => snow.remove(), duration * 1000);
}

// 每0.5秒生成雪花
setInterval(createSnowflake, 500);

// 初始生成一批雪花
Array.from({length: 15}).forEach(createSnowflake);