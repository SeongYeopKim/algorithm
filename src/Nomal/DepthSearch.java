package Nomal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Graph {
	int[][] gragh;
	int max;
	int start;
	int[] visit;

	public Graph(int max, int start) {
		super();
		this.max = max;
		this.start = start;
		gragh = new int[max][max];
		visit = new int[max];
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				gragh[i][j] = 0;
			}
		}
	}

	public void add(int a, int b) {
		gragh[a][b] = 1;
		gragh[b][a] = 1;
		//System.out.println("a: " + a + " b : " + b);
	}

	public void print() {
		for (int j = 0; j < max; j++) {
			for (int i = 0; i < max; i++) {
				System.out.print(gragh[i][j] + " ");
			}
			System.out.println();
		}
	}

	public String search(int v, String result) {
		visit[v] = 1;
		for (int i = 0; i < max; i++) {
			if (gragh[v][i] == 1 && visit[i] != 1) {
//				System.out.println(v + " " + i);
				result= result+v+" "+i+"\n";
				result = search(i, result);
			}
		}
		return result;

	}

}

public class DepthSearch {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new  Scanner(new File(url + "input_depth.txt"));
			String temp = sc.nextLine();
			String[] temp2 = temp.split(" ");
			int cnt = Integer.parseInt(temp2[0]);
			int start = Integer.parseInt(temp2[1]);
		//	System.out.println(Arrays.toString(temp2));

			temp = sc.nextLine();
			temp2 = temp.split(" ");
			int[] item = new int[temp2.length - 2];
			for (int i = 0; i < temp2.length - 2; i++) {
				item[i] = Integer.parseInt(temp2[i]);
			}
			Graph graph = new Graph(cnt, start);
			//System.out.println(Arrays.toString(item));
			for (int i = 0; i < item.length / 2; i++) {
				graph.add(item[i * 2] - 1, item[i * 2 + 1] - 1);
			}
			//graph.print();
			String a=graph.search(start-1, "");
			System.out.println(a);
			FileWriter fw = new FileWriter(new File(url+"output_depth.txt"));
			fw.write(a);
			sc.close();
			fw.close();
			//System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
