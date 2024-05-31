/*
 * Created by JFormDesigner on Tue May 28 17:23:46 CST 2024
 */

package RepairViews;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import cn.login.DatabaseConnection;
/**
 * @author 86191
 */
public class RepairLook extends JFrame {
    public RepairLook() {
        initComponents();
        Look();
    }
    private void Look(){
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM needre JOIN repair ON needre.area = repair.area ";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("<html>需要修理宿舍<br>");

            while (resultSet.next()) {
                String area =resultSet.getString("area");
                String dormid=resultSet.getString("dormid");

                sb.append(area).append("\t");
                sb.append(dormid).append("<br>");

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
