package NetSimGUI.java;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
	private static final long serialVersionUID = 1L;
	private JSplitPane mainView, leftPane;
	private JPanel rightPane, bottomLeftPane, topLeftPane;
	private JToggleButton linkButton, nodeButton, transButton, appButton, selectButton;
	private JMenuBar jMenuBar;
	private JMenu fileMenu, editMenu, helpMenu;
	private JMenuItem jMenuItem1, jMenuItem2, jMenuItem3, jMenuItem4;
	private JLabel posIcon;
	public About aboutWindow= new About();
	private ArrayList<Component> selectedComponents = new ArrayList<Component>();

	ImageIcon iconNode = new ImageIcon (getClass().getClassLoader().getResource("resources/icons/node.png"));
	ImageIcon iconApp = new ImageIcon (getClass().getClassLoader().getResource("resources/icons/app.png"));
	ImageIcon iconTrans = new ImageIcon(getClass().getClassLoader().getResource("resources/icons/trans.png"));
	ImageIcon iconLink = new ImageIcon(getClass().getClassLoader().getResource("resources/icons/link.png"));
	ImageIcon iconPoint = new ImageIcon(getClass().getClassLoader().getResource("resources/icons/point.png"));

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
					leftPane.setDividerLocation(350);
					{
						topLeftPane = new JPanel();
						BoxLayout topLeftPaneLayout = new BoxLayout(topLeftPane, javax.swing.BoxLayout.Y_AXIS);
						topLeftPane.setLayout(topLeftPaneLayout);
						leftPane.add(topLeftPane, JSplitPane.LEFT);
						topLeftPane.setBorder(BorderFactory.createTitledBorder("SELECT"));
						{
							//Adds the components buttons

							nodeButton = new JToggleButton();
							nodeButton.setText("  Node ");
							nodeButton.setIcon(iconNode);
							linkButton = new JToggleButton();
							linkButton.setText("Link  ");
							linkButton.setIcon(iconLink);
							appButton = new JToggleButton();
							appButton.setText("  App  ");
							appButton.setIcon(iconApp);
							transButton = new JToggleButton();
							transButton.setText("Trans ");
							transButton.setIcon(iconTrans);
							selectButton = new JToggleButton();
							selectButton.setText("     Select ");
							selectButton.setIcon(iconPoint);

							topLeftPane.add(transButton);
							topLeftPane.add(appButton);
							topLeftPane.add(nodeButton);
							topLeftPane.add(linkButton);
							topLeftPane.add(selectButton);

							//Group Buttons
							ButtonGroup group = new ButtonGroup();
							group.add(appButton);
							group.add(transButton);
							group.add(nodeButton);
							group.add(linkButton);				
							group.add(selectButton);


							selectButton.addKeyListener(new KeyAdapter() {
								public void keyPressed(KeyEvent evt) {
									rightPaneKeyPressed(evt);
								}
							});
						}
					}
					{
						bottomLeftPane = new JPanel();
						leftPane.add(bottomLeftPane, JSplitPane.RIGHT);
					}
				}
				{
					rightPane = new JPanel();
					mainView.add(rightPane, JSplitPane.RIGHT);
					rightPane.setBackground(new java.awt.Color(255,255,255));
					rightPane.setPreferredSize(new java.awt.Dimension(393, 398));
					{
						rightPane.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent me){
								rightPaneClicked(me);
							}
						});
					}
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
					jMenuItem2.addActionListener(SimpleListener);
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
					jMenuItem3.addActionListener(SimpleListener2);
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
					jMenuItem4.addActionListener(SimpleListener1);
					//jMenuItem4.setAction(getAppActionMap().get("about"));
				}									
			}
			pack();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	ActionListener SimpleListener = new ActionListener()
	{
		public void actionPerformed (ActionEvent e)
		{
			
			System.out.println("You chosegegegegege" + e.getActionCommand());
			System.exit(0);
		}
	}
	;
	
	ActionListener SimpleListener1 = new ActionListener()
	{
		public void actionPerformed (ActionEvent e)
		{
			
			System.out.println("You chosegegegegege" + e.getActionCommand());
			aboutWindow.show();
			
		}
	};
	
	ActionListener SimpleListener2 = new ActionListener()
	{
		public void actionPerformed (ActionEvent e)
		{
			
			System.out.println("You chosegegegegege" + e.getActionCommand());
			
			rightPane.removeAll();
			rightPane.validate();
		}
	};
	
	private void rightPaneKeyPressed(java.awt.event.KeyEvent evt) {
		System.out.println("AJA....!!!");
		System.out.println(evt.getKeyCode());
		System.out.println(KeyEvent.VK_DELETE);
		if ( evt.getKeyCode() == KeyEvent.VK_DELETE) {
			System.out.println("Gotcha!!!");
			for (Object comp : selectedComponents) {
				rightPane.remove((Component) comp);
			}
			rightPane.repaint();
		}
	}

	private void rightPaneClicked(MouseEvent me) {
		ImageIcon icon = null;
		String name = null;
		int posX = me.getX();
		int posY = me.getY();
		int h =30;
		int w = 60;

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

		if(icon!=null){
			posX=posX-15;
			posY=posY-20;
			Image img = icon.getImage();  
			Image newimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
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
		else if (selectButton.isSelected()){
			Component iconComp = rightPane.getComponentAt(posX, posY);
			if (!iconComp.equals(rightPane)) {
				if (!me.isControlDown()){
					for (Object comp : selectedComponents) {
						((Component) comp).setForeground(java.awt.Color.BLACK);
					}
					selectedComponents.clear();
				}
				iconComp.setForeground(java.awt.Color.BLUE);
				selectedComponents.add(iconComp);               
			}
			else {
				for (Object comp : selectedComponents) {
					((Component) comp).setForeground(java.awt.Color.BLACK);
				}
				selectedComponents.clear();
			}

			//rightPane.remove( rightPane.getComponentAt(posX, posY) );

		}

		rightPane.repaint();

		}	
	}
//end	