//Yelanika Gunasekara 
//Assignment2
//13 March 2020

import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LSBSTApp extends BinaryTree
{
	public static BinaryTree bst = new BinaryTree();
	public static String[] line = new String[2];
	public static int counter = 0;
	public static String[] temp = new String[2976];


	public static BinaryTree CreateBST()
	{
		BinaryTree bst = new BinaryTree();
		bst.BinaryTree();

		try{
			Scanner sc = new Scanner (new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
	
			for (int i=0; i < 2976; i++)	
			{
				temp[counter] = sc.nextLine();
				line = temp[counter].split("_");
				bst.insert(line[0] + " " + line[1] + " " + line[2]);
				counter = counter +1;
			}

			sc.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return bst;

	}

	public static void main(String[] args)
	{
		bst = CreateBST();
	
		if (args.length == 0)
			bst.printAllAreas();
		else
		{
			String s = args[0];
			String d = args[1];
			String t = args[2];
			String check = s + " " + d + " " + t;	
			System.out.println(bst.printAreas(check) + "	");
		}
	}
}
