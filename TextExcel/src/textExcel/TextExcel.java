package textExcel;
import java.util.Scanner;


import java.io.FileNotFoundException;
import java.util.Scanner;

/*Jonathan Ballona S.
 * 11 May, 2018
 * Period 2
 * Client code to execute the commands
 */

public class TextExcel 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Boolean ended = false;
		Spreadsheet spSht= new Spreadsheet();
		do{
			String commands = input.nextLine(); 
			System.out.println(spSht.processCommand(commands));
			if(input.equals("quit")) {
				ended = true;
			}
		}while(ended == false);
	}
}

