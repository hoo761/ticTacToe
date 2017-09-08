/* This is the GameBoard class. It creates a BufferedImage of the game grid
 * and handles all the Boxes objects and draws them on the gameboard Buffered Image
 * 
 * Created by Jacob Houssian
 */


package com.ticTacToe.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GameBoard 
{
	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int SPACING = 10;
	public static final int BOARD_HEIGHT = (COLS + 1) * SPACING + COLS * Boxes.WIDTH;
	public static final int BOARD_WIDTH = (ROWS + 1) * SPACING + ROWS * Boxes.HEIGHT;
	
	public static ArrayList<Boxes> boxes = new ArrayList<Boxes>();
	
	private BufferedImage gameBoard;
	private BufferedImage finalBoard;
	
	private int x;
	private int y;
	
	public GameBoard(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		gameBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		createBoardImage();
	}
	
	private void createBoardImage()
	{
		Graphics2D g = (Graphics2D) gameBoard.getGraphics();
		g.setColor(new Color(0, 255, 0));
		g.fillRect(0,  0, BOARD_WIDTH, BOARD_HEIGHT);
		
		g.setColor(new Color(204, 204, 204));
		
		for(int row = 0; row < ROWS; row++)
		{
			for(int col = 0; col < COLS; col++)
			{
				int x = SPACING + SPACING * col + Boxes.WIDTH * col;
				int y = SPACING + SPACING * row + Boxes.HEIGHT * row;

				boxes.add(new Boxes("null", x, y));
			}
		}
		
	}
	
	public void render(Graphics2D g)
	{
		finalBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2d = (Graphics2D) finalBoard.getGraphics();
		g2d.drawImage(gameBoard, 0, 0, null);
		
		for(int spot = 0; spot < ROWS * COLS; spot++)	
		{
			boxes.get(spot).render(g2d);
		}
		
		g.drawImage(finalBoard, x, y, null);
		g2d.dispose();
		
	}
	
	
}
