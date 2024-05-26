package DormViews;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DormWindows extends JFrame {
    public DormWindows() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // 打开 DselfMessage 窗口
        new DselfMessage().setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // 打开 SelectStudent 窗口
        new SelectStudent().setVisible(true);
    }

    private void button3ActionPerformed(ActionEvent e) {
        // 打开 AddStudent 窗口
        new AddStudent().setVisible(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        // 打开 DeleteStudent 窗口
        new DeleteStudent().setVisible(true);
    }

    private void button5ActionPerformed(ActionEvent e) {
        // 打开 UpdateStudent 窗口
        new UpdateStudent().setVisible(true);
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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(35, 25, 115, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u5b66\u751f\u4fe1\u606f\u67e5\u8be2");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(35, 70, 115, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u6dfb\u52a0\u5b66\u751f\u4fe1\u606f");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(30, 120, 125, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("\u5b66\u751f\u4fe1\u606f\u5220\u9664");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4ActionPerformed(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(25, 165, 145, button4.getPreferredSize().height);

        //---- button5 ----
        button5.setText("\u4fee\u6539\u5b66\u751f\u4fe1\u606f");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5ActionPerformed(e);
            }
        });
        contentPane.add(button5);
        button5.setBounds(30, 215, 145, button5.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
