/* 删除学生 */
/*
 * Created by JFormDesigner on Sat May 25 20:06:42 CST 2024
 */

package DormViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 86191
 */
public class DeleteStudent extends JFrame {
    public DeleteStudent() {
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
        label1.setText("\u8f93\u5165\u5b66\u751f\u7684\u5b66\u53f7");
        contentPane.add(label1);
        label1.setBounds(25, 55, 115, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(135, 50, 135, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u5220\u9664");
        contentPane.add(button1);
        button1.setBounds(60, 115, 95, button1.getPreferredSize().height);
        button1.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                // 获得被删除学生的学号
                String studentid = textField1.getText().trim();
                deleteStudent(studentid);
    }});

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void deleteStudent(String studentId) {
        try {
            // 连接数据库
            Connection connection = DatabaseConnection.getConnection();

            // 定义删除语句，跟addStudent中一样，用?作为占位符，暂时顶替被删除学生的学号
            String query = "DELETE FROM student WHERE id = ?";

            // 创建执行SQL对象，防止SQL注入
            PreparedStatement statement = connection.prepareStatement(query);

            // 用被删除学生的学号来替换占位符
            statement.setString(1, studentId);

            // 执行删除操作，返回被删除的行数
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "学生信息删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "未找到要删除的学生信息");
            }

            // 及时释放资源
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
