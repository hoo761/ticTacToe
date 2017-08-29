package com.ticTacToe.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener, MouseMotionListener, Runnable
{

	private static final long serialVersionUID = 1L;
	public static final int WINDOW_WIDTH = 500;
	public static final int WINDOW_HEIGHT = 550;
	public static final Font main = new Font("Times New Roman", Font.PLAIN, 28);

	private Thread game;
	private Boxes box;
	private GameBoard board;
	private BufferedImage image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
	private boolean running;
	
	private boolean shouldRender;

	public Game()
	{
		setFocusable(true);
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		addMouseListener(this);
		addMouseMotionListener(this);
		
		board = new GameBoard(80, 130);
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(new Color(250, 250, 250));
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		board.render(g);
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
			shouldRender = true;
			
			if(shouldRender)
				render();
		}
		try 
	    {
	        Thread.sleep(1000);     
	    }
	    catch (InterruptedException e) 
	    {
	        System.out.println("Interrupted.");
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

	
	// MOUSE LISTENER \\
	
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{

	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		if(e.getX() > GameBoard.boxes.get(0).getX() + 80 && e.getX() < GameBoard.boxes.get(0).getX() + 180
				&& e.getY() > GameBoard.boxes.get(0).getY() + 130 && e.getY() < GameBoard.boxes.get(0).getY() + 230)
		{
			GameBoard.boxes.get(0).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(1).getX() + 80 && e.getX() < GameBoard.boxes.get(1).getX() + 180
				&& e.getY() > GameBoard.boxes.get(1).getY() + 130 && e.getY() < GameBoard.boxes.get(1).getY() + 230)
		{
			GameBoard.boxes.get(1).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(2).getX() + 80 && e.getX() < GameBoard.boxes.get(2).getX() + 180
				&& e.getY() > GameBoard.boxes.get(2).getY() + 130 && e.getY() < GameBoard.boxes.get(2).getY() + 230)
		{	
			GameBoard.boxes.get(2).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(3).getX() + 80 && e.getX() < GameBoard.boxes.get(3).getX() + 180
				&& e.getY() > GameBoard.boxes.get(3).getY() + 130 && e.getY() < GameBoard.boxes.get(3).getY() + 230)
		{
			GameBoard.boxes.get(3).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(4).getX() + 80 && e.getX() < GameBoard.boxes.get(4).getX() + 180
				&& e.getY() > GameBoard.boxes.get(4).getY() + 130 && e.getY() < GameBoard.boxes.get(4).getY() + 230)
		{
			GameBoard.boxes.get(4).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(5).getX() + 80 && e.getX() < GameBoard.boxes.get(5).getX() + 180
				&& e.getY() > GameBoard.boxes.get(5).getY() + 130 && e.getY() < GameBoard.boxes.get(5).getY() + 230)
		{
			GameBoard.boxes.get(5).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(6).getX() + 80 && e.getX() < GameBoard.boxes.get(6).getX() + 180
				&& e.getY() > GameBoard.boxes.get(6).getY() + 130 && e.getY() < GameBoard.boxes.get(6).getY() + 230)
		{
			GameBoard.boxes.get(6).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(7).getX() + 80 && e.getX() < GameBoard.boxes.get(7).getX() + 180
				&& e.getY() > GameBoard.boxes.get(7).getY() + 130 && e.getY() < GameBoard.boxes.get(7).getY() + 230)
		{
			GameBoard.boxes.get(7).isHovering(true);
		}
		
		else if(e.getX() > GameBoard.boxes.get(8).getX() + 80 && e.getX() < GameBoard.boxes.get(8).getX() + 180
				&& e.getY() > GameBoard.boxes.get(8).getY() + 130 && e.getY() < GameBoard.boxes.get(8).getY() + 230)
		{
			GameBoard.boxes.get(8).isHovering(true);
		
		}
		else
		{
			for(int i = 0; i < 9; i ++)		// Resets the "isHovering" boolean
			{
				GameBoard.boxes.get(i).isHovering(false);
			}
		}
	}
}

