/* 
 * NetSim V0.1 - LinePanel.java
 * 
 * Yina Arenas
 * Gu Lin
 * Alex Gessner
 */

package NetSimGUI.java;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;

public class LinePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public Vector<Integer> linevector;

	public LinePanel() {
		linevector = new Vector<Integer>();
	}

	public LinePanel(LayoutManager layout) {
		super(layout);
	}

	public LinePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public LinePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
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
