package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int rows;
	private int cols;
	
	Cell[][] values= new Cell[20][12];
	public Spreadsheet() {
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				values[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		String[] splitCommand = command.split(" ",3);
		if(splitCommand[0].toLowerCase().equals("clear") && (splitCommand.length == 1)) {     //this method will clear out the whole spreadsheet
			clearWholeSpreadSheet();
			return getGridText();
			
		}else if(splitCommand[0].toLowerCase().equals("clear") && (splitCommand.length == 2)) {    //this method will clear out a specific cell (works)
			SpreadsheetLocation temp = new SpreadsheetLocation(splitCommand[1]);
			values[temp.getRow()][temp.getCol()] = new EmptyCell();
			return getGridText();
		
		}else if(splitCommand.length == 1) {		    //this method will return the value of a cell (works)
			SpreadsheetLocation temp = new SpreadsheetLocation(splitCommand[0]);
			return getCell(temp).fullCellText();
			
		}else if((splitCommand[1].equals("=")) && (splitCommand.length == 3)) {  //this method will assign a value to a cell
				SpreadsheetLocation temp = new SpreadsheetLocation(splitCommand[0]);
				checkWhatInputType(temp,splitCommand[2]);
				return getGridText();
		}else {
			return "Not an input";
		}
	}

	@Override
	public int getRows()
	{

		return 20;
	}

	@Override
	public int getCols()
	{

		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		Cell location = values[loc.getRow()][loc.getCol()];
		return location;
	}

	@Override
	public String getGridText()
	{
		String fullGridTxt = "";
		for(char letter = 'A'; letter <= 'L'; letter++) {     //Adds the header for the spreadsheet
			if(letter == 'A') {
				fullGridTxt += "   |" + letter + "         ";
			}else {
				fullGridTxt += "|" + letter + "         ";
			}
		}
		fullGridTxt+="|\n";
		
		for(int i = 1; i <= 20; i++) {             //Adds the rest of the rows w/ input
			if(i < 10) {
				fullGridTxt += i + "  ";
				
			}else {
				fullGridTxt += i + " ";
			}
			for(int j = 0; j < 12; j++) {
				fullGridTxt += "|" + values[i-1][j].abbreviatedCellText();
			}
			fullGridTxt += "|\n";
		}
		
		return fullGridTxt;
		
	}
	//This method will check what is inside the input to assign it to the proper cell type
	public void checkWhatInputType(Location loc, String input) {
		
		
		if(input.contains("\"")) {
			values[loc.getRow()][loc.getCol()] = new TextCell(input);
		}else if(input.contains("%")) {
			values[loc.getRow()][loc.getCol()] = new PercentCell(input);
		}else if (input.contains("(")) { 
			values[loc.getRow()][loc.getCol()] = new FormulaCell(input);
		}else{
			values[loc.getRow()][loc.getCol()] = new ValueCell(input);
		}	
	}
	//This method will clear out the whole spreadsheet by calling this
	public void clearWholeSpreadSheet() {
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				values[i][j] = new EmptyCell();
			}
		}
	}	
}


