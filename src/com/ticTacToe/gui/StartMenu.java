package com.ticTacToe.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class StartMenu extends JPanel implements MouseListener, MouseMotionListener  
{
	
	private static final long serialVersionUID = 1L;
	public static final int WINDOW_WIDTH = 500;
	public static final int WINDOW_HEIGHT = 550;
	
	public StartMenu()
	{
		setFocusable(true);
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		test(g);
	}
	
	private static void test(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(200, 300, 50, 50);
	}

	
	
	// LISTENER //
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
