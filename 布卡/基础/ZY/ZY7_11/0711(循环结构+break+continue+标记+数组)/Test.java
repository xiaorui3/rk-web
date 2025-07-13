public class Test{
	public static void main(String[] args){
		//int[] ageBox = new int[] {10,20,30,40,50};

		//for(int index = 0 ; index<ageBox.length ; index++){
		//	int value = ageBox[index];
		//	System.out.println(value);
		//}


		//ageBox[0] = 100;
		//int value = ageBox[4] ;

		//System.out.println(ageBox[0]);		//100
		//System.out.println(value);		//50

		//System.out.println(ageBox[7]);




		int value = 250;
		int[] array = new int[]{10,20,30};
		array[0] = 100;
		array[1] = array[0];
		array[0] = array[2];
		array[2] = 500;
		array[1] = value;
		for(int v : array){
			System.out.println(v);
		}







	}
}