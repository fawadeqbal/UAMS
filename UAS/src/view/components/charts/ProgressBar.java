package view.components.charts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar extends JFrame {
    private JProgressBar progressBar;
    
    public ProgressBar() {
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                // Start a new thread to perform a task with progress updates
                new Thread(() -> {
                    for (int i = 0; i <= 100; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        final int progress = i;
                        SwingUtilities.invokeLater(() -> {
                            progressBar.setValue(progress);
                            if (progress == 100) {
                                startButton.setEnabled(true);
                            }
                        });
                    }
                }).start();
            }
        });
        add(progressBar);
        add(startButton, BorderLayout.SOUTH);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgressBar::new);
    }
}
