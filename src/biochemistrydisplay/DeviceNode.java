/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biochemistrydisplay;

/**
 *
 * @author Nhokxayda
 */
import com.nettopo.boudis.BubbleBorder;
import com.nettopo.boudis.constants;
import com.nettopo.boudis.movableComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

public class DeviceNode extends JPanel {
	
	private JLabel labelINFON ;
	private int totalWidth ;
	 
	public DeviceNode(String nom ) { 
		
		this.setLayout(null);
		this.setOpaque(false);
		JLabel labelICO = new JLabel();
		ImageIcon iconLogo = new ImageIcon(this.getClass().getResource("../image/Dev.png"));
		labelICO.setIcon(iconLogo);		
		labelICO.setBounds(0, 15, 35, 35);
		this.add(labelICO);
		
		labelINFON = newLabelInfo(nom,0, 0, 260 , 26, Color.lightGray,Color.DARK_GRAY); 
		
	}

 
	
	private Dimension getLabelSizeFromText(String txt){		
		 
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
		
		int textwidth = (int)(constants.font.getStringBounds(txt, frc).getWidth());
		int textheight = (int)(constants.font.getStringBounds(txt, frc).getHeight()); 
		
		Dimension d = new Dimension(textwidth + 24, textheight + 2);
		
		if(this.getWidth() < d.getWidth() + 35 ){
			totalWidth = (int) d.getWidth() + 35 ;
			this.setSize(totalWidth,this.getHeight());
		}
		
		return d ;
		
		
	} 
	
	private JLabel newLabelInfo(String txt, int x,int y,int w,int h,Color r, Color l){
		
		JLabel label= new JLabel(txt);		  
		label.setBounds(x,y,w,h);	
		label.setSize(getLabelSizeFromText(label.getText()));
		AbstractBorder brdr = new  BubbleBorder(l,1,8,0);		
		label.setOpaque(true);
		label.setBorder(brdr); 
		label.setBackground(r);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(constants.font); 		
		this.add(label);
		return label;
		
	}

	public JLabel getLabelINFON() {
		return labelINFON;
	}

	public void setLabelINFON(JLabel labelINFON) {
		this.labelINFON = labelINFON;
	} 
	
	public int getTotalWidth() {
		return totalWidth;
	}



	public void setTotalWidth(int totalWidth) {
		this.totalWidth = totalWidth;
	}
	
	public static movableComponent createNode(String nom, int x,int y,int w,int h){
		DeviceNode b3 = new DeviceNode(nom); 
		w = b3.getTotalWidth();
		movableComponent b3d = new movableComponent(b3 ,x, y , w, h) ;
		b3d.setBounds(x, y, w, h);
		return b3d ;
	}

}