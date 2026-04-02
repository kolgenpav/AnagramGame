package com.toy.anagrams.ui;

import com.toy.anagrams.lib.AbstractWordLibrary;

import javax.swing.*;

/**
 * Main windows of the game. Entry point of app.
 */
public class Anagrams extends JFrame {
    /**
     * Array index init.
     */
    private int wordIdx = 0;
    /**
     * Instance of WordLibrary.
     */
    private final transient AbstractWordLibrary wordLibrary;

//    /**
//     * Constructor that initialize WordLibrary and Swing components.
//     *
//     * @param awordLibrary   WordLibrary instance
//     * @param afeedbackLabel JLabel for feedback JTextField
//     * @param anextTrial     next scrambled word JButton
//     * @param aguessedWord   feedback JTextField
//     */
//    public Anagrams(final AbstractWordLibrary awordLibrary, final JLabel afeedbackLabel,
//                    final JButton anextTrial, final JTextField aguessedWord) {
//        this.wordLibrary = awordLibrary;
//        this.feedbackLabel = afeedbackLabel;
//        this.nextTrial = anextTrial;
//        this.guessedWord = aguessedWord;
//    }

    /**
     * Constructor that initialize WordLibrary and Swing components.
     * For testing purpose only.
     *
     * @param wordLibrary   WordLibrary instance
     * @param feedbackLabel JLabel for feedback JTextField
     * @param guessedWord   feedback JTextField
     */
    public Anagrams(final AbstractWordLibrary wordLibrary, final JLabel feedbackLabel,
                    final JTextField guessedWord) {
        this.wordLibrary = wordLibrary;
//        this.feedbackLabel = feedbackLabel;
//        this.guessedWord = guessedWord;
        /* SpotBugs suggestion to avoid possible NPE in the future,
           so we create new JLabel and JTextField instances with the same text as the original ones.
         */
        this.feedbackLabel = new JLabel(feedbackLabel.getText());
        this.guessedWord = new JTextField(guessedWord.getText());
    }

    /**
     * Default constructor.
     */
    public Anagrams() {
        wordLibrary = AbstractWordLibrary.getDefault();

        initComponents();
        getRootPane().setDefaultButton(guessButton);
        scrambledWord.setText(wordLibrary.getScrambledWord(wordIdx));
        pack();
        guessedWord.requestFocusInWindow();
        /* SpotBugs reported a bug in the manual centering code above
         * (it used frameSize.width for both axes), so we rely on
         * setLocationRelativeTo(null) instead to center the window. */
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension frameSize = getSize();
//        setLocation(new Point((screenSize.width - frameSize.width) / 2,
//                (screenSize.height - frameSize.width) / 2));
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        JLabel scrambledLabel = new JLabel();
        scrambledWord = new javax.swing.JTextField();
        JLabel guessLabel = new JLabel();
        guessedWord = new javax.swing.JTextField();
        feedbackLabel = new javax.swing.JLabel();
        javax.swing.JPanel buttonsPanel = new javax.swing.JPanel();
        guessButton = new javax.swing.JButton();
        nextTrial = new javax.swing.JButton();
        MenuBuilder menu = getMenuBuilder();

        setTitle("Anagrams");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(final java.awt.event.WindowEvent evt) {
                exitForm();
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
        guessButton.addActionListener(this::guessedWordActionPerformed);

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
        nextTrial.addActionListener(this::nextTrialActionPerformed);

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
        buildMenu(menu);
    }

    private void buildMenu(MenuBuilder menu) {
        menu.fileMenu().setMnemonic('F');
        menu.fileMenu().setText("File");
        menu.aboutMenuItem().setMnemonic('A');
        menu.aboutMenuItem().setText("About");
        menu.aboutMenuItem().setToolTipText("About");
        menu.aboutMenuItem().addActionListener(this::aboutMenuItemActionPerformed);
        menu.fileMenu().add(menu.aboutMenuItem());
        menu.exitMenuItem().setMnemonic('E');
        menu.exitMenuItem().setText("Exit");
        menu.exitMenuItem().setToolTipText("Quit Team, Quit!");
        menu.exitMenuItem().addActionListener(this::exitMenuItemActionPerformed);
        menu.fileMenu().add(menu.exitMenuItem());
        menu.mainMenu().add(menu.fileMenu());
        setJMenuBar(menu.mainMenu());
    }

    private static MenuBuilder getMenuBuilder() {
        javax.swing.JMenuBar mainMenu = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        return new MenuBuilder(mainMenu, fileMenu);
    }

    private void aboutMenuItemActionPerformed(final java.awt.event.ActionEvent evt) {
        new About(this).setVisible(true);
    }

    private void nextTrialActionPerformed(final java.awt.event.ActionEvent evt) {
        wordIdx = (wordIdx + 1) % wordLibrary.getSize();

        feedbackLabel.setText(" ");
        scrambledWord.setText(wordLibrary.getScrambledWord(wordIdx));
        guessedWord.setText("");
        getRootPane().setDefaultButton(guessButton);

        guessedWord.requestFocusInWindow();
    }

    private void exitMenuItemActionPerformed(final java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void guessedWordActionPerformed(final java.awt.event.ActionEvent evt) {
        String guessedWordText = guessedWord.getText();
        check(wordIdx, guessedWordText);
        guessedWord.requestFocusInWindow();
    }

    /**
     * Check if user give the correct answer.
     *
     * @param awordIdx         array index
     * @param aguessedWordText user answer
     * @return is answer correct
     */
    public boolean check(final int awordIdx, final String aguessedWordText) {
        if (wordLibrary.isCorrect(awordIdx, aguessedWordText)) {
            feedbackLabel.setText("Correct! Try a new word!");
            getRootPane().setDefaultButton(nextTrial);
            return true;
        } else {
            feedbackLabel.setText("Incorrect! Try again!");
            guessedWord.setText("");
            return false;
        }
    }

    private void exitForm() {
        System.exit(0);
    }

    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField guessedWord;
    private javax.swing.JButton nextTrial;
    private javax.swing.JTextField scrambledWord;
}
