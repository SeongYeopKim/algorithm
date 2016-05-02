/*
 * 문제 2. 문자열 트리 문자열을 트리모양으로 만들고 트리의 빈칸은 알파벳 처음부터 채움,  각 층의 중간의 알파벳 구하기
 * ex) abcdefg
 *       a
 *     b c d
 *   e f g a b 
 *   -> acg
 *     
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * 
 */
package Quiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ITree {
	public final static int A = 65;
	int cnt;
	String[] item;
	int fibo;

	public ITree(int cnt, String[] item) {
		super();
		this.cnt = cnt;
		this.item = item;
		fibo = 1;
	}

	public String[] makeFull() {
		for (int j = 0; j < item.length; j++) {
			int k = getFibo(item[j].length(), 0, 1) - item[j].length()-1;
			System.out.println(k);
			for (int i = 0; i < k; i++) {
				item[j] = item[j] + (char) (A + i);
			}
			System.out.println(item[j]+ "len : "+ item[j].length());
			System.out.println(getResult(item[j]));
		}
		
		
		return item;
	}

	public int getFibo(int k, int n, int fibo) { // 길이, 0, 1 고정!
		if (fibo < k) {
			n++;
			fibo = getFibo(k, n, fibo + 2 * n + 1);
		}
		return fibo;
	}
	public String getResult(String item) {
		String result="";
		for(int i=0; i<item.length(); i+=2){
			System.out.println(item+ " "+ i);
			result += item.substring(i,i+1);
			item = item.substring(i,item.length());
			
		}
		return result;
	}
	public String start(){
		String result="";
		makeFull();
		
		//result= getResult();
		
		return  result;
	}

}

public class Q02_FiboTree {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_real02.txt"));
			int cnt = sc.nextInt();
			String[] item = new String[cnt];
			sc.nextLine();

			for (int i = 0; i < cnt; i++) {
				item[i] = sc.nextLine();
			}
			sc.close();
			ITree iTree = new ITree(cnt, item);
			iTree.makeFull();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
