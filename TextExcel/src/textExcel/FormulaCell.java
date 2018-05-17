package textExcel;
import java.util.Arrays;
/*Jonathan Ballona S.
 * 11 May, 2018
 * Period 2
 * Formula cell to deal with operations (equations)
 */

public class FormulaCell extends RealCell{
	Cell[][] sprdSheet;
	
	public FormulaCell(String input, Cell[][] spSht){
		super(input);
		sprdSheet = spSht;
	}

	
	public double getDoubleValue() {

		double doubleValue = 0.0;
		if(super.fullCellText().contains("+") || super.fullCellText().contains("-") 
					|| super.fullCellText().contains("*") || super.fullCellText().contains("/")) { //Deal with equation commands
			
			String[] splitFormula = super.fullCellText().substring(2,super.fullCellText().length()-2).split(" ");
		
			String[] sumFormula = super.fullCellText().substring(6, super.fullCellText().length()-2).split("-");

			if(splitFormula[0].toUpperCase().equals("SUM")) {
				doubleValue = calculateSumOfIntervals(sumFormula[0],sumFormula[1]);
				
				
			}else if( splitFormula[0].toUpperCase().equals("AVG")) { // Dealing with average command
				
				SpreadsheetLocation intervalStart = new SpreadsheetLocation(sumFormula[0]);
				SpreadsheetLocation intervalEnd = new SpreadsheetLocation(sumFormula[1]);
				
				double divisible = ((intervalEnd.getRow() - intervalStart.getRow()) +1)*((intervalEnd.getCol() - intervalStart.getCol())+1);
				double tempSum =  calculateSumOfIntervals(sumFormula[0],sumFormula[1]);
				doubleValue = (tempSum/divisible); 
				
			}else if( !(splitFormula[0].equals("SUM")) && !(splitFormula[0].equals("AVG"))) {
				doubleValue = oneStringCompleteOperation(splitFormula);
			}
			
		}else {
			//To test for testAvgSingleNontrivial
			doubleValue = Double.parseDouble(super.fullCellText().substring(1, super.fullCellText().length() -2));
		}
		
		
		return doubleValue;
		
	}
	
	public double oneStringCompleteOperation(String[] equation) {
		Double resultValue;
		//To deal with non reference values if the 1st isn't
		if(Character.isLetter(equation[0].charAt(0))) {
			SpreadsheetLocation temp = new SpreadsheetLocation(equation[0]);
			resultValue = ( (RealCell)sprdSheet[temp.getRow()][temp.getCol()] ).getDoubleValue();
		}else {
			resultValue = Double.parseDouble(equation[0]);
		}
		
		//Goes through a whole string to complete the operation
		for( int index = 1; index < equation.length-1; index+=2) {
			 double tempNum;
			if(Character.isLetter(equation[index+1].charAt(0)) ) {
				System.out.println("True");
				SpreadsheetLocation temp = new SpreadsheetLocation(equation[index+1]);
				tempNum = ( (RealCell)sprdSheet[temp.getRow()][temp.getCol()] ).getDoubleValue();
			}else {
				tempNum = Double.parseDouble(equation[index+1]);
			}
			if(equation[index].equals("*")){              //Multiply
				resultValue = (resultValue * tempNum);
			}else if(equation[index].equals("/")) {			//Division
				resultValue = ( resultValue / tempNum);
			}else if(equation[index].equals("+")) {			//Addition
				resultValue = (resultValue + tempNum );
			}else if(equation[index].equals("-")) {			//Subtraction
				resultValue = (resultValue - tempNum );
			}
		}
		
		return resultValue;
	}
	public double calculateSumOfIntervals(String intervalA, String intervalB) {
		double sumResult = 0;
		
		SpreadsheetLocation intervalStart = new SpreadsheetLocation(intervalA);
		SpreadsheetLocation intervalEnd = new SpreadsheetLocation(intervalB);
		
		int startRow = intervalStart.getRow();
		int endRow = intervalEnd.getRow();
		
		int startCol = intervalStart.getCol();
		int endCol = intervalEnd.getCol();
		
		//Test f5 = ( SUM b3 - d4 )
		for( int row = startRow; row <= endRow; row++) {
			for(int col = startCol; col <= endCol; col++) {
				if(sprdSheet[row][col] instanceof EmptyCell) {
					sumResult+= 0;
				}else {
					sumResult+=((RealCell)sprdSheet[row][col]).getDoubleValue();
				}
			}
		}
			return sumResult;
	}

	//Just in case if I run into an error
	public static void testFormulaVariables(String[] form, Double[] operands, String[] signs) {
		System.out.println("splitFormula: " + Arrays.toString((form)));
		System.out.print("Operands: ");
		for(int i = 0; i < operands.length; i++) {
			System.out.print(operands[i] + " ");
		}
		
		System.out.print("\nSigns: ");
		for(int i = 0; i <signs.length; i++) {
			System.out.print(signs[i]);
		}
		System.out.println("");
	}
}
