/*
 * 문제 8. 엘레베이터의 운행 거리 측정하기 
 * 한순간 한사람만 이용가능하고, 하루에 n명의 사람이 이용할 경우의 총 운행 수
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * input ex) 
 * 이용자수, 이용자의 위치와 목적 층수를 차례로 입 
 * 3
 * -2 10
 * 1 15
 * 7 -1 
 */



package Quiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Elevator {
	int count; // 총 운행한 층수

	void display(int floor) {
		if (floor != 0) {
			System.out.print(floor + ">");
			count++;
		}
	}

	void move(int start, int end) {
		int floor; // 이동하는 엘리베이터 층수
		System.out.println("<<Elevator moving");
		if (start > end) {
			for (floor = start; floor >= end; floor--) {
				display(floor);
			}
			count--;
		} else if (start < end) {
			for (floor = start; floor <= end; floor++)
				display(floor);
			count--;
		}
		System.out.println("\n This floor is " + end + "th. Thank you");
	}
}

public class Q08_Elevator {
	public static void main(String[] args) {
		try {
			String url = "/Users/ksy/sorceCode/";
			Scanner sc = new Scanner(new File(url + "input_mid03.txt"));
			int users = sc.nextInt();
			int[] start = new int[users];
			int[] end = new int[users];
			Elevator ev = new Elevator();
			int begin = 1;
			for (int i = 0; i < users; i++) {
				start[i] = sc.nextInt();
				end[i] = sc.nextInt();
			}
			sc.close();
			for (int i = 0; i < users; i++) {
				System.out.println("users" + i);
				ev.move(begin, start[i]);
				System.out.println("Enter the ev!");
				ev.move(start[i], end[i]);
				System.out.println("Arrived!");
				begin = end[i];

			}
			System.out.println("count : " + ev.count);
			FileWriter fw = new FileWriter(new File(url+"output_mid03.txt"));
			fw.write(ev.count+ " ");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
