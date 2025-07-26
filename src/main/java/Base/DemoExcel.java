//package Base;
//import java.io.File;
//import java.io.IOException;
//
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableCell;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
//public class DemoExcel {
//
//	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
//		
//		WritableWorkbook workbook = Workbook.createWorkbook(new File("FirstBook.csv"));
//		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
//		
//		WritableCell cell1 = new Label(0,0, "Name");
//		WritableCell cell2 = new Label(1,0, "Date");
//		WritableCell cell3 = new Label(2,0, "Parents");
//		
//		sheet.addCell(cell1);
//		sheet.addCell(cell2);
//		sheet.addCell(cell3);
//		
//		workbook.write();
//		workbook.close();
//		
//	
//	}
//	
//}