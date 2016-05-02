package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_binary_search.txt"));
			int size = sc.nextInt();
			// System.out.println(size);
			int[] item = new int[size];
			for (int i = 0; i < size; i++) {
				item[i] = sc.nextInt();
			}
			int target = sc.nextInt();
			System.out.println(target);
			int result = b_search(item, 15, 0, size - 1);
			System.out.println(result);
			sc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static int b_search(int[] array, int target, int start, int end) {
		if (end-start > 1) {
			int root = (end+start) / 2;
			System.out.println(root);
			if (array[root] == target) {
				System.out.println("root");
				return root;
			} else if (array[root] < target) {
				System.out.println("크다");
				return b_search(array, target, root + 1, end);
			} else
				System.out.println("작다");
			return b_search(array, target, start, root - 1);
		}
		return array[start];
	}

}
