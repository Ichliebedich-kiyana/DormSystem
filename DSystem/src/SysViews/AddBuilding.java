/*
 * Created by JFormDesigner on Tue May 28 21:57:29 CST 2024
 */

package SysViews;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import cn.login.DatabaseConnection;
/**
 * @author 86191
 */
public class AddBuilding extends JFrame {
    public AddBuilding() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8f93\u5165\u65b0\u589e\u5bbf\u820d\u533a");
        contentPane.add(label1);
        label1.setBounds(55, 50, 100, 30);

        //---- label2 ----
        label2.setText("\u8f93\u5165\u5bbf\u820d\u53f7");
        contentPane.add(label2);
        label2.setBounds(70, 105, 80, 30);
        contentPane.add(textField1);
        textField1.setBounds(185, 55, 90, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(185, 115, 85, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 180), button1.getPreferredSize()));
        button1.addActionListener(e -> addButtonActionPerformed());
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void addButtonActionPerformed(){
        try{
            String area = textField1.getText();
            String dormid = textField2.getText();
            Connection connection =DatabaseConnection.getConnection();
            String query = "INSERT INTO building(area,dormid) VALUES(?,?)";
            PreparedStatement statement =connection.prepareStatement(query);
            statement.setString(1,area);
            statement.setString(2,dormid);
            int row=statement.executeUpdate();
            if(row>0){
                JOptionPane.showMessageDialog(this,"添加成功");
            }else{
                JOptionPane.showMessageDialog(this,"添加失败");
            }
            statement.close();
            connection.close();
        }catch(SQLException ex){
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,"数据库操作失败"+ex.getMessage());
        }


    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
