/* 
 * NetSim V0.1 - LinePanel.java
 * 
 * Yina Arenas
 * Gu Lin
 * Alex Gessner
 */

package NetSimGUI.java;

import java.awt.*;
import javax.swing.*;

public class About extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jLabel;
	private JTextField jTextField1;

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
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, BorderLayout.SOUTH);
				jTextField1.setText(" Netsim  Version: 0.1  (c) Copyright NetSim contributors, All rights reserved. ");
				jTextField1.setPreferredSize(new java.awt.Dimension(536, 54));
				jTextField1.setSize(250, 350);
				jTextField1.setFont(new java.awt.Font("Times New Roman",0,16));
			}
			{
				ImageIcon iconApp = new ImageIcon(getClass().getClassLoader().getResource("resources/icons/About.jpg"));
				jLabel = new JLabel(iconApp, JLabel.CENTER);
				getContentPane().add(jLabel, BorderLayout.WEST);
				jLabel.setSize(200, 341);
			}
			
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
