package textExcel;

/*Jonathan Ballona S.
 * 11 May, 2018
 * Period 2
 * ValueCell class to create them and gets its double type value
 */

public class ValueCell extends RealCell{
	public ValueCell(String value){
		super(value);
	}
	public  double getDoubleValue() {
		Double dblValue = Double.parseDouble(super.fullCellText());
		return dblValue;
	}
}