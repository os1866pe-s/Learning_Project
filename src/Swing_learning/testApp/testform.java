package Swing_learning.testApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testform {
    private JPanel panel1;
    private JList list1;
    private JButton button1;

    private DefaultListModel<String> categories;

    public static void main(String[] args) {
        JFrame frame = new JFrame("testform");
        frame.setContentPane(new testform().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {

        panel1 = new JPanel();
        categories = new DefaultListModel();
        categories.addElement("test");

        ListenForButton lForButton = new ListenForButton();

        button1 = new JButton();
        button1.addActionListener(lForButton);

        list1 = new JList(categories);
    }


    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button1){
                categories.removeAllElements();

                categories.addElement("test2");
            }
        }
    }
}
