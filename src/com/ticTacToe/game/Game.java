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
	public static final int GAMEBOARD_X = (WINDOW_WIDTH / 2) - (GameBoard.BOARD_WIDTH / 2);
	public static final int GAMEBOARD_Y = (WINDOW_HEIGHT / 2) - (GameBoard.BOARD_HEIGHT / 4);
	public static final Font main = new Font("Times New Roman", Font.PLAIN, 28);

	private Thread game;
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
		
		board = new GameBoard(GAMEBOARD_X, GAMEBOARD_Y);
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
	public void mouseMoved(MouseEvent e) 
	{
		for(int j = 0; j < 9; j ++)
		{
			GameBoard.boxes.get(j).isHovering(false);
			
			if(e.getX() > GameBoard.boxes.get(j).getX() + GAMEBOARD_X && e.getX() < GameBoard.boxes.get(j).getX() + Boxes.WIDTH + GAMEBOARD_X
					&& e.getY() > GameBoard.boxes.get(j).getY() + GAMEBOARD_Y && e.getY() < GameBoard.boxes.get(j).getY() + Boxes.WIDTH + GAMEBOARD_Y)
			{
				GameBoard.boxes.get(j).isHovering(true);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		for(int j = 0; j < 9; j ++)
		{
			GameBoard.boxes.get(j).hasClicked(false);
			
			if(e.getX() > GameBoard.boxes.get(j).getX() + GAMEBOARD_X && e.getX() < GameBoard.boxes.get(j).getX() + Boxes.WIDTH + GAMEBOARD_X
					&& e.getY() > GameBoard.boxes.get(j).getY() + GAMEBOARD_Y && e.getY() < GameBoard.boxes.get(j).getY() + Boxes.WIDTH + GAMEBOARD_Y)
			{
				GameBoard.boxes.get(j).hasClicked(true);
				System.out.println("box" + j);
			}
		}
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
	
}

