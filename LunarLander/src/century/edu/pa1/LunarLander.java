package century.edu.pa1;

import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class LunarLander extends LunarGui{
	private final double gravity = 1.62;
	private double current_fuelFlowRate;
	private double verticalSpeedOfLander;
	private double altitudeOfLander;
	private double amountOfFuel;
	private double massOfLanderWhenNoFuel;
	private double maxFuelConsumptionRate;
	private double maxThrustOfLanderEngine;
	
	//LunarList datalist = new LunarList();
	
	// constructor
	public LunarLander(double altitudeOfLander, double amountOfFuel, double massOfLanderWhenNoFuel,
			double maxFuelConsumptionRate, double maxThrustOfLanderEngine, String title) {
		super(title);
		super.setVisible(true);
		this.current_fuelFlowRate = 0.0;
		this.verticalSpeedOfLander = 0.0;
		this.altitudeOfLander = altitudeOfLander;
		this.amountOfFuel = amountOfFuel;
		this.massOfLanderWhenNoFuel = massOfLanderWhenNoFuel;
		this.maxFuelConsumptionRate = maxFuelConsumptionRate;
		this.maxThrustOfLanderEngine = maxThrustOfLanderEngine;
	}

	//set the fuelFlowRate
	public void setCurrent_FuelFlowRate(double fuelFlowRate) {
		this.current_fuelFlowRate = fuelFlowRate;
	}
	
	//return the fuelFlowRate
	public double getCurrent_FuelFlowRate() {
		return current_fuelFlowRate;
	}

	//set the verticalSpeed
	public void setVerticalSpeedOfLander(double verticalSpeed) {
		this.verticalSpeedOfLander = verticalSpeed;
	}
	
	// return the verticalSpeed
	public double getVerticalSpeedOfLander() {
		return verticalSpeedOfLander;
	}

	//set the altitude
	public void setAltitudeOfLander(double altitude) {
		this.altitudeOfLander = altitude;
	}

	//return the altitude
	public double getAltitudeOfLander() {
		return altitudeOfLander;
	}

	//set the amount
	public void setAmountOfFuel(double amount) {
		this.amountOfFuel = amount;
	}
	
	//return the amount
	public double getAmountOfFuel() {
		return amountOfFuel;
	}

	//set the mass
	public void setMassOfLanderWhenNoFuel(double mass) {
		this.massOfLanderWhenNoFuel = mass;
	}
	
	//return the mass
	public double getMassOfLander() {
		return massOfLanderWhenNoFuel;
	}

	//set the maxFuelConsumptionRate
	public void setMaxFuelConsumptionRate(double maxFuelConsumptionRate) {
		this.maxFuelConsumptionRate = maxFuelConsumptionRate;
	}
	
	//return the maxFuelConsumptionRate
	public double getMaxFuelConsumptionRate() {
		return maxFuelConsumptionRate;
	}

	//set the maxThrust
	public void setMaxThrustOfLanderEngine(double maxThrust) {
		this.maxThrustOfLanderEngine = maxThrust;
	}
	
	//return the maxThrust
	public double getMaxThrustOfLanderEngine() {
		return maxThrustOfLanderEngine;
	}

	/**********************************************************************
	 **********************************************************************	
	 the first modification method changes the current fuel flow rate
	 to a new value ranging from 0.0 to 1.0.
	 this value is expressed as a fraction of the maximum fuel flow
	 **********************************************************************
	 ***********************************************************************/
	public void actionPerfomed(ActionEvent e){
	
		this.current_fuelFlowRate = current_fuelFlowRate + 0.01;
		
		Thread t2 = new Thread(this);
		t2.start();
	}
	
	/**********************************************************************
	 **********************************************************************
	The second modification method simulates the passage of 
	a small amount of time. This time, called t, is expressed 
	in seconds and will typically be a small value such as 0.1 seconds.
	The method will update the first four values in the preceding 
	list to reflect the passage of t seconds.
	***********************************************************************
	***********************************************************************/
	public void run(){
		double t = 0;
		boolean y = true;
		while (y) {
			landingFieldPanel.repaint();
			/* if the fuel flow rate is grater than zero and the amount of fuel left
			 * is zero, reset the fuel flow rate to zero*/
			if (this.current_fuelFlowRate  > 0 && this.amountOfFuel == 0){
				this.current_fuelFlowRate = 0.0;
			}
			
			
			/* During t seconds, the velocity of the lander changes by approximately 
			 * this amount (measured in meters/sec): t * ( (f/m)  - 1.62)*/
			double f = this.current_fuelFlowRate * this.maxThrustOfLanderEngine;
			double m = this.massOfLanderWhenNoFuel + this.amountOfFuel;
			this.verticalSpeedOfLander = t * ((f /m) - this.gravity);
			
			/*  During t seconds, the altitude of the lander changes by t * v meters,
			 *  where v is the vertical velocity of the lander 
			 *  (measured in meters/sec with negative values downward).*/
			this.altitudeOfLander = this.altitudeOfLander + (t * this.verticalSpeedOfLander);
			
			/*  During t seconds the amount of remaining fuel is reduced by t * r * c kilograms.
			 *  The value of r is the current fuel flow rate, and c is the maximum 
			 *  fuel consumption (measured in kilograms per second)*/
			double r = this.current_fuelFlowRate;
			double c = this.maxFuelConsumptionRate;
			this.amountOfFuel = this.amountOfFuel - (t * r * c);
			
			/*if the altitude has dropped below zero, then reset both altitude 
			and velocity to zero (indicating that the ship has landed). */
			if (this.altitudeOfLander < 0){
				this.altitudeOfLander = 0;
				this.verticalSpeedOfLander = 0;
				y = false;
			}
			
			/* if the total amount of remaining fuel drops below zero, 
			 * then reset this amount to zero (indicating that we have run out of fuel).*/
			if (this.amountOfFuel < 0){
				this.amountOfFuel = 0;
				y = false;
			}
			System.out.println(df(this.altitudeOfLander) + " m\t\t\t" + 
								df(this.verticalSpeedOfLander) + " m/s\t\t\t "+ df(this.amountOfFuel)
								+"kg\t\t\t" + df(t) + " s\n");
			/*LunarData data = new LunarData(this.verticalSpeedOfLander, this.altitudeOfLander);
			datalist.addData(data);
			*/
			t = t+0.1;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	
	
	if (this.amountOfFuel == 0){
		System.out.println("we have run out of fuel");
	}

	if (this.altitudeOfLander == 0){
		
		System.out.println("Landed successfully");
		
	}
	}
	/*public Class<? extends LunarList> getData(){
		datalist.getClass();
		return datalist.getClass();
	}*/
	
	public String df(double x){
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(x);
		
	}


}
