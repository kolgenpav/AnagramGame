package com.toy.anagrams.ui;

import com.toy.anagrams.lib.AbstractWordLibrary;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Anagrams extends JFrame {

    public static void main(final String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Anagrams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anagrams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anagrams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anagrams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Anagrams().setVisible(true);
            }
        });
    }

    private int wordIdx = 0;
    private AbstractWordLibrary wordLibrary;

    public Anagrams(AbstractWordLibrary wordLibrary, JLabel feedbackLabel,
                    JButton nextTrial, JTextField guessedWord) {
        this.wordLibrary = wordLibrary;
        this.feedbackLabel = feedbackLabel;
        this.nextTrial = nextTrial;
        this.guessedWord = guessedWord;
    }

    public Anagrams(AbstractWordLibrary wordLibrary, JLabel feedbackLabel,
                    JTextField guessedWord) {
        this.wordLibrary = wordLibrary;
        this.feedbackLabel = feedbackLabel;
        this.guessedWord = guessedWord;
    }

    public Anagrams() {
        wordLibrary = AbstractWordLibrary.getDefault();

        initComponents();
        getRootPane().setDefaultButton(guessButton);
        scrambledWord.setText(wordLibrary.getScrambledWord(wordIdx));
        pack();
        guessedWord.requestFocusInWindow();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.width) / 2));
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        scrambledLabel = new javax.swing.JLabel();
        scrambledWord = new javax.swing.JTextField();
        guessLabel = new javax.swing.JLabel();
        guessedWord = new javax.swing.JTextField();
        feedbackLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        guessButton = new javax.swing.JButton();
        nextTrial = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setTitle("Anagrams");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(12, 12, 12, 12)));
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        scrambledLabel.setText("Scrambled Word:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 6);
        mainPanel.add(scrambledLabel, gridBagConstraints);

        scrambledWord.setColumns(20);
        scrambledWord.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        mainPanel.add(scrambledWord, gridBagConstraints);

        guessLabel.setDisplayedMnemonic('Y');
        guessLabel.setLabelFor(guessedWord);
        guessLabel.setText("Your Guess:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 6);
        mainPanel.add(guessLabel, gridBagConstraints);

        guessedWord.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(guessedWord, gridBagConstraints);

        feedbackLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(feedbackLabel, gridBagConstraints);

        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        guessButton.setMnemonic('G');
        guessButton.setText("Guess");
        guessButton.setToolTipText("Guess the scrambled word.");
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessedWordActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        buttonsPanel.add(guessButton, gridBagConstraints);

        nextTrial.setMnemonic('N');
        nextTrial.setText("New Word");
        nextTrial.setToolTipText("Fetch a new word.");
        nextTrial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTrialActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        buttonsPanel.add(nextTrial, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(buttonsPanel, gridBagConstraints);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");
        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.setToolTipText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(aboutMenuItem);

        exitMenuItem.setMnemonic('E');
        exitMenuItem.setText("Exit");
        exitMenuItem.setToolTipText("Quit Team, Quit!");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitMenuItem);

        mainMenu.add(fileMenu);

        setJMenuBar(mainMenu);

    }

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new About(this).setVisible(true);
    }

    private void nextTrialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTrialActionPerformed
        wordIdx = (wordIdx + 1) % wordLibrary.getSize();

        feedbackLabel.setText(" ");
        scrambledWord.setText(wordLibrary.getScrambledWord(wordIdx));
        guessedWord.setText("");
        getRootPane().setDefaultButton(guessButton);

        guessedWord.requestFocusInWindow();
    }

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }

    private void guessedWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessedWordActionPerformed
        String guessedWordText = guessedWord.getText();
        boolean isCorrect = check(wordIdx, guessedWordText);
        guessedWord.requestFocusInWindow();
    }

    public boolean check(int wordIdx, String guessedWordText) {
        if (wordLibrary.isCorrect(wordIdx, guessedWordText)) {
            feedbackLabel.setText("Correct! Try a new word!");
            getRootPane().setDefaultButton(nextTrial);
            return true;
        } else {
            feedbackLabel.setText("Incorrect! Try again!");
            guessedWord.setText("");
            return false;
        }
    }

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton guessButton;
    private javax.swing.JLabel guessLabel;
    private javax.swing.JTextField guessedWord;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton nextTrial;
    private javax.swing.JLabel scrambledLabel;
    private javax.swing.JTextField scrambledWord;
}
