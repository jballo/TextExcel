package textExcel;

import java.util.Arrays;

public class FormulaCell extends RealCell{
	private String formulaCell;
	public FormulaCell(String input){
		super(input);
		this.formulaCell = input;
	}
	
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
	
	public double getDoubleValue() {
		//String[] splitFormula = super.fullCellText().substring(1,super.fullCellText().length()-1).split(" ");
		String[] splitFormula = super.fullCellText().substring(2,super.fullCellText().length()-2).split(" ");
		
		
		String[] signs = new String[(splitFormula.length-1)/2];	
		Double [] operands = new Double [(splitFormula.length - signs.length)];
		
		System.out.println("splitFormula: " + Arrays.toString((splitFormula))+ "\nsplitFormula length: " + splitFormula.length);
		System.out.println("Operands length: " + operands.length + "\nSigns length: " + signs.length);
		//for-loop for filling in the signs
		int signPlacement = 0;
		for(int i = 1; i < splitFormula.length; i+=2) {
				signs[signPlacement] = (splitFormula[i]);
				signPlacement++;
		}
		
		//for-loop for filling in the operands
		int operandPlacement = 0;
		
		//Works for checkpoint 4 to fill in the operands
		for(int i = 0; i <= splitFormula.length; i++) {
			if(i%2 == 0) {
				operands[operandPlacement] = (Double.parseDouble(splitFormula[i]));
				operandPlacement++;
			}
		}
		
		//Fills in operands for checkpoint 5
		/*for(int i = 0; i <= splitFormula.length; i++) {
			if(i%2 == 0) {
				if(splitFormula[i] instanceof String) {
					
					SpreadsheetLocation temp = new SpreadsheetLocation(splitFormula[i]);
				}else {
					operands[operandPlacement] = (Double.parseDouble(splitFormula[i]));
					operandPlacement++;
				}
			}
		}*/
		
		testFormulaVariables(splitFormula, operands, signs);
		Double resultant = operands[0];
		
		System.out.println("Before Calculations: " + resultant);
		
		for(int i = 0; i < (signs.length); i++) {
			if(signs[i].equals("*")){
				resultant = (resultant * operands[i+1]);
			}else if(signs[i].equals("/")) {
				resultant = ( resultant / operands[i+1]);
			}else if(signs[i].equals("+")) {
				resultant = (resultant + operands[i+1] );
			}else if(signs[i].equals("-")) {
				resultant = (resultant - operands[i+1] );
			}
		}
		System.out.println("After Calculations: " + resultant);
		return resultant;
	}
	
	
}


