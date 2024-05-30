
package SViews;

import DormViews.DselfMessage;
import RepairViews.RepairLook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import cn.login.LoginWindow;
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
    private void button2ActionPerformed(ActionEvent e) {

        new RepairQuest().setVisible(true);
    }
    private  void button3ActionPerformed(ActionEvent e){
        dispose();
        new LoginWindow().setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4e2a\u4eba\u4fe1\u606f");
        button1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                button1AncestorAdded(e);
                button1AncestorAdded(e);
                button1AncestorAdded(e);
                button1AncestorAdded(e);
                button1AncestorAdded(e);
                button1AncestorAdded(e);
            }
            @Override
            public void ancestorMoved(AncestorEvent e) {}
            @Override
            public void ancestorRemoved(AncestorEvent e) {}
        });
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(45, 40, 90, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u8bf7\u6c42\u4fee\u7406");

        contentPane.add(button2);
        button2.setBounds(45, 105, 100, button2.getPreferredSize().height);
        button2.addActionListener(e -> button2ActionPerformed(e));
        //---- button3 ----
        button3.setText("\u9000\u51fa\u767b\u9646");
        contentPane.add(button3);
        button3.setBounds(60, 185, 90, button3.getPreferredSize().height);
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
