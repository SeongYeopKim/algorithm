/*
 * 문제 5. Matrix에 폭탄을 설치하는데, 3가지 종류의 폭탄이 있다. 각 폭탄은 1, 2, 3칸 범위의 상하좌우,대각선으로 영향을 미친다.
 * 폭탄의 영향이 없는 위치의 갯수 구하기 
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * input ex) 
 * 갯수 , 맵크기, 폭탄좌표
 * 1
 * 7
 * 0 0 1 5 ,1 1 2 4, 3 2 5 5
 * ________
 *  
 */
package Quiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Queen {
	private int mapSize;
	private ArrayList<ArrayList<Integer>> qList;
	private int[][] map;
	private int result=0;

	public Queen(int mapSize, ArrayList<ArrayList<Integer>> qList) {
		super();
		this.mapSize = mapSize;
		this.qList = qList;
	}

	public int start() {
		init();
		
		return insert();
	}

	private int insert() {
		for (int i = 0; i < qList.size(); i++) {
			int x = qList.get(i).get(0);
			int y = qList.get(i).get(1);
			int cnt = qList.get(i).get(2);
			for (int j = x - cnt; j <= x + cnt; j++) {
				check(j, y);
			}
			for (int j = y - cnt; j <= y + cnt; j++) {
				check(x, j);
			}
			map[x][y] = cnt+10;
			for (int j = 1; j <= cnt; j++) {
				check(x - j, y - j);
				check(x + j, y + j);
				check(x - j, y + j);
				check(x + j, y - j);
				
			}
		}
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				System.out.print(map[i][j] + "\t");
				if(map[i][j]==0)
					result++;
			}
			System.out.println();
		}
		return result;
	}

	private void check(int x, int y) {
		if (!(x < 0 || x >= mapSize || y < 0 || y >= mapSize)) {
			map[x][y] = 1;
		}
	}

	private void init() {
		map = new int[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = 0;
			}
		}
	}

}

public class Q06_Bomb2 {
	public static void main(String[] args) throws IOException {

		String url = "/Users/ksy/";
		Scanner sc = new Scanner(new File(url + "input.txt"));
		int mapSize = Integer.parseInt(sc.nextLine());

		ArrayList<ArrayList<Integer>> qList = new ArrayList<>();

		// 값 분리하기
		ArrayList<Integer> tempList;

		String temp1 = sc.nextLine();
		String[] temp2 = temp1.split(",");
		for (int i = 0; i < temp2.length; i++) {
			String[] temp3 = temp2[i].split(" ");
			for (int j = 0; j < temp3.length / 2; j++) {
				tempList = new ArrayList<>();
				tempList.add(Integer.parseInt(temp3[j * 2])); // x
				tempList.add(Integer.parseInt(temp3[j * 2 + 1])); // y
				tempList.add(i + 1); // 타입 형태
				qList.add(tempList);
			}
		}
		sc.close();

		System.out.println("size: " + mapSize + "\n qList:" + qList.toString());
		Queen q = new Queen(mapSize, qList);
		int result = q.start();
		System.out.println(result);
		FileWriter fw = new FileWriter(new File(url+"output2.txt"));
		fw.write(Integer.toString(result));
		fw.close();

	}
}
