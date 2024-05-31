/*
 * Created by JFormDesigner on Tue May 28 16:58:07 CST 2024
 */

package SViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 86191
 */
public class RepairQuest extends JFrame {
    public RepairQuest() {
        initComponents();
    }
    private void addButtonActionPerformed(){
        Repair();
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
        label1.setText("\u8f93\u5165\u5bbf\u820d\u533a\u57df");
        contentPane.add(label1);
        label1.setBounds(45, 50, 85, 25);

        //---- label2 ----
        label2.setText("\u8f93\u5165\u5bbf\u820d\u53f7");
        contentPane.add(label2);
        label2.setBounds(40, 105, 65, 25);
        contentPane.add(textField1);
        textField1.setBounds(155, 50, 90, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(155, 110, 90, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(85, 180), button1.getPreferredSize()));
        button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            addButtonActionPerformed();

    }});
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private  void Repair(){
        String area = textField1.getText();
        String dormid = textField2.getText();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO needre (area,dormid) VALUES (?, ?)";
            PreparedStatement statement =connection.prepareStatement(query);
            statement.setString(1,area);
            statement.setString(2,dormid);
            int rowinsert = statement.executeUpdate();
            if(rowinsert>0){
                JOptionPane.showMessageDialog(this,"申请修理");
            }
            else JOptionPane.showMessageDialog(this,"申请失败");
            statement.close();
            connection.close();
        }catch (SQLException ex){
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,"数据库操作失败");
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
