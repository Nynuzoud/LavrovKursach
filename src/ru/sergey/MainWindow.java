package ru.sergey;

import ru.sergey.common.Preferences;
import ru.sergey.data.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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
    private JButton russianLang;
    private JButton englishLang;
    private JMenu tabMenu;
    private JMenuItem diagramItem;
    private JMenuItem reportItem;
    private ResourceBundle locale;
    private Locale enLocale;
    private Locale ruLocale;
    private JTextField[] jTextFields;
    private int[] result = null;

    //init classes
    private DefaultData defaultData = new DefaultData();
    private SaveData saveData = new SaveData();
    private ExcelData excelData = new ExcelData();

    //init loading dialog
    ImageIcon loading = new ImageIcon(getClass().getResource(Preferences.getPreferences.LOADING_IMG_DESTINATION));
    JDialog loadingDilog = new JDialog();

    //current furnace
    private static int currentFurnace;

    public void MainForm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        localization();

        windowListener();

        calculateActionListener();

        buildMenu();

        buildWindow();

        initTextFields();

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

        initLoadingDialog();

        onTextChangedListener();
    }

    private void initTextFields() {
        jTextFields = new JTextField[17];
        jTextFields[0] = vBazovomPeriodeTextField;
        jTextFields[1] = minTextField;
        jTextFields[2] = maxTextField;
        jTextFields[3] = rashodKoksaTextField;
        jTextFields[4] = ekvZameniTextField;
        jTextFields[5] = proizvChugTextField;
        jTextFields[6] = seraVChuguneTextField;
        jTextFields[7] = minSeraTextField;
        jTextFields[8] = maxSeraTextField;
        jTextFields[9] = izmPrChugPGTextField;
        jTextFields[10] = izmPrChugKoksTextField;
        jTextFields[11] = izmSeraPGTextField;
        jTextFields[12] = izmSeraKoksTextField;
        jTextFields[13] = izmSeraPrTextField;

        jTextFields[14] = rezervTextField;
        jTextFields[15] = zapasTextField;
        jTextFields[16] = trebChugTextField;
    }

    private void localization() {
        ruLocale = new Locale("ru", "RU");
        enLocale = new Locale("en", "GB");
        locale = ResourceBundle.getBundle("locales", ruLocale);

        try {
            Image ruImage = ImageIO.read(getClass().getResource(Preferences.getPreferences.RUSSIAN_FLAG_DESTINATION));
            Image enImage = ImageIO.read(getClass().getResource(Preferences.getPreferences.ENGLISH_FLAG_DESTINATION));
            russianLang.setIcon(new ImageIcon(ruImage));
            englishLang.setIcon(new ImageIcon(enImage));
            englishLang.addActionListener(e -> {
                locale = ResourceBundle.getBundle("locales", enLocale);
                translateFormObjects();
                buildMenu();
                buildWindow();
            });
            russianLang.addActionListener(e -> {
                locale = ResourceBundle.getBundle("locales", ruLocale);
                translateFormObjects();
                buildMenu();
                buildWindow();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void translateFormObjects() {
        pokazateliLabel.setText(locale.getString("pokazateliLabel"));
        rezervLabel.setText(locale.getString("rezervLabel"));
        zapasLabel.setText(locale.getString("zapasLabel"));
        trebChugLabel.setText(locale.getString("trebChugLabel"));
        rashodGazaLabel.setText(locale.getString("rashodGazaLabel"));
        vBazovomPeriodLabel.setText(locale.getString("vBazovomPeriodLabel"));
        minLabel.setText(locale.getString("minLabel"));
        maxLabel.setText(locale.getString("maxLabel"));
        seraLabel.setText(locale.getString("seraLabel"));
        seraVChuguneLabel.setText(locale.getString("seraVChuguneLabel"));
        MinSeraLabel.setText(locale.getString("MinSeraLabel"));
        maxSeraLabel.setText(locale.getString("maxSeraLabel"));
        koefLabel.setText(locale.getString("koefLabel"));
        izmPrChugPGLabel.setText(locale.getString("izmPrChugPGLabel"));
        izmPrChugKoksLabel.setText(locale.getString("izmPrChugKoksLabel"));
        izmSeraPGLabel.setText(locale.getString("izmSeraPGLabel"));
        izmSeraKoksLabel.setText(locale.getString("izmSeraKoksLabel"));
        izmSeraPrLabel.setText(locale.getString("izmSeraPrLabel"));
        otherLabel.setText(locale.getString("otherLabel"));
        proizvChugLabel.setText(locale.getString("proizvChugLabel"));
        rashodKoksaLabel.setText(locale.getString("rashodKoksaLabel"));
        ekvZameniLabel.setText(locale.getString("ekvZameniLabel"));
        furnaceLabel.setText(locale.getString("furnaceLabel"));
        furnaceRadioButton1.setText(locale.getString("furnaceRadioButton1"));
        furnaceRadioButton2.setText(locale.getString("furnaceRadioButton2"));
        furnaceRadioButton3.setText(locale.getString("furnaceRadioButton3"));
        furnaceRadioButton4.setText(locale.getString("furnaceRadioButton4"));
        furnaceRadioButton5.setText(locale.getString("furnaceRadioButton5"));
        furnaceRadioButton6.setText(locale.getString("furnaceRadioButton6"));
        furnaceRadioButton7.setText(locale.getString("furnaceRadioButton7"));
        furnaceRadioButton8.setText(locale.getString("furnaceRadioButton8"));
        calculate.setText(locale.getString("calculate"));
    }

    private void initLoadingDialog() {
        loadingDilog.add(new JLabel("loading...", loading, JLabel.CENTER));
        loadingDilog.setSize(400, 300);
        loadingDilog.setLocation((getWidth() - loadingDilog.getWidth()) / 2, (getHeight() - loadingDilog.getHeight()) / 2);
        loadingDilog.setUndecorated(true);
        loadingDilog.setVisible(false);
    }

    private void windowListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                savePreviousFurnaceData(currentFurnace);
                saveData.saveItemAction();
            }
        });
    }

    private void calculateActionListener() {
        calculate.addActionListener(e -> {
            loadingDilog.setVisible(true);
            Thread loadingThread = new Thread(() -> {
                savePreviousFurnaceData(currentFurnace);
                excelData.sendData();
                result = excelData.getData();
                if (result != null) {
                    setResult(result);
                    JOptionPane.showMessageDialog(MainPanel, locale.getString("solutionFound"));
                    if (diagramItem != null) {
                        diagramItem.setEnabled(true);
                    }
                    if (reportItem != null) {
                        reportItem.setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(MainPanel, locale.getString("noSolutions"));
                }
                loadingDilog.setVisible(false);
            });
            loadingThread.start();
        });
    }

    private void buildWindow() {
        setSize(1400, 600);
        add(MainPanel);
        setVisible(true);
    }

    private void setResult(int[] result) {
        resultLabel1.setText(String.valueOf(result[0]));
        resultLabel2.setText(String.valueOf(result[1]));
        resultLabel3.setText(String.valueOf(result[2]));
        resultLabel4.setText(String.valueOf(result[3]));
        resultLabel5.setText(String.valueOf(result[4]));
        resultLabel6.setText(String.valueOf(result[5]));
        resultLabel7.setText(String.valueOf(result[6]));
        resultLabel8.setText(String.valueOf(result[7]));
        resultsLabelVisibility(true);
    }

    private void resultsLabelVisibility(Boolean visibility) {
        resultsLabel.setVisible(visibility);
        resultFurnLabel1.setVisible(visibility);
        resultFurnLabel2.setVisible(visibility);
        resultFurnLabel3.setVisible(visibility);
        resultFurnLabel4.setVisible(visibility);
        resultFurnLabel5.setVisible(visibility);
        resultFurnLabel6.setVisible(visibility);
        resultFurnLabel7.setVisible(visibility);
        resultFurnLabel8.setVisible(visibility);
        resultLabel1.setVisible(visibility);
        resultLabel2.setVisible(visibility);
        resultLabel3.setVisible(visibility);
        resultLabel4.setVisible(visibility);
        resultLabel5.setVisible(visibility);
        resultLabel6.setVisible(visibility);
        resultLabel7.setVisible(visibility);
        resultLabel8.setVisible(visibility);
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
        JMenuBar menuBar = new JMenuBar();

        buildFileMenu(menuBar);
        buildServicesMenu(menuBar);
    }

    private void buildServicesMenu(JMenuBar menuBar) {
        tabMenu = new JMenu(locale.getString("services"));
        diagramItem = new JMenuItem(locale.getString("diagram"));
        reportItem = new JMenuItem(locale.getString("report"));
        tabMenu.add(diagramItem);
        tabMenu.add(reportItem);

        // add menus to menubar
        menuBar.add(tabMenu);

        // put the menubar on the frame
        setJMenuBar(menuBar);

        if (result == null) {
            diagramItem.setEnabled(false);
            reportItem.setEnabled(false);
        }

        diagramItem.addActionListener(e -> {
            loadingDilog.setVisible(true);
            Thread loadingThread = new Thread(() -> {
                Diagram diagram = new Diagram(locale);
                diagram.build();
                loadingDilog.setVisible(false);
            });
            loadingThread.start();
        });

        reportItem.addActionListener(e -> settingsDialog());

    }

    private void settingsDialog() {

        JPanel setupReport = new JPanel();
        setupReport.setLayout(new GridLayout(24, 2));

        JLabel furnLabel = new JLabel(locale.getString("furnaces"));
        furnLabel.getFont().deriveFont(22.0f);
        setupReport.add(furnLabel);

        JCheckBox allFurnCheckBox = new JCheckBox(locale.getString("checkFurnaces"), true);
        setupReport.add(allFurnCheckBox);

        List<JCheckBox> furnCheckBoxList = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            JCheckBox checkBox = new JCheckBox(locale.getString("furnaceLabel") + " " + i, true);
            checkBox.setFont(Font.getFont(Font.SANS_SERIF));
            setupReport.add(checkBox);
            furnCheckBoxList.add(checkBox);
        }

        makeSpace(setupReport, 0);

        String[] settingsTech = {locale.getString("reportRashodPGBase"),
                locale.getString("reportMinPG"),
                locale.getString("reportMaxPG"),
                locale.getString("reportRashodKoksBase"),
                locale.getString("reportEkvZamKoksBase"),
                locale.getString("reportProizvChugBase"),
                locale.getString("reportSodSiBase"),
                locale.getString("reportMinSi"),
                locale.getString("reportMaxSi")};

        String[] settingsKoef = {locale.getString("reportIzmPrChugPG"),
                locale.getString("reportIzmProizvChugRashodKoks"),
                locale.getString("reportIzmSiPG"),
                locale.getString("reportIzmSiKoks"),
                locale.getString("reportIzmSiProizv")};

        String[] settingsPokaz = {locale.getString("reportRezervPG"),
                locale.getString("reportZapasKoks"),
                locale.getString("reportTrebProizvChug")};

        JLabel techLabel = new JLabel(locale.getString("techsParams"));
        furnLabel.getFont().deriveFont(22.0f);
        setupReport.add(techLabel);

        JCheckBox allTechCheckBox = new JCheckBox(locale.getString("checkTechParams"), true);
        setupReport.add(allTechCheckBox);

        List<JCheckBox> techCheckBoxList = new ArrayList<>();
        for (String name : settingsTech) {
            JCheckBox checkBox = new JCheckBox(name, true);
            checkBox.setFont(Font.getFont(Font.SANS_SERIF));
            setupReport.add(checkBox);
            techCheckBoxList.add(checkBox);
        }

        makeSpace(setupReport, settingsTech.length);

        JLabel koefLabel = new JLabel(locale.getString("koefLabel"));
        furnLabel.getFont().deriveFont(22.0f);
        setupReport.add(koefLabel);

        JCheckBox allKoefCheckBox = new JCheckBox(locale.getString("checkKoefs"), true);
        setupReport.add(allKoefCheckBox);

        List<JCheckBox> koefCheckBoxList = new ArrayList<>();
        for (String name : settingsKoef) {
            JCheckBox checkBox = new JCheckBox(name, true);
            checkBox.setFont(Font.getFont(Font.SANS_SERIF));
            setupReport.add(checkBox);
            koefCheckBoxList.add(checkBox);
        }

        makeSpace(setupReport, settingsKoef.length);

        JLabel pokazLabel = new JLabel(locale.getString("pokazateliLabel"));
        furnLabel.getFont().deriveFont(22.0f);
        setupReport.add(pokazLabel);

        JCheckBox allPokazCheckBox = new JCheckBox(locale.getString("checkPokazateli"), true);
        setupReport.add(allPokazCheckBox);

        List<JCheckBox> pokazCheckBoxList = new ArrayList<>();
        for (String name : settingsPokaz) {
            JCheckBox checkBox = new JCheckBox(name, true);
            checkBox.setFont(Font.getFont(Font.SANS_SERIF));
            setupReport.add(checkBox);
            pokazCheckBoxList.add(checkBox);
        }

        allFurnCheckBox.addActionListener(e -> {
            Boolean isCheckBoxSelected = false;
            if (allFurnCheckBox.isSelected()) {
                isCheckBoxSelected = true;
            }
            for (int i = 0; i < furnCheckBoxList.size(); i++) {
                JCheckBox checkBox = furnCheckBoxList.get(i);
                checkBox.setSelected(isCheckBoxSelected);
                furnCheckBoxList.set(i, checkBox);
            }
        });

        allTechCheckBox.addActionListener(e -> {
            Boolean isCheckBoxSelected = false;
            if (allTechCheckBox.isSelected()) {
                isCheckBoxSelected = true;
            }
            for (int i = 0; i < techCheckBoxList.size(); i++) {
                JCheckBox checkBox = techCheckBoxList.get(i);
                checkBox.setSelected(isCheckBoxSelected);
                techCheckBoxList.set(i, checkBox);
            }
        });

        allKoefCheckBox.addActionListener(e -> {
            Boolean isCheckBoxSelected = false;
            if (allKoefCheckBox.isSelected()) {
                isCheckBoxSelected = true;
            }
            for (int i = 0; i < koefCheckBoxList.size(); i++) {
                JCheckBox checkBox = koefCheckBoxList.get(i);
                checkBox.setSelected(isCheckBoxSelected);
                koefCheckBoxList.set(i, checkBox);
            }
        });

        allPokazCheckBox.addActionListener(e -> {
            Boolean isCheckBoxSelected = false;
            if (allPokazCheckBox.isSelected()) {
                isCheckBoxSelected = true;
            }
            for (int i = 0; i < pokazCheckBoxList.size(); i++) {
                JCheckBox checkBox = pokazCheckBoxList.get(i);
                checkBox.setSelected(isCheckBoxSelected);
                pokazCheckBoxList.set(i, checkBox);
            }
        });

        int option = JOptionPane.showConfirmDialog(new JFrame(), setupReport,
                locale.getString("checkFields"), JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            loadingDilog.setVisible(true);
            Thread loadingThread = new Thread(() -> {

                Boolean[] isSelectedCheckBoxes = new Boolean[furnCheckBoxList.size() + techCheckBoxList.size() +
                        koefCheckBoxList.size() + pokazCheckBoxList.size()];
                int index = 0;
                for (JCheckBox checkBox : furnCheckBoxList) {
                    isSelectedCheckBoxes[index] = checkBox.isSelected();
                    index++;
                }

                for (JCheckBox checkBox : techCheckBoxList) {
                    isSelectedCheckBoxes[index] = checkBox.isSelected();
                    index++;
                }

                for (JCheckBox checkBox : koefCheckBoxList) {
                    isSelectedCheckBoxes[index] = checkBox.isSelected();
                    index++;
                }

                for (JCheckBox checkBox : pokazCheckBoxList) {
                    isSelectedCheckBoxes[index] = checkBox.isSelected();
                    index++;
                }

                Report report = new Report(locale);
                report.build(isSelectedCheckBoxes);
                loadingDilog.setVisible(false);
            });
            loadingThread.start();
        } else {
            setupReport.setVisible(false);
        }
    }

    private void makeSpace(JPanel setupReport, int length) {
        if (length % 2 != 0) {
            setupReport.add(new JLabel("\u00a0"));
        }

        setupReport.add(new JLabel("\u00a0"));
        setupReport.add(new JLabel("\u00a0"));
    }

    private void buildFileMenu(JMenuBar menuBar) {
        //build the File menu
        tabMenu = new JMenu(locale.getString("file"));
        JMenuItem openItem = new JMenuItem(locale.getString("open"));
        JMenuItem saveItem = new JMenuItem(locale.getString("save_file"));
        JMenuItem closeItem = new JMenuItem(locale.getString("close"));
        JMenuItem helpItem = new JMenuItem(locale.getString("help"));
        JMenuItem aboutItem = new JMenuItem(locale.getString("about"));
        tabMenu.add(openItem);
        tabMenu.add(saveItem);
        tabMenu.add(closeItem);
        tabMenu.add(helpItem);
        tabMenu.add(aboutItem);

        // add menus to menubar
        menuBar.add(tabMenu);

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

        helpItem.addActionListener(e -> {
            try {
                Desktop.getDesktop().open(new File(Preferences.getPreferences.HELP_DESTINATION));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(MainPanel, locale.getString("aboutText")));
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

        int j = 0;
        for (int i = 0; i < jTextFields.length; i++) {
            if (i < 14) {
                array[currentFurnaceIndex][i] = Double.valueOf(jTextFields[i].getText());
            } else {
                array[8][j] = Double.valueOf(jTextFields[i].getText());
                j++;
            }
        }

        DefaultData.setDefaultArray(array);
    }

    private void setDefaultDataToFurnaces(int furnaceNumber) {
        int currentFurnaceIndex = furnaceNumber - 1;

        double[][] array = DefaultData.getDefaultArray();

        int j = 0;
        for (int i = 0; i < jTextFields.length; i++) {
            if (i < 14) {
                jTextFields[i].setText(String.valueOf(array[currentFurnaceIndex][i]));
            } else {
                jTextFields[i].setText(String.valueOf(array[8][j]));
                j++;
            }
        }

        furnaceLabel.setText(locale.getString("furnaceLabel") + " " + furnaceNumber);
    }

    private void onTextChangedListener() {
        for (JTextField jTextField : jTextFields) {
            jTextField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    checkField(jTextField);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    checkField(jTextField);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    checkField(jTextField);
                }
            });
        }
    }

    private void checkField(JTextField jTextField) {
        resultsLabelVisibility(false);
        diagramItem.setEnabled(false);
        reportItem.setEnabled(false);
        double doubleValue = 0;
        int intValue = 0;
        Boolean isDoubleOK = false;
        try {
            doubleValue = Double.valueOf(jTextField.getText());
            jTextField.setBackground(new Color(255, 255, 255));
            isDoubleOK = true;
        } catch (Exception e1) {
            jTextField.setBackground(new Color(206, 23, 0));
        }
        if (!isDoubleOK) {
            try {
                intValue = Integer.valueOf(jTextField.getText());
                jTextField.setBackground(new Color(255, 255, 255));
            } catch (Exception e1) {
                jTextField.setBackground(new Color(206, 23, 0));
            }
        }
        System.out.println(intValue != 0 ? intValue : doubleValue);
    }
}
