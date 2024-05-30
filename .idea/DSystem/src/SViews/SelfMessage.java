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

    private void displayUserInfo() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT id, name, age ,dormid,area FROM student limit 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("<html>编号\t姓名\t年龄\t宿舍号\t宿舍所在区域<br>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String dormid=resultSet.getString("dormid");
                String area =resultSet.getString("area");
                sb.append(id).append("\t");
                sb.append(name).append("\t");
                sb.append(age).append("\t");
                sb.append(dormid).append("\t");
                sb.append(area).append("<br>");

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
    private JLabel labelInfo;


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
