package NetSimGUI.java;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;

public class LinePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2812343318256065006L;
	public Vector<Integer> linevector;

	public LinePanel() {
		// TODO Auto-generated constructor stub
		linevector = new Vector<Integer>();
	}

	public LinePanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public LinePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public LinePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		int a,b,c,d;

		super.paint(g);

		Iterator<Integer> i = this.linevector.iterator();
		while (i.hasNext()) {
			a = i.next();
			b = i.next();
			c = i.next();
			d = i.next();
			g.drawLine(a, b, c, d);
		}

	} 

}
