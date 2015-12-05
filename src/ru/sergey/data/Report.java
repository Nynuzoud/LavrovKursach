package ru.sergey.data;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.exception.DRException;

public class Report {
    public void build() {
        JasperReportBuilder reportBuilder = DynamicReports.report();
        try {
            reportBuilder
                    .addColumn(Columns.column("Исходные данные", "items", DynamicReports.type.stringType()))
                    .addColumn(Columns.column("Значение", "count", DynamicReports.type.stringType()))
                    .addTitle(Components.text("Результаты"))
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }
}
