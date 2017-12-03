/* This is the Start file. It constructs the Game object in a JPanel which is in a 
 * JFrame. This also calls the game to start
 * 
 * Created by Jacob Houssian
 */



package com.ticTacToe.game;

import javax.swing.JFrame;

import com.ticTacToe.game.Game;
import com.ticTacToe.gui.StartMenu;

public class Start 
{
	public static void main(String[] args)
	{
		//Game game = new Game();
		StartMenu startMenu = new StartMenu();
		
		JFrame window = new JFrame("Tic Tac Toe");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.add(startMenu);	// "game" will be a JPanel
		window.pack();
		window.setLocationRelativeTo(null); // Centers it on the screen
		window.setVisible(true);
		
		//game.start();
	}
}
