package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort___ {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_quick.txt"));
			String temp = sc.nextLine();
			String[] temp2 = temp.split(" ");
			System.out.println(temp);
			int[] item = new int[temp2.length];
			for (int i = 0; i < temp2.length; i++) {
				item[i] = Integer.parseInt(temp2[i]);
			}
			item = quick(item, 0, item.length - 1);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int[] quick(int[] item, int start, int end) {
		if (start <= end) {
			int pivot = item[end];
			int div = start;
			for (int i = start; i < end; i++) {
				if (item[i] <= pivot) {
					item = exchange(item, i, div);
					div++;
				}
				System.out.println(Arrays.toString(item));
			}
			System.out.println("end : " + end + "pivot : " + div);
			item = exchange(item, end, div);
			System.out.println(Arrays.toString(item));
			quick(item, start, div - 1);
			quick(item, div + 1, end);
		}
		return item;
	}

	private static int[] exchange(int[] item, int i, int div) {
		int temp = item[i];
		item[i] = item[div];
		item[div] = temp;
		return item;
	}

}
