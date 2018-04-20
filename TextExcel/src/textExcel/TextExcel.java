package textExcel;
import java.util.Scanner;


import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Boolean ended = false;
		Spreadsheet  marcusB= new Spreadsheet();
		do{
			//TestsALL.Helper th = new TestsALL.Helper();
			//System.out.println(th.getText());
			
			String commands = input.nextLine(); 
			System.out.println(marcusB.processCommand(commands));
			if(input.equals("quit")) {
				ended = true;
			}
		}while(ended == false);
	}
}

