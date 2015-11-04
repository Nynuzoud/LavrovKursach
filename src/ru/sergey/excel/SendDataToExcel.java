package ru.sergey.excel;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.sergey.data.DefaultData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SendDataToExcel {
    public void sendData() {
        FileInputStream file = null;
        double[][] array = DefaultData.getDefaultArray();
        try {
            file = new FileInputStream(new File("optimize.xlsm"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = 3;
            int maxRowNum = 12;
            for(int i = rowNum; i <= maxRowNum; i++) {
                for (int j = 1; j <= 8; j++) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
