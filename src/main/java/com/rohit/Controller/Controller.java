package com.rohit.Controller;

import com.rohit.optype;
import com.rohit.Model.Model;
import com.rohit.View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private View theView;
    private Model theModel;

    public Controller(View theView, Model theModel) {
        this.theView = theView;
        this.theModel = theModel;

        theView.setCalculateActionListener(new CalculateActionListener());
        theView.activateDisplay();

    }

    class CalculateActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                int firstNumber = Integer.parseInt(theView.getFirstNTextFieldText());
                int secondNumber = Integer.parseInt(theView.getSecondNTextFieldText());
                optype curOptype = theView.getOptype();

                switch (curOptype) {
                    case ADDITION: {
                        theModel.addValues(firstNumber, secondNumber);
                        break;
                    }
                    case SUBTRACTION: {
                        theModel.subtractValues(firstNumber, secondNumber);
                        break;
                    }
                    case MULTIPLICATION: {
                        theModel.multiplyValues(firstNumber, secondNumber);
                        break;
                    }
                    case DIVISION: {
                        theModel.divideValues(firstNumber, secondNumber);
                        break;
                    }

                    case UNSELECTED: {
                        theView.displayErrorMessage("No Option Selected!");
                        return;
                    }
                }

                theView.setResultsJLabel(String.valueOf(theModel.getResult()));

            } catch (Exception err) {
                theView.displayErrorMessage(err.toString());
            }

        }

    }

}
