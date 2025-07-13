package java代码.异常;

import java.util.logging.Logger;

public class 错误日志 {
    private static Logger log = Logger.getLogger(错误日志.class.toString());
    public static void main(String[] args) {
        // 级别依次升高，后面的日志级别会屏蔽之前的级别
        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("server");
/**
 * 级别	SEVERE	WARNING	INFO	CONFIG	FINE	FINER	FINEST
 * 调用方法	severe()	warning()	info()	config()	fine()	finer()	finest()
 * 含义	严重	警告	信息	配置	良好	较好	最好
 */
    }
}
