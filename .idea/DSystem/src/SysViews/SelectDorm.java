/*
 * Created by JFormDesigner on Sun May 26 11:49:14 CST 2024
 */

package SysViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 86191
 */
public class SelectDorm extends JFrame {
    public SelectDorm() {
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
        label1.setBounds(40, 40, 90, 55);
        contentPane.add(textField1);
        textField1.setBounds(140, 55, 95, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u67e5\u627e");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(70, 145), button1.getPreferredSize()));
        button1.addActionListener(e -> displayStudentInfo(textField1.getText()));
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void displayStudentInfo(String dormId) {
        try {
            // 获取数据库连接
            Connection connection =  DatabaseConnection.getConnection();

            // 准备 SQL 查询语句
            String query = "SELECT * FROM dorm WHERE id = ?";

            // 创建 PreparedStatement 对象
            PreparedStatement statement = connection.prepareStatement(query);

            // 设置参数
            statement.setString(1, dormId);

            // 执行查询
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // 如果查询到结果，则获取宿管信息
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String area = resultSet.getString("area");
                // 在弹窗中显示学生信息
                JOptionPane.showMessageDialog(this,
                        "编号" + id + "\n" +
                                "姓名 " + name + "\n" +
                                "年龄 " + age +"\n" +
                                "所管理区域" + area);
            } else {
                // 如果未查询到结果，显示提示信息
                JOptionPane.showMessageDialog(this, "未找到对应宿管信息");
            }

            // 关闭连接和语句
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库查询出错");
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
