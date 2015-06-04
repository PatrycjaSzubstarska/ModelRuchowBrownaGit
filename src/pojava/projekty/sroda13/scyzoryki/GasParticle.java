package pojava.projekty.sroda13.scyzoryki;

import java.util.Random;

public class GasParticle
{
	double massKg, temperatureK, velocityXMperS, velocityYMperS,
	centerOfMassXM, centerOfMassYM, radiusM;

	public GasParticle(double massSet, double temperatureSet, double radiusSet)
	{
		massKg = massSet;
		temperatureK = temperatureSet;
		radiusM = radiusSet;
		Random randomTemp = new Random();

		int randomInt;
		randomInt = randomTemp.nextInt(48501);
		centerOfMassXM = (randomInt / 100);
		randomInt = randomTemp.nextInt(38001);
		centerOfMassYM = (randomInt / 100);

		double aVariable = Math.sqrt(((1.38 * (10E-23)) * temperatureK)
				/ massKg);
		double maxwellMean = (2 * aVariable * Math.sqrt((2 / Math.PI)));
		double maxwellVariance = ((aVariable * aVariable * (3 * Math.PI - 8)) / Math.PI);

		velocityXMperS = ((randomTemp.nextGaussian())
				* Math.sqrt(maxwellVariance) + maxwellMean);
		velocityYMperS = ((randomTemp.nextGaussian())
				* Math.sqrt(maxwellVariance) + maxwellMean);

		if(randomTemp.nextBoolean())
			velocityXMperS = -velocityXMperS;

		if(randomTemp.nextBoolean())
			velocityYMperS = -velocityYMperS;
	}

	public double getcenterOfMassXM()
	{
		return centerOfMassXM;
	}

	public void setcenterOfMassXM(double centerOfMassXM)
	{
		this.centerOfMassXM = centerOfMassXM;
	}

	public double getcenterOfMassYM()
	{
		return centerOfMassYM;
	}

	public void setcenterOfMassYM(double centerOfMassYM)
	{
		this.centerOfMassYM = centerOfMassYM;
	}

	public double getradiusM()
	{
		return radiusM;
	}

	public void setradiusM(double radiusM)
	{
		this.radiusM = radiusM;
	}

	public double getvelocityXMperS()
	{
		return velocityXMperS;
	}

	public void setvelocityXMperS(double velocityXMperS)
	{
		this.velocityXMperS = velocityXMperS;
	}

	public double getvelocityYMperS()
	{
		return velocityYMperS;
	}

	public void setvelocityYMperS(double velocityYMperS)
	{
		this.velocityYMperS = velocityYMperS;
	}

	public double getmassKg()
	{
		return massKg;
	}
}
