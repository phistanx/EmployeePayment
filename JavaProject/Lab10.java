
public class Lab10 {
	public static <E> void sorted(E [] ok){
		E temp;
		for(int i=1;i<=ok.length;i++){
			for(int j=1;j<=ok.length-1;i++){
				if((int)ok[j-1]>(int)ok[j]){
					temp=ok[j-1];
					ok[j-1]=ok[j];
					ok[j]=temp;
				}
			}
		}
		
		for(E element : ok) {
	         System.out.printf("%s ", element);
	      }
	      System.out.println();
	   }
	
	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		sorted(intArray);
	}

}
