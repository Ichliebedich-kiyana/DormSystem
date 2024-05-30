/* 查询学生信息界面 */

package DormViews;

import cn.login.DatabaseConnection;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 86191
 */
public class SelectStudent extends JFrame {
    public SelectStudent() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8f93\u5165\u5b66\u751f\u5b66\u53f7");
        contentPane.add(label1);
        label1.setBounds(40, 45, 120, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(150, 40, 95, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(60, 85), button1.getPreferredSize()));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取文本框中输入的学生学号
                String studentId = textField1.getText().trim();

                // 查询学生信息并显示在弹窗中
                displayStudentInfo(studentId);
            }
        });
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    private void displayStudentInfo(String studentId) {
        try {
            // 获取数据库连接
            Connection connection = DatabaseConnection.getConnection();

            // 准备SQL查询语句
            String query = "SELECT * FROM student WHERE id = ?";

            // 创建PreparedStatement接口实现对象，处理SQL
            PreparedStatement statement = connection.prepareStatement(query);

            // 设置参数
            statement.setString(1, studentId);

            // 执行查询
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // 如果查询到结果，则获取学生信息
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String dormid = resultSet.getString("dormid");
                String area = resultSet.getString("area");
                // 在弹窗中显示学生信息
                JOptionPane.showMessageDialog(this,
                        "学号 " + id + "\n" +
                                "姓名" + name + "\n" +
                                "年龄" + age + "\n" +
                                "宿舍号" + dormid +"\n"+
                                "宿舍所在区域" + area);
            } else {
                // 如果未查询到结果，显示提示信息
                JOptionPane.showMessageDialog(this, "未找到对应学生信息");
            }

            // 关闭连接和语句
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库查询出错");
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
