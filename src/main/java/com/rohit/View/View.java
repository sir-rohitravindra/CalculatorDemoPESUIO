package com.rohit.View;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.FlowLayout;

import com.rohit.optype;

public class View extends JFrame {
    private JTextField firstNTextField;
    private JTextField secondNTextField;

    private JRadioButton addJRadioButton;
    private JRadioButton subtractJRadioButton;
    private JRadioButton multiplyJRadioButton;
    private JRadioButton divideJRadioButton;

    private ButtonGroup opButtonGroup;

    private JButton calculateJButton;

    private JLabel resultsJLabel;

    private int width, height;
    private boolean isResizable;

    public View(int width, int height, boolean isResizable) {
        this.width = width;
        this.height = height;
        this.isResizable = isResizable;

        setupComponents();
        buildDisplay();
    }

    // Build the components of the jframe.
    private void setupComponents() {
        // build the textfields
        firstNTextField = new JTextField(5);
        secondNTextField = new JTextField(5);

        // build the radiobuttons
        addJRadioButton = new JRadioButton("+");
        subtractJRadioButton = new JRadioButton("-");
        multiplyJRadioButton = new JRadioButton("*");
        divideJRadioButton = new JRadioButton("/");

        // add the radiobuttons to the button group!
        opButtonGroup = new ButtonGroup();
        opButtonGroup.add(addJRadioButton);
        opButtonGroup.add(subtractJRadioButton);
        opButtonGroup.add(multiplyJRadioButton);
        opButtonGroup.add(divideJRadioButton);

        // build the Jbutton
        calculateJButton = new JButton("Calculate");

        // build the Results display JLabel
        resultsJLabel = new JLabel();
    }

    // add all components to the JFrame.
    private void buildDisplay() {
        this.add(firstNTextField);
        this.add(secondNTextField);
        this.add(calculateJButton);

        this.add(addJRadioButton);
        this.add(subtractJRadioButton);
        this.add(multiplyJRadioButton);
        this.add(divideJRadioButton);

        this.add(resultsJLabel);

    }

    // called by controller to turn on the display.
    public void activateDisplay() {
        this.setSize(width, height);
        this.setResizable(isResizable);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // get the text of first text input
    public String getFirstNTextFieldText() {
        return this.firstNTextField.getText();
    }

    // get the text of second text input
    public String getSecondNTextFieldText() {
        return this.secondNTextField.getText();
    }

    public optype getOptype() {
        if (addJRadioButton.isSelected()) {
            return optype.ADDITION;
        } else if (subtractJRadioButton.isSelected()) {
            return optype.SUBTRACTION;
        } else if (multiplyJRadioButton.isSelected()) {
            return optype.MULTIPLICATION;
        } else if (divideJRadioButton.isSelected()) {
            return optype.DIVISION;
        } else {
            return optype.UNSELECTED;
        }
    }

    // get the text of results label
    public String getResultsJLabel() {
        return this.resultsJLabel.getText();
    }

    // set the text of first text input
    public void setResultsJLabel(String results) {
        this.resultsJLabel.setText("The result is : " + results);
    }

    public void setCalculateActionListener(ActionListener actionListener) {
        calculateJButton.addActionListener(actionListener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
