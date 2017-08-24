package com.ticTacToe.game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, Runnable
{

	private static final long serialVersionUID = 1L;
	public static final int WINDOW_WIDTH = 640;
	public static final int WINDOW_HEIGHT = 900;
	public static final Font main = new Font("Times New Roman", Font.PLAIN, 28);

	private Thread game;
	private BufferedImage image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
	private boolean running;

public Game()
{
	setFocusable(true);
	setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
	addKeyListener(this);
}

public void update()
{
	
}

public void render()
{
	Graphics2D g = (Graphics2D) image.getGraphics();
	g.setColor(new Color(250, 250, 250));
	g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	g.dispose();
	
	Graphics2D g2d = (Graphics2D) getGraphics();
	g2d.drawImage(image, 0, 0, null);
	g2d.dispose();	
}

public Graphics2D getGameGraphics()
{
	Graphics2D g = (Graphics2D) image.getGraphics();
	return g;
}

public void run() 
{	
	while(running)
	{
		update();	
		render();
	}
	try 
    {
        Thread.sleep(1000);     
    }
    catch (InterruptedException e) 
    {
        System.out.println("Interrupted.");
        render();
    }
}


public synchronized void start()
{
	if(running) return;
	running = true;
	game = new Thread(this, "game");	
		game.start();
	}
	
	public synchronized void stop()
	{
		if(!running) return;
		running = false;
		System.exit(0);
	}

	public void keyPressed(KeyEvent e) 
	{
		
	}

	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_LEFT)
		{

		}	
		if(keyCode == KeyEvent.VK_RIGHT)
		{
			
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			
		}
		if(keyCode == KeyEvent.VK_DOWN)
		{
			
		}
		if(keyCode == KeyEvent.VK_R)
		{
		
		}
	}

	public void keyTyped(KeyEvent e) 
	{

	}
}

