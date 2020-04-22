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
	
			while (sc.hasNext())
			{
				temp[counter] = sc.nextLine();
				line = temp[counter].split("_");
//-				System.out.println (line[1]);// + "  " + line[1] + "  " + line[2]);
				bst.insert(line[0] + " " + line[1] + " " + line[2]);
//				bst.insert(temp[counter]);
				counter = counter + 1;
			}

			sc.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println("Everything Works");
		return bst;

	}

	public static String test(String d)
	{
		String result = "";
		if (d.length() > 7);
		{
			int len = d.length();
			
			for (int i = 8; i < len; i++)
			{
				result = result + d.charAt(i);
			}
		}
			
		return result;
	}

	public static void main(String[] args)
	{
		bst = CreateBST();
//		bst.printAllAreas();
	
		if (args.length == 0)
			bst.printAllAreas();
		else
		{
			String s = args[0];
			String d = args[1];
			String t = args[2];
			String check = s + " " + d + " " + t;	
			System.out.println(bst.printAreas(check));
		}
	}
}
