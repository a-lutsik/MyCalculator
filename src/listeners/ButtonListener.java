package listeners;

import calcOperations.CalcOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{

    private JTextField fieldChislo_1;
    private JTextField fieldChislo_2;
    private JTextField fieldResult;

    public ButtonListener(JTextField fieldChislo_1, JTextField fieldChislo_2, JTextField fieldResult) {
        this.fieldChislo_1 = fieldChislo_1;
        this.fieldChislo_2 = fieldChislo_2;
        this.fieldResult = fieldResult;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource() instanceof JButton)) {
            return;
        }

        JButton button = (JButton) event.getSource();

        final Double chislo_1 = Double.parseDouble(fieldChislo_1.getText());
        final Double chislo_2 = Double.parseDouble(fieldChislo_2.getText());


        if (button.getActionCommand().equals("Сложение")) {
            fieldResult.setText(String.valueOf(CalcOperations.add(chislo_1, chislo_2)));
        } else if (button.getActionCommand().equals("Вычетание")) {
            fieldResult.setText(String.valueOf(CalcOperations.substruct(chislo_1, chislo_2)));
        } else if (button.getActionCommand().equals("Умножение")) {
            fieldResult.setText(String.valueOf(CalcOperations.increase(chislo_1, chislo_2)));
        } else if (button.getActionCommand().equals("Деление")) {
            fieldResult.setText(String.valueOf(CalcOperations.division(chislo_1, chislo_2)));
        }
    }
}
