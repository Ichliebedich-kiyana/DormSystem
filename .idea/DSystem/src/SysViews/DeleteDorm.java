/*
 * Created by JFormDesigner on Sun May 26 11:38:49 CST 2024
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
public class DeleteDorm extends JFrame {
    public DeleteDorm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8f93\u5165\u5bbf\u7ba1\u7f16\u53f7");
        contentPane.add(label1);
        label1.setBounds(35, 55, 95, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(140, 50, 90, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u5b9a\u5220\u9664");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 125), button1.getPreferredSize()));
        button1.addActionListener(e -> deleteStudent(textField1.getText()));
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void deleteStudent(String studentId) {
        try {
            // Get database connection
            Connection connection = DatabaseConnection.getConnection();

            // Prepare SQL delete statement
            String query = "DELETE FROM dorm WHERE id = ?";

            // Create PreparedStatement object
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameter
            statement.setString(1, studentId);

            // Execute update (delete) operation
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "宿管信息删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "未找到要删除的宿管信息");
            }

            // Close resources
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败: " + ex.getMessage());
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
