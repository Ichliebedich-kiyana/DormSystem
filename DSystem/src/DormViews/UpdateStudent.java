/* 更新学生信息窗口 */
package DormViews;

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
public class UpdateStudent extends JFrame {
    public UpdateStudent() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();

        //======== this ========
        setTitle("\u4fee\u6539\u5b66\u751f\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(this::updateButtonActionPerformed);
        contentPane.add(button1);
        button1.setBounds(100, 290, 95, button1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u8f93\u5165\u4fee\u6539\u8981\u5b66\u751f\u7684\u5b66\u53f7");
        contentPane.add(label3);
        label3.setBounds(10, 20, 145, label3.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(170, 15, 90, textField3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u8f93\u5165\u8981\u4fee\u6539\u7684\u4fe1\u606f");
        contentPane.add(label4);
        label4.setBounds(90, 65, 120, label4.getPreferredSize().height);

        //---- label9 ----
        label9.setText("\u7528\u6237\u540d");
        contentPane.add(label9);
        label9.setBounds(35, 105, 45, label9.getPreferredSize().height);

        //---- label10 ----
        label10.setText("\u5bc6\u7801");
        contentPane.add(label10);
        label10.setBounds(35, 140, 45, label10.getPreferredSize().height);

        //---- label11 ----
        label11.setText("\u5b66\u53f7");
        contentPane.add(label11);
        label11.setBounds(35, 175, 35, label11.getPreferredSize().height);

        //---- label12 ----
        label12.setText("\u59d3\u540d");
        contentPane.add(label12);
        label12.setBounds(35, 210, label12.getPreferredSize().width, label12.getPreferredSize().height);

        //---- label13 ----
        label13.setText("\u5e74\u9f84");
        contentPane.add(label13);
        label13.setBounds(35, 245, label13.getPreferredSize().width, label13.getPreferredSize().height);

        contentPane.add(textField4);
        textField4.setBounds(105, 100, 95, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(105, 135, 90, textField5.getPreferredSize().height);
        contentPane.add(textField6);
        textField6.setBounds(105, 170, 90, textField6.getPreferredSize().height);
        contentPane.add(textField7);
        textField7.setBounds(105, 205, 90, textField7.getPreferredSize().height);
        contentPane.add(textField8);
        textField8.setBounds(105, 240, 90, textField8.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(300, 350));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void updateButtonActionPerformed(ActionEvent e) {
        // 获取更新学生信息
        String id = textField3.getText();
        String username = textField4.getText();
        String password = textField5.getText();
        String newId = textField6.getText();
        String name = textField7.getText();
        String age = textField8.getText();

        try {
            // 验证输入（将String对象转换为int型）
            int parsedNewId = Integer.parseInt(newId);
            int parsedAge = Integer.parseInt(age);

            // 连接数据库
            Connection connection = DatabaseConnection.getConnection();

            // SQL语句
            String query = "UPDATE student SET username = ?, password = ?, id = ?, name = ?, age = ? WHERE id = ?";

            // 处理SQL语句
            PreparedStatement statement = connection.prepareStatement(query);

            // 将信息信息填入占位符中
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, parsedNewId);
            statement.setString(4, name);
            statement.setInt(5, parsedAge);
            statement.setString(6, id); // WHERE中的初始id

            // 执行更新操作,返回更新的行数
            int rowsAffected = statement.executeUpdate();

            // 提供用户反馈
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "学生信息更新成功");
            } else {
                JOptionPane.showMessageDialog(this, "未找到要更新的学生信息");
            }

            // 及时释放资源
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
    private JButton button1;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JLabel label6;
    private JLabel label7;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
