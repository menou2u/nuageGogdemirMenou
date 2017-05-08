package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.LinkedList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datas2DFactory {

	private LinkedList<Double> x = new LinkedList<Double>();
	private LinkedList<Double> y = new LinkedList<Double>();
	private Dictionary<Integer, Boolean> dic;
	
	public Datas2DFactory(String fileName) throws IOException
	{
		FileInputStream fis = new FileInputStream(fileName);
		try {
			XSSFWorkbook wb = readFile(fileName);	
			XSSFSheet sheet = wb.getSheetAt(0);
			setX(retrieveDatas(sheet, 1));
			setY(retrieveDatas(sheet, 2));
		} finally {
		    fis.close();
		}
	}	
	
	
	private XSSFWorkbook readFile(String filename) throws IOException {
	    FileInputStream fis = new FileInputStream(filename);
	    try {
	        return new XSSFWorkbook(fis);		// NOSONAR - should not be closed here
	    } finally {
	        fis.close();
	    }
	}
	
	public LinkedList<Double> retrieveDatas(XSSFSheet sheet, int column){
		LinkedList<Double> res = new LinkedList<Double>();
		int rows = sheet.getPhysicalNumberOfRows();
		for (int i =0;i<rows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			isAGoodRow(row);
			int cells = row.getPhysicalNumberOfCells();
			if (column<cells)
			{
				XSSFCell cell = row.getCell(column);
				if (isNumericCell(cell))
				{
					res.add((Double)cell.getNumericCellValue());
				}
			}
		}
		return res;
	}
	
	public boolean isNumericCell(XSSFCell cell)
	{
		boolean value = false;
		if(cell != null) {
			switch (cell.getCellTypeEnum()) {
			
				case FORMULA:
					value = false;
					break;
				case NUMERIC:
					value = true;
					break;
				case STRING:
					value = false;
					break;
				case BLANK:
					value = false;
					break;
				case BOOLEAN:
					value = false;
					break;
				case ERROR:
					value = false;
					break;
				default:
					value = false;
			}
		}
		return value;
	}


	public LinkedList<Double> getY() {
		return y;
	}


	public void setY(LinkedList<Double> y) {
		this.y = y;
	}


	public LinkedList<Double> getX() {
		return x;
	}


	public void setX(LinkedList<Double> x) {
		this.x = x;
	}

	private void isAGoodRow(XSSFRow row)
	{
		Boolean correct = true;
		for (int i=0;i<row.getPhysicalNumberOfCells();i++)
		{
			if (!isNumericCell(row.getCell(i)))
			{
				correct = false;
			}
		}
		Integer numRow = row.getRowNum();
		dic.put(numRow,correct);
	}
	
}
