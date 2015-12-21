package ru.sergey.data;

import org.knowm.xchart.Chart;
import org.knowm.xchart.ChartBuilder;
import org.knowm.xchart.StyleManager;
import org.knowm.xchart.SwingWrapper;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Diagram {

    private ResourceBundle locale;

    public Diagram(ResourceBundle mainLocale) {
        locale = mainLocale;
    }

    public void build(){
        int[] furnaceResult = DefaultData.getFurnaceResult();
        double[][] defaultArray = DefaultData.getDefaultArray();

        Number[] resultNumbers = new Number[8];
        Number[] defaultNumbers = new Number[8];
        String[] numberOfFurnaces = new String[8];

        for (int i = 0; i < resultNumbers.length; i++) {
            resultNumbers[i] = furnaceResult[i];
        }

        for (int i = 0; i < defaultNumbers.length; i++) {
            defaultNumbers[i] = defaultArray[i][0];
        }

        for (int i = 0; i < numberOfFurnaces.length; i++) {
            int furnaceNumber = i + 1;
            numberOfFurnaces[i] = locale.getString("furnaceLabel") + " " + furnaceNumber;
        }

        Chart chart = new ChartBuilder()
                .chartType(StyleManager.ChartType.Bar)
                .width(1200)
                .height(600)
                .title(locale.getString("comparisonPG"))
                .xAxisTitle(locale.getString("furnaceNumber"))
                .yAxisTitle(locale.getString("rashod"))
                .theme(StyleManager.ChartTheme.GGPlot2)
                .build();

        chart.addSeries(locale.getString("baseRashod"),
                new ArrayList<>(Arrays.asList(numberOfFurnaces)),
                new ArrayList<>(Arrays.asList(defaultNumbers)));

        chart.addSeries(locale.getString("optRashod"),
                new ArrayList<>(Arrays.asList(numberOfFurnaces)),
                new ArrayList<>(Arrays.asList(resultNumbers)));

        SwingWrapper swingWrapper = new SwingWrapper(chart);
        JFrame diagramFrame = swingWrapper.displayChart(locale.getString("diagramRashodPG"));

        WindowAdapter windowAdapter = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                 diagramFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        };

        diagramFrame.addWindowListener(windowAdapter);
    }
}
