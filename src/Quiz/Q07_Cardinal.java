/*
 * 문제 7. 동서남북 복불복 게임으로 내기  첫 시작위치,와 횟수를 입력하면, 그 위치에서부터 영문자로 동서남북을 정하고 해당 숫자만큼 이동하는 것이다.
 * 입력된 횟수만큼을 반복하여 최종 도착지 숫자에 1000을 곱한 만큼 돈을 거둔다. 범위를 벗어나는 경우 10000원을 거둔다.
 * 폭탄의 영향이 없는 위치의 갯수 구하기 
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * input ex) 
 * 맵크기 입력, 테스트 케이스 갯수, 맵 입력, 
 * 시작위치 a,b 이동횟수 입력
 *
7
3
E3 S2 S4 S5 E2 S1 S5
N2 S3 S2 E1 N3 W4 N3
W1 N1 E3 W3 S3 W1 S3
E3 S2 N2 S2 E1 N2 W3
N3 E3 S1 N1 W3 E1 W1
E1 N2 W1 N3 S2 N3 W5
N5 E1 n4 W3 N5 W1 S1
3 4 3
2 3 4
4 6 5
 * 
 */





package Quiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Q07_Cardinal {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_mid01.txt"));
			int size = sc.nextInt();
			int tCnt = sc.nextInt();
		//	System.out.println(size + " " + tCnt);
			String[][] matrix = new String[size][size];
			sc.nextLine();
			for (int i = 0; i < size; i++) {
				matrix[i] = sc.nextLine().split(" ");
				System.out.println(Arrays.toString(matrix[i]));
			}
			String[][] temp = new String[tCnt][3];
			int[][] tCase = new int[tCnt][3];
			for (int i = 0; i < tCnt; i++) {
				temp[i] = sc.nextLine().split(" ");
				for (int j = 0; j < 3; j++) {
					tCase[i][j] = Integer.parseInt(temp[i][j]);
				}
				tCase[i][0]--; // 좌표
				tCase[i][1]--;

			}
			for (int i = 0; i < tCnt; i++) {
				System.out.println(start(tCase[i], matrix));
			}
			System.out.println(Arrays.toString(get(matrix, 3, 4)));
			// System.out.println(Arrays.toString(tCase[0]));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int start(int[] tCase, String[][] matrix) {
		int result = 0;
		int[] temp = tCase;
		for (int i = 0; i < tCase[2]; i++) {
			if (temp[0] != -1) {
				temp = get(matrix, temp[0], temp[1]);
				//System.out.println("y : " +  temp[0]+" x : "+temp[1]);

			}

		}
		if(temp[0] == -1)
			result = 10000;
		else
			result = temp[2]*1000;
		
		return result;

	}

	public static int[] get(String[][] matrix, int y, int x) {
		int[] next = new int[3]; // 0 :y 1:x 3:갯수 W <- E ->
		char[] item = matrix[y][x].toCharArray();
		int idx = item[1] - 48;
		//System.out.println("idx" + idx);
		switch (item[0]) {
		case 'W':
			if (x - idx >= 0) {
				next[0] = y;
				next[1] = x - idx;
				next[2] = get2(matrix[next[0]][next[1]]);
			} else
				next[0] = -1;
			break;
		case 'E':
			if (x + idx < matrix.length) {
				next[0] = y;
				next[1] = x + idx;
				next[2] = get2(matrix[next[0]][next[1]]);
			} else
				next[0] = -1;
			break;
		case 'S':
			if (y + idx < matrix.length) {
				next[0] = y + idx;
				next[1] = x;
				next[2] = get2(matrix[next[0]][next[1]]);
			} else
				next[0] = -1;
			break;
		case 'N':
			if (y - idx >= 0) {
				next[0] = y - idx;
				next[1] = x;
				next[2] = get2(matrix[next[0]][next[1]]);
			} else
				next[0] = -1;
			break;

		}
		return next;
	}

	public static int get2(String a) {
		char[] item = a.toCharArray();
		return item[1] - 48;
	}
}
