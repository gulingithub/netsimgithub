/* 
 * NetSim V0.1 
 * 
 * Yina Arenas
 * Gu Lin
 * Alex Gessner
 */

package NetSimGUI.java;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class NetSimGUI extends JFrame {
	//Variable declaration
	private static final long serialVersionUID = 1L;
	private JSplitPane mainView, leftPane;
	private JPanel bottomLeftPane, topLeftPane;
	private JPanel rightPane;
	private JToggleButton linkButton, nodeButton, transButton, appButton, selectButton;
	private JMenuBar jMenuBar;
	private JMenu fileMenu, helpMenu; //editMenu,
	private JMenuItem  jMenuItem2,  jMenuItem4; //jMenuItem1, jMenuItem3,
	private JLabel posIcon;
	public About aboutWindow= new About();
	private ArrayList<Component> selectedComponents = new ArrayList<Component>();
	private ArrayList<Link> linkList = new ArrayList<Link>();
	private boolean startDrag = false, drawLink = false;
	private int initMousePosX, initMousePosY;
	private Component initComponent= null;


	///////////
	int x, y, oldx, oldy, count;


	//Icons
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

	//Initialize frame
	public NetSimGUI() {
		super("NetSim");
		initGUI();
	}

	//Main Configuration: panels and menu
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
							transButton.setText("  Trans ");
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
					rightPane = new LinePanel();
					mainView.add(rightPane, JSplitPane.RIGHT);
					rightPane.setBackground(new java.awt.Color(255,255,255));
					rightPane.setPreferredSize(new java.awt.Dimension(393, 398));
					{
						rightPane.addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent me){
								rightPaneClicked(me);
								//drawNetworkConnection(me);
							}
							public void mouseReleased(MouseEvent me){
								rightPaneMouseReleased(me);
							}							
						});
						rightPane.addMouseMotionListener(new MouseAdapter(){
							public void mouseDragged(MouseEvent me){
								rightPaneMouseDragged(me);
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
					/*jMenuItem1 = new JMenuItem();
					fileMenu.add(jMenuItem1);
					jMenuItem1.setText("New");
					//jMenuItem2.setAction(getAppActionMap().get("new"));
					fileMenu.addSeparator();*/
					jMenuItem2 = new JMenuItem();
					fileMenu.add(jMenuItem2);
					jMenuItem2.setText("Quit");
					jMenuItem2.addActionListener(SimpleListener);
					//jMenuItem2.setAction(getAppActionMap().get("quit"));
				}		            	
				/*//Edit Menu
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
				}*/
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
		public void actionPerformed (ActionEvent e){
			System.exit(0);
		}
	}
	;

	ActionListener SimpleListener1 = new ActionListener()
	{
		public void actionPerformed (ActionEvent e){			
			aboutWindow.show();			
		}
	};

	//Detects DEL key to delete components
	private void rightPaneKeyPressed(java.awt.event.KeyEvent evt) {
		if ( evt.getKeyCode() == KeyEvent.VK_DELETE) {
			for (Object comp : selectedComponents) {
				rightPane.remove((Component) comp);
			}
			rightPane.repaint();
		}
	}

/*	//Alex's function to draw line
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
	}*/

	//Inserts and moves components from the pane
	private void rightPaneClicked(MouseEvent me) {
		ImageIcon icon = null;
		String name = null;
		int posX = me.getX();
		int posY = me.getY();
		int h =30;
		int w = 60;
		Component iconComp = rightPane.getComponentAt(posX, posY);

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

		//Inserts new components
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
		//Selects components
		else if (selectButton.isSelected()) {
			if (!iconComp.equals(rightPane)) {
				if (!me.isControlDown()){
					for (Object comp : selectedComponents) {
						((Component) comp).setForeground(java.awt.Color.BLACK);
					}
					selectedComponents.clear();
					iconComp.setForeground(java.awt.Color.BLUE);
					selectedComponents.add(iconComp);
				}
				else {
					if (selectedComponents.contains(iconComp)) {
						iconComp.setForeground(java.awt.Color.BLACK);
						selectedComponents.remove(iconComp);
					}
					else {
						iconComp.setForeground(java.awt.Color.BLUE);
						selectedComponents.add(iconComp);
					}
				}
			}
			else {
				for (Object comp : selectedComponents) {
					((Component) comp).setForeground(java.awt.Color.BLACK);
				}
				selectedComponents.clear();
			}
		}
		rightPane.repaint();
	}

	//Implements components dragging
	private void rightPaneMouseDragged(java.awt.event.MouseEvent evt) {
		Component iconComp = rightPane.getComponentAt(evt.getX(), evt.getY());
		Graphics g = rightPane.getGraphics();
		if (selectButton.isSelected()) {
			if (!startDrag) {
				initMousePosX = evt.getX();
				initMousePosY = evt.getY();

				if (!selectedComponents.contains(iconComp) && !evt.isControlDown()) {
					for (Object comp : selectedComponents)
						((Component) comp).setForeground(java.awt.Color.BLACK);
					selectedComponents.clear();
					if (!iconComp.equals(rightPane)) {
						iconComp.setForeground(java.awt.Color.BLUE);
						selectedComponents.add(iconComp);
					}
				}
				startDrag = true;
			}
			int deltaX = evt.getX() - initMousePosX;
			int deltaY = evt.getY() - initMousePosY;

			if (!selectedComponents.isEmpty() && !evt.isControlDown()) {
				deltaX = evt.getX() - initMousePosX;
				deltaY = evt.getY() - initMousePosY;
				for (Object comp : selectedComponents) {
					int X = ((Component) comp).getX() + deltaX;
					int Y = ((Component) comp).getY() + deltaY;
					((Component) comp).setLocation(X, Y);
				}
				initMousePosX = evt.getX();
				initMousePosY = evt.getY();
			}
			else {
				g.drawRect(Math.min(initMousePosX, evt.getX()), Math.min(initMousePosY, evt.getY()),
						Math.abs(initMousePosX - evt.getX()), Math.abs(initMousePosY - evt.getY()));
			}
		}
		else if (linkButton.isSelected()) {
			if (!startDrag) {
				initMousePosX = evt.getX();
				initMousePosY = evt.getY();
				startDrag = true;
				if(!iconComp.equals(rightPane)){
					initComponent = iconComp;
					drawLink = true;
				}
			}
			if (drawLink)
				g.drawLine(initMousePosX, initMousePosY, evt.getX(), evt.getY());
		}
		rightPane.repaint();
		drawLinks();
	}

	//Helps in the selection of several components 
	private void rightPaneMouseReleased(java.awt.event.MouseEvent evt) {
		Component iconComp = rightPane.getComponentAt(evt.getX(), evt.getY());
		if (startDrag == true && selectButton.isSelected()) {
			for (Object comp : rightPane.getComponents()) {
				int posX = ((Component) comp).getX();
				int posY = ((Component) comp).getY();
				int minX = Math.min(initMousePosX, evt.getX());
				int minY = Math.min(initMousePosY, evt.getY());
				int maxX = Math.max(initMousePosX, evt.getX());
				int maxY = Math.max(initMousePosY, evt.getY());
				if (posX >= minX && posX <= maxX && posY >= minY && posY <= maxY) {
					if (selectedComponents.contains((Component) comp)) {
						((Component) comp).setForeground(java.awt.Color.BLACK);
						selectedComponents.remove(((Component) comp));
					}
					else {
						((Component) comp).setForeground(java.awt.Color.BLUE);
						selectedComponents.add(((Component) comp));
					}
				}
			}
			rightPane.repaint();
		}
		if(startDrag && linkButton.isSelected()){
			if(!iconComp.equals(rightPane)&& !iconComp.equals(initComponent)){
				Link l = new Link(initComponent, iconComp);
				linkList.add(l);
				drawLinks();

			}
			drawLink = false;
		}
		startDrag = false;		
	}

	private void drawLinks(){
		Graphics g = rightPane.getGraphics();

		for(Link l:linkList){
			int x1 = l.initComponent.getX()+15;
			int y1 = l.initComponent.getY()+20;
			int x2 = l.lastComponent.getX()+15;
			int y2 = l.lastComponent.getY()+20;

			g.drawLine(x1, y1, x2, y2);			
		}
	}
}
//end	