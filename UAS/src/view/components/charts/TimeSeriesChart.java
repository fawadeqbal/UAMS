package view.components.charts;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;

public class TimeSeriesChart extends JFrame {

    public TimeSeriesChart() {
        super("Time Series Chart Example");

        TimeSeries series = new TimeSeries("Data Series");
        series.add(new Day(1, 1, 2023), 5);
        series.add(new Day(2, 1, 2023), 12);
        series.add(new Day(3, 1, 2023), 8);
        series.add(new Day(4, 1, 2023), 15);
        series.add(new Day(5, 1, 2023), 10);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Time Series Chart Example", "Date", "Value", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimeSeriesChart::new);
    }
}
