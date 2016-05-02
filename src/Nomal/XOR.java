package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class XOR {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_XOR.txt"));
			 char[] key = sc.nextLine().toCharArray();
			 char[] val = sc.nextLine().toCharArray();
			 char[] result = new char[val.length];
			 sc.close();
			 for(int i=0; i<val.length;i++){
				 result[i] = (char)(val[i] ^ key[i%key.length]);
			 }
			 System.out.println(Arrays.toString(result));
			 char[] result2 = new char[result.length];
			 for(int i=0; i<result.length; i++){
				 result2[i] = (char)(result[i]^key[i%key.length]);
			 }
			 System.out.println(Arrays.toString(result2));
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
