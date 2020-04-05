package GameOfLife;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeGame extends JFrame{/*�������*/
	private final World world;
	public LifeGame(int rows,int columns)    /*�����̣߳���Ϸ��ʼ*/
	{
		world=new World(rows, columns);
		new Thread(world).start();
		add(world);
	}
	
	public static void main(String[]args)
	{
		LifeGame frame=new LifeGame(40, 50);
		
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		JMenu options =new JMenu("ѡ��ͼ��");/*���Զ����ͼ����ѡ��һ��������Ϸ*/
		menu.add(options);/*�˵����������options*/
		
		JMenuItem arrow=options.add("Arrow");
		arrow.addActionListener(frame.new ArrowActionListener());/*�Զ���ͼ�����ŵ�options��*/
		JMenuItem square=options.add("Square");
		square.addActionListener(frame.new SquareActionListener());
		JMenuItem wd=options.add("wd");
		wd.addActionListener(frame.new wdActionListener());
		
		JMenu help=new JMenu("Help");
		menu.add(help);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007,859);
		frame.setTitle("������Ϸ");
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setResizable(false);/*������ƵĲ��� ���ϵ�������Ϊ ����������Ϊ���룬
		��ӹر�ѡ����ô��ڴ�С������  ����ˢ��ʱ����˸ ����Ϊ�������ɵ�����С */
	}
	class ArrowActionListener implements ActionListener
	{                                                 /*arrow�̳�������*/
		public void actionPerformed(ActionEvent e)
		{
			world.setArrow();
		}
	}
	class SquareActionListener implements ActionListener /*square�̳�������*/
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setSquare();
		}
	}
	class wdActionListener implements ActionListener /*wd�̳�������*/
	{
		public void actionPerformed(ActionEvent e)
		{
			world.setwd();
		}
	}
}
