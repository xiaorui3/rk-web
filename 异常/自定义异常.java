package java代码.异常;

public class 自定义异常 {
    static class SelfException extends RuntimeException {
        SelfException() {
        }
        SelfException(String msg) {
            super(msg);
        }
    }
    public class PrintStackTraceTest {
        public static void main(String[] args) {
            firstMethod();
        }
        public static void firstMethod() {
            secondMethod();
        }
        public static void secondMethod() {
            thirdMethod();
        }
        public static void thirdMethod() {
            throw new SelfException("自定义异常信息");
        }
    }
}
