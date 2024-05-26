/*
 * Created by JFormDesigner on Sat May 25 17:55:18 CST 2024
 */

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

    private void displayUserInfo() {
        try {
            Connection connection = DatabaseConnection.getConnection();
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
