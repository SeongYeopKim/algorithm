/*
 * 문제 4.  2개의 집합의 숫자들이 입력되면, 중복된 숫자를 지운 합집합을 구하여 최종 갯수 출력
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * input ex) 
 * 구할거 갯수, 두개의 집합 차례로 입력
 * 2
 * 1 2 3 4 4 5 5 7 9, 1 2 5 3 4 
 * 3 4 3 2 5 5 6 3 4, 3 2 4 5 5
 * ________
 * 
 */


package Quiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

class Bag {
	String[] input;
	int cnt; // 갯수

	public Bag(String[] input, int cnt) {
		super();
		this.input = input;
		this.cnt = cnt;
	}

	public int cal(String item) {
		int result = 0;
		String[] temp = item.split(",");
		String[] temp1 = temp[0].split(" ");
		String[] temp2 = temp[1].split(" ");
		int[] item1 = new int[temp1.length + temp2.length-1];
		int k = 0;
		for (int i = 0; i < temp1.length; i++) {
			item1[i] = Integer.parseInt(temp1[i]);
			System.out.print(item1[i]);
		}
		System.out.println();
		for (int i = 0; i < temp2.length; i++) {
			item1[temp1.length-1 + i] = Integer.parseInt(temp2[i]);
		}
		HashSet<Integer> hashSet = new HashSet<>();
		int[] re = new int[item1.length];
		System.out.println(item1.length);
		for (int i = 0; i < item1.length-1; i++) {
			System.out.print(item1[i]);
			boolean bo = true;
			if (result == 0) {
				re[0] = item1[0];
				++result;
			} else {
				for (int j = 0; j < result; j++) {
					//System.out.print("i" + i+ "j"+j);
					if (re[j] == item1[i]) {
						bo = false;
					}
				}
				if (bo) {
					re[result] = item1[i];
					result++;
				}

			}

			hashSet.add(item1[i]);
		}
		System.out.println();
		System.out.println(item1.length);
		
		System.out.println(hashSet.size());

		return result;
	}
	// String[] temp = item.split(",");
	// String[][] temp2 = new String[temp.length][100];
	// int[][] inItem = new int[temp.length][100];
	// for(int i=0; i<temp.length;i++){
	// temp2[i]= temp[i].split(" ");
	// System.out.println("len: "+ temp2[i].length);
	// }
	//
	//
	// for(int i=0; i<temp2.length; i++){
	// for(int j=0; j<temp2[i].length; j++){
	// inItem[i][j] = Integer.parseInt(temp2[i][j]);
	// System.out.print(inItem[i][j]+ " ");
	// }
	// System.out.println();
	// }
	// compare(inItem[0],inItem[1]);
	// return 0;
	// }
	// public int compare(int[] a, int[] b){
	// int result=0;
	// int i=0;
	// int j=0;
	// int[] sum = new int[a.length+b.length];
	// if(a.length!= 0){ //a 에만 값이 있을 경우
	// sum[0]=a[0];
	// i++;
	// result++;
	// }else if(b.length != 0 ){ //b에만 값이 있을 경우
	// sum[0]= b[0];
	// result++;
	// j++;
	// }else{ //값이 없을 경우
	// return result;
	// }
	// System.out.println(a.length);
	// while(a.length!=i && b.length!=j){
	// for(int k=0; k<sum.length; k++){
	// if(sum[k]!=a[i]){
	// sum[result]=a[i];
	// i++;
	// result++;
	// }
	// }
	// }
	// for(int k=0; k<sum.length; k++){
	// System.out.println("k:" +sum[k]);}
	// return result;
	// }

	public void start() {
		cal(input[0]);
	}

}

public class Q04_Union {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_real04.txt"));
			int cnt = sc.nextInt();
			String[] temp = new String[cnt];
			sc.nextLine();
			for (int i = 0; i < cnt; i++) {
				temp[i] = sc.nextLine();
			}
			Bag bag = new Bag(temp, cnt);
			// System.out.println(sc.nextInt());
			bag.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("실행시간" + (end - start));
	}
}
