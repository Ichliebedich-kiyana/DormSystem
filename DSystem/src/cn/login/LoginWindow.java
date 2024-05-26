package cn.login;

import DormViews.DormWindows;
import RepairViews.RepairWindows;
import SViews.StudentWindows;
import SysViews.SysWindows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginWindow extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JComboBox<String> comboBox1;
    private JButton button1;

    public LoginWindow() {
        initComponents();

        // Add ActionListener to the Login button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve user input
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());
                String selectedRole = (String) comboBox1.getSelectedItem();

                // Determine table based on selected role
                String tableName = "";
                if (selectedRole.equals("学生登陆")) {
                    tableName = "student";
                } else if (selectedRole.equals("宿管登陆")) {
                    tableName = "dorm";
                } else if (selectedRole.equals("管理员登陆")) {
                    tableName = "sys";
                } else if (selectedRole.equals("修理人员登陆")) {
                    tableName = "repair";
                }

                // Query the database
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    String query = "SELECT * FROM " + tableName + " WHERE username = ? AND password = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, username);
                    statement.setString(2, password);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        // Login successful
                        //JOptionPane.showMessageDialog(LoginWindow.this, "登录成功");

                        dispose();

                        if ("student".equals(tableName)) {
                            new StudentWindows().setVisible(true);
                        } else if ("dorm".equals(tableName)) {
                            new DormWindows().setVisible(true);
                        }
                        else if ("sys".equals(tableName)) {
                            // 如果你有 AdminWindows 窗口
                            new SysWindows().setVisible(true);
                        }
                        else if ("repair".equals(tableName)) {
                            // 如果你有 RepairWindow 窗口
                            new RepairWindows().setVisible(true);
                        }
                    } else {
                        // Login failed
                        JOptionPane.showMessageDialog(LoginWindow.this, "用户名或密码错误");
                    }

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(LoginWindow.this, "数据库连接错误");
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        contentPane.add(label1);
        label1.setBounds(40, 60, 70, 40);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(35, 140, 75, label2.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(120, 70, 110, textField1.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(120, 140, 105, passwordField1.getPreferredSize().height);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5b66\u751f\u767b\u9646",
                "\u5bbf\u7ba1\u767b\u9646",
                "\u7ba1\u7406\u5458\u767b\u9646",
                "\u4fee\u7406\u4eba\u5458\u767b\u9646"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(35, 205), comboBox1.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u767b\u9646");
        contentPane.add(button1);
        button1.setBounds(165, 205, 95, button1.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginWindow frame = new LoginWindow();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
