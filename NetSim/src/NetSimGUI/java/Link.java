/* 
 * NetSim V0.1 - Link.java
 * 
 * Yina Arenas
 * Gu Lin
 * Alex Gessner
 */

package NetSimGUI.java;

import java.awt.Component;

public class Link {
	public Component initComponent = null;
	public Component lastComponent = null;
	
	Link(Component o, Component d){
		this.initComponent = o;
		this.lastComponent = d;		
	}
}
