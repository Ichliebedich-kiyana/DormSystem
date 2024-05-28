/* 添加学生窗口 */
package DormViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 86191
 */
public class AddStudent extends JFrame {
    public AddStudent() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u5b66\u751f\u4fe1\u606f");
        contentPane.add(label1);
        label1.setBounds(10, 15, 135, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d");
        contentPane.add(label2);
        label2.setBounds(15, 50, 60, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        contentPane.add(label3);
        label3.setBounds(15, 90, 50, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u5b66\u53f7");
        contentPane.add(label4);
        label4.setBounds(15, 125, 40, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u59d3\u540d");
        contentPane.add(label5);
        label5.setBounds(15, 165, 50, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u5e74\u9f84");
        contentPane.add(label6);
        label6.setBounds(10, 210, 40, label6.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(75, 45, 90, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(75, 85, 90, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(75, 125, 85, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(75, 165, 85, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(75, 205, 90, textField5.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.addActionListener(e -> addButtonActionPerformed());
        button1.setBounds(new Rectangle(new Point(220, 120), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // 为添加按钮绑点事件
    private void addButtonActionPerformed() {
        // 获取新增学生的信息
        String username = textField1.getText();
        String password = textField2.getText();
        String id = textField3.getText();
        String name = textField4.getText();
        String age = textField5.getText();

        try {
            // 调用DatabaseConnection类静态方法，连接数据库
            Connection connection = DatabaseConnection.getConnection();
            // 定义插入SQL，用？作为占位符来插入信息
            String query = "INSERT INTO student (username, password, id, name, age) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            // 更改占位符的信息
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, id);
            statement.setString(4, name);
            statement.setString(5, age);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "学生信息添加成功");
            } else {
                JOptionPane.showMessageDialog(this, "学生信息添加失败");
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败");
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
