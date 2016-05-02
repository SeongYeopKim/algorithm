package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChoiceSort__ {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		Scanner sc;
		try {
			sc = new Scanner(new File(url + "input_choice.txt"));
			int max = 10;
			Integer[] item = new Integer[max];
			int i = 0;

			while (sc.hasNextInt()) {
				item[i] = sc.nextInt();
				System.out.print(item[i] + " ");
				i++;
			}
			sc.close();

			
			int cnt = max; 
			int temp1=0, temp2=0;
			for(i=0; i<max; i++){
				for(int j=0; j<cnt; j++){
					if(item[i]>temp1){
						temp1= item[i] ; //maximum;
						temp2=j;
					}
				}
				item[temp2] = item[max-1];
				item[cnt-1]= temp1;
				cnt--;
			}
			System.out.println();
			for(i=0; i<max; i++){
				System.out.print(item[i]+" ");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
