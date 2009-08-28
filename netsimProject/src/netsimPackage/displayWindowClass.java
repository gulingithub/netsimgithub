package netsimPackage;
import java.awt.Canvas;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class displayWindowClass extends javax.swing.JFrame {
	private JButton runButton;
	private JButton clearButton;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private Canvas networkCanvas;
	private JPanel jPanel2;
	private JCheckBox checkServer;
	private JCheckBox checkSattelite;
	private JCheckBox checkStereo;
	private JCheckBox checkLaptop;
	private JPanel jPanel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				displayWindowClass inst = new displayWindowClass();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public displayWindowClass() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(644, 457));
			{
				runButton = new JButton();
				getContentPane().add(runButton);
				runButton.setText("Run It");
				runButton.setBounds(339, 306, 75, 22);
				runButton.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				clearButton = new JButton();
				getContentPane().add(clearButton);
				clearButton.setText("Clear");
				clearButton.setBounds(433, 306, 75, 22);
				clearButton.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(288, 221, 262, 73);
				{
					TableModel jTable1Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setBounds(332, 212, 175, 58);
				}
			}
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1);
				jPanel1.setBounds(19, 39, 223, 289);
				jPanel1.setBorder(BorderFactory.createTitledBorder("please choose two"));
				{
					checkLaptop = new JCheckBox();
					checkLaptop.setText("Laptop");
				}
				{
					checkStereo = new JCheckBox();
					checkStereo.setText("Stereo System");
				}
				{
					checkSattelite = new JCheckBox();
					checkSattelite.setText("Weather Sattelite");
				}
				{
					checkServer = new JCheckBox();
					checkServer.setText("Central Server");
				}
					jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(32, 32)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(checkLaptop, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 64, Short.MAX_VALUE))
					    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addComponent(checkStereo, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(checkSattelite, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 16, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(checkServer, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 16, Short.MAX_VALUE)))
					.addContainerGap(32, 32));
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(checkLaptop, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(checkStereo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(checkSattelite, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(checkServer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE));
			}
			{
				jPanel2 = new JPanel();
				GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanel2);
				getContentPane().add(jPanel2);
				jPanel2.setLayout(jPanel2Layout);
				jPanel2.setBounds(288, 39, 262, 158);
				jPanel2.setBorder(BorderFactory.createTitledBorder("Your Network"));
				{
					networkCanvas = new Canvas();
				}
				jPanel2Layout.setHorizontalGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap(22, 22)
					.addComponent(networkCanvas, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap());
				jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(networkCanvas, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap());
			}
			pack();
			this.setSize(644, 457);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
