import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class VoucherApp {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            
            JFrame frame = new JFrame("Voucher Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setSize(600, 400);
            
            
            JPanel gridPanel = new JPanel(new GridLayout(2, 3, 10, 10));
            for(int i=1;i<=6;i++)//1.3
            {
                gridPanel.add(new JLabel("Voucher "+ i +" Code "+ i));
            }
            
            
            JPanel voucherPanel = new JPanel();
            voucherPanel.setBorder(new TitledBorder("Voucher Code"));
            
            
            JTextField voucherField = new JTextField(15);
            voucherPanel.add(voucherField);
            
            
            JPanel historyPanel = new JPanel(new BorderLayout());
            JTextArea historyArea = new JTextArea(10, 40);
            historyArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(historyArea);
            
            JCheckBox pensionerCheckBox = new JCheckBox("Are you a pensioner ?");//1.5
            pensionerCheckBox.setSelected(true);
            
            JComboBox<String> ageComboBox = new JComboBox<>(new String[]{
                "Between 65 and 80",
                "Between 80 and 90",
                "Over 100"
            });
            
            ageComboBox.setEditable(true);
            
            JPanel buttonPanel = new JPanel();
            JButton addVoucherButton = new JButton("Add Voucher");
            JButton saveVoucherButton = new JButton("Save Voucher");
            JButton exitButton = new JButton("Exit");
            
            
            exitButton.addActionListener(e -> System.exit(0));
            
            buttonPanel.add(addVoucherButton);
            buttonPanel.add(saveVoucherButton);
            buttonPanel.add(exitButton);
            
            frame.add(voucherPanel,BorderLayout.NORTH);
            frame.add(gridPanel,BorderLayout.CENTER);
            frame.add(historyPanel,BorderLayout.EAST);
            frame.add(buttonPanel,BorderLayout.SOUTH);
            
            
            pensionerCheckBox.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ageComboBox.setEnabled(pensionerCheckBox.isSelected());
                }
            });
            
            frame.setVisible(true);
        });
        
     }
        
 }
    
