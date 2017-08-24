package com.ticTacToe.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Boxes 
{
	public static final int WIDTH  = 100;
	public static final int HEIGHT = 100;
	
	private Color boxColor;
	private Color typeColor;
	private Font font;
	private String type;
	private BufferedImage boxImage;
	private int x;
	private int y;
	
	public Boxes(String type, int x, int y)
	{
		this.type = type;
		this.x = x;
		this.y = y;
		font = new Font("", Font.BOLD, 50);
		
		boxImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		drawBox();
	}
	
	public void render(Graphics2D g)
	{
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
}
