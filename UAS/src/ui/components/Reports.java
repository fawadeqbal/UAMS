package ui.components;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Reports extends JPanel {

    private JLabel titleLabel;

    public Reports() {
        FlatLightLaf.install();

        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Header Label
        titleLabel = new JLabel("Attendance Statistics");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add sample data
        dataset.addValue(80, "Attendance", "Course 1");
        dataset.addValue(90, "Attendance", "Course 2");
        dataset.addValue(70, "Attendance", "Course 3");
        dataset.addValue(85, "Attendance", "Course 4");
        dataset.addValue(75, "Attendance", "Course 5");

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "", // Chart title (empty as we have the title label)
                "Course", // X-axis label
                "Attendance Percentage", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Chart orientation
                false, // Include legend
                true, // Include tooltips
                false // Include URLs
        );

        // Customize chart appearance
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setSeriesPaint(0, new Color(0x3B82F6)); // Blue color

        // Remove chart border
        chart.setBorderPaint(null);
        chart.setBorderVisible(false);

        // Remove plot border
        plot.setOutlinePaint(null);
        plot.setOutlineVisible(false);

        // Remove axis borders
        plot.getDomainAxis().setAxisLineVisible(false);
        plot.getRangeAxis().setAxisLineVisible(false);

        // Remove tick marks and labels from the range axis
        plot.getRangeAxis().setTickMarksVisible(false);
        plot.getRangeAxis().setTickLabelsVisible(false);

        return chart;
    }

    private void setupLayout() {
        setPreferredSize(new Dimension(600, 400));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Reports Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Reports panel = new Reports();
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
