package ru.sergey.excel;


import org.apache.poi.ddf.EscherColorRef;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.sergey.data.DefaultData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class SendDataToExcel {
    public void sendData() {
        FileInputStream file = null;
        double[][] array = DefaultData.getDefaultArray();
        try {
            file = new FileInputStream(new File("Книга1.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int i = 0;
            for (Row row : sheet) {
                int j = 0;

                for (Cell cell : row) {
                    if(cell.getNumericCellValue() != 0.0) {

                        j++;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
