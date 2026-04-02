package com.toy.anagrams.ui;

import javax.swing.*;

/**
 * Main class for Anagrams game.
 */
public class Main {
    /**
     * Entry point method.
     *
     * @param args command line args don't used
     */
    public static void main(final String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels =
                    javax.swing.UIManager.getInstalledLookAndFeels();
            for (javax.swing.UIManager.LookAndFeelInfo installedLookAndFeel : installedLookAndFeels) {
                if ("Nimbus".equals(installedLookAndFeel.getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeel.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                 | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anagrams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        SwingUtilities.invokeLater(() -> new Anagrams().setVisible(true));
    }
}
