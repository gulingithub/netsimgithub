package NetSimGUI.java;



import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class About extends javax.swing.JFrame {
	private JLabel jLabel;
	private JTextField jTextField1;
	private JTextArea jTextArea2;
	private JTextArea jTextArea1;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				About inst = new About();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public About() {
		super("About");
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				ImageIcon iconApp = new ImageIcon("C:/main-image.gif");
				jLabel = new JLabel(iconApp, JLabel.CENTER);
				getContentPane().add(jLabel, BorderLayout.WEST);
				jLabel.setText("APPLICATION");
				jLabel.setPreferredSize(new java.awt.Dimension(534, 182));
				jLabel.setSize(200, 341);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, BorderLayout.SOUTH);
				jTextField1.setText(" Netsim  Version: 0.0.0  (c) Copyright NetSim contributors, All rights reserved. ");
				jTextField1.setPreferredSize(new java.awt.Dimension(536, 173));
				jTextField1.setSize(250, 350);
				jTextField1.setFont(new java.awt.Font("Times New Roman",0,16));
			}

			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
