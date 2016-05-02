/*
 * 문제 1. 그래프 구조로 나타낸 친구들의 관계에서 한개를 빼면 그래프가 이어지지 않는 노드(핵심친구)의 갯수를 찾기
 * 새 학기각 시작되어 담임 선생님이 학생들 간에 교유관계를 조사하고 있다. 두 학생이 친할 경우 연결고리를 그린다
 * 담인선생님은 이 친구들 사이의 핵심친구를 알아내고자한다 
 * 
 * 여기서 ㅅ학심 친구란 이 친구가 중심이 되어 학생들 간의 연결고리가 이어지는 관계로 만약 핵심친구가 빠지게 되면 학생들 간에 ㅇ녀결이 끊어진 상태가 된다.
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * 해결방법:      
 * 				
 * 
 */

package Quiz;
import java.util.Arrays;

class Finder {
	int[][] info;
	int cnt;
	int[][] temp; /// 핵심친구를 제외할때 정보를 나타내기위해서
	int[] route; // 친구 관계를 확인하는 용도

	public Finder(int cnt, String[] item) {
		this.cnt = cnt;
		info = new int[cnt][cnt];
		route = new int[cnt];
		temp= new int[cnt][cnt];

		for (int i = 0; i < cnt; i++) // 0으로 체우기
			for (int j = 0; j < cnt; j++)
				info[i][j] = 0;

		for (int i = 0; i < item.length / 2; i++) { // 입력된 값들으로 핵심 친구의 정보를 그래프로
													// 표시
			int a = Integer.parseInt(item[i * 2])-1;
			int b = Integer.parseInt(item[i * 2 + 1])-1;
			info[a][b] = 1;
			info[b][a] = 1;
		}
		for(int i=0; i<cnt;i++){
			for(int j=0; j<cnt;j++){
				System.out.print(info[i][j]+ " ");
			}
			System.out.println();
		}
				

	}

	public void remove(int a) { // a의 친구 교류 모두 끊은 temp를 생성 , route초기화

		System.out.println("___________temp_________________________");
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				if (i == a || j == a)
					temp[i][j] = 0;
				else
					temp[i][j] = info[i][j];
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
			route[i] =0;
		}

	}

	public String start() {
		String result = "";
		for (int i = 0; i < cnt; i++) {
			remove(i);
			search((i+1)%cnt);
			int zero =0;
			for(int k=0; k<cnt; k++){		// 끊긴 친구가 있으면 핵심친구로 결과에 입력
				if(route[k] ==0)
					zero++;
			}
			if(zero>1){
				result = result + (i+1) + " "; 
			}
				
				
		}
		return result;
	}

	private void search(int p) {
		for(int i=0; i<cnt;i++){
			if(temp[p][i]==1 && route[i] == 0){
				route[i] =1;
				search(i);
			}
		}
	}

}

public class Q01_FindPointFriends {
	public static void main(String[] args) {
		int cnt = 9;
		String temp = "1 4 1 3 2 4 3 4 3 6 4 5 5 6 6 7 6 9 7 8 8 9";
		String[] item = temp.split(" ");
		Finder finder = new Finder(cnt, item);
		System.out.println(finder.start());
		

	}
}
