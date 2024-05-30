/*
 * Created by JFormDesigner on Tue May 28 17:40:50 CST 2024
 */

package RepairViews;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import  cn.login.DatabaseConnection;
/**
 * @author 86191
 */
public class RepairComplete extends JFrame {
    public RepairComplete() {
        initComponents();
    }
    private void delete(){
        String area = textField1.getText();
        String dormid = textField2.getText();
        try{
            Connection connection = DatabaseConnection.getConnection();
            String query = "DELETE FROM needre WHERE area = ? AND dormid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, area);
            statement.setString(2, dormid);
            int row = statement.executeUpdate();
            if(row > 0) {
                JOptionPane.showMessageDialog(this, "已完成");
            } else {
                JOptionPane.showMessageDialog(this, "没有该记录");
            }
            statement.close();
            connection.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "连接失败" + ex.getMessage());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u533a\u57df");
        contentPane.add(label1);
        label1.setBounds(70, 40, 55, 30);
        contentPane.add(textField1);
        textField1.setBounds(140, 40, 95, 35);

        //---- button1 ----
        button1.setText("\u5b8c\u6210");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(90, 145), button1.getPreferredSize()));
        button1.addActionListener(e -> delete());
        //---- label2 ----
        label2.setText("\u5bbf\u820d\u53f7");
        contentPane.add(label2);
        label2.setBounds(55, 90, 60, label2.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(140, 90, 95, textField2.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
