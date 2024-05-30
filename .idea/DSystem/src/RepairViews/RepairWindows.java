

package RepairViews;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import cn.login.LoginWindow;
/**
 * @author 86191
 */
public class RepairWindows extends JFrame {
    public RepairWindows() {
        initComponents();
    }
    private  void button1ActionPerformed(ActionEvent e){
        new RsMessage().setVisible(true);
    }

    private  void button2ActionPerformed(ActionEvent e){
        new RepairLook().setVisible(true);
    }
    private  void button3ActionPerformed(ActionEvent e){
        new RepairComplete().setVisible(true);
    }
    private  void button4ActionPerformed(ActionEvent e){
        new LoginWindow().setVisible(true);
    }
    private void initComponents() {
                // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
                button1 = new JButton();
                button2 = new JButton();
                button3 = new JButton();
                button4 = new JButton();

                //======== this ========
                var contentPane = getContentPane();
                contentPane.setLayout(null);

                //---- button1 ----
                button1.setText("\u4e2a\u4eba\u4fe1\u606f");
                contentPane.add(button1);
                button1.setBounds(35, 25, 105, 45);
                button1.addActionListener(e -> button1ActionPerformed(e));
                //---- button2 ----
                button2.setText("\u67e5\u770b\u9700\u8981\u4fee\u7406\u7684\u5bbf\u820d");
                contentPane.add(button2);
                button2.setBounds(40, 95, 120, 40);
                button2.addActionListener(e -> button2ActionPerformed(e));
                //---- button3 ----
                button3.setText("\u4fee\u7406\u5b8c\u6210\u540e\u53d6\u6d88");
                contentPane.add(button3);
                button3.setBounds(45, 160, 110, 40);
                button3.addActionListener(e -> button3ActionPerformed(e));
                //---- button4 ----
                button4.setText("\u9000\u51fa\u767b\u5f55");
                contentPane.add(button4);
                button4.setBounds(new Rectangle(new Point(235, 110), button4.getPreferredSize()));
                button4.addActionListener(e -> button4ActionPerformed(e));
                contentPane.setPreferredSize(new Dimension(400, 300));
                pack();
                setLocationRelativeTo(getOwner());
                // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
