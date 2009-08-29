package NetSimGUI.java;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.io.*;

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
public class NetSimGUI extends JFrame {
	private JSplitPane mainView, leftPane;
	private LinePanel rightPane;
	private JPanel bottomLeftPane, topLeftPane;
	private JRadioButton linkButton, nodeButton, transButton, appButton;
	private JMenuBar jMenuBar;
	private JMenu fileMenu, editMenu, helpMenu;
	private JMenuItem jMenuItem1, jMenuItem2, jMenuItem3, jMenuItem4;
	private JButton pointerButton;
	private JLabel posIcon;
	int x, y, oldx, oldy, count;


	ImageIcon iconNode = new ImageIcon("C:/node.png");
	ImageIcon iconApp = new ImageIcon("C:/app.png");
	ImageIcon iconTrans = new ImageIcon("C:/trans.png");

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NetSimGUI inst = new NetSimGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public NetSimGUI() {
		super("NetSim");
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				//Main View Pane Configuration
				mainView = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
				mainView.setDividerSize(2);
				mainView.setDividerLocation(150);
				mainView.setPreferredSize(new Dimension(612, 400));
				getContentPane().add(mainView, BorderLayout.CENTER);
				{
					leftPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
					mainView.add(leftPane, JSplitPane.LEFT);
					leftPane.setDividerSize(2);
					leftPane.setDividerLocation(150);
					{
						topLeftPane = new JPanel();
						BoxLayout topLeftPaneLayout = new BoxLayout(topLeftPane, javax.swing.BoxLayout.Y_AXIS);
						topLeftPane.setLayout(topLeftPaneLayout);
						leftPane.add(topLeftPane, JSplitPane.LEFT);
						topLeftPane.setBorder(BorderFactory.createTitledBorder("SELECT"));
						{
							nodeButton = new JRadioButton();
							nodeButton.setText("NODE");
							linkButton = new JRadioButton();
							linkButton.setText("LINK");
							appButton = new JRadioButton();
							appButton.setText("APPLICATION");
							transButton = new JRadioButton();
							transButton.setText("TRANSPORT");

							ButtonGroup group = new ButtonGroup();
							group.add(appButton);
							group.add(transButton);
							group.add(nodeButton);
							group.add(linkButton);					
						}
						{
							topLeftPane.add(transButton);
							topLeftPane.add(appButton);
							topLeftPane.add(nodeButton);
							topLeftPane.add(linkButton);
							{
								pointerButton = new JButton();
								topLeftPane.add(pointerButton);
								pointerButton.setLayout(null);
								pointerButton.setText("point");
							}
						}
					}
					{
						bottomLeftPane = new JPanel();
						leftPane.add(bottomLeftPane, JSplitPane.RIGHT);
					}
				}
				{
					rightPane = new LinePanel();
					mainView.add(rightPane, JSplitPane.RIGHT);
					rightPane.setBackground(new java.awt.Color(255,255,255));
					rightPane.setPreferredSize(new java.awt.Dimension(393, 398));
					rightPane.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent me){
								rightPaneClicked(me);
								drawNetworkConnection(me);
								if (count >= 2)
								{
									
								}
							}
					});
		
				}
			}

			jMenuBar = new JMenuBar();
			setJMenuBar(jMenuBar);
			{
				//File Menu
				fileMenu = new JMenu();
				jMenuBar.add(fileMenu);
				fileMenu.setText("File");
				fileMenu.setName("fileMenu");
				{
					jMenuItem1 = new JMenuItem();
					fileMenu.add(jMenuItem1);
					jMenuItem1.setText("New");
					//jMenuItem2.setAction(getAppActionMap().get("new"));
					fileMenu.addSeparator();
					jMenuItem2 = new JMenuItem();
					fileMenu.add(jMenuItem2);
					jMenuItem2.setText("Quit");
					//jMenuItem2.setAction(getAppActionMap().get("quit"));
				}		            	
				//Edit Menu
				editMenu = new JMenu();
				jMenuBar.add(editMenu);
				editMenu.setText("Edit");
				editMenu.setName("editMenu");
				{
					jMenuItem3 = new JMenuItem();
					editMenu.add(jMenuItem3);
					jMenuItem3.setText("Clear");
					//jMenuItem3.setAction(getAppActionMap().get("clear"));
				}
				//Help Menu
				helpMenu = new JMenu();
				jMenuBar.add(helpMenu);
				helpMenu.setText("Help");
				helpMenu.setName("helpMenu");
				{
					jMenuItem4 = new JMenuItem();
					helpMenu.add(jMenuItem4);
					jMenuItem4.setText("About");		                
					//jMenuItem4.setAction(getAppActionMap().get("about"));
				}									
			}
			pack();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void drawNetworkConnection(MouseEvent me) {
        if(count == 0)
        {
            x = me.getX();
            y = me.getY();
            count++;
        }
        else
        {
            oldx = x;
            oldy = y;
            x = me.getX();
            y = me.getY();
            
            this.rightPane.linevector.add(oldx);
            this.rightPane.linevector.add(oldy);
            this.rightPane.linevector.add(x);
            this.rightPane.linevector.add(y);
            
            count++;
            
            this.rightPane.repaint();
        }
	}

		
		
		
		
	
	private void rightPaneClicked(MouseEvent me) {
		ImageIcon icon = null;
		String name = null;

		if (nodeButton.isSelected()){
			icon = iconNode;
			name = "NODE";		
		}
		else if (appButton.isSelected()){
			icon = iconApp;
			name = "APP";
		}
		else if (transButton.isSelected()){
			icon = iconTrans;
			name = "TRANS";
		}

		int posX = me.getX()-15;
		int posY = me.getY()-20;
		int h =30;
		int w = 60;

		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);

		posIcon = new JLabel(name, newIcon,JLabel.CENTER);
		posIcon.setSize(w, h);

		javax.swing.GroupLayout rightPaneLayout = new javax.swing.GroupLayout(rightPane);
		rightPane.setLayout(rightPaneLayout);
		rightPaneLayout.setHorizontalGroup(
				rightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(rightPaneLayout.createSequentialGroup()
						.addGap(posX, posX, posX)
						.addComponent(posIcon, javax.swing.GroupLayout.PREFERRED_SIZE, w, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(w, Short.MAX_VALUE))
		);
		rightPaneLayout.setVerticalGroup(
				rightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(rightPaneLayout.createSequentialGroup()
						.addGap(posY, posY, posY)
						.addComponent(posIcon, javax.swing.GroupLayout.PREFERRED_SIZE, h, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(h, Short.MAX_VALUE))
		);

	}
}