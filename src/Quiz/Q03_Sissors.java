/*
 * 문제 3.  시저 암호 알고리즘 문자열의 순서를 입력받은 수만큼 밀기
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * input ex) 
 * 입력할 갯수, 몇칸 밀지, 문자열
 * 1
 * 3 HELLOWORLD
 * ________
 * 
 */

package Quiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Transformer {
	final int A = 65;
	final int Z = 90;
	final int a = 97;
	final int z = 122;
	String[] item;
	int[] pw;

	public Transformer(String[] item, int[] pw) {
		super();
		this.item = item;
		this.pw = pw;
	}

	public String get() {
		String result = "";
		for (int i = 0; i < item.length; i++) {
			char[] temp = new char[item[i].length()];
			temp = item[i].toCharArray();
			System.out.println(pw[i]);
			for (int j = 0; j < temp.length; j++) {
				
				if (temp[j] >= a && temp[j] <= z) { // 입력 문자가 소문
					temp[j] = (char)(temp[j] - (a-A));
				//	System.out.println(temp[j]);
					//System.out.print("+");
				}
				//System.out.print((temp[j] + pw[i])%(A-Z));
				temp[j] = (char) (A + ((temp[j] + pw[i] -A)%(Z-A+1)));
				System.out.print(temp[j] );
				//System.out.print( " ->" +temp[j] + " ");
				// result += temp[j];
			}
			System.out.println();
			result += "\n";
		}
		//System.out.println(result);

		return result;
	}
}

public class Q03_Sissors {
	public static void main(String[] args) {

		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_real03.txt"));
			int cnt = sc.nextInt();
			sc.nextLine();
			String[] temp = new String[cnt];
			String[][] temp2 = new String[cnt][2];
			String[] item = new String[cnt];
			int[] pw = new int[cnt];
			int i = 0;
			while (sc.hasNextLine()) {
				temp[i] = sc.nextLine();
				temp2[i] = temp[i].split(" ");
				pw[i] = Integer.parseInt(temp2[i][0]);
				item[i] = temp2[i][1];
				i++;
			}
			sc.close();
			Transformer tf = new Transformer(item, pw);
			tf.get();
			System.out.println(item[0] + " " + pw[0]);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
