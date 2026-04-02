package com.toy.anagrams.ui;

import javax.swing.*;

/**
 * MenuBuilder record for menu components.
 *
 * @param mainMenu      Main menu bar
 * @param fileMenu      File menu
 * @param aboutMenuItem About menu item
 * @param exitMenuItem  Exit menu item
 */
public record MenuBuilder(JMenuBar mainMenu, JMenu fileMenu, JMenuItem aboutMenuItem, JMenuItem exitMenuItem) {
    /**
     * Constructor with default menu items.
     *
     * @param mainMenu Main menu bar
     * @param fileMenu File menu
     */
    public MenuBuilder(JMenuBar mainMenu, JMenu fileMenu) {
        this(mainMenu, fileMenu, new JMenuItem(), new JMenuItem());
    }
}
