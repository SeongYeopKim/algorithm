package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedList {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url+"input_ll.txt"));
			int cnt = sc.nextInt();
			MList list = new MList();
			for(int i =0; i<cnt; i++){
				int check = sc.nextInt();
				System.out.println("check"+check);
				list.add(check);
			}
			list.sAdd(sc.nextInt(), sc.nextInt());
			sc.close();
			
			System.out.println(list.getAllData());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class MList{
	List head;
	List tail;
	public void add(int data){
		System.out.println(data);
		List a = new List(data);
		if(head==null&tail==null){
			System.out.println("null : "+ data);
			head=a;
			tail=a;
		}else if(head==tail){
			System.out.println("== : "+ data);
			head.setPointer(a);
			tail=a;
		}else{
			
			List temp = head;
			while(temp.getPointer()!=null){
				temp=temp.getPointer();
			}
			System.out.println("data : "+temp.getData());
			temp.setPointer(a);
			tail=a;
			System.out.println("tail" + tail.getData());
		}
	}
	public void sAdd(int data,int cnt){
		List insert = new List(data);
		List temp = head;
		for(int i=0; i<cnt-1;i++){
			temp = temp.getPointer();
		}
		List temp2= temp.getPointer();
		temp.setPointer(insert);
		insert.setPointer(temp2);
		
	}
	public String getAllData(){
		String data="";
		List temp = head;
		while(temp.getPointer()!=null){
			data+=temp.getData()+" ";
			temp=temp.getPointer();
		}
		data+=temp.getData();//tail
		return data;
	}
	
}
class List{
	private int data;
	private List pointer;
	public int getData() {
		return data;
	}
	public List(int data) {
		super();
		this.data = data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public List getPointer() {
		return pointer;
	}
	public void setPointer(List pointer) {
		this.pointer = pointer;
	}
	
}