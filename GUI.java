import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener{
    private double calculatedIncome = 0;
    private JFrame frame;
    private JPanel panel;
    private JLabel calculatedLabel;
    private JFormattedTextField textInput;


    public GUI() {
        frame = new JFrame();
        panel = new JPanel();
        textInput = new JFormattedTextField();

        JLabel headerLabel = new JLabel("Enter the amount in the box below " +
        "to convert to post-tax income", null, 0);
        JButton convertBtn = new JButton("Calculate");
        convertBtn.addActionListener(this);
        calculatedLabel = new JLabel("Income remaining after tax: ");
        panel.add(headerLabel);
        panel.add(textInput);
        panel.add(convertBtn);
        panel.add(calculatedLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hello");
        frame.pack();

        frame.setVisible(true);
    
    }

    public static void main(String[] args){
        new GUI();
    }

    public void actionPerformed(ActionEvent e){
        try {
            int inputVal = Integer.parseInt(textInput.getText());
            calculatedIncome = Calculate.income(inputVal);
            calculatedLabel.setText("Income remaining after tax: " + calculatedIncome);
        } catch (Exception ex) {
            calculatedLabel.setText("invalid input");
            // TODO: handle exception
        }
        
    }



}
