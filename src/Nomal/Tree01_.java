package Nomal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Nod {
	int data;
	Nod left;
	Nod right;
}

class Tree {
	Nod root;

	public void add(int a, int b) {
		if (root == null) {
			Nod nod = new Nod();
			nod.data = a;
			root = nod;
			Nod nod1 = new Nod();
			nod1.data = b;
			root.left = nod1;
		} else {
			Nod temp = find(root, a);
			Nod nod = new Nod();
			nod.data = b;
			if (temp.left != null) {
				temp.left = nod;
			} else
				temp.right = nod;
		}

	}

	private Nod find(Nod nod, int a) {
		if (nod.data != a) {
			if (nod.left != null) {
				find(nod.left, a);
			}
			if (nod.right != null)
				find(nod.right, a);
		}

		return nod;
	}
}

public class Tree01_ {
	public static void main(String[] args) {
		String url = "/Users/ksy/sorceCode/";
		try {
			Scanner sc = new Scanner(new File(url + "input_tree01.txt"));
			String temp = sc.nextLine();
			String[] item = temp.split(" ");
			Tree tree = new Tree();
			for (int i = 0; i <= (item.length) / 2; i++) {
				tree.add(Integer.parseInt(item[i * 2]), Integer.parseInt(item[i * 2 + 1]));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tree tree = new Tree();

	}
}
