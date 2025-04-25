package org.systemdesign.assignment.personal.week8.factory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactoryButtonProduct extends JFrame implements MouseListener {
    private JLabel label;

    public void frame() {
        JFrame frame = new JFrame("Frame for factory button product");
        JButton button1 = new JButton("Move the mouse over here !");
        button1.setBounds(90, 130, 300, 30);
        JButton button2 = new JButton("Click here  !");
        button2.setBounds(90, 200, 300, 30);


        frame.add(button1);
        frame.add(button2);

        button2.addActionListener(e -> {
            button2.setContentAreaFilled(false);
            button2.setOpaque(true);
            button2.setBackground(Color.RED);
            button2.setForeground(Color.RED);
        });


        frame.setSize(500, 350);
        pack();
        setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public FactoryButtonProduct() {
        frame();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked!");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released!");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered!");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited!");
    }

    public static void main(String[] args) {
        new FactoryButtonProduct();
    }
}
