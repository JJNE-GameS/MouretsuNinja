package com.jjnegames.mouretsu.display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.jjnegames.mouretsu.graphics.GraphicsManager;

public class Display extends JFrame implements Runnable {
	
	BufferedImage displayImage;
	int[] pixels;
	GraphicsManager gm = new GraphicsManager();
	int resWidth;
	int resHeight;
	
	public Display(int resWidth, int resHeight){
		
		setTitle("Mouretsu");
		setSize(resWidth,resHeight);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayImage=this.getGraphicsConfiguration().createCompatibleImage(resWidth, resHeight);
		pixels=((DataBufferInt)(displayImage.getRaster().getDataBuffer())).getData();
		this.resWidth = resWidth;
		this.resHeight = resHeight;
//		for(int i=3000; i<50000; i++){
//		pixels[i]= 0xffffff;
//		}
		Thread t = new Thread(this);
		t.start();
		
		
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
	
		
		/*
		int x = 200;
		int y = 200;
		int w = 20;
		int h = 20;
		
		g.clearRect(0, 0, getWidth(), getHeight());
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		
		double x1 = -w/2; 
		double y1 = -h/2;
		
		double x2 = w/2;
		double y2 = -h/2;
		
		double x3 = w/2;
		double y3 = h/2;
		
		double x4 = -w/2;
		double y4 = h/2;
		
		
		double rx1 = x1*cos-y1*sin;
		double ry1 = x1*sin+y1*cos;
		
		double rx2 = x2*cos-y2*sin;
		double ry2 = x2*sin+y2*cos;

		double rx3 = x3*cos-y3*sin;
		double ry3 = x3*sin+y3*cos;
		
		double rx4 = x4*cos-y4*sin;
		double ry4 = x4*sin+y4*cos;
		
		
		g.drawLine((int)rx1+x, (int)ry1+y, (int)rx2+x, (int)ry2+y);
		g.drawLine((int)rx2+x, (int)ry2+y, (int)rx3+x, (int)ry3+y);
		g.drawLine((int)rx3+x, (int)ry3+y, (int)rx4+x, (int)ry4+y);
		g.drawLine((int)rx4+x, (int)ry4+y, (int)rx1+x, (int)ry1+y);
		
		*/
		
	}
	
	double angle = 0;
	
	
	public void render() {
		
		for(int i=0;i<pixels.length;i++){
			pixels[i]=0;
		}

		
		gm.drawRectangle(pixels, resWidth, resHeight, 0xffffff, 200, 200, 40, 40, angle);
		angle += 0.1;
	}
	
	@Override
	public void run() {
		while(true){
			render();
			repaint();
			try{
				Thread.sleep(60);
			}catch(Exception ex){
				
			}
		}
	}
	
	
	
}
