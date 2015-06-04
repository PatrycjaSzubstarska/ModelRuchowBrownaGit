package pojava.projekty.sroda13.scyzoryki;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SavingResultsToFiles
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out
				.println("Podaj parametry czastki gazu - mase oraz temperature: ");
		Scanner input = new Scanner(System.in);
		double mass, temperature, radius;
		mass = input.nextDouble();
		temperature = input.nextDouble();
		radius = 1.0; // It's needles in this class.

		GasParticle trialParticle = new GasParticle(mass, temperature, radius);
		Box squareBox = new Box(100.0, 100.0);
		double timeS = 0.0;

		PrintWriter resultsOfSimulationTime = new PrintWriter("resultsTime.txt");
		PrintWriter resultsOfSimulationX_SM = new PrintWriter("resultsX_SM.txt");
		PrintWriter resultsOfSimulationY_SM = new PrintWriter("resultsY_SM.txt");
		PrintWriter resultsOfSimulationVx = new PrintWriter("resultsVx.txt");
		PrintWriter resultsOfSimulationVy = new PrintWriter("resultsVy.txt");

		System.out
				.println("Wektor polozenia poczatkowego oraz predkosci poczatkowej czastki gazu: ");
		System.out.println("x_sm = " + trialParticle.centerOfMassXM);
		System.out.println("y_sm = " + trialParticle.centerOfMassYM);
		System.out.println("Vx = " + trialParticle.velocityXMperS);
		System.out.println("Vy = " + trialParticle.velocityYMperS);
		resultsOfSimulationTime.println(+timeS);
		resultsOfSimulationX_SM.println(+trialParticle.centerOfMassXM);
		resultsOfSimulationY_SM.println(+trialParticle.centerOfMassYM);
		resultsOfSimulationVx.println(+trialParticle.velocityXMperS);
		resultsOfSimulationVy.println(+trialParticle.velocityYMperS);

		System.out.println("Przystepujemy do symulacji zderzen czastki: ");

		double dTimeS = 10E-6;
		int currentNumberOfCollisions = 0;
		int finalNumberOfCollisions = 0;

		System.out.println("Ile zderzen ma zarejestrowac program? ");
		finalNumberOfCollisions = input.nextInt();

		while (currentNumberOfCollisions < finalNumberOfCollisions)
		{
			timeS += dTimeS;
			trialParticle.centerOfMassXM += (trialParticle.velocityXMperS * dTimeS);
			trialParticle.centerOfMassYM += (trialParticle.velocityYMperS * dTimeS);
			
			if ((trialParticle.centerOfMassXM <= 0)
					|| (trialParticle.centerOfMassXM >= squareBox.sizeX))
			{
				trialParticle.velocityXMperS *= (-1);
				System.out.println("Odbicie nastapilo po czasie: " + timeS);
				System.out.println("x_sm = " + trialParticle.centerOfMassXM);
				System.out.println("y_sm = " + trialParticle.centerOfMassYM);
				System.out.println("Vx = " + trialParticle.velocityXMperS);
				System.out.println("Vy = " + trialParticle.velocityYMperS);
				resultsOfSimulationTime.println(+timeS);
				resultsOfSimulationX_SM.println(+trialParticle.centerOfMassXM);
				resultsOfSimulationY_SM.println(+trialParticle.centerOfMassYM);
				resultsOfSimulationVx.println(+trialParticle.velocityXMperS);
				resultsOfSimulationVy.println(+trialParticle.velocityYMperS);
				currentNumberOfCollisions++;
			}
			
			if ((trialParticle.centerOfMassYM <= 0)
					|| (trialParticle.centerOfMassYM >= squareBox.sizeY))
			{
				trialParticle.velocityYMperS *= (-1);
				System.out.println("Odbicie nastapilo po czasie: " + timeS);
				System.out.println("x_sm = " + trialParticle.centerOfMassXM);
				System.out.println("y_sm = " + trialParticle.centerOfMassYM);
				System.out.println("Vx = " + trialParticle.velocityXMperS);
				System.out.println("Vy = " + trialParticle.velocityYMperS);
				resultsOfSimulationTime.println(+timeS);
				resultsOfSimulationX_SM.println(+trialParticle.centerOfMassXM);
				resultsOfSimulationY_SM.println(+trialParticle.centerOfMassYM);
				resultsOfSimulationVx.println(+trialParticle.velocityXMperS);
				resultsOfSimulationVy.println(+trialParticle.velocityYMperS);
				currentNumberOfCollisions++;
			}
		}

		resultsOfSimulationTime.close();
		resultsOfSimulationX_SM.close();
		resultsOfSimulationY_SM.close();
		resultsOfSimulationVx.close();
		resultsOfSimulationVy.close();
		input.close();
	}
}
