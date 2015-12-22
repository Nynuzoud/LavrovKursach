package ru.sergey.data;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.*;
import java.util.ResourceBundle;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

public class Report {

    private ResourceBundle locale;

    public Report(ResourceBundle mainLocale) {
        locale = mainLocale;
    }

    public void build(Boolean[] isSelectedCheckBoxes) {
        JasperReportBuilder reportBuilder = report();

        //styles
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle)
                .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);
        StyleBuilder bigBoldStyle = stl.style(boldStyle)
                .setFontSize(14)
                .setTopPadding(15)
                .setBottomPadding(10);
        StyleBuilder columnStyle = stl.style()
                .setBorder(stl.penThin())
                .setLeftPadding(10)
                .setRightPadding(10)
                .setTopPadding(5)
                .setBottomPadding(5)
                .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE);
        StyleBuilder titleStyle = stl.style(boldCenteredStyle)
                .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER)
                .setFontSize(18)
                .setBottomPadding(15);

        TextColumnBuilder<String> furnaceColumn = col.column(locale.getString("furnaceLabel"), "furnace", type.stringType())
                .setStyle(bigBoldStyle);
        TextColumnBuilder<String> itemsColumn = col.column(locale.getString("ishData"), "items", DynamicReports.type.stringType());
        TextColumnBuilder<String> countColumn = col.column(locale.getString("value"), "count", DynamicReports.type.stringType());
        try {
            System.out.println("1");
            reportBuilder
                    .setColumnTitleStyle(columnTitleStyle)
                    .setColumnStyle(columnStyle)
                    .columns(furnaceColumn, itemsColumn, countColumn)
                    .title(Components.text(locale.getString("results"))
                            .setStyle(titleStyle))
                    .groupBy(furnaceColumn)
                    .setDataSource(getDataSource(isSelectedCheckBoxes))
                    .show(false);
            System.out.println("2");
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource getDataSource(Boolean[] isSelectedCheckBoxes) {
        double[][] defaultData = DefaultData.getDefaultArray();
        int[] resultData = DefaultData.getFurnaceResult();
        DRDataSource drDataSource = new DRDataSource("furnace", "items", "count");

        int index;
        for (int i = 0; i < defaultData.length; i++) {
            if (i < 8) {
                if (isSelectedCheckBoxes[i]) {
                    index = i + 1;
                    if (isSelectedCheckBoxes[8]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportRashodPGBase"),
                                String.valueOf(defaultData[i][0]));
                    }
                    if (isSelectedCheckBoxes[9]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportMinPG"),
                                String.valueOf(defaultData[i][1]));
                    }
                    if (isSelectedCheckBoxes[10]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportMaxPG"),
                                String.valueOf(defaultData[i][2]));
                    }
                    if (isSelectedCheckBoxes[11]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportRashodKoksBase"),
                                String.valueOf(defaultData[i][3]));
                    }
                    if (isSelectedCheckBoxes[12]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportEkvZamKoksBase"),
                                String.valueOf(defaultData[i][4]));
                    }
                    if (isSelectedCheckBoxes[13]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportProizvChugBase"),
                                String.valueOf(defaultData[i][5]));
                    }
                    if (isSelectedCheckBoxes[14]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportSodSiBase"),
                                String.valueOf(defaultData[i][6]));
                    }
                    if (isSelectedCheckBoxes[15]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportMinSi"),
                                String.valueOf(defaultData[i][7]));
                    }
                    if (isSelectedCheckBoxes[16]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportMaxSi"),
                                String.valueOf(defaultData[i][8]));
                    }
                    if (isSelectedCheckBoxes[17]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportIzmPrChugPG"),
                                String.valueOf(defaultData[i][9]));
                    }
                    if (isSelectedCheckBoxes[18]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportIzmProizvChugRashodKoks"),
                                String.valueOf(defaultData[i][10]));
                    }
                    if (isSelectedCheckBoxes[19]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportIzmSiPG"),
                                String.valueOf(defaultData[i][11]));
                    }
                    if (isSelectedCheckBoxes[20]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportIzmSiKoks"),
                                String.valueOf(defaultData[i][12]));
                    }
                    if (isSelectedCheckBoxes[21]) {
                        drDataSource.add(locale.getString("furnaceLabel") + " " + index, locale.getString("reportIzmSiProizv"),
                                String.valueOf(defaultData[i][13]));
                    }
                }
            } else {
                if (isSelectedCheckBoxes[22]) {
                    drDataSource.add(locale.getString("pokazatelName"), locale.getString("reportRezervPG"),
                            String.valueOf(defaultData[i][0]));
                }
                if (isSelectedCheckBoxes[23]) {
                    drDataSource.add(locale.getString("pokazatelName"), locale.getString("reportZapasKoks"),
                            String.valueOf(defaultData[i][1]));
                }
                if (isSelectedCheckBoxes[24]) {
                    drDataSource.add(locale.getString("pokazatelName"), locale.getString("reportTrebProizvChug"),
                            String.valueOf(defaultData[i][2]));
                }
            }
        }

        for (int i = 0; i < resultData.length; i++) {
            index = i + 1;
            drDataSource.add(locale.getString("result"), locale.getString("optRashodFurnace") + " №" + index + ", " +
                    locale.getString("m3chas"),
                    String.valueOf(resultData[i]));
        }
        System.out.println("3");
        return drDataSource;
    }
}
