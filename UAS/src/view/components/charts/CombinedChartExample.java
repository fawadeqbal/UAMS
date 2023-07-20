/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class CombinedChartExample extends JFrame {

    public CombinedChartExample() {
        super("Combined Chart Example");

        CategoryDataset barDataset = createBarDataset();
        XYSeriesCollection lineDataset = createLineDataset();

        JFreeChart chart = createCombinedChart(barDataset, lineDataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private CategoryDataset createBarDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "Category1");
        dataset.addValue(4, "Series1", "Category2");
        dataset.addValue(5, "Series1", "Category3");
        dataset.addValue(3, "Series1", "Category4");
        dataset.addValue(8, "Series1", "Category5");
        return dataset;
    }

    private XYSeriesCollection createLineDataset() {
        XYSeries series = new XYSeries("Data Series");
        series.add(1, 5);
        series.add(2, 12);
        series.add(3, 8);
        series.add(4, 15);
        series.add(5, 10);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private JFreeChart createCombinedChart(CategoryDataset barDataset, XYSeriesCollection lineDataset) {
        JFreeChart barChart = ChartFactory.createBarChart("Bar Chart", "Category", "Value", barDataset);
        CategoryPlot barPlot = barChart.getCategoryPlot();
        CategoryAxis domainAxis = barPlot.getDomainAxis();
        domainAxis.setCategoryMargin(0.1); // Set category margin for better visualization

        JFreeChart lineChart = ChartFactory.createXYLineChart("Line Chart", "X", "Y", lineDataset);
        XYPlot linePlot = lineChart.getXYPlot();
        ValueAxis domainAxisLine = linePlot.getDomainAxis();
        domainAxisLine.setRange(0.5, 5.5); // Set range for better visualization

        CombinedDomainXYPlot plot = new CombinedDomainXYPlot();
//        plot.add(barPlot);
        plot.add(linePlot);

        return new JFreeChart("Combined Chart Example", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CombinedChartExample::new);
    }
}
