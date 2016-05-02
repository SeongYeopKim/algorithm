package Quiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//정원에 있는 휴지들의 좌표들이 주어질 때, 모든 휴지들을 줍고 나갈 수 있는 최적의 경로를 구하는 코드를 작성하세요.
//정원은 2차원 좌표로 각 휴지들의 좌표는 모두 정수형으로 주어집니다. 출발점은 (0,0) 이며, 도착점 (10,10) 입니다.
//최적의 경로는 이동한 거리의 합이 가장 짧은 경로입니다. 최적인 경로가 여러가지일 경우, 아무 경로나 출력합니다.
//입력 조건
//
//첫 번째 라인에 휴지의 개수 N 이 주어집니다.
//두 번째 라인부터 N 개의 라인은 각각이 휴지 하나의 좌표입니다. 
//좌표 X 와 좌표 Y 는 공백으로 구분됩니다. 크기 제한은 다음과 같습니다. 중복된 좌표는 없습니다.
//1 <= N <= 10, 정수
//0 <= X, Y <= 10, 정수
class Map {
	double[][] info; // 경로 길이 찾기;
	int[] x;
	int[] y;
	int cnt;

	public Map(int cnt) {
		super();
		this.cnt = cnt + 2;
		x = new int[this.cnt];
		y = new int[this.cnt];
		x[0] = 0;
		y[0] = 0;
		x[this.cnt - 1] = 10;
		y[this.cnt - 1] = 10;

	}

	public void init() { // 모든 정보를 입력한 후에 실행
		info = new double[cnt][cnt];
		System.out.println(cnt + "dfd");
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				// System.out.println(" aa "+ x[i]+" " +y[j]+" aa ");
				info[i][j] = makeInfo(i, j);
				//System.out.print((int) info[i][j] + " ");
				System.out.printf( "%f\t" ,info[i][j]);
			}
			System.out.println();
			System.out.println();
		}
	}

	public void add(String x, String y, int i) {
		this.x[i] = Integer.parseInt(x);
		this.y[i] = Integer.parseInt(y);
	}

	public double makeInfo(int cnt1, int cnt2) {
		return Math.sqrt((x[cnt1] - x[cnt2]) * (x[cnt1] - x[cnt2]) + (y[cnt1] - y[cnt2]) * (y[cnt1] - y[cnt2]));

	}

	public int[] findRoute() {

		int[][] route = new int[cnt][cnt];
		
		
		return null;
		// int[] route = new int[cnt];
		// 탐욕기법으로 찾으려 도전했으나, 이건 모든 길을 찾는 알고리즘이라는걸 뒤늦게 깨달았습니다.
		// int sig = 0;
		// int i = 0;
		// while (sig != cnt) {
		// sig++;
		//
		// double min = 20; // 최대값설정
		// int loc = 0;
		// for (int j = 0; j < cnt; j++) {
		// if (info[i][j] != 0 && min > info[i][j]) {
		// min = info[i][j];
		// loc = j;
		// }
		// }
		//
		// System.out.println("min : " + min + " loc : " + loc);
		// info[loc][i] = 0;
		// info[i][loc] = 0;
		// route[i] = loc;
		// i = loc;
		//
		// }
		// return route;

	}
}

public class Test03 {
	public static void main(String[] args) {
		String url = "/Users/ksy/";
		try {
			Scanner sc = new Scanner(new File(url + "input03.txt"));
			Map map = new Map(sc.nextInt());
			sc.nextLine();
			String[] temp = new String[2];
			int i = 0;
			while (sc.hasNextLine()) {
				i++;
				temp = sc.nextLine().split(" ");
				map.add(temp[0], temp[1], i);
			}
			map.init();
			map.findRoute();
			sc.close();

			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
