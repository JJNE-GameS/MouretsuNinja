package com.jjnegames.mouretsu.graphics;

import com.jjnegames.mouretsu.utils.Mathematics;

public class GraphicsManager {

	/*
	public void drawLine(int[] pixels, int pixelWidth, int pixelHeight, int color, int x1, int y1, int x2,int y2){
//		if(x1>x2){ 
//			int x3 = x1;
//			x1 = x2;
//			x2 = x3;
//		}
//		if(y1>y2){ 
//			int y3 = y1;
//			y1 = y2;
//			y2 = y3;
//		}
		int deltax = x2-x1;
		int deltay = y2-y1;
		double error = 0;
		
		if(deltax !=0){
			double deltaerr = Math.abs(deltay/deltax);
			int y = y1;
			
			for(int x=x1;x<x2;x++){
				if(!(x<0 || x>= pixelWidth || y<0 || y>=pixelHeight)){
					pixels[x+y*pixelWidth]=color;
				}
				error = error + deltaerr;
				if(error > 0.5){
					y += 1;
					error = error -1;
				}
			}
		}else{
			int x= x1;	
			for(int y =y1;y<y2;y++){
				if(!(x<0 || x>= pixelWidth || y<0 || y>=pixelHeight)){
					pixels[x+y*pixelWidth]=color;
				}
			}
		}
		
		
			
		
	}
	
	
	*/
	
	
	
	
	
	
	
	//***********************************************/
	
	
	
	
	public void drawLine(int[] pixels, int pixelWidth, int pixelHeight, int color, int x1, int y1, int x2,int y2){
		
		int d = 0;
		 
        int dy = Math.abs(y2 - y1);
        int dx = Math.abs(x2 - x1);
 
        int dy2 = (dy << 1); // slope scaling factors to avoid floating
        int dx2 = (dx << 1); // point
 
        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
 
        if (dy <= dx) {
            for (;;) {
            	if(!(x1<0 || x1>= pixelWidth || y1<0 || y1>=pixelHeight)){
					pixels[x1+y1*pixelWidth]=color;
				}
                if (x1 == x2)
                    break;
                x1 += ix;
                d += dy2;
                if (d > dx) {
                    y1 += iy;
                    d -= dx2;
                }
            }
        } else {
            for (;;) {
            	if(!(x1<0 || x1>= pixelWidth || y1<0 || y1>=pixelHeight)){
					pixels[x1+y1*pixelWidth]=color;
				}
                if (y1 == y2)
                    break;
                y1 += iy;
                d += dx2;
                if (d > dy) {
                    x1 += ix;
                    d -= dy2;
                }
            }
        }
	}
	
	
	
	
	
	//************************************************/
	
	
	
	
	
	
	
	
	public void drawRectangle(int[] pixels, int pixelWidth, int pixelHeight, int color,int x, int y, int w, int h, double angle){
		
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
		
		drawLine(pixels, pixelWidth, pixelHeight, color, (int)rx1+x, (int)ry1+y, (int)rx2+x, (int)ry2+y);
		drawLine(pixels, pixelWidth, pixelHeight, color, (int)rx2+x, (int)ry2+y, (int)rx3+x, (int)ry3+y);
		drawLine(pixels, pixelWidth, pixelHeight, color, (int)rx3+x, (int)ry3+y, (int)rx4+x, (int)ry4+y);
		drawLine(pixels, pixelWidth, pixelHeight, color, (int)rx4+x, (int)ry4+y, (int)rx1+x, (int)ry1+y);

	}
}
