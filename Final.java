import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Final extends JFrame{
	private Timer timer = new Timer(1000, new TimerListener());
	private Line line = new Line();
	private Car1 car1 = new Car1(); 
	private Car2 car2 = new Car2();
	private Car3 car3 = new Car3();
	private JLabel jlbCar1 = new JLabel("Car 1 : ");
	private JLabel jlbCar2 = new JLabel("Car 2 : ");
	private JLabel jlbCar3 = new JLabel("Car 3 : ");
	private JTextField jtfCar1 = new JTextField(3);
	private JTextField jtfCar2 = new JTextField(3);
	private JTextField jtfCar3 = new JTextField(3);
	private JButton jbtStart = new JButton("Start");
	private JButton jbtStop = new JButton("Stop");
	int x1 = 0;
	int y1 = 60;
	int x2 = 0;
	int y2 = 140;
	int x3 = 0;
	int y3 = 220;
	
	public Final(){
		line.setLayout(null);
		line.add(jlbCar1);
		jlbCar1.setLayout(null);
		jlbCar1.setBounds(80, 3, 40, 40);
		line.add(jtfCar1);
		jtfCar1.setLayout(null);
		jtfCar1.setBounds(130, 10, 50, 25);
		line.add(jlbCar2);
		jlbCar2.setLayout(null);
		jlbCar2.setBounds(230, 3, 40, 40);
		line.add(jtfCar2);
		jtfCar2.setLayout(null);
		jtfCar2.setBounds(280, 10, 50, 25);
		line.add(jlbCar3);
		jlbCar3.setLayout(null);
		jlbCar3.setBounds(380, 3, 40, 40);
		line.add(jtfCar3);
		jtfCar3.setLayout(null);
		jtfCar3.setBounds(430, 10, 50, 25);
		line.add(jbtStart);
		jbtStart.setLayout(null);
		jbtStart.setBounds(530, 5, 70, 30);
		line.add(jbtStop);
		jbtStop.setLayout(null);
		jbtStop.setBounds(630, 5, 70, 30);
		
		car1.setLayout(null);
		car1.setBounds(x1, y1, 100, 60);
		line.add(car1);
		car2.setLayout(null);
		car2.setBounds(x2, y2, 100, 60);
		line.add(car2);
		car3.setLayout(null);
		car3.setBounds(x3, y3, 100, 60);
		line.add(car3);
		add(line);
	}
	
	public class Line extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawLine(0, 40, 800, 40);
			g.drawLine(0, 120, 800, 120);
			g.drawLine(0, 200, 800, 200);
		}
	}
	
	public class Car1 extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.fillOval(20,40,20,20);
			g.fillOval(60,40,20,20);
			g.setColor(Color.gray);
			g.fillRect(0,20,100,20);
			g.setColor(Color.blue);
			int x[] = {20,40,60,80};
			int y[] = {20,0,0,20};
			g.fillPolygon(x,y,x.length);
		}
	
	}
	
	public class Car2 extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.fillOval(20,40,20,20);
			g.fillOval(60,40,20,20);
			g.setColor(Color.gray);
			g.fillRect(0,20,100,20);
			g.setColor(Color.blue);
			int x[] = {20,40,60,80};
			int y[] = {20,0,0,20};
			g.fillPolygon(x,y,x.length);
		}
	}
	
	public class Car3 extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.fillOval(20,40,20,20);
			g.fillOval(60,40,20,20);
			g.setColor(Color.gray);
			g.fillRect(0,20,100,20);
			g.setColor(Color.blue);
			int x[] = {20,40,60,80};
			int y[] = {20,0,0,20};
			g.fillPolygon(x,y,x.length);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new Final();
		frame.setTitle("U10316046_1032JavaProject");
		frame.setSize(800,320);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
