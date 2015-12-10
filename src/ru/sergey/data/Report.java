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

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

public class Report {
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

        TextColumnBuilder<String> furnaceColumn = col.column("Печь", "furnace", type.stringType())
                .setStyle(bigBoldStyle);
        TextColumnBuilder<String> itemsColumn = col.column("Исходные данные", "items", DynamicReports.type.stringType());
        TextColumnBuilder<String> countColumn = col.column("Значение", "count", DynamicReports.type.stringType());
        try {
            reportBuilder
                    .setColumnTitleStyle(columnTitleStyle)
                    .setColumnStyle(columnStyle)
                    .columns(furnaceColumn, itemsColumn, countColumn)
                    .title(Components.text("Результаты")
                            .setStyle(titleStyle))
                    .groupBy(furnaceColumn)
                    .setDataSource(getDataSource(isSelectedCheckBoxes))
                    .show(false);
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
                        drDataSource.add("Печь " + index, "Расход природного газа в базовом периоде, м3/ч",
                                String.valueOf(defaultData[i][0]));
                    }
                    if (isSelectedCheckBoxes[9]) {
                        drDataSource.add("Печь " + index, "Минимально допустимый расход природного газа, м3/ч",
                                String.valueOf(defaultData[i][1]));
                    }
                    if (isSelectedCheckBoxes[10]) {
                        drDataSource.add("Печь " + index, "Максимально допустимый расход природного газа, м3/ч",
                                String.valueOf(defaultData[i][2]));
                    }
                    if (isSelectedCheckBoxes[11]) {
                        drDataSource.add("Печь " + index, "Расход кокса в базовом периоде, т/час",
                                String.valueOf(defaultData[i][3]));
                    }
                    if (isSelectedCheckBoxes[12]) {
                        drDataSource.add("Печь " + index, "Эквивалент замены кокса в базовом периоде, кг кокса /(м3 ПГ)",
                                String.valueOf(defaultData[i][4]));
                    }
                    if (isSelectedCheckBoxes[13]) {
                        drDataSource.add("Печь " + index, "Производительность по чугуну в базовом периоде, т /ч",
                                String.valueOf(defaultData[i][5]));
                    }
                    if (isSelectedCheckBoxes[14]) {
                        drDataSource.add("Печь " + index, "Содержание Si в чугуне в базовом периоде, %",
                                String.valueOf(defaultData[i][6]));
                    }
                    if (isSelectedCheckBoxes[15]) {
                        drDataSource.add("Печь " + index, "Минимально допустимое [Si], %",
                                String.valueOf(defaultData[i][7]));
                    }
                    if (isSelectedCheckBoxes[16]) {
                        drDataSource.add("Печь " + index, "Максимально допустимое [Si], %",
                                String.valueOf(defaultData[i][8]));
                    }
                    if (isSelectedCheckBoxes[17]) {
                        drDataSource.add("Печь " + index, "Изменение производства чугуна при изменении ПГ, т чуг/(м3 ПГ)",
                                String.valueOf(defaultData[i][9]));
                    }
                    if (isSelectedCheckBoxes[18]) {
                        drDataSource.add("Печь " + index, "Изменение производства чугуна при увеличении расхода кокса, т чуг/(кг кокса)",
                                String.valueOf(defaultData[i][10]));
                    }
                    if (isSelectedCheckBoxes[19]) {
                        drDataSource.add("Печь " + index, "Изменение [Si] при увеличении расхода ПГ на 1 м3/ч",
                                String.valueOf(defaultData[i][11]));
                    }
                    if (isSelectedCheckBoxes[20]) {
                        drDataSource.add("Печь " + index, "Изменение [Si] при увеличении расхода кокса на 1 кг/ч",
                                String.valueOf(defaultData[i][12]));
                    }
                    if (isSelectedCheckBoxes[21]) {
                        drDataSource.add("Печь " + index, "Изменение [Si] при увеличении производительности печи на 1 т чуг/ч",
                                String.valueOf(defaultData[i][13]));
                    }
                }
            } else {
                if (isSelectedCheckBoxes[22]) {
                    drDataSource.add("Наименование показателя", "Резерв по расходу природного газа в целом по цеху, м3/ч",
                            String.valueOf(defaultData[i][0]));
                }
                if (isSelectedCheckBoxes[23]) {
                    drDataSource.add("Наименование показателя", "Запасы кокса по цеху, т/ч",
                            String.valueOf(defaultData[i][1]));
                }
                if (isSelectedCheckBoxes[24]) {
                    drDataSource.add("Наименование показателя", "Требуемое производство чугуна в цехе, т/ч",
                            String.valueOf(defaultData[i][2]));
                }
            }
        }

        for (int i = 0; i < resultData.length; i++) {
            index = i + 1;
            drDataSource.add("Результат", "Оптимальный расход печи №" + index + ", м3/ч",
                    String.valueOf(resultData[i]));
        }

        return drDataSource;
    }
}
