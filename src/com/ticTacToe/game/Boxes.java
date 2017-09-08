/* This is the Boxes class. It creates the Boxes object that is used as
 * the boxes on the game board as BufferedImages
 * 
 * Created by Jacob Houssian
 */


package com.ticTacToe.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Boxes 
{
	public static final int WIDTH  = 100;	// Width of the boxes
	public static final int HEIGHT = 100;	// Height of the boxes
	
	private Color boxColor;				// Color of the box object
	private Color typeColor;			// Color of the Strings on each box object
	private Font font;					// Font of Strings on the boxes
	private String type;				// Used to determine if a box is a "X", "O", or null for a blank box
	private BufferedImage boxImage;		// BufferedImage for each box
	private int x;						// X position of each box
	private int y;						// Y position of each box
	private boolean isHovering;			// Is set to true if the mouse is on that box, and false when not on the box

	
	public Boxes(String type, int x, int y)
	{
		this.type = type;
		this.x = x;
		this.y = y;
		font = new Font("", Font.BOLD, 50);
		isHovering = false;
		
		boxImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		drawBox();
	}
	
	public void render(Graphics2D g)
	{
		if(isHovering)
		{
			Graphics2D g2d = (Graphics2D) boxImage.getGraphics();
			
			g2d.setColor(Color.YELLOW);
			g2d.fillRect(0, 0, WIDTH, HEIGHT);
		}
		else
			drawBox();
		
		g.drawImage(boxImage, x, y, null);
	}
	
	public void drawBox()
	{
		Graphics2D g = (Graphics2D) boxImage.getGraphics();
		g.setFont(font);
		
		if(type.equals("X"))
		{
			boxColor = new Color(250, 0, 0);
			typeColor = new Color(0, 0, 250);
			
			g.setColor(boxColor);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			g.setColor(typeColor);
			g.drawString(type, 35, 60);
		}
		else if(type.equals("O"))
		{
			boxColor = new Color(0, 0, 250);
			typeColor = new Color(250, 0, 0);
			
			g.setColor(boxColor);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			g.setColor(typeColor);
			g.drawString(type, 30, 60);
		}
		else
		{
			g.setColor(new Color(0, 0, 0));
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
		
		g.dispose();
	}
	
	public void setBox(String type)
	{
		isHovering = false;
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void isHovering(boolean isHovering)
	{
		this.isHovering = isHovering;
	}
		
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
}
