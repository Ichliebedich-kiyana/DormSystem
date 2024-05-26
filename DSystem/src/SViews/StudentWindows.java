/*
 * Created by JFormDesigner on Sat May 25 15:31:37 CST 2024
 */

package SViews;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author 86191
 */
public class StudentWindows extends JFrame {
    private String userName;

    public StudentWindows(String userName) {
        this.userName = userName;
        initComponents();
    }
    public StudentWindows() {
        initComponents();
    }

    private void button1AncestorAdded(AncestorEvent e) {
        // TODO add your code here

    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        new SelfMessage().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4e2a\u4eba\u4fe1\u606f");
        button1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                button1AncestorAdded(e);

            }
            @Override
            public void ancestorMoved(AncestorEvent e) {}
            @Override
            public void ancestorRemoved(AncestorEvent e) {}
        });
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(60, 55, 90, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u8bf7\u6c42\u4fee\u7406");
        contentPane.add(button2);
        button2.setBounds(55, 130, 100, button2.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
