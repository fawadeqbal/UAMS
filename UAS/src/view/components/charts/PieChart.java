package view.components.charts;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class PieChart extends JFrame {

    public PieChart() {
        super("Pie Chart Example");

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 20);
        dataset.setValue("Category 2", 50);
        dataset.setValue("Category 3", 30);

        JFreeChart chart = ChartFactory.createPieChart("Pie Chart Example", dataset, true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PieChart::new);
    }
}
