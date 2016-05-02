package Quiz;
/*
 * 문제 1. 아무개를 JENNIFERSOFT로 변경하기 위한 조작의 최소 횟수
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * 해결방법:
 * 1.  INPUT 에 JENNIFERSOFT의 문자와 같은게 있다면 제니퍼와 같은 크기의 int형 배열에 몇번째 문자인지 삽입 없는 문자라면 -1로 넣기
 *  ex) MICROSOFT -> -1 -1 -1 -1 1 7 -1 3 5 6 -1 8 
 *  
 * 2.  오름차순으로 증가하는 숫자 중 가장 긴 것을 찾고 또 다른 배열을 생성하고, 앞의 배열에 각 숫자가 몇칸씩 띄어져 있는지 삽입한다. 
 *  ex)  1 3 5 6 8  / 2 0 0 1
 * 3. 삭제하는 경우 :숫자의 사이에 더 많은 공간이 있을때 갯수 만큼 삭제
 *    변경하는 경우 : 숫자의 사이에 공간이 있을때
 *    추가하는 경우 : 제니퍼길이-(조작한 문자의 끝-처음+1) ->   12- ( 8-1+1)
 *      --> 모두 더하면 해답
 *  1과 3사이에 1개 삭제,1개 변경 ,  6과 8사이에 1 변경, -> 1~8까지 완성 9,10,11,12 4개 추가 -> 7개!
 *  
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Jennifer {
	String target;
	String input;
	int cnt;

	public Jennifer(String input, String target) {
		super();
		this.input = input;
		this.target = target;
		cnt = 0;
	}

	public int start() {

		// 0. 스트링버퍼로 처리해보자
		StringBuffer tar = new StringBuffer(target);
		StringBuffer inp = new StringBuffer(input);
		int[] sequence = new int[tar.length()]; // 타겟에 적합한 알파벳이 몇번째에 있는지
		for (int i = 0; i < tar.length(); i++) {
			sequence[i] = -1;
		}

		// 1. 비교해서 같은 알파벳이 있는것을 찾아서 배열에 몇번째에 있는지 저장.
		// -> 같은게 나오면 앞에서부터 검색해서 중복된것 처리해야되니까 찾은건 X로 표시 .
		// -> 뒤에서부터 검사하면 결과가 달라질 수 도 있으니 처리한 뒤 한번 더 검사해보기.
		for (int i = 0; i < inp.length(); i++) {
			for (int j = 0; j < tar.length(); j++) {
				if (tar.charAt(j) == inp.charAt(i)) {
					sequence[j] = i;
					inp.replace(i, i + 1, Integer.toString(i)); // 중복된 문자가 나올수
																// 있으니 타겟의 몇번째
																// 문자인지로 치환해두기

				}
			}
		}

		// 오름차순으로 증가하는 수를 찾기
		ArrayList<Integer> list; 
		ArrayList<Integer> maxList = new ArrayList<>();
		for (int i = 0; i < sequence.length; i++) {
			list =new ArrayList<>();
			for (int j = 0; j < sequence.length; j++) {
				list.add(sequence[i]);
				list = findAsc(sequence,list,j);
				if(maxList.size()<list.size()){
					// 시간이 다되서 제출하겠습니다...
					
				}
			}
			System.out.print(sequence[i] + "\t");
		}

		return 0;
	}
	public ArrayList<Integer> findAsc(int[] array,ArrayList<Integer> list, int index){
		if(index>=array.length){
			//end
		}else{
			if(array[index] > list.get(list.size()-1)){
				
				list.add( array[index]);
				index++;
				list = findAsc(array, list, index);
			}else{
				index++;
				list = findAsc(array, list, index);
			}
			
			
		}
		return list;
	}

}

public class Test05 {
	public static void main(String[] args) {
		String url = "/Users/ksy/";
		final String TARGET = "JENNIFERSOFT";
		// final String TARGET = "JENIFRSOT";
		try {
			Scanner sc = new Scanner(new File(url + "input05.txt"));
			Jennifer jennifer = new Jennifer(sc.nextLine(), TARGET);
			jennifer.start();
			// String test = "ABCDEFGH";
			// StringBuffer teB = new StringBuffer(test);
			// teB.replace(0, 1, "X");
			// System.out.println(teB.append(0));
			//

			sc.close();

			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
