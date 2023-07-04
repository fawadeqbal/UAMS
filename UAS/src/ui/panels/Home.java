package ui.panels;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;
import model.UASController;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.JFreeChart;

public class Home extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JPanel chartPanel;

    public Home() {

        initializeComponents();
        setupLayout();

    }

    private void initializeComponents() {
        // Create the table
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        // Create the chart
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);

        // Set table data and column headers
        Vector<String> columnHeaders = new Vector<>();
        columnHeaders.add("Course");
        columnHeaders.add("Attendance");
        tableModel.setColumnIdentifiers(columnHeaders);

        Vector<Vector<String>> tableData = new Vector<>();
        tableData.add(createRow("Course 1", "80%"));
        tableData.add(createRow("Course 2", "90%"));
        tableData.add(createRow("Course 3", "70%"));
        tableData.add(createRow("Course 4", "85%"));
        tableData.add(createRow("Course 5", "75%"));
        setTableData(tableData);

        // Set the table and chart panel in the layout
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(chartPanel, BorderLayout.WEST);
    }

    private Vector<String> createRow(String course, String attendance) {
        Vector<String> row = new Vector<>();
        row.add(course);
        row.add(attendance);
        return row;
    }

    private void setTableData(Vector<Vector<String>> data) {
        tableModel.setDataVector(data, getColumnHeaders());
    }

    private Vector<String> getColumnHeaders() {
        Vector<String> headers = new Vector<>();
        headers.add("Course");
        headers.add("Attendance");
        return headers;
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
                "Attendance Statistics", // Chart title
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

        // Set different colors for each bar
        renderer.setSeriesPaint(0, new Color(41, 128, 185));
        renderer.setSeriesPaint(1, new Color(230, 57, 70));
        renderer.setSeriesPaint(2, new Color(82, 190, 128));
        renderer.setSeriesPaint(3, new Color(253, 203, 110));
        renderer.setSeriesPaint(4, new Color(135, 206, 250));

        return chart;
    }

    private void setupLayout() {

        setPreferredSize(new Dimension(800, 600));
    }
}
