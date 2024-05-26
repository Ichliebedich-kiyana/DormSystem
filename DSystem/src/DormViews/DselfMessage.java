/*
 * Created by JFormDesigner on Sat May 25 17:55:18 CST 2024
 */

package DormViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author 86191
 */
public class DselfMessage extends JFrame {
    public DselfMessage() {
        initComponents();
        displayUserInfo();
    }

    private void displayUserInfo() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM dorm";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("编号\t姓名\t年龄\n");

            while (resultSet.next()) {
                int number = resultSet.getInt("number");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                sb.append(number).append("\t");
                sb.append(name).append("\t");
                sb.append(age).append("\n");
            }

            // Display the information in a dialog
            JOptionPane.showMessageDialog(this, sb.toString(), "学生信息", JOptionPane.INFORMATION_MESSAGE);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
