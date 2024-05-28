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
<<<<<<< HEAD
            String query = "SELECT name, id, age ,area FROM dorm limit 1";
=======

            // 定义查询语句
            String query = "SELECT * FROM dorm";
>>>>>>> zhong
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

<<<<<<< HEAD
            labelInfo.setText(sb.toString());
=======
            // 在对话框中显示信息
            JOptionPane.showMessageDialog(this, sb.toString(), "学生信息", JOptionPane.INFORMATION_MESSAGE);
>>>>>>> zhong

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
