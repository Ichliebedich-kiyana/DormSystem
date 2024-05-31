/*
 * Created by JFormDesigner on Tue May 28 14:09:24 CST 2024
 */

package RepairViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class RsMessage extends JFrame {
    private String username;
    private String password;
    private JLabel labelInfo; // 将labelInfo声明为类的成员变量

    public RsMessage(String username, String password) {
        this.username = username;
        this.password = password;
        initComponents(); // 先初始化组件
        displayUserInfo(username, password); // 然后显示用户信息
    }

    private void displayUserInfo(String username, String password) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT id, name, age, area FROM repair WHERE username =? AND password =?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("<html>编号\\t姓名\\t年龄\\t负责区域<br>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String area = resultSet.getString("area");
                sb.append(id).append("\t");
                sb.append(name).append("\t");
                sb.append(age).append("\t");
                sb.append(area).append("<br>");
            }
            sb.append("</html>");

            labelInfo.setText(sb.toString()); // 现在labelInfo已经被初始化，可以安全地设置文本

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        labelInfo = new JLabel(); // 初始化labelInfo
        setLayout(null);
        labelInfo.setVerticalAlignment(SwingConstants.TOP);
        add(labelInfo);
        labelInfo.setBounds(30, 30, 340, 200);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
    }
}
