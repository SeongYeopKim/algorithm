package Quiz;
/*
 * 문제 1. 빈도수 높은 알파벳 순 정렬 , 같은빈도수는 알파벳 순으로 정렬
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * 해결방법:     ( 빈도수 * 1000+알바벳(숫자로변환) ) -> 숫자로 만들어서 큰숫자부터 정렬 
 * 				정렬된 값을 %1000 하여 알파벳으로 재변환
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Test01 {
	// 퀵소트
		private static long[] quick(long[] item, int start, int end) {
			if (start < end) {
				long pivot = item[end];
				int div = start;
				for (int i = start; i < end; i++) {
					if (item[i] >= pivot) {
						item = exchange(item, i, div);
						div++;
					}
				}
				item = exchange(item, end, div);
				quick(item, start, div - 1);
				quick(item, div + 1, end);
			}
			return item;
		}

		private static long[] exchange(long[] item, int i, int div) {
			long temp = item[i];
			item[i] = item[div];
			item[div] = temp;
			return item;
		}
		
		
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		try {
			String url = "/Users/ksy/"; // input 파일의 위치를 변경 바랍니다.
			Scanner sc = new Scanner(new File(url + "input.txt"));

			String b = sc.nextLine();
			sc.close();
			char[] temp = b.toCharArray();
			
			ArrayList<Character> list = new ArrayList<>(); // 길이를 조절할 수 있는 배열을
															// 만들기 위해 List이용
			long[] cnt = new long[temp.length];

			for (int i = 0; i < cnt.length; i++) {
				cnt[i] = 0;
			}
			boolean sig = true;
			for (int i = 0; i < b.length(); i++) {
				cnt[i] = 0;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j) == temp[i]) {
						sig = false;
						cnt[j]++;
					}
				}
				if (sig) {
					list.add(temp[i]);
				}
				sig = true;
			}
			long[] tempp = new long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				tempp[i] = cnt[i] * 1000 + (int) list.get(i);
			}
			tempp = quick(tempp, 0, tempp.length - 1);
			for (int i = 0; i < tempp.length; i++) {
				System.out.print((char) (tempp[i] % 1000));
			}
			System.out.println("수행시간 : " +(System.currentTimeMillis() - start) + "mls");
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
}
