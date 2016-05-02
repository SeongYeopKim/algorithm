package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertSort {
	public static void main(String[] args) throws FileNotFoundException {
		String url = "/Users/ksy/sorceCode/";
		Scanner sc = new Scanner(new File(url + "input_select.txt"));
		Integer[] item = new Integer[100];
		int max = 0;
		while (sc.hasNextInt()) {
			item[max] = sc.nextInt();
			max++;
		}
		System.out.println("test"+item[max-2]);
		max= max-1;
		for (int i = 0; i <max; i++) {
			System.out.print(item[i] + " ");
		}
		System.out.println();
		sc.close();
		// int size =1;
		int loc = 0;
		for (int size = 1; size < max; size++) {
			for (int i = 0; i < size; i++) {
				if (item[i] < item[size] && item[i + 1] >= item[size]) {
					loc = i+1;
					System.out.println();
					System.out.println("loc : " + loc);  //위치찾기
				}
			}
			int temp = 0;
			temp = item[size];
			item[size] = item[loc];

			for (int i = size; i >loc; i--) {
				item[i] = item[i - 1];
			}
			item[loc] = temp;
			System.out.println();
			for (int i = 0; i < max; i++) {
				System.out.print(item[i] + " ");
			}
		}
		// System.out.println(loc+" "+ item[loc]);
		for(int i =0; i<max; i++){
			if(item[max]== item[i]){
				max = i;
			}
		}
		System.out.println();
		System.out.println(max+1 +"번째 달린");
	}

}