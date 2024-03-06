package e2;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import e2.model.CellImpl;
import e2.model.GridConstants;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton, Pair<Integer, Integer>> buttons = new HashMap<>();
    private final Logics logics;

    public GUI() {
        this.logics = new LogicsImpl();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * GridConstants.SIZE.getValue(), 100 * GridConstants.SIZE.getValue());

        JPanel panel = new JPanel(new GridLayout(GridConstants.SIZE.getValue(), GridConstants.SIZE.getValue()));
        this.getContentPane().add(BorderLayout.CENTER, panel);

        ActionListener onClick = (e) -> {
            final JButton bt = (JButton) e.getSource();
            final Pair<Integer, Integer> pos = buttons.get(bt);
            boolean aMineWasFound = this.logics.getGrid().isBomb(new CellImpl(
                    pos.getX(), pos.getY()));
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                bt.setEnabled(false);
                this.logics.getGrid().updateVisitedCellsSet(new CellImpl(pos.getX(), pos.getY()));
                drawBoard();
                handleAutoclicks(pos.getX(), pos.getY());
            }
            boolean isThereVictory = this.logics.isWin();
            if (isThereVictory) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton) e.getSource();
                if (bt.isEnabled()) {
                    final Pair<Integer, Integer> pos = buttons.get(bt);
                    logics.toggleFlag(new CellImpl(pos.getX(), pos.getY()));
                }
                drawBoard();
            }
        };

        for (int i = 0; i < GridConstants.SIZE.getValue(); i++) {
            for (int j = 0; j < GridConstants.SIZE.getValue(); j++) {
                final JButton jb = new JButton("");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb, new Pair<>(i, j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }

    private void quitGame() {
        this.drawBoard();
        for (var entry : this.buttons.entrySet()) {
            var position = entry.getValue();
            var button = entry.getKey();
            if (this.logics.getGrid().isBomb(new CellImpl(position.getX(),
                    position.getY()))) {
                button.setText("*");
            }
            button.setEnabled(false);
        }
    }

    private void drawBoard() {
        for (var entry : this.buttons.entrySet()) {
            var position = entry.getValue();
            var button = entry.getKey();
            if (this.logics.hasFlag(new CellImpl(position.getX(), position.getY()))) {
                button.setText("F");
            } else {
                button.setText("");
            }
            int bombs = this.logics.getGrid().getAdjancentBombsTotal(new CellImpl(position.getX(), position.getY()));
            if (bombs > 0
                    && this.logics.getGrid().isCellAlreadyVisited(new CellImpl(position.getX(), position.getY()))) {
                button.setEnabled(false);
                button.setText(String.valueOf(bombs));
            }

        }
    }

    private void handleAutoclicks(int x, int y) {
        if (this.logics.getGrid().getAdjancentBombsTotal(new CellImpl(x, y)) == 0) {
            this.logics.performAutoClicks(new CellImpl(x, y));
        }
    }
}
