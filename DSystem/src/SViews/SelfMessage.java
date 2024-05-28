/* 显示查询的学生信息 */
package SViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class SelfMessage extends JFrame {
    public SelfMessage() {
        initComponents();
        displayUserInfo();
    }

    /* 显示信息 */
    private void displayUserInfo() {
        try {
            // 连接数据库
            Connection connection = DatabaseConnection.getConnection();
            // 定义查询SQL
            String query = "SELECT id, name, age FROM student limit 1";
            // 处理SQL语句
            PreparedStatement statement = connection.prepareStatement(query);
            // 存储查询结果
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            // 格式化为HTML字符串
            sb.append("<html>编号\t姓名\t年龄<br>");

            while (resultSet.next()) {
                // 获得查询id
                int id = resultSet.getInt("id");
                // 获得查询姓名
                String name = resultSet.getString("name");
                // 获得查询年龄
                int age = resultSet.getInt("age");

                // 格式化拼接字符串
                sb.append(id).append("\t");
                sb.append(name).append("\t");
                sb.append(age).append("<br>");
            }
            sb.append("</html>");

            labelInfo.setText(sb.toString());

            // 及时释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /* 窗口初始化 */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        labelInfo = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u4fe1\u606f"); // 学生信息
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- labelInfo ----
        labelInfo.setVerticalAlignment(SwingConstants.TOP);
        contentPane.add(labelInfo);
        labelInfo.setBounds(30, 30, 340, 200);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel labelInfo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
