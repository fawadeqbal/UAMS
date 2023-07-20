package view.components.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class BarChart extends JFrame {

    public BarChart() {
        super("Bar Chart Example");

        CategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Example", "Category", "Value", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "Category1");
        dataset.addValue(4, "Series1", "Category2");
        dataset.addValue(5, "Series1", "Category3");
        dataset.addValue(3, "Series1", "Category4");
        dataset.addValue(8, "Series1", "Category5");
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BarChart::new);
    }
}
