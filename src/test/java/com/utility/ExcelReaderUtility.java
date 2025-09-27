package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelFile(String fileName){
		
		File xlsxFile= new File(System.getProperty("user.dir") + "/testData/"+fileName);
		
		XSSFWorkbook xssfworkbook=null;
		try {
			xssfworkbook = new XSSFWorkbook(xlsxFile);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		List<User> userList=new ArrayList<>();
		Row row;
		Cell emailcell;
		Cell passwordcell;
		User user;
		XSSFSheet xssfSheet=xssfworkbook.getSheet("LoginTestData");
		Iterator<Row> rowIterator=xssfSheet.iterator();
		rowIterator.next();
		while(rowIterator.hasNext()) {
			row=rowIterator.next();
			emailcell=row.getCell(0);
			passwordcell=row.getCell(1);
			user=new User(emailcell.toString(),passwordcell.toString());
			userList.add(user);
			
		}
		try {
			xssfworkbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}


}
