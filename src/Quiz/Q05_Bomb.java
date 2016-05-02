/*
 * 문제 5. Matrix에 폭탄을 설치하는데, 3가지 종류의 폭탄이 있다. 각 폭탄은 1, 2, 3칸 범위의 상하좌우로 영향을 미친다.
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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q05_Bomb {
	public static void main(String[] args) throws IOException {
		String source = "/Users/ksy/";
		ArrayList<ArrayList<Integer>> bombInfo = new ArrayList<>();
		int mapSize; // 맵크기
		ArrayList<Integer> tempList = new ArrayList<>();
		Scanner sc = new Scanner(new File(source + "input.txt"));
		mapSize = sc.nextInt();
		sc.nextLine();
		String temp = (sc.nextLine());
		String[] temp2 = temp.split(",");

		for (int i = 0; i < temp2.length; i++) {
			String[] temp3 = temp2[i].split(" ");
			System.out.println(temp2.length);
			for (int j = 0; j < temp3.length / 2; j++) {
				tempList.add(Integer.parseInt(temp3[j * 2]));
				tempList.add(Integer.parseInt(temp3[j * 2 + 1]));
				tempList.add(i);
				bombInfo.add(tempList);
				tempList = new ArrayList<Integer>();
			}
		}
		System.out.println(bombInfo);
		sc.close();

		Bomb bomb = new Bomb(mapSize, bombInfo);
		int result = bomb.start();
		FileWriter fw = new FileWriter(new File(source+"output.txt"));
		fw.write(result+"test2");
		fw.close();

		// System.out.println(sc.nextInt());
	}
} // x y 123

class Bomb {
	private int mapSize;
	private ArrayList<ArrayList<Integer>> bombInfo;
	int[][] map;
	int result=0;

	public Bomb(int mapSize, ArrayList<ArrayList<Integer>> bombInfo) {
		super();
		this.mapSize = mapSize;
		this.bombInfo = bombInfo;
		map = new int[mapSize][mapSize];
	}

	public int start() {
		
		init();
		for(int i=0; i<bombInfo.size();i++){
			set(bombInfo.get(i));
		}
		print();
		
		
		return result;
	}

	private void init() {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = 0;
			}
		}
	}
	private void set(ArrayList<Integer> bombInfo){
		int x = bombInfo.get(0);
		int y = bombInfo.get(1);
		int kind = bombInfo.get(2);
		for(int i = x-kind-1; i< x+kind+2;i++){
			check(i,y);
		}
		for(int j= y-kind-1; j< y+kind+2; j++){
			check(x,j);
		}
		
	}
	private void check(int x, int y){
		if(!(x<0 || x>=mapSize || y <0 || y >=mapSize)){
			map[x][y]=1;
		}
	}
	private void print(){
		for(int y=0; y<mapSize;y++){
			for (int x=0; x<mapSize;x++){
				if(map[x][y]==0)
					result++;
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
		System.out.println(result);
	}

}