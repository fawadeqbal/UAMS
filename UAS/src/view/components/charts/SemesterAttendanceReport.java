package view.components.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot; // Use CategoryPlot instead of XYPlot
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class SemesterAttendanceReport extends JPanel {

    public SemesterAttendanceReport() {
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        

        // Set the layout manager for the panel to adjust the chart size
        setLayout(new BorderLayout());
        add(chartPanel,BorderLayout.CENTER);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Replace this with your actual data
        // For example, if you have attendance data for each course and date,
        // you can add the data to the dataset as follows:

        // Course 1 attendance
        dataset.addValue(80, "CSC102", "Jan");
        dataset.addValue(90, "CSC102", "Feb");
        dataset.addValue(95, "CSC102", "Mar");
        dataset.addValue(100, "CSC102", "Apr");

        // Course 2 attendance
        dataset.addValue(85, "CSC204", "Jan");
        dataset.addValue(70, "CSC204", "Feb");
        dataset.addValue(92, "CSC204", "Mar");
        dataset.addValue(78, "CSC204", "Apr");
        
        dataset.addValue(85, "MTH209", "Jan");
        dataset.addValue(67, "MTH209", "Feb");
        dataset.addValue(73, "MTH209", "Mar");
        dataset.addValue(98, "MTH209", "Apr");
        
        dataset.addValue(85, "MGT106", "Jan");
        dataset.addValue(67, "MGT106", "Feb");
        dataset.addValue(80, "MGT106", "Mar");
        dataset.addValue(56, "MGT106", "Apr");
        
        dataset.addValue(85, "MTH103", "Jan");
        dataset.addValue(46, "MTH103", "Feb");
        dataset.addValue(92, "MTH103", "Mar");
        dataset.addValue(50, "MTH103", "Apr");
        
        

        // Add data for other courses in a similar way

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
    JFreeChart chart = ChartFactory.createBarChart(
            "Semester Attendance Report",
            "Date",
            "Attendance Percentage",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );

    // Customize the chart
    CategoryPlot plot = chart.getCategoryPlot();
    BarRenderer renderer = new BarRenderer();
    renderer.setShadowVisible(false);
    plot.setRenderer(renderer);
    plot.setDomainGridlinesVisible(true); // Show domain gridlines
    plot.setDomainGridlinePaint(Color.lightGray); // Set domain gridline color
    plot.setRangeGridlinesVisible(true); // Show range gridlines
    plot.setRangeGridlinePaint(Color.lightGray); // Set range gridline color

    return chart;
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Semester Attendance Histogram Chart");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new SemesterAttendanceReport();
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
