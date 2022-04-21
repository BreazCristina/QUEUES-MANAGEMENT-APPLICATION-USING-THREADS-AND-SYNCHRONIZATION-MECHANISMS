import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class View extends JFrame{
    //... Components

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JComboBox comboBox;
    JButton btnNewButton = new JButton("Start");
    JButton btnNewButton_1 = new JButton("Reset");
    static JTextArea textArea;
    JScrollPane scrollPane;

    public View() {
        frame = new JFrame();
        frame.getContentPane().setForeground(Color.BLACK);
        frame.setBounds(100, 100, 947, 730);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Number of Clients:");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel.setBounds(35, 30, 138, 19);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(161, 25, 145, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Number of Queues:");
        lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel_1.setBounds(35, 64, 138, 27);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(161, 63, 145, 25);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Simulation Time:");
        lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel_2.setBounds(612, 22, 125, 35);
        frame.getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(726, 25, 86, 25);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Minimum arrival time:");
        lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel_3.setBounds(20, 115, 187, 40);
        frame.getContentPane().add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setBounds(161, 121, 145, 25);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Maximim arrival time:");
        lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel_4.setBounds(20, 163, 153, 28);
        frame.getContentPane().add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setBounds(161, 163, 145, 25);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(566, 123, 145, 25);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(566, 163, 145, 25);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Minimum service time:");
        lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel_5.setBounds(404, 128, 162, 14);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Maximum service time:");
        lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel_6.setBounds(404, 166, 152, 23);
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Strategy:");
        lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel_7.setBounds(404, 30, 65, 19);
        frame.getContentPane().add(lblNewLabel_7);

        comboBox = new JComboBox();

        comboBox.setEditable(true);
        comboBox.setForeground(Color.BLACK);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"SHORTEST_TIME", "SHORTEST_QUEUE"}));
        comboBox.setSelectedIndex(1);
       // comboBox.addItem("SHORTEST_TIME");
        //comboBox.addItem("SHORTEST_QUEUE");
        comboBox.setToolTipText("");
        comboBox.setBounds(479, 26, 125, 22);
        frame.getContentPane().add(comboBox);


        btnNewButton.setForeground(new Color(123, 104, 238));

        btnNewButton.setBounds(35, 234, 108, 23);
        frame.getContentPane().add(btnNewButton);


        btnNewButton_1.setForeground(new Color(106, 90, 205));
        btnNewButton_1.setBounds(153, 234, 113, 23);
        frame.getContentPane().add(btnNewButton_1);

        textArea = new JTextArea(1000000,1000000);
        textArea.setBounds(30, 268, 875, 412);
       // frame.getContentPane().add(textArea);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 268, 875, 412);
        frame.getContentPane().add(scrollPane);




        frame.setVisible(true);
    }



    String getUserInput() {
        return textField.getText();
    }

    String getUserInput1() {
        return textField_1.getText();
    }
    String getUserInput2() {
        return textField_2.getText();
    }
    String getUserInput3() {
        return textField_3.getText();
    }
    String getUserInput4() {
        return textField_4.getText();
    }
    String getUserInput5() {
        return textField_5.getText();
    }
    String getUserInput6() {
        return textField_6.getText();
    }

    public JComboBox getComboBox() {
        return comboBox;
    }




    void addListener(ActionListener mal) {
          btnNewButton.addActionListener(mal);
       }

       void rstListener(ActionListener r)
       {
           btnNewButton_1.addActionListener(r);
       }
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public static JTextArea getTextArea() {
        return textArea;
    }
}
