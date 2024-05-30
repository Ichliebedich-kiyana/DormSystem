/*
 * Created by JFormDesigner on Sun May 26 11:22:43 CST 2024
 */

package SysViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 86191
 */
public class AddDorm extends JFrame {
    public AddDorm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();
        label6 = new JLabel();
        textField6 = new JTextField();

        //======== this ========
        setTitle("\u6dfb\u52a0\u5bbf\u7ba1\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        contentPane.add(label1);
        label1.setBounds(25, 25, 55, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(30, 65, 45, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u7f16\u53f7");
        contentPane.add(label3);
        label3.setBounds(30, 110, 45, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u59d3\u540d");
        contentPane.add(label4);
        label4.setBounds(30, 145, 50, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u5e74\u9f84");
        contentPane.add(label5);
        label5.setBounds(30, 185, 40, label5.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(105, 25, 85, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(105, 70, 85, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(105, 115, 85, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(105, 155, 85, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(105, 195, 95, textField5.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(250, 110, 90, button1.getPreferredSize().height);
        button1.addActionListener(e -> addButtonActionPerformed());
        //---- label6 ----
        label6.setText("\u6240\u7ba1\u7406\u533a\u57df");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(15, 250), label6.getPreferredSize()));
        contentPane.add(textField6);
        textField6.setBounds(110, 245, 85, textField6.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 335));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void addButtonActionPerformed() {
        String username = textField1.getText();
        String password = textField2.getText();
        String id = textField3.getText();
        String name = textField4.getText();
        String age = textField5.getText();
        String area = textField6.getText();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO dorm (username, password, name, id, age,area) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(4, id);
            statement.setString(5, age);
            statement.setString(6,area);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "宿管信息添加成功");
            } else {
                JOptionPane.showMessageDialog(this, "宿管信息添加失败");
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败");
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    private JLabel label6;
    private JTextField textField6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
