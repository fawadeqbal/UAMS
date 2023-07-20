package view.components.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;

public class Histogram extends JFrame {

    public Histogram() {
        super("Histogram Example");

        double[] data = {5.1, 3.5, 1.4, 0.2, 4.9, 3.0, 1.4, 0.2, 4.7, 3.2, 1.3, 0.2,
                         4.6, 3.1, 1.5, 0.2, 5.0, 3.6, 1.4, 0.2, 5.4, 3.9, 1.7, 0.4};

        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Histogram", data, 10);

        JFreeChart chart = ChartFactory.createHistogram("Histogram Example", "Value", "Frequency", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Histogram::new);
    }
}
