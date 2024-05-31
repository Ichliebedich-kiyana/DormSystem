/*
 * Created by JFormDesigner on Fri May 31 14:10:20 CST 2024
 */

package SViews;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import cn.login.DatabaseConnection;
/**
 * @author 86191
 */
public class DeleteRepairQuest extends JFrame {
    public DeleteRepairQuest() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8f93\u5165\u5bbf\u820d\u533a");
        contentPane.add(label1);
        label1.setBounds(65, 35, 75, 30);
        contentPane.add(textField1);
        textField1.setBounds(175, 40, 105, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u8f93\u5165\u5bbf\u820d\u53f7");
        contentPane.add(label2);
        label2.setBounds(65, 105, 65, 25);
        contentPane.add(textField2);
        textField2.setBounds(180, 105, 90, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(105, 180), button1.getPreferredSize()));
        button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            deletequest();

    }});
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void deletequest() {
        try {
            String area=textField1.getText();
            String dormid=textField2.getText();
            // 连接数据库
            Connection connection = DatabaseConnection.getConnection();

            // 定义删除语句，跟addStudent中一样，用?作为占位符，暂时顶替被删除学生的学号
            String query = "DELETE FROM needre WHERE area = ? AND dormid = ?";

            // 创建执行SQL对象，防止SQL注入
            PreparedStatement statement = connection.prepareStatement(query);

            // 用被删除学生的学号来替换占位符
            statement.setString(1, area);
            statement.setString(2, dormid);

            // 执行删除操作，返回被删除的行数
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "修理信息删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "未找到要删除修理信息");
            }

            // 及时释放资源
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库操作失败: " + ex.getMessage());
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
