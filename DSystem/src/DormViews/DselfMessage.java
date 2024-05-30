/* 个人信息窗口 */

package DormViews;

/*
 * Created by JFormDesigner on Sun May 26 11:15:15 CST 2024
 */


import cn.login.DatabaseConnection;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class DselfMessage extends JFrame {
    public DselfMessage() {
        initComponents();
        displayUserInfo();
    }

    /* 从数据库中查询用户信息并在一个对话框中显示 */
    private void displayUserInfo() {
        try {
            // 获取数据库连接
            Connection connection = DatabaseConnection.getConnection();

            // 定义查询语句
            String query = "SELECT name, id, age ,area FROM dorm limit 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("<html>编号\t姓名\t年龄\t所管理楼栋<br>");

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String area = resultSet.getString("area");
                sb.append(id).append("\t");
                sb.append(name).append("\t");
                sb.append(area).append("\t");
                sb.append(age).append("<br>");
            }
            sb.append("</html>");


            labelInfo.setText(sb.toString());

            // 在对话框中显示信息
            JOptionPane.showMessageDialog(this, sb.toString(), "学生信息", JOptionPane.INFORMATION_MESSAGE);


            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /* 初始化组件 */
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
