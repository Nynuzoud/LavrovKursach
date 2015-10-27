package ru.sergey;

import ru.sergey.data.DefaultData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem closeItem;

    //init classes
    DefaultData defaultData = new DefaultData();

    //current furnace
    private static int currentFurnace;

    public void MainForm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        setSize(1150, 500);
        add(MainPanel);
        setVisible(true);

        furnaceRadioButton1.setSelected(true);

        RadioButtonListener radioButtonListener = new RadioButtonListener();
        furnaceRadioButton1.addActionListener(radioButtonListener);
        furnaceRadioButton2.addActionListener(radioButtonListener);
        furnaceRadioButton3.addActionListener(radioButtonListener);
        furnaceRadioButton4.addActionListener(radioButtonListener);
        furnaceRadioButton5.addActionListener(radioButtonListener);
        furnaceRadioButton6.addActionListener(radioButtonListener);
        furnaceRadioButton7.addActionListener(radioButtonListener);
        furnaceRadioButton8.addActionListener(radioButtonListener);

        defaultData.createDefaultData();

        setDefaultDataToFurnaces(1);
        currentFurnace = 1;
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
        ArrayList<HashMap<String, Double>> arrayList = DefaultData.getDefaultArrayList();
        HashMap<String, Double> hashMap = new HashMap<>();
        hashMap.put("rashodPGBase"+currentFurnace, Double.valueOf(vBazovomPeriodeTextField.getText()));
        hashMap.put("minRashodPG", Double.valueOf(minTextField.getText()));
        hashMap.put("maxRashodPG", Double.valueOf(maxTextField.getText()));
        hashMap.put("rezervPG", Double.valueOf(rezervTextField.getText()));
        hashMap.put("zapasKoks", Double.valueOf(zapasTextField.getText()));
        hashMap.put("trebProizvChug", Double.valueOf(trebChugTextField.getText()));
        hashMap.put("sodSiChugBase"+currentFurnace, Double.valueOf(seraVChuguneTextField.getText()));
        hashMap.put("minSi", Double.valueOf(minSeraTextField.getText()));
        hashMap.put("maxSi", Double.valueOf(maxSeraTextField.getText()));
        hashMap.put("izmChugPG"+currentFurnace, Double.valueOf(izmPrChugPGTextField.getText()));
        hashMap.put("izmChugKoks"+currentFurnace, Double.valueOf(izmPrChugKoksTextField.getText()));
        hashMap.put("izmSiPG"+currentFurnace, Double.valueOf(izmSeraPGTextField.getText()));
        hashMap.put("izmSiKoks"+currentFurnace, Double.valueOf(izmSeraKoksTextField.getText()));
        hashMap.put("izmSiProizv"+currentFurnace, Double.valueOf(izmSeraPrTextField.getText()));
        hashMap.put("proizvChugBase"+currentFurnace, Double.valueOf(proizvChugTextField.getText()));
        hashMap.put("rashodKoksaBase"+currentFurnace, Double.valueOf(rashodKoksaTextField.getText()));
        hashMap.put("ekvZamKoksaBase"+currentFurnace, Double.valueOf(ekvZameniTextField.getText()));
        arrayList.set(currentFurnaceIndex, hashMap);
        DefaultData.setDefaultArrayList(arrayList);
    }

    private void setDefaultDataToFurnaces(int furnaceNumber) {
        int furnaceNumberIndex = furnaceNumber - 1;
        HashMap<String, Double> furnaceHashMap = DefaultData.getDefaultArrayList().get(furnaceNumberIndex);
        vBazovomPeriodeTextField.setText(String.valueOf(furnaceHashMap.get("rashodPGBase"+furnaceNumber)));
        minTextField.setText(String.valueOf(furnaceHashMap.get("minRashodPG")));
        maxTextField.setText(String.valueOf(furnaceHashMap.get("maxRashodPG")));

        rezervTextField.setText(String.valueOf(furnaceHashMap.get("rezervPG")));
        zapasTextField.setText(String.valueOf(furnaceHashMap.get("zapasKoks")));
        trebChugTextField.setText(String.valueOf(furnaceHashMap.get("trebProizvChug")));

        seraVChuguneTextField.setText(String.valueOf(furnaceHashMap.get("sodSiChugBase"+furnaceNumber)));
        minSeraTextField.setText(String.valueOf(furnaceHashMap.get("minSi")));
        maxSeraTextField.setText(String.valueOf(furnaceHashMap.get("maxSi")));

        izmPrChugPGTextField.setText(String.valueOf(furnaceHashMap.get("izmChugPG"+furnaceNumber)));
        izmPrChugKoksTextField.setText(String.valueOf(furnaceHashMap.get("izmChugKoks"+furnaceNumber)));
        izmSeraPGTextField.setText(String.valueOf(furnaceHashMap.get("izmSiPG"+furnaceNumber)));
        izmSeraKoksTextField.setText(String.valueOf(furnaceHashMap.get("izmSiKoks"+furnaceNumber)));
        izmSeraPrTextField.setText(String.valueOf(furnaceHashMap.get("izmSiProizv"+furnaceNumber)));

        proizvChugTextField.setText(String.valueOf(furnaceHashMap.get("proizvChugBase"+furnaceNumber)));
        rashodKoksaTextField.setText(String.valueOf(furnaceHashMap.get("rashodKoksaBase"+furnaceNumber)));
        ekvZameniTextField.setText(String.valueOf(furnaceHashMap.get("ekvZamKoksaBase"+furnaceNumber)));

        furnaceLabel.setText("Печь "+furnaceNumber);
    }
}
