package ru.sergey.data;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static net.sf.dynamicreports.report.builder.DynamicReports.report;

public class Report {
    public void build() {
        JasperReportBuilder reportBuilder = report();
        try {
            reportBuilder
                    .addColumn(Columns.column("Исходные данные", "items", DynamicReports.type.stringType()))
                    .addColumn(Columns.column("Значение", "count", DynamicReports.type.stringType()))
                    .addTitle(Components.text("Результаты"))
                    .setDataSource(getDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private Collection<?> getDataSource() {
        double[][] defaultArray = DefaultData.getDefaultArray();

        Collection<HashMap<String, String>> collection = new ArrayList<>();
        HashMap<String, String> hashMap;

        for (int i = 0; i < defaultArray.length - 1; i++) {
            hashMap = new HashMap<>();
            for (int j = 0; j < defaultArray[i].length; j++) {
                switch (j) {
                    case 0:

                }
            }
        }



        return null;
    }
}
