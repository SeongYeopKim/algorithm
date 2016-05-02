package Quiz;
/*
 * 문제 1. 0,4 부터 4,0으로 최소비용으로 가는 길 찾기
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * 해결방법:
 *  맵과 같은 크기의 배열 생성 max 값으로 초기화 
 *  0의 경우 10까지 실행
 *  0의 경우 맵에서 0인 값들을 실제값으로 변경. 길이 나오는지 찾는다. 없으면 1의 case실행 계속 없으면 9 까지증가
 *  진흙의 정보를 담은 int[][] map 객체, 윗 줄의 정보를 담은것이 tMap,
 *  한 개의 경우에서 방문했던 길인지 알기위한 tempMap객체 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *  
 * */
class JRoom {
	int[][] map;		//진흙 정보
	boolean[][] tMap;	//각 케이스별 갈수있는 길인지 체크 

	public JRoom(int[][] map) { // 초기화
		super();
		this.map = map;
		tMap = new boolean[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				tMap[i][j] = false;
			}
		}

	}

	public void makeCase(int i) {  // i 의 숫자보다 작은 진흙이 있는 곳은 갈 수 있게 만든다
		for (int j = 0; j < map.length; j++) {
			for (int k = 0; k < map.length; k++) {
				if (map[j][k] <= i) {
					tMap[j][k] = true;
				}
			}
		}
		tMap[0][0] = true; // 0,0 은 무조건 밟을수 밖에없다!
		tMap[map.length - 1][map.length - 1] = true; // 도착지 또한
	}

	public int start() {
		boolean[][] tempMap = new boolean[map.length][map.length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				tempMap[i][j] = true;
			}
		}
		int min = 100;								//진흙은 최대 100까지만
		for (int i = 0; i < 10; i++) {
			makeCase(i);							//케이스 생성 후 , 길 비교. 그중 가장 짧은게 해답
			int dirty = findRoute(tempMap, 0, 0, 0);
			if (min > dirty/100 && dirty/100>0) {
				min = dirty/100;
			}
		}
		return min;
	}

	public int findRoute(boolean[][] tempMap, int x, int y, int dirty) {

		dirty += map[x][y];
		tempMap[x][y] = false;
		if (x == 4 && y == 4) {
			
			return dirty * 100;					// 4,4에 도달했는지 확인하기 위해 *100
		} else {
			if (x >= 0 && x < map.length && y >= 0 && y < map.length) {
				if (x + 1 < map.length) {
					if (tMap[x + 1][y] == true && tempMap[x + 1][y] == true) {
						dirty = findRoute(tMap, x + 1, y, dirty);
					}
				}
				if (y + 1 < map.length) {
					if (tMap[x][y + 1] == true && tempMap[x][y + 1] == true) {
						dirty = findRoute(tMap, x, y + 1, dirty);
					}
				}
				if (x - 1 >= 0) {
					if (tMap[x - 1][y] == true && tempMap[x - 1][y] == true) {
						dirty = findRoute(tMap, x - 1, y, dirty);
					}
				}
				if (y - 1 >= 0) {
					if (tMap[x][y - 1] == true && tempMap[x][y - 1] == true) {
						dirty = findRoute(tMap, x, y - 1, dirty);
					}
				}

			}
		}

		return dirty;
	}

}

public class Test04 {
	public static void main(String[] args) {
		String url = "/Users/ksy/";
		final int intToChar = 48;
		long start = System.currentTimeMillis();

		try {
			Scanner sc = new Scanner(new File(url + "input04.txt"));

			int cnt = sc.nextInt();
			int[][] map = new int[cnt][cnt];
			sc.nextLine();
			for (int i = 0; i < cnt; i++) {
				String temp = sc.nextLine();
				char[] temp2 = temp.toCharArray();
				for (int j = 0; j < temp2.length; j++) {
					map[i][j] = temp2[cnt - 1 - j] - intToChar; // 0,4에서 4,0로가는게
																// 헷갈리므로 0,0-> 4,4로 변경!
				}
			}
			JRoom room = new JRoom(map);
			int result = room.start();
			System.out.println(result);
			sc.close();
			System.out.println("수행시간 : " +(System.currentTimeMillis() - start) + "mls");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
