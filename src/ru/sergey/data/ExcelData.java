package ru.sergey.data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

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
                            if (i > 19 && i < 23 && j == 1) {
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

    public int[] getData() {
        int[] result = null;

        FileInputStream file;
        String exePath = "./src/RunMacros.exe";
        try {
            Process process = Runtime.getRuntime().exec(exePath);
            process.waitFor();
            InputStream inputStream = process.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int c;
            while((c = inputStream.read()) != -1)
            {
                baos.write(c);
            }
            String response = new String(baos.toByteArray());
            System.out.println("Response from EXE: " + response);

            if(response.equals("OK")) {
                result = new int[8];

                file = new FileInputStream(new File("optimize.xlsm"));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);

                int i = 0;
                if(sheet.getRow(49).getCell(1).getNumericCellValue() < 4) {
                    for(int l = 1; l < 9; l++) {
                        int cellValue = (int) sheet.getRow(2).getCell(l).getNumericCellValue();
                        System.out.println(cellValue);
                        result[i] = cellValue;
                        i++;
                    }
                } else {
                    result = null;
                }
                file.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
