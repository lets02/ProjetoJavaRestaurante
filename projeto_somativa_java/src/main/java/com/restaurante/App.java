package com.restaurante;

import javax.swing.*;
import com.restaurante.view.MainMenuView;

public class App {
    public static void main(String[] args) {
        // Configurações da aparência do Swing
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Inicializa a tela inicial
        SwingUtilities.invokeLater(() -> {
            new MainMenuView().setVisible(true);
        });
    }
}
