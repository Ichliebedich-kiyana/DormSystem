/*
 * Created by JFormDesigner on Sun May 26 11:15:15 CST 2024
 */

package SysViews;


import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class SMessage extends JFrame {
    private String username;
    private String password;
    private JLabel labelInfo;

    public SMessage(String username, String password) {
        this.username = username;
        this.password = password;
        initComponents();
        displayUserInfo(username, password);
    }

    private void displayUserInfo(String username,String password) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT name, id, age FROM sys WHERE username=? AND password =?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("<html>编号\t姓名\t年龄<br>");

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");

                sb.append(id).append("\t");
                sb.append(name).append("\t");
                sb.append(age).append("<br>");
            }
            sb.append("</html>");

            labelInfo.setText(sb.toString());

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        labelInfo = new JLabel();
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        labelInfo.setVerticalAlignment(SwingConstants.TOP);
        contentPane.add(labelInfo);
        labelInfo.setBounds(30, 30, 340, 200);
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

}
