package Quiz;
/*
 * 문제 2. 가로로 이어진 2자리 찾기
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * 해결방법:     ( 빈도수 * 1000+알바벳(숫자로변환) ) -> 숫자로 만들어서 큰숫자부터 정렬 
 * 				정렬된 값을 %1000 하여 알파벳으로 재변환
 * 
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test02 {
	final static int DIV = 44;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String url = "/Users/ksy/";
		
		int result = 0;
		try {
			Scanner sc = new Scanner(new File(url + "input2.txt"));
			

			int n = sc.nextInt();
			String[] temp = new String[n];
			char[][] che = new char[n][n];
			sc.nextLine();
			int k=0;
			while(sc.hasNextLine()){
				temp[k] = sc.nextLine();
				che[k] = temp[k].toCharArray();
				k++;
			}
			sc.close();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if ((int) che[i][j] > DIV && (int) che[i][j + 1] > DIV)
						result++;
				}
			}
			System.out.println("result : "+result);
			System.out.println("수행시간 : "+ (System.currentTimeMillis() - start) + "mls");
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
