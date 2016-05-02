package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

class Dij {
	int start;
	int end;
	int[][] info;
	
	public Dij(int[] startEnd, int[][] info) {
		start = startEnd[0];
		end = startEnd[1];
		this.info = info;
	}

	public String find(String result) {
		for (int i = 0; i < info.length; i++) {
			for (int j = 0; j < info.length; j++) {
				
			}
		}
		return result;

	}

}

public class Dijkstra {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_dij.txt"));
			int[] route = cut(sc.nextLine()); // 0 출발 1 도
			int[] temp = cut(sc.nextLine());
			int[][] inpo = new int[temp.length][temp.length]; // 전체 행렬의 크기를 알기위해
			inpo[0] = temp;
			for (int i = 1; i < temp.length; i++) {
				inpo[i] = cut(sc.nextLine());
			}

			Dij dij = new Dij(route, inpo);

			// System.out.println(Arrays.toString(inpo[4]));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[] cut(String temp) {
		String[] a = temp.split(" ");
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = Integer.parseInt(a[i]);
		}
		return result;
	}
}
