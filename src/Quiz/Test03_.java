package Quiz;
/*
 * 문제 1. (0,0) 부터 (10,10) 도착하는데 중간에 있는 점들 모두 통과하는 최단경로 찾기
 * 제작자: 김성엽
 * 연락처: 010 6694 0010 
 * email: tjdduq1118@gmail.com 
 * 해결방법: 모든 경로 탐색   
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Mapk {
	int x[];
	int y[];
	int cnt;
	ArrayList<Integer[]> routeList;
	
	public Mapk(int cnt) {
		this.cnt = cnt;
		x = new int[cnt];
		y = new int[cnt];
		routeList = new ArrayList<>();
	}

	public void add(int x, int y, int i) {
		this.x[i] = x;
		this.y[i] = y;
	}

	
	public double start(){
		Integer[] item = new Integer[cnt];
		for(int i=0; i<cnt; i++){
			item[i] = i;
		}
		findRoute(item,cnt);
		
		for(int i=0; i<routeList.size();i++){
			item= routeList.get(i);
		}
		compare(routeList);
		
		return 0;
	}
	

	private void findRoute(Integer[] item, int index) {
		if(index<=0){
			Integer[] temp = new Integer[item.length];
			for(int i=0;i<item.length;i++){
				temp[i]=item[i];
			}
			routeList.add(temp);
		}else{
			findRoute(item,index-1);
			int current = item.length-index;
			for(int i = current+1; i<item.length;i++){
				swap(item,current,i);
				findRoute(item,index-1);
				swap(item,i,current);
			}
		}
	}

	private void swap(Integer[] item, int pos1, int pos2) {
		int t1= item[pos1];
		item[pos1] = item[pos2];
		item[pos2] = t1;
		
		
	}

	public void compare(ArrayList<Integer[]> list) {
		
		double max=10000000;
		int max1=0;
		for(int i=0; i<list.size(); i++){
			double temp = calLen(list.get(i));
			if(max>= temp){
				max= temp;
				max1 = i;
			}
		}
		System.out.print("(0,0) -> ");
		for(int i=0; i<cnt; i++){
			System.out.print("(" +x[list.get(max1)[i]] + "," +y[list.get(max1)[i]] + ") " +"-> ");
		}
		System.out.println("(10,10)");
	}

	private double calLen(Integer[] item) {
		double length = 0;
		for(int i=0; i<item.length-1;i++){
			length += Math.sqrt((x[item[i+1]] - x[item[i]]) * (x[item[i+1]] - x[item[i]]) + 
					(y[item[i+1]] - y[item[i]]) * (y[item[i+1]] - y[item[i]]));
		}
		length+= Math.sqrt(x[item[0]]*x[item[0]]+y[item[0]]*y[item[0]]);
		length+= Math.sqrt((10-x[item[item.length-1]])*(10-x[item[item.length-1]])+
				(10-y[item[item.length-1]])*(10-y[item[item.length-1]]));
		return length;
	}

}

public class Test03_ {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String url = "/Users/ksy/";
		try {
			Scanner sc = new Scanner(new File(url + "input03.txt"));
			int cnt = sc.nextInt();
			Mapk map = new Mapk(cnt);
			for (int i = 0; i < cnt; i++) {
				map.add(sc.nextInt(), sc.nextInt(), i);
			}
			map.start();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("수행시간 : " +(System.currentTimeMillis() - start) + "mls");
		
	}

}
