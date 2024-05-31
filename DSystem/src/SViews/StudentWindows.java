
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
    private String username;
    private String password;
    public StudentWindows(String userName,String password) {
        this.username = userName;
        this.password=password;
        initComponents();
    }


    private void button1AncestorAdded(AncestorEvent e) {
        // TODO add your code here

    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        new SelfMessage(username,password).setVisible(true);
    }
    private void button2ActionPerformed(ActionEvent e) {

        new RepairQuest().setVisible(true);
    }
    private  void button3ActionPerformed(ActionEvent e){
        dispose();
        new LoginWindow().setVisible(true);
    }

    private  void button4ActionPerformed(ActionEvent e){
        new UpdateRepairCause().setVisible(true);
    }
    private  void button5ActionPerformne(ActionEvent e){
        new DeleteRepairQuest().setVisible(true);
    }
    private void button2AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

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
        button2.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                button2AncestorAdded(e);
            }
            @Override
            public void ancestorMoved(AncestorEvent e) {}
            @Override
            public void ancestorRemoved(AncestorEvent e) {}
        });
        contentPane.add(button2);
        button2.setBounds(45, 105, 100, button2.getPreferredSize().height);
        button2.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            button2ActionPerformed(e);

    }});
        //---- button3 ----
        button3.setText("\u9000\u51fa\u767b\u9646");
        contentPane.add(button3);
        button3.setBounds(55, 195, 90, button3.getPreferredSize().height);
        button3.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            button3ActionPerformed(e);

    }});
        //---- button4 ----
        button4.setText("\u66f4\u6539\u7ef4\u4fee\u539f\u56e0");
        contentPane.add(button4);
        button4.setBounds(200, 45, 105, button4.getPreferredSize().height);
        button4.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            button4ActionPerformed(e);

    }});
        //---- button5 ----
        button5.setText("\u5220\u9664\u4fdd\u4fee\u7533\u8bf7");
        contentPane.add(button5);
        button5.setBounds(205, 115, 110, button5.getPreferredSize().height);
        button5.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            button5ActionPerformne(e);

    }});
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
