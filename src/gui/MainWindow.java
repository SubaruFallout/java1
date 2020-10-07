package gui;

import backpacks.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;


public class MainWindow extends JFrame {
    private Backpack backpack = new Backpack(100000);
    private JLabel backpackInfo = new JLabel(backpack.toString());
    private JButton addShapeButton = new JButton("Add shape");
    private JButton deleteShapeButton = new JButton("Delete selected shape");
    private DefaultListModel<String> shapesData = new DefaultListModel<>();
    private JList<String> listOfData = new JList<>(shapesData);

    public MainWindow() {
        this.setTitle("Backpack");
        this.setBounds(100, 100, 760, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        // add Label (backpack info)
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 25, 0, 0);
        add(backpackInfo, constraints);

        // add ComboList (main data)
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 25, 25, 20);
        container.add(new JScrollPane(listOfData), constraints);

        // add Button (Add shape)
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.SOUTH;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 20, 20);
        container.add(addShapeButton, constraints);

        // add Button (Delete shape)
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 20, 20);
        container.add(deleteShapeButton, constraints);

        addShapeButton.setPreferredSize(new Dimension(250, 50));
        addShapeButton.addActionListener(new AddShape());

        deleteShapeButton.setPreferredSize(new Dimension(250, 50));
        deleteShapeButton.addActionListener(new DeleteShape());
    }

    class AddShape implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AddShapeDialogWindow dialogWindow = new AddShapeDialogWindow(backpack, getGui());
            dialogWindow.setVisible(true);
        }
    }

    class DeleteShape implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (listOfData.getSelectedIndex() == -1) {
                return;
            }
            backpack.removeByIndex(listOfData.getSelectedIndex());
            shapesData.remove(listOfData.getSelectedIndex());
            refreshWindow();
        }

    }

    public void refreshWindow() {
        backpackInfo.setText(backpack.toString());
        List<String> shapesInfo = backpack.getShapesInfo();
        shapesData.removeAllElements();
        for (String shapeInfo : shapesInfo) {
            shapesData.addElement(shapeInfo);
        }
    }

    public MainWindow getGui() {
        return this;
    }
}
