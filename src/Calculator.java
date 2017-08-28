import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.sun.deploy.panel.JavaPanel;
import listeners.ButtonListener;
import listeners.ComboBoxListener;
import listeners.TextFieldListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator {

    //Declaration variables of Jlabel
    private JLabel labelChislo_1;
    private JLabel labelChislo_2;
    private JLabel labelResult;
    private JLabel labelChangeSkin;

    //Declaration variables of JTextField
    private JTextField fieldChislo_1;
    private JTextField fieldChislo_2;
    private JTextField fieldResult;

    //Declaration variables of JComboBox
    private JComboBox<String> listSkin;
    private JScrollPane scroller;

    //Declaration variables of JButton
    private JButton buttonAdding;
    private JButton buttonSubstruction;
    private JButton buttonIncrease;
    private JButton buttonDivision;

    //Declaration variables of JPanel
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelButtom;

    private JFrame frame;

    private static final String INPUT_NUMBER = "Введите число";

    public static void main(String[] args) {

        //Setting skin of App
        try{
            UIManager.setLookAndFeel(new AeroLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
        }
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        Calculator calculator = new Calculator();
        calculator.createLabel();
        calculator.createTextField();
        calculator.createComboBox();
        calculator.createButton();
        calculator.createPanel();
        calculator.createFrame();
        
    }

    private void createButton() {
        buttonAdding = new JButton("Сложение");
        buttonSubstruction = new JButton("Вычетание");
        buttonIncrease = new JButton("Умножение");
        buttonDivision = new JButton("Деление");

        addButtonListener();
    }

    private void createLabel() {
        labelChislo_1 = new JLabel("Число 1");
        labelChislo_2 = new JLabel("Число 2");
        labelResult = new JLabel("Результат");
        labelChangeSkin = new JLabel("Скины");
    }

    private void createTextField() {
        fieldChislo_1 = new JTextField(INPUT_NUMBER, 10);
        fieldChislo_2 = new JTextField(INPUT_NUMBER, 10);
        fieldResult = new JTextField("Результат", 10);

        addTextFieldListener();
    }

    private void createComboBox() {
        String[] list = {
                "Default",
                "BernsteinLookAndFeel",
                "AluminiumLookAndFeel",
                "HiFiLookAndFeel",
                "TextureLookAndFeel",
                "AcrylLookAndFeel"
        };
        listSkin = new JComboBox<String>(list);
        listSkin.setMaximumRowCount(3);

        //Creating ScrollPanel for JComboBox
        scroller = new JScrollPane(listSkin);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void createPanel() {
        FlowLayout layout = new FlowLayout();

        panelTop = new JPanel(layout);
        panelTop.add(labelChislo_1);
        panelTop.add(fieldChislo_1);
        panelTop.add(labelChislo_2);
        panelTop.add(fieldChislo_2);

        panelMiddle = new JPanel(layout);
        panelMiddle.add(buttonAdding);
        panelMiddle.add(buttonSubstruction);
        panelMiddle.add(buttonIncrease);
        panelMiddle.add(buttonDivision);

        panelButtom = new JPanel(layout);
        panelButtom.add(labelResult);
        panelButtom.add(fieldResult);
        panelButtom.add(labelChangeSkin);
        panelButtom.add(scroller);
    }

    private void createFrame() {
        frame = new JFrame("Калькулятор");
        frame.setSize(600, 200);
        frame.setMinimumSize(new Dimension(600, 200));
        frame.setLayout(new BorderLayout(2, 2));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.getContentPane().add(panelTop, BorderLayout.NORTH);
        frame.getContentPane().add(panelMiddle, BorderLayout.CENTER);
        frame.getContentPane().add(panelButtom, BorderLayout.SOUTH);

        createSkinListener();
    }

    private void addButtonListener() {
        ButtonListener buttonListener = new ButtonListener(fieldChislo_1, fieldChislo_2, fieldResult);

        buttonAdding.addActionListener(buttonListener);
        buttonSubstruction.addActionListener(buttonListener);
        buttonIncrease.addActionListener(buttonListener);
        buttonDivision.addActionListener(buttonListener);
    }

    private void addTextFieldListener() {
        TextFieldListener textFieldListener_1 = new TextFieldListener(fieldChislo_1);
        fieldChislo_1.addFocusListener(textFieldListener_1);

        TextFieldListener textFieldListener_2 = new TextFieldListener(fieldChislo_2);
        fieldChislo_2.addFocusListener(textFieldListener_2);

    }

    private void createSkinListener() {
        ComboBoxListener comboBoxListener = new ComboBoxListener(frame);
        listSkin.addActionListener(comboBoxListener);
    }
}
