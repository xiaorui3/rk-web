package box;

//  这个类是一个异常???     is-a
public class BoxIndexOutOfBoundsException extends RuntimeException{

    public BoxIndexOutOfBoundsException(){}
    public BoxIndexOutOfBoundsException(String message){
        //父类带String参数的构造方法
        super(message);
    }

}
