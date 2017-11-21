package century.edu.pa1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LunarGui extends JFrame implements ActionListener, Runnable {
	
	private JPanel main;
	protected LandingField landingFieldPanel;
	private JButton start;
	private Image bgImage = new ImageIcon("moon.png").getImage();
	private Image spaceShipImage = new ImageIcon("shuttle.png").getImage();
	private final static int M_WIDTH = 480;
	private final static int M_HEIGHT = 500;
	private final static int M_CENTER = M_WIDTH / 2;
	private final static int START_LINE = 0;
	private final static int SPACE_IMAGE_HEIGHT = 30;
	private final static int FINISH_LINE = 220;
	
	public LunarGui(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(M_WIDTH, M_HEIGHT);
		guiComponents();
	}
	
	private void guiComponents(){
		main = new JPanel(new BorderLayout());
		landingFieldPanel = new LandingField();
		start = new JButton("Start");
		start.addActionListener(this);
		main.add(landingFieldPanel, BorderLayout.CENTER);
		main.add(start, BorderLayout.SOUTH);
		add(main);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Thread t2 = new Thread(this);
		t2.start();
	}
	
	public double getVerticalSpeedOfLander() {
		return this.getVerticalSpeedOfLander();	
	}
	
	public double getAltitudeOfLander(){
		return this.getAltitudeOfLander();
	}
	
	public double getAmountOfFuel(){
		return this.getAmountOfFuel();
	}
	
	class LandingField extends JPanel{
		private static final long serialVersionUID = 1L;
		private int position;

		public LandingField(){}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(bgImage, 0, 0, null);
			g2.setColor(Color.green); //set the color
			
			//draw landing line
			g2.drawLine(START_LINE, FINISH_LINE +SPACE_IMAGE_HEIGHT,
					M_WIDTH, FINISH_LINE + SPACE_IMAGE_HEIGHT);
			
			//Draw landing object
			drawLandingShip(g2);
			
			//update the position
			updatePosition();
		}
		
		private void updatePosition(){
			position += (int) (Math.random() * 5) + 5.5;
		}
		
		private void drawLandingShip(Graphics2D g2){
			if (position < FINISH_LINE) {
				g2.drawImage(spaceShipImage, M_CENTER, position, 
						SPACE_IMAGE_HEIGHT, SPACE_IMAGE_HEIGHT, null);
				g2.drawString("Altitude: " + getAltitudeOfLander(), M_CENTER + 80, FINISH_LINE - 45);
				g2.drawString("Speed: " + getVerticalSpeedOfLander(), M_CENTER + 80, FINISH_LINE - 25);
				if (getAltitudeOfLander() == 0){
					g2.drawString("Landded Successfully", M_CENTER + 80, FINISH_LINE -5);
				}
				if (getAmountOfFuel() == 0){
					g2.drawString("We have run out of fuel", M_CENTER + 80, FINISH_LINE -5);
				}
			} else{
				g2.drawImage(spaceShipImage, M_CENTER, FINISH_LINE, 
						SPACE_IMAGE_HEIGHT, SPACE_IMAGE_HEIGHT, null);
				g2.drawString("Altitude: " + getAltitudeOfLander(), M_CENTER + 80, FINISH_LINE - 45);
				g2.drawString("Speed: " + getVerticalSpeedOfLander(), M_CENTER + 80, FINISH_LINE - 25);
				if (getAltitudeOfLander() == 0){
					g2.drawString("Landded Successfully", M_CENTER + 80, FINISH_LINE -5);
				}
			}
				
		}
		
	}



	@Override
	public void run() {
	}
	
}
