package com.nju.OnlineTestSystem.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.model.SingleQuestion;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
public class ExcelUtil {

	/**
	 * 读取excel
	 */
	public List<SingleQuestion> readQuestionExcel(File file){
		try {
			InputStream inputStream = new FileInputStream(file);
			Workbook workbook = Workbook.getWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(0);

			int row = sheet.getRows();
			List<SingleQuestion> list = new ArrayList<>();
			
			for (int i = 2; i < row; i++) {
				if (!sheet.getCell(0, i).getContents().equals("")) {
					SingleQuestion question = new SingleQuestion();
					question.setClassid(Integer.parseInt(sheet.getCell(0, i).getContents()));
					question.setBody(sheet.getCell(1, i).getContents());
					question.setOptiona(sheet.getCell(2, i).getContents());
					question.setOptionb(sheet.getCell(3, i).getContents());
					question.setOptionc(sheet.getCell(4, i).getContents());
					question.setOptiond(sheet.getCell(5, i).getContents());
					question.setOptione(sheet.getCell(6, i).getContents());
					question.setOptionf(sheet.getCell(7, i).getContents());
					question.setAnswer(sheet.getCell(8, i).getContents());
					question.setScore(Integer.parseInt(sheet.getCell(9, i).getContents()));
					list.add(question);
				}
			}
			workbook.close();
			inputStream.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
