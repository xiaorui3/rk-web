
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args){
		String[] userBox = {"zhangsan","wangwu","zzt"};
		int[] passwordBox = {333,555,888};

		Scanner input = new Scanner(System.in);
		System.out.println("请输入账号：");
		String name = input.nextLine();
		System.out.println("请输入密码：");
		int password = input.nextInt();	//nextLine()--Integer.parseInt()
		
		//通过循环找userBox的数，与输入的name挨个比较
		boolean flag = false;	
		for(int i=0;i<userBox.length;i++){
			if(userBox[i].equals(name)){
				if(passwordBox[i]==password){
					System.out.println("登录成功");
					flag = true;
				}
				break;
			}
		}
		if(!flag){
			System.out.println("用户名或密码错误");
		}
		//用户名或密码错误，想要输出，flag标记就不能改
		//什么时候能改呢？全对-登录成功的时候
	}
}



