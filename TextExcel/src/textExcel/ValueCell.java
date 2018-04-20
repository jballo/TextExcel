package textExcel;

public class ValueCell extends RealCell{
	public ValueCell(String value){
		super(value);
	}
	
	
	public  double getDoubleValue() {
		Double dblValue = Double.parseDouble(super.fullCellText());
		return dblValue;
	}
	
}

