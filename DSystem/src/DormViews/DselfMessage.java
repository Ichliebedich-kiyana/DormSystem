/* 个人信息窗口 */

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

    /* 从数据库中查询用户信息并在一个对话框中显示 */
    private void displayUserInfo() {
        try {
            // 获取数据库连接
            Connection connection = DatabaseConnection.getConnection();

            // 定义查询语句
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

            // 在对话框中显示信息
            JOptionPane.showMessageDialog(this, sb.toString(), "学生信息", JOptionPane.INFORMATION_MESSAGE);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
