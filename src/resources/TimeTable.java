/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author fawad
 */
public class TimeTable {
    
    
    public static JPanel timetable() {
        JPanel timetablePanel = new JPanel();
        timetablePanel.setBackground(Color.WHITE);
        timetablePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        timetablePanel.setLayout(new GridLayout(1, 2));

        // Create Monday Timetable
        JPanel mondayPanel = new JPanel();
        mondayPanel.setLayout(new BoxLayout(mondayPanel, BoxLayout.Y_AXIS));
        mondayPanel.setBorder(BorderFactory.createTitledBorder("Monday"));

        JLabel mondayLabel1 = new JLabel("9:00 AM - 10:00 AM: English");
        JLabel mondayLabel2 = new JLabel("10:30 AM - 11:30 AM: Math");
        JLabel mondayLabel3 = new JLabel("12:00 PM - 1:00 PM: Science");

        mondayPanel.add(mondayLabel1);
        mondayPanel.add(mondayLabel2);
        mondayPanel.add(mondayLabel3);

        // Create Tuesday Timetable
        JPanel tuesdayPanel = new JPanel();
        tuesdayPanel.setLayout(new BoxLayout(tuesdayPanel, BoxLayout.Y_AXIS));
        tuesdayPanel.setBorder(BorderFactory.createTitledBorder("Tuesday"));

        JLabel tuesdayLabel1 = new JLabel("9:00 AM - 10:00 AM: History");
        JLabel tuesdayLabel2 = new JLabel("10:30 AM - 11:30 AM: Geography");
        JLabel tuesdayLabel3 = new JLabel("12:00 PM - 1:00 PM: Physical Education");

        tuesdayPanel.add(tuesdayLabel1);
        tuesdayPanel.add(tuesdayLabel2);
        tuesdayPanel.add(tuesdayLabel3);

        timetablePanel.add(mondayPanel);
        timetablePanel.add(tuesdayPanel);

        return timetablePanel;
    }
}
