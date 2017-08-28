package listeners;

import javax.swing.*;
import java.awt.event.*;

public class TextFieldListener extends FocusAdapter{

    private JTextField fieldChislo;
    private final String TEXT = "Введите число";


    public TextFieldListener(JTextField fieldChislo) {
        this.fieldChislo = fieldChislo;
    }

    @Override
    public void focusGained(FocusEvent e) {
        fieldChislo.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (fieldChislo.getText().equals("")) {
            fieldChislo.setText(TEXT);
        } else {
            return;
        }
    }
}
