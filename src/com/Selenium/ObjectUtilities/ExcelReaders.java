package com.Selenium.ObjectUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaders {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream fip=new FileInputStream("D:\\Selenium\\abc.xls");
	Workbook workbook=WorkbookFactory.create(fip);
	Sheet sheet=workbook.getSheet("sheet1");
	Row row=sheet.createRow(0);
	Cell cell=row.createCell(0);
	cell.setCellValue("bindu");
	FileOutputStream fop=new FileOutputStream("D:\\Selenium\\abc.xls");
	workbook.write(fop);
}
}
