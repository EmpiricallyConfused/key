

package paycard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class ChargeUI {

    ChargeUI(int desiredCardType, int limit) {
	frame = new JFrame("Charge Paycard");
	jTextArea1.setFont(new Font("", Font.PLAIN, 18));
	if (desiredCardType == IssueCardUI.STANDARD) {
	    this.limit = 1000;
	    paycard = new PayCard();
	} else if (desiredCardType==IssueCardUI.JUNIOR) {
	    this.limit = 100;
	    paycard = PayCardJunior.createCard();
	} else if (desiredCardType == IssueCardUI.USER_DEFINED) {
	    this.limit = limit;
	    paycard = new PayCard(limit);
	}
    }

    
    public void initGUI() {
	jButton2.setText("Quit");
	jButton2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){jButton2ActionPerformed(e);}});
	jButton1.setText("charge");
	jButton1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){jButton1ActionPerformed(e);}});
	frame.setBounds(100, 100, 550, 350);
	frame.setResizable(true);
	frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	jTextField1.setText("jTextField1");
	frame.getContentPane().setLayout(new BorderLayout());
	frame.getContentPane().add(new JPanel(), BorderLayout.WEST);
	frame.getContentPane().add(new JPanel(), BorderLayout.EAST);
	frame.getContentPane().add(jPanel1, BorderLayout.CENTER);
	frame.getContentPane().add(jPanel2, BorderLayout.SOUTH);
	jPanel2.setLayout(new GridLayout(1,2));
	jPanel2.add(jButton1);
	jPanel2.add(jButton2);
	jPanel1.setLayout(new BorderLayout());
	jPanel3.setLayout(new GridLayout(1, 2));
	jPanel3.add(jLabel1);
	jPanel3.add(jTextField1);
	jPanel1.add(jPanel3,BorderLayout.SOUTH);
	jPanel1.add(jTextArea1);
	jPanel1.add(jLabel2,BorderLayout.NORTH);
	jLabel1.setText("Amount to charge:");
	jTextField1.setText("");
	jTextArea1.setText("");
	jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
	jTextArea1.setEditable(false);
	JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
	jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	jPanel1.add(jScrollPane1, null);
	jLabel2.setText("Limit of paycard is " + limit + ".");
	jLabel2.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
	frame.show();
    }

    
    public void jButton2ActionPerformed(ActionEvent e) {
        frame.dispose();
        System.exit(0);
    }

    
    public void jButton1ActionPerformed(ActionEvent e) {
	// read textfield
	int charge;
	try {
	    charge=Integer.parseInt(jTextField1.getText());
	}
	catch(NumberFormatException ex) {
	    JOptionPane.showMessageDialog(
		    frame, "Amount to charge has to be a number!", "Error",
		    JOptionPane.ERROR_MESSAGE);
	    return;
	}
	paycard.charge(charge);
	jTextArea1.append(paycard.infoCardMsg()+"\n");
    }
    

    private JFrame frame;
    private int limit;
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JButton jButton2 = new JButton();
    private PayCard paycard;
    private JButton jButton1 = new JButton();
    private JTextArea jTextArea1 = new JTextArea();
    private JLabel jLabel2 = new JLabel();
}
