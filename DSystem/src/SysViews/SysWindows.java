package SysViews;

import DormViews.DselfMessage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import cn.login.LoginWindow;
/**
 * @author 86191
 */
public class SysWindows extends JFrame {
    private String username;
    private String password;

    public SysWindows(String username, String password) {
        this.username = username;
        this.password = password;
        initComponents();
    }
    private void button1ActionPerformed(ActionEvent e) {
        // 打开 DselfMessage 窗口
        new SMessage(username, password).setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // 打开 DselfMessage 窗口
        new AddDorm().setVisible(true);
    }

    private  void button3ActionPerformed(ActionEvent e){
        new DeleteDorm().setVisible(true);
    }

    private  void button4ActionPerformed(ActionEvent e){
        new SelectDorm().setVisible(true);
    }

    private void button5ActionPerformed(ActionEvent e){
        new UpdateDorm().setVisible(true);
    }
    private void button6ActionPerformed(ActionEvent e){
        dispose();
        new LoginWindow().setVisible(true);
    }
    private void button7ActionPerformed(ActionEvent e){
        new AddBuilding().setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4e2a\u4eba\u4fe1\u606f");
        contentPane.add(button1);
        button1.setBounds(45, 20, 110, button1.getPreferredSize().height);
        button1.addActionListener(e -> button1ActionPerformed(e));
        //---- button2 ----
        button2.setText("\u65b0\u589e\u5bbf\u7ba1");
        contentPane.add(button2);
        button2.setBounds(45, 70, 105, button2.getPreferredSize().height);
        button2.addActionListener(e -> button2ActionPerformed(e));
        //---- button3 ----
        button3.setText("\u5220\u9664\u5bbf\u7ba1\u4fe1\u606f");
        contentPane.add(button3);
        button3.setBounds(50, 115, 90, button3.getPreferredSize().height);
        button3.addActionListener(e -> button3ActionPerformed(e));
        //---- button4 ----
        button4.setText("\u67e5\u770b\u5bbf\u7ba1\u4fe1\u606f");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(45, 165), button4.getPreferredSize()));
        button4.addActionListener(e -> button4ActionPerformed(e));
        //---- button5 ----
        button5.setText("\u4fee\u6539\u5bbf\u7ba1\u4fe1\u606f");
        contentPane.add(button5);
        button5.setBounds(50, 210, 105, button5.getPreferredSize().height);
        button5.addActionListener(e -> button5ActionPerformed(e));
        //---- button6 ----
        button6.setText("\u9000\u51fa\u767b\u5f55");
        contentPane.add(button6);
        button6.setBounds(new Rectangle(new Point(235, 105), button6.getPreferredSize()));
        button6.addActionListener(e -> button6ActionPerformed(e));
        //---- button7 ----
        button7.setText("\u65b0\u589e\u5bbf\u820d");
        contentPane.add(button7);
        button7.setBounds(55, 260, 100, button7.getPreferredSize().height);
        button7.addActionListener(e -> button7ActionPerformed(e));
        contentPane.setPreferredSize(new Dimension(400, 335));
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
    private JButton button6;
    private JButton button7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
