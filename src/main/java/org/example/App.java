package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App extends JFrame {
    private JLabel departureCityLabel;
    private JComboBox<String> departureCityComboBox;
    private JLabel arrivalCityLabel;
    private JComboBox<String> arrivalCityComboBox;
    private JCheckBox businessClassCheckBox;
    private JCheckBox firstClassCheckBox;
    private JRadioButton directFlightRadioButton;
    private JRadioButton layoverFlightRadioButton;
    private JButton registerButton;

    public App() {
        setTitle("Flight Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        departureCityLabel = new JLabel("Departure City:");
        departureCityComboBox = new JComboBox<>(new String[]{"New York", "London", "Paris", "Tokyo"});

        arrivalCityLabel = new JLabel("Arrival City:");
        arrivalCityComboBox = new JComboBox<>(new String[]{"Los Angeles", "Sydney", "Dubai", "Moscow"});

        businessClassCheckBox = new JCheckBox("Business Class");
        firstClassCheckBox = new JCheckBox("First Class");

        directFlightRadioButton = new JRadioButton("Direct Flight");
        layoverFlightRadioButton = new JRadioButton("Flight with Layover");
        directFlightRadioButton.setSelected(true);

        ButtonGroup flightTypeGroup = new ButtonGroup();
        flightTypeGroup.add(directFlightRadioButton);
        flightTypeGroup.add(layoverFlightRadioButton);

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFlight();
            }
        });

        add(departureCityLabel);
        add(departureCityComboBox);
        add(arrivalCityLabel);
        add(arrivalCityComboBox);
        add(businessClassCheckBox);
        add(firstClassCheckBox);
        add(directFlightRadioButton);
        add(layoverFlightRadioButton);
        add(registerButton);

        pack();
        setLocationRelativeTo(null);
    }

    private void registerFlight() {
        String departureCity = (String) departureCityComboBox.getSelectedItem();
        String arrivalCity = (String) arrivalCityComboBox.getSelectedItem();
        boolean isBusinessClassSelected = businessClassCheckBox.isSelected();
        boolean isFirstClassSelected = firstClassCheckBox.isSelected();
        boolean hasLayover = layoverFlightRadioButton.isSelected();

        // Здесь можно добавить код для сохранения данных в файл или передачи данных на сервер

        JOptionPane.showMessageDialog(this, "Flight Registered successfully!",
                "Registration Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App app = new App();
                app.setVisible(true);
            }
        });
    }

    }