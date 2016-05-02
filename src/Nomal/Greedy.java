package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Counter{
	int amountOfCount;
	int[] coin;
	int price;
	int money;
	public Counter(String line){
		String[] temp2 = line.split(" ");
		amountOfCount = Integer.parseInt(temp2[0]);
		coin = new int[amountOfCount];
		for(int i=0; i<amountOfCount;i++){
			coin[i] = Integer.parseInt(temp2[i+1]);
		}
		price = Integer.parseInt(temp2[amountOfCount+1]);
		money = Integer.parseInt(temp2[amountOfCount+2]);
	}
	public String getResult(){
		String result ="";
		int change = money-price;
		System.out.println(change);
		for(int i=0; i<amountOfCount;i++){
			int temp = 0;
			temp = change / coin[i];
			change %= coin[i];
			result += temp + " ";
		}
		return result;
	}
}
public class Greedy {
	public static void main(String[] args) {
		String url ="/users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url+"input_greedy.txt"));
			String line = sc.nextLine();
			
			Counter counter = new Counter(line);
			String item = counter.getResult();
			System.out.println(item);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
