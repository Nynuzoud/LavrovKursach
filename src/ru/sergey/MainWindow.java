package ru.sergey;

import ru.sergey.common.Preferences;
import ru.sergey.data.DefaultData;
import ru.sergey.data.ExcelData;
import ru.sergey.data.SaveData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class MainWindow extends JFrame {
    private JPanel MainPanel;
    private JLabel pokazateliLabel;
    private JLabel rashodGazaLabel;
    private JLabel seraLabel;
    private JLabel koefLabel;
    private JLabel rezervLabel;
    private JLabel vBazovomPeriodLabel;
    private JLabel seraVChuguneLabel;
    private JLabel izmPrChugPGLabel;
    private JTextField rezervTextField;
    private JTextField vBazovomPeriodeTextField;
    private JTextField seraVChuguneTextField;
    private JTextField izmPrChugPGTextField;
    private JLabel zapasLabel;
    private JLabel minLabel;
    private JLabel MinSeraLabel;
    private JLabel izmPrChugKoksLabel;
    private JTextField zapasTextField;
    private JTextField minTextField;
    private JTextField minSeraTextField;
    private JTextField izmPrChugKoksTextField;
    private JLabel trebChugLabel;
    private JLabel maxLabel;
    private JLabel maxSeraLabel;
    private JLabel izmSeraPGLabel;
    private JTextField trebChugTextField;
    private JTextField maxTextField;
    private JTextField maxSeraTextField;
    private JTextField izmSeraPGTextField;
    private JLabel izmSeraKoksLabel;
    private JTextField izmSeraKoksTextField;
    private JLabel izmSeraPrLabel;
    private JLabel otherLabel;
    private JLabel proizvChugLabel;
    private JTextField proizvChugTextField;
    private JLabel rashodKoksaLabel;
    private JTextField rashodKoksaTextField;
    private JLabel ekvZameniLabel;
    private JTextField ekvZameniTextField;
    private JTextField izmSeraPrTextField;
    private JLabel furnaceLabel;
    private JLabel resultsLabel;
    private JLabel resultFurnLabel1;
    private JLabel resultFurnLabel2;
    private JLabel resultFurnLabel3;
    private JLabel resultLabel1;
    private JLabel resultLabel2;
    private JLabel resultLabel3;
    private JLabel resultFurnLabel4;
    private JLabel resultFurnLabel5;
    private JLabel resultFurnLabel6;
    private JLabel resultFurnLabel7;
    private JLabel resultFurnLabel8;
    private JLabel resultLabel4;
    private JLabel resultLabel5;
    private JLabel resultLabel6;
    private JLabel resultLabel7;
    private JLabel resultLabel8;
    private JRadioButton furnaceRadioButton1;
    private JRadioButton furnaceRadioButton2;
    private JRadioButton furnaceRadioButton3;
    private JRadioButton furnaceRadioButton4;
    private JRadioButton furnaceRadioButton5;
    private JRadioButton furnaceRadioButton6;
    private JRadioButton furnaceRadioButton7;
    private JRadioButton furnaceRadioButton8;
    private JButton calculate;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem closeItem;

    //init classes
    DefaultData defaultData = new DefaultData();
    SaveData saveData = new SaveData();
    ExcelData excelData = new ExcelData();

    //current furnace
    private static int currentFurnace;

    public void MainForm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                savePreviousFurnaceData(currentFurnace);
                saveData.saveItemAction();
            }
        });

        calculate.addActionListener(e -> {
            excelData.sendData();
        });

        buildMenu();

        setSize(1150, 500);
        add(MainPanel);
        setVisible(true);

        furnaceRadioButton1.setSelected(true);

        addListenersToRadioButtons();

        if(!savedFileExists()) {
            defaultData.createDefaultData();
            setDefaultDataToFurnaces(1);
        } else {
            saveData.openItemAction();
            setDefaultDataToFurnaces(1);
        }

        currentFurnace = 1;
    }

    private boolean savedFileExists() {
        Boolean isFileExists = false;

        File file = new File(Preferences.getPreferences.FILE_DESTINATION);
        if(file.exists()) {
            isFileExists = true;
        }

        return isFileExists;
    }

    private void addListenersToRadioButtons() {
        RadioButtonListener radioButtonListener = new RadioButtonListener();
        furnaceRadioButton1.addActionListener(radioButtonListener);
        furnaceRadioButton2.addActionListener(radioButtonListener);
        furnaceRadioButton3.addActionListener(radioButtonListener);
        furnaceRadioButton4.addActionListener(radioButtonListener);
        furnaceRadioButton5.addActionListener(radioButtonListener);
        furnaceRadioButton6.addActionListener(radioButtonListener);
        furnaceRadioButton7.addActionListener(radioButtonListener);
        furnaceRadioButton8.addActionListener(radioButtonListener);
    }

    private void buildMenu() {
        menuBar = new JMenuBar();

        //build the File menu
        fileMenu = new JMenu("Файл");
        openItem = new JMenuItem("Открыть");
        saveItem = new JMenuItem("Сохранить..");
        closeItem = new JMenuItem("Закрыть");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);

        // add menus to menubar
        menuBar.add(fileMenu);

        // put the menubar on the frame
        setJMenuBar(menuBar);

        saveItem.addActionListener(e -> {
            savePreviousFurnaceData(currentFurnace);
            saveData.saveItemAction();
        });

        openItem.addActionListener(e -> {
            saveData.openItemAction();
            setDefaultDataToFurnaces(currentFurnace);
        });
    }

    class RadioButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton button = (JRadioButton) e.getSource();
            if(button == furnaceRadioButton1) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 1;
                setDefaultDataToFurnaces(1);
            } else if (button == furnaceRadioButton2) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 2;
                setDefaultDataToFurnaces(2);
            } else if (button == furnaceRadioButton3) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 3;
                setDefaultDataToFurnaces(3);
            } else if (button == furnaceRadioButton4) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 4;
                setDefaultDataToFurnaces(4);
            } else if (button == furnaceRadioButton5) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 5;
                setDefaultDataToFurnaces(5);
            } else if (button == furnaceRadioButton6) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 6;
                setDefaultDataToFurnaces(6);
            } else if (button == furnaceRadioButton7) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 7;
                setDefaultDataToFurnaces(7);
            } else if (button == furnaceRadioButton8) {
                savePreviousFurnaceData(currentFurnace);
                currentFurnace = 8;
                setDefaultDataToFurnaces(8);
            }
        }
    }

    private void savePreviousFurnaceData(int currentFurnace) {
        int currentFurnaceIndex = currentFurnace - 1;

        double[][] array = DefaultData.getDefaultArray();

        array[currentFurnaceIndex][0] = Double.valueOf(vBazovomPeriodeTextField.getText());
        array[currentFurnaceIndex][1] = Double.valueOf(minTextField.getText());
        array[currentFurnaceIndex][2] = Double.valueOf(maxTextField.getText());
        array[currentFurnaceIndex][3] = Double.valueOf(rashodKoksaTextField.getText());
        array[currentFurnaceIndex][4] = Double.valueOf(ekvZameniTextField.getText());
        array[currentFurnaceIndex][5] = Double.valueOf(proizvChugTextField.getText());
        array[currentFurnaceIndex][6] = Double.valueOf(seraVChuguneTextField.getText());
        array[currentFurnaceIndex][7] = Double.valueOf(minSeraTextField.getText());
        array[currentFurnaceIndex][8] = Double.valueOf(maxSeraTextField.getText());
        array[currentFurnaceIndex][9] = Double.valueOf(izmPrChugPGTextField.getText());
        array[currentFurnaceIndex][10] = Double.valueOf(izmPrChugKoksTextField.getText());
        array[currentFurnaceIndex][11] = Double.valueOf(izmSeraPGTextField.getText());
        array[currentFurnaceIndex][12] = Double.valueOf(izmSeraKoksTextField.getText());
        array[currentFurnaceIndex][13] = Double.valueOf(izmSeraPrTextField.getText());

        array[8][0] = Double.valueOf(rezervTextField.getText());
        array[8][1] = Double.valueOf(zapasTextField.getText());
        array[8][2] = Double.valueOf(trebChugTextField.getText());

        DefaultData.setDefaultArray(array);
    }

    private void setDefaultDataToFurnaces(int furnaceNumber) {
        int currentFurnaceIndex = furnaceNumber - 1;

        double[][] array = DefaultData.getDefaultArray();
        vBazovomPeriodeTextField.setText(String.valueOf(array[currentFurnaceIndex][0]));
        minTextField.setText(String.valueOf(array[currentFurnaceIndex][1]));
        maxTextField.setText(String.valueOf(array[currentFurnaceIndex][2]));
        rashodKoksaTextField.setText(String.valueOf(array[currentFurnaceIndex][3]));
        ekvZameniTextField.setText(String.valueOf(array[currentFurnaceIndex][4]));
        proizvChugTextField.setText(String.valueOf(array[currentFurnaceIndex][5]));
        seraVChuguneTextField.setText(String.valueOf(array[currentFurnaceIndex][6]));
        minSeraTextField.setText(String.valueOf(array[currentFurnaceIndex][7]));
        maxSeraTextField.setText(String.valueOf(array[currentFurnaceIndex][8]));
        izmPrChugPGTextField.setText(String.valueOf(array[currentFurnaceIndex][9]));
        izmPrChugKoksTextField.setText(String.valueOf(array[currentFurnaceIndex][10]));
        izmSeraPGTextField.setText(String.valueOf(array[currentFurnaceIndex][11]));
        izmSeraKoksTextField.setText(String.valueOf(array[currentFurnaceIndex][12]));
        izmSeraPrTextField.setText(String.valueOf(array[currentFurnaceIndex][13]));

        rezervTextField.setText(String.valueOf(array[8][0]));
        zapasTextField.setText(String.valueOf(array[8][1]));
        trebChugTextField.setText(String.valueOf(array[8][2]));

        furnaceLabel.setText("Печь "+furnaceNumber);
    }
}
