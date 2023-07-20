package view.components.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYZDataset;

import javax.swing.*;

public class BubbleChartExample extends JFrame {

    public BubbleChartExample() {
        super("Bubble Chart Example");

        DefaultXYZDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createBubbleChart("Bubble Chart Example", "X", "Y", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private DefaultXYZDataset createDataset() {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[][] data = {{1.0, 2.0, 3.0}, {5.0, 8.0, 6.0}, {10.0, 15.0, 8.0}};
        dataset.addSeries("Series1", data);
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BubbleChartExample::new);
    }
}
