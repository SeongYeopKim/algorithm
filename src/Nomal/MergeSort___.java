package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort___ {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_merge.txt"));
			String temp = sc.nextLine();
			int max = Integer.parseInt(temp);
			int[] item = new int[max];
			temp = sc.nextLine();
			String[] temp2 = temp.split(" ");
			for (int i = 0; i < item.length; i++) {
				item[i] = Integer.parseInt(temp2[i]);
			}
			System.out.println(Arrays.toString(item));
			item = merge(item);

			System.out.println(Arrays.toString(item));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int[] merge(int[] item) {
		if (item.length > 1) {
			int ele1 = item.length / 2;
			int ele2 = item.length - ele1;
			int[] item1 = new int[ele1];
			int[] item2 = new int[ele2];
			for (int i = 0; i < ele1; i++) {
				item1[i] = item[i];
			}
			for (int i = 0; i < ele2; i++) {
				item2[i] = item[ele1 + i];
			}
			merge(item1);
			merge(item2);
			int a = 0, b = 0, c = 0;
			while (item1.length != a && item2.length != b) {
				if (item1[a] < item2[b]) {
					item[c] = item1[a];
					a++;
					c++;
				} else {
					item[c] = item2[b];
					b++;
					c++;
				}
			}
			while(item1.length!=a){
				item[c]=item1[a];
				c++;
				a++;
			}
			while(item2.length!=b){
				item[c]=item2[b];
				b++;
				c++;
			}
		}
		return item;
	}
}
