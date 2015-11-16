package ru.sergey.data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelData {
    public void sendData() {
        FileInputStream file;
        double[][] array = DefaultData.getDefaultArray();
        try {
            file = new FileInputStream(new File("optimize.xlsm"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int m = 0;
            int l = 0;
            int i = 0;
            int p = 0;
            for (Row row : sheet) {
                int j = 0;
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            if (i > 2 && j > 0 && i < 18) {
                                System.out.println(cell.getNumericCellValue());
                                System.out.println("m: " + m + " l: " + l);
                                cell.setCellValue(array[m][l]);
                                m++;
                                if(m == 8) {
                                    m = 0;
                                    l++;
                                }
                            }
                            if (i > 21 && i < 25 && j == 1) {
                                cell.setCellValue(array[8][p]);
                                p++;
                            }
                            break;
                    }
                    j++;
                }
                i++;
            }
            file.close();
            FileOutputStream outputStream = new FileOutputStream(new File("optimize.xlsm"));
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
