package view;

/**
 *
 * @author fawad
 */
import view.components.UTCTime;
import javax.swing.*;
import controller.UASController;
import japa.parser.ParseException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import view.forms.LoginUI;
import view.components.ManageCourses;
import view.components.ManageStudents;
import view.components.ManageTeachers;
import view.components.ManageUsers;
import view.forms.AssignmentDashboard;

public class AdminDashboard extends JFrame {

    private JPanel headerPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public AdminDashboard() {
         if (!UASController.isUserLoggedIn()) {
            LoginUI loginScreen = new LoginUI();
            loginScreen.setVisible(true);
            this.dispose();
        } else {
             
        setTitle("Attendance Management System - Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Header Panel
        createHeaderPanel();

        // Menu Panel
        createMenuPanel();

        // Content Panel
        createContentPanel();

        pack();
        setLocationRelativeTo(null);
        }

    }

    private void createHeaderPanel() {
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(800, 75));
        add(headerPanel, BorderLayout.NORTH);
       // Add WindowListener to handle closing event
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Call the method to expire the session and handle any other necessary cleanup
                    UASController.expireSession();
                }
            });

        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setForeground(new Color(250, 250, 250));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);
        headerPanel.add(rightPanel, BorderLayout.EAST);

        JLabel timeLabel = new JLabel();
        timeLabel.setForeground(new Color(250, 250, 250));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        rightPanel.add(timeLabel, BorderLayout.NORTH);

        // Update the time label using the UTCTime class
        Thread updateTimeThread = new Thread(() -> {
            while (true) {
                try {
                    Date utcTime = UTCTime.getCurrentUtcTime();
                    String formattedTime = new SimpleDateFormat("HH:mm:ss").format(utcTime);
                    SwingUtilities.invokeLater(() -> timeLabel.setText("UTC Time: " + formattedTime));
                    Thread.sleep(1000); // Update every second
                } catch (InterruptedException | ParseException e) {
                    
                }
            }
        });

        updateTimeThread.start();
    }

    private void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(52, 152, 219));
        menuPanel.setPreferredSize(new Dimension(220, 600));
        menuPanel.setLayout(new GridBagLayout());
        add(menuPanel, BorderLayout.WEST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

//        JButton addStudentButton = createMenuButton("Add Student");
//        menuPanel.add(addStudentButton, gbc);
//        gbc.gridy++;
        JButton manageStudentsButton = createMenuButton("Manage Students");
        menuPanel.add(manageStudentsButton, gbc);
        gbc.gridy++;
        JButton manageCourseButton = createMenuButton("Manage Courses");
        menuPanel.add(manageCourseButton, gbc);
        gbc.gridy++;
        JButton manageUserButton = createMenuButton("Manage Users");
        menuPanel.add(manageUserButton, gbc);
        gbc.gridy++;
        JButton manageTeacherButton = createMenuButton("Manage Teachers");
        menuPanel.add(manageTeacherButton, gbc);
        gbc.gridy++;
        JButton assignCourseTeacherButton = createMenuButton("Assignment Dashboard");
        menuPanel.add(assignCourseTeacherButton, gbc);
        gbc.gridy++;

        gbc.gridy++;
        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(41, 128, 185));
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 12));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        logoutButton.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));

        // Add ActionListener to handle logout functionality
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UASController.expireSession();
            }
        });

        menuPanel.add(logoutButton, gbc);
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 35));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(41, 128, 185));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        button.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));

        // Hover Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {

        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event or navigate to the corresponding page
                String buttonText = button.getText();

                contentPanel.removeAll();
                if (buttonText.equals("Manage Courses")) {
                    contentPanel.add(new ManageCourses());
                } else if (buttonText.equals("Manage Users")) {
                    contentPanel.add(new ManageUsers());
                } else if (buttonText.equals("Manage Students")) {
                    contentPanel.add(new ManageStudents());
                }else if (buttonText.equals("Manage Teachers")) {
                    contentPanel.add(new ManageTeachers());
                } else if (buttonText.equals("Assignment Dashboard")) {
                    contentPanel.add(new AssignmentDashboard());
                }
                
                
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        return button;
    }

    private void createContentPanel() {
        contentPanel = new JPanel();

        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        String[] parts = UASController.objApplicationSession.getUser().getEmail().split("@");
        String username = parts[0];
        JLabel welcomeLabel = new JLabel("Hey there " + username + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(41, 128, 185));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(welcomeLabel, BorderLayout.CENTER);
    }

}
