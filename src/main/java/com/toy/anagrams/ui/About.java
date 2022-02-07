package com.toy.anagrams.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * JDialog window with about game info.
 */
public class About extends JDialog {
    /**
     * Constructor of JDialog instance.
     *
     * @param parent parent JFrame
     */
    public About(final JFrame parent) {
        super(parent, true);
        initComponents();
        pack();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        javax.swing.JTextArea copyrightTextArea = new javax.swing.JTextArea();
        javax.swing.JButton closeButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Anagrams");
        mainPanel.setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(11, 11, 12, 12)));
        copyrightTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        copyrightTextArea.setColumns(25);
        copyrightTextArea.setEditable(false);
        copyrightTextArea.setLineWrap(true);
        copyrightTextArea.setRows(8);
        copyrightTextArea.setText("Anagrams\n\nCopyright (c) 2003  Irritable Enterprises, Inc.");
        copyrightTextArea.setWrapStyleWord(true);
        copyrightTextArea.setBorder(null);
        copyrightTextArea.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 24, 0);
        mainPanel.add(copyrightTextArea, gridBagConstraints);

        closeButton.setMnemonic('C');
        closeButton.setText("Close");
        closeButton.addActionListener(this::closeButtonActionPerformed);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        mainPanel.add(closeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);

    }

    private void closeButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    /**
     * GCD calculation - для розрахунку метрик Холстеда.
     *
     * @param g0 first number
     * @param g1 second nuber
     * @return great-common delimiter
     */
    @SuppressWarnings("CheckStyle")
    int getGCD(int g0, int g1) {
        while (g1 != 0) {
            int g2 = g0 % g1;
            g0 = g1;
            g1 = g2;
        }
        return g0;
    }

}
