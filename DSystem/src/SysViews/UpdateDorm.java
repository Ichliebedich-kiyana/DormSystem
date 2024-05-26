/*
 * Created by JFormDesigner on Sun May 26 11:55:51 CST 2024
 */

package SysViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 86191
 */
public class UpdateDorm extends JFrame {
    public UpdateDorm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        button1 = new JButton();
        label8 = new JLabel();
        textField7 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8f93\u5165\u8981\u4fee\u6539\u7684\u5bbf\u7ba1\u7f16\u53f7");
        contentPane.add(label1);
        label1.setBounds(20, 25, 145, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(175, 20, 90, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u8f93\u5165\u8981\u4fee\u6539\u7684\u4fe1\u606f");
        contentPane.add(label2);
        label2.setBounds(85, 70, 140, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u7528\u6237\u540d");
        contentPane.add(label3);
        label3.setBounds(25, 110, 65, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u5bc6\u7801");
        contentPane.add(label4);
        label4.setBounds(25, 150, 45, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u7f16\u53f7");
        contentPane.add(label5);
        label5.setBounds(25, 235, 35, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u59d3\u540d");
        contentPane.add(label6);
        label6.setBounds(25, 190, 50, label6.getPreferredSize().height);

        //---- label7 ----
        label7.setText("\u5e74\u9f84");
        contentPane.add(label7);
        label7.setBounds(25, 280, 45, label7.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(95, 100, 110, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(95, 145, 95, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(90, 190, 90, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(90, 235, 75, textField5.getPreferredSize().height);
        contentPane.add(textField6);
        textField6.setBounds(90, 280, 90, textField6.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 375), button1.getPreferredSize()));
        button1.addActionListener(e -> updateButtonActionPerformed(e));
        //---- label8 ----
        label8.setText("\u6240\u7ba1\u7406\u533a\u57df");
        contentPane.add(label8);
        label8.setBounds(15, 335, 70, label8.getPreferredSize().height);
        contentPane.add(textField7);
        textField7.setBounds(100, 330, 100, textField7.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 460));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void updateButtonActionPerformed(ActionEvent e) {
        String id = textField1.getText();
        String username = textField2.getText();
        String password = textField3.getText();
        String name = textField4.getText();
        String newId = textField5.getText();
        String age = textField6.getText();
        String area = textField7.getText();
        try {
            // Validate inputs
            int parsedNewId = Integer.parseInt(newId);
            int parsedAge = Integer.parseInt(age);

            // Get database connection
            Connection connection = DatabaseConnection.getConnection();

            // Prepare SQL update statement
            String query = "UPDATE dorm SET username = ?, password = ?, id = ?, name = ?, age = ? ,area=? WHERE id = ?";

            // Create PreparedStatement object
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, parsedNewId);
            statement.setString(4, name);
            statement.setInt(5, parsedAge);
            statement.setString(6, area);
            statement.setString(7, id);

            // Execute update operation
            int rowsAffected = statement.executeUpdate();

            // Provide user feedback
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "宿管信息更新成功");
            } else {
                JOptionPane.showMessageDialog(this, "未找到要更新的宿管信息");
            }

            // Close resources
            statement.close();
            connection.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID和年龄必须是数字");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败: " + ex.getMessage());
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton button1;
    private JLabel label8;
    private JTextField textField7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
