/*
 * Created by JFormDesigner on Sat May 25 17:22:42 CST 2024
 */

package SysViews;

import java.awt.*;
import javax.swing.*;

/**
 * @author 86191
 */
public class SysWindows extends JFrame {
    public SysWindows() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4e2a\u4eba\u4fe1\u606f");
        contentPane.add(button1);
        button1.setBounds(45, 20, 110, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u65b0\u589e\u5bbf\u7ba1");
        contentPane.add(button2);
        button2.setBounds(50, 70, 105, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u5220\u9664\u5bbf\u7ba1\u4fe1\u606f");
        contentPane.add(button3);
        button3.setBounds(60, 115, 90, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("\u67e5\u770b\u5bbf\u7ba1\u4fe1\u606f");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(55, 160), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("\u4fee\u6539\u5bbf\u7ba1\u4fe1\u606f");
        contentPane.add(button5);
        button5.setBounds(55, 210, 105, button5.getPreferredSize().height);

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
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
