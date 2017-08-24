package com.ticTacToe.game;

import javax.swing.JFrame;

import com.ticTacToe.game.Game;

public class Start 
{
	public static void main(String[] args)
	{
		Game game = new Game();
		
		JFrame window = new JFrame("Tic Tac Toe");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.add(game);	// "game" will be a JPanel
		window.pack();
		window.setLocationRelativeTo(null); // Centers it on the screen
		window.setVisible(true);
		
		game.start();
	}
}
