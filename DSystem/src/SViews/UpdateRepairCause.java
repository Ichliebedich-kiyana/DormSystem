/*
 * Created by JFormDesigner on Fri May 31 13:52:24 CST 2024
 */

package SViews;
import cn.login.DatabaseConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 86191
 */
public class UpdateRepairCause extends JFrame {
    public UpdateRepairCause() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8f93\u5165\u5bbf\u820d\u533a");
        contentPane.add(label1);
        label1.setBounds(30, 35, 75, 25);

        //---- label2 ----
        label2.setText("\u8f93\u5165\u5bbf\u820d\u53f7");
        contentPane.add(label2);
        label2.setBounds(30, 85, 65, 25);

        //---- label3 ----
        label3.setText("\u66f4\u6539\u4fdd\u4fee\u539f\u56e0");
        contentPane.add(label3);
        label3.setBounds(30, 145, 85, 30);
        contentPane.add(textField1);
        textField1.setBounds(145, 35, 80, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(145, 90, 80, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(145, 155, 80, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(70, 215), button1.getPreferredSize()));
        button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            updateButtonActionPerformed(e);

    }});
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void updateButtonActionPerformed(ActionEvent e) {
        String area = textField1.getText();
        String dormid = textField2.getText();
        String cause = textField3.getText();

        try {
            // Validate inputs


            // Get database connection
            Connection connection = DatabaseConnection.getConnection();

            // Prepare SQL update statement
            String query = "UPDATE needre SET cause = ? WHERE area = ? AND dormid =?";

            // Create PreparedStatement object
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters
            statement.setString(1,cause);
            statement.setString(2,area);
            statement.setString(3,dormid);
            // Execute update operation
            int rowsAffected = statement.executeUpdate();

            // Provide user feedback
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "维修原因信息更新成功");
            } else {
                JOptionPane.showMessageDialog(this, "未找到要更新的信息");
            }

            // Close resources
            statement.close();
            connection.close();
        }  catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败: " + ex.getMessage());
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
