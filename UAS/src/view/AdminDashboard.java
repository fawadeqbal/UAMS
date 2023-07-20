/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author fawad
 */
import view.components.UTCTime;
import javax.swing.*;
import view.panels.LoginUI;
import controller.UASController;
import japa.parser.ParseException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import view.forms.AddCourse;
import view.forms.AddStudent;
import view.forms.AddUser;
import view.panels.AddTeacher;
import view.panels.AssignCourse;
import view.panels.Courses;
import view.panels.ViewStudents;
import view.panels.ViewTeachers;
import view.panels.ViewUsers;

public class AdminDashboard extends JFrame {

    private JPanel headerPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public AdminDashboard() {

        setTitle("Attendance Management System - Dashboard");
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

    private void createHeaderPanel() {
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(800, 75));
        add(headerPanel, BorderLayout.NORTH);

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

        JButton addStudentButton = createMenuButton("Add Student");
        menuPanel.add(addStudentButton, gbc);
        gbc.gridy++;
        JButton viewStudentsButton = createMenuButton("View Students");
        menuPanel.add(viewStudentsButton, gbc);
        gbc.gridy++;
        JButton addCourseButton = createMenuButton("Add Course");
        menuPanel.add(addCourseButton, gbc);
        gbc.gridy++;
        JButton viewCoursesButton = createMenuButton("View Courses");
        menuPanel.add(viewCoursesButton, gbc);
        gbc.gridy++;
        JButton addUserButton = createMenuButton("Add User");
        menuPanel.add(addUserButton, gbc);
        gbc.gridy++;
        JButton viewUsersButton = createMenuButton("View Users");
        menuPanel.add(viewUsersButton, gbc);
        gbc.gridy++;
        JButton addTeacherButton = createMenuButton("Add Teacher");
        menuPanel.add(addTeacherButton, gbc);
        gbc.gridy++;
        JButton viewTeachersButton = createMenuButton("View Teachers");
        menuPanel.add(viewTeachersButton, gbc);
        gbc.gridy++;
        JButton assignCourseTeacherButton = createMenuButton("Assign Course Teacher");
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
                dispose();
                new LoginUI().setVisible(true);
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
                if (buttonText.equals("Add Course")) {
                    contentPanel.add(new AddCourse());
                } else if (buttonText.equals("View Courses")) {
                    contentPanel.add(new Courses());
                } else if (buttonText.equals("Add User")) {
                    contentPanel.add(new AddUser());
                } else if (buttonText.equals("View Users")) {
                    contentPanel.add(new ViewUsers());
                } else if (buttonText.equals("Add Student")) {
                    contentPanel.add(new AddStudent());
                } else if (buttonText.equals("View Students")) {
                    contentPanel.add(new ViewStudents());
                }else if (buttonText.equals("View Teachers")) {
                    contentPanel.add(new ViewTeachers());
                }else if (buttonText.equals("Add Teacher")) {
                    contentPanel.add(new AddTeacher());
                } else if (buttonText.equals("Assign Course Teacher")) {
                    contentPanel.add(new AssignCourse());
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
