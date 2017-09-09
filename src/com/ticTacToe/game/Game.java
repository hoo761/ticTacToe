/* This is the Game class. It is the main game object used to handle all
 * the game objects and put the game together 
 * 
 * Created by Jacob Houssian
 */

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
	private boolean win;
	private String takenBy[];
	private int[][] winSpots;
	private int turn;

	// Game Constructor
	public Game()
	{
		setFocusable(true);
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		addMouseListener(this);
		addMouseMotionListener(this);
		setWinSpots();
		
		win = false;
		takenBy = new String[9];
		turn = 1;
		board = new GameBoard(GAMEBOARD_X, GAMEBOARD_Y);
	}
	
	
	public void update()
	{
		setTaken();
		
		checkWin();
	}
	
	// Renders game graphics
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
	
	// Returns Graphics2D object for the main BufferedImage
	public Graphics2D getGameGraphics()
	{
		Graphics2D g = (Graphics2D) image.getGraphics();
		return g;
	}
	
	// Main game thread
	public void run() 
	{	
		while(running && !win)
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
	    }
	}

	// Used with thread
	public synchronized void start()
	{
		if(running) return;
		running = true;
		game = new Thread(this, "game");	
			game.start();
	}
	
	// Used with thread
	public synchronized void stop()
	{
		if(!running) return;
		running = false;
		System.exit(0);
	}

	public void setTaken()
	{
		for(int spot = 0; spot < takenBy.length; spot ++)
		{
			if(!GameBoard.boxes.get(spot).getType().equals("null"))
			{
				GameBoard.boxes.get(spot).isTaken(true);
				takenBy[spot] = GameBoard.boxes.get(spot).getType();
			}
			else
			{
				takenBy[spot] = GameBoard.boxes.get(spot).getType();
			}
		}
	}
	
	public String getType()
	{
		if(turn % 2 == 0)
			return "O";
		else
			return "X";
	}
	
	public void checkWin()
	{
		checkWinX();
		checkWinO();
	}
	
	public void checkWinX()
	{
		for(int x = 0; x < 8; x++)
		{
			int amount = 0;
			for(int y = 0; y < 3; y++)
			{
				if(GameBoard.boxes.get(winSpots[x][y]).getType().equals("X"))
				{
					amount++;
				}
				if(amount == 3)
				{
					System.out.println("X WIN");
					//win = true;
				}
			}
		}
	}
	
	public void checkWinO()
	{
		for(int x = 0; x < 8; x++)
		{
			int amount = 0;
			for(int y = 0; y < 3; y++)
			{
				if(GameBoard.boxes.get(winSpots[x][y]).getType().equals("O"))
				{
					amount++;
				}
				if(amount == 3)
				{
					System.out.println("O WIN");
					//win = true;
				}
			}
		}
	}
	
	public void setWinSpots()
	{
		winSpots = new int[][]
		{
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},
			{0, 3, 6},
			{1, 4, 7}, 
			{2, 5, 8},
			{0, 4, 8},
			{2, 4, 6}
		};
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
			if(e.getX() > GameBoard.boxes.get(j).getX() + GAMEBOARD_X && e.getX() < GameBoard.boxes.get(j).getX() + Boxes.WIDTH + GAMEBOARD_X
					&& e.getY() > GameBoard.boxes.get(j).getY() + GAMEBOARD_Y && e.getY() < GameBoard.boxes.get(j).getY() + Boxes.WIDTH + GAMEBOARD_Y)
			{
				System.out.println("box" + j);
				if(!GameBoard.boxes.get(j).getTaken())
				{
					GameBoard.boxes.get(j).setBox(getType());
					setTaken();
					turn ++;
				}
				for(int x = 0; x < 9; x ++)
				{
					System.out.print(takenBy[x] + " ");
				}
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

