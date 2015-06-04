package pojava.projekty.sroda13.scyzoryki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class ParticleAnimation extends JPanel implements Runnable
{
	public Thread animationThread;
	public boolean animationThreadSuspended;
	List<GasParticle> particles;
	int numberOfParticles;
	Random random;
	Box box;

	public ParticleAnimation()
	{
		super();
		particles = new ArrayList<GasParticle>();
		setBackground(Color.WHITE);
		box = new Box(485.0, 380.0); // Approximate dimensions of drawingPanel
	}

	public void addParticle(int n)
	{
		numberOfParticles = (n + 1);
		GasParticle particle;

		for (int ii = 0; ii < numberOfParticles; ii++)
		{
			particle = new GasParticle(1E-24, 293.15, 1E-9); // Particle's mass
			// and
			// temperature
			// are needed
			// only to
			// construct
			// particle
			// right now.
			particle.radiusM *= 2E9; // In other case it wouldn't be visible.
			particle.velocityXMperS = (particle.velocityXMperS / 100);
			particle.velocityYMperS = (particle.velocityYMperS / 100); // Velocity
			// is
			// about
			// 5 *
			// 10^2

			if (ii == 0)
			{
				particle.massKg *= 100;
				particle.velocityXMperS = 0;
				particle.velocityYMperS = 0;
				particle.centerOfMassXM = (485.0 / 2);
				particle.centerOfMassYM = (380.0 / 2);
				particle.radiusM *= 10;
			}

			particles.add(particle);
		}

		repaint();
	}

	public void paintComponent(Graphics graphics)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;

		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(0, 0, ((int) (box.sizeX)), ((int) (box.sizeY)));

		GasParticle ballTemp;

		for (int jj = 0; jj < numberOfParticles; jj++)
		{
			ballTemp = particles.get(jj);

			if (jj == 0)
			{
				graphics2D.setColor(Color.YELLOW);
			}

			else
			{
				graphics2D.setColor(Color.BLUE);
			}

			graphics2D.fillOval(
					((int) (ballTemp.centerOfMassXM - ballTemp.radiusM)),
					((int) (ballTemp.centerOfMassYM - ballTemp.radiusM)),
					((int) (2 * ballTemp.radiusM)),
					((int) (2 * ballTemp.radiusM)));
		}
	}

	void collision()
	{
		double tempX1, tempX2, tempY1, tempY2, tempR1, tempR2, tempVX1, tempVX2, tempVY1, tempVY2, tempM1, tempM2;

		double newTempVX1, newTempVX2, newTempVY1, newTempVY2;

		boolean xL, xR, yB, yT;

		GasParticle testOval1, testOval2;

		for (int kk = 0; kk < numberOfParticles; kk++)
		{
			testOval1 = particles.get(kk);

			tempX1 = testOval1.getcenterOfMassXM();
			tempY1 = testOval1.getcenterOfMassYM();
			newTempVX1 = tempVX1 = testOval1.getvelocityXMperS();
			newTempVY1 = tempVY1 = testOval1.getvelocityYMperS();
			tempR1 = testOval1.getradiusM();
			tempM1 = testOval1.getmassKg();

			for (int ll = 0; ll < numberOfParticles; ll++) {
				if (kk == ll)
				{
					continue;
				}

				testOval2 = particles.get(ll);
				newTempVX2 = tempVX2 = testOval2.getvelocityXMperS();
				newTempVY2 = tempVY2 = testOval2.getvelocityYMperS();

				tempX2 = testOval2.getcenterOfMassXM();
				tempY2 = testOval2.getcenterOfMassYM();
				tempR2 = testOval2.getradiusM();
				tempM2 = testOval2.getmassKg();

				xL = (tempX1 + tempR1 + tempVX1) >= (tempX2 + tempVX2);
				xR = (tempX1 + tempVX1) <= (tempX2 + tempR2 + tempVX2);
				yB = (tempY1 + tempVY1) <= (tempY2 + tempR2 + tempVY2);
				yT = (tempY1 + tempR1 + tempVY1) >= (tempY2 + tempVY2);

				if (xL && xR && yB && yT)
				{
					if ((tempX1 + tempR1) < (tempX2) && xL)
					{
						newTempVX1 = (tempVX1 * (tempM1 - tempM2) + 2 * tempM2
								* tempVX2)
								/ (tempM1 + tempM2);
						newTempVX2 = (tempVX2 * (tempM2 - tempM1) + 2 * tempM1
								* tempVX1)
								/ (tempM1 + tempM2);
					}

					if ((tempX1) > (tempX2 + tempR2) && xR)
					{
						newTempVX1 = (tempVX1 * (tempM1 - tempM2) + 2 * tempM2
								* tempVX2)
								/ (tempM1 + tempM2);
						newTempVX2 = (tempVX2 * (tempM2 - tempM1) + 2 * tempM1
								* tempVX1)
								/ (tempM1 + tempM2);
					}

					if ((tempY1 + tempR1) < (tempY2) && yT)
					{
						newTempVY1 = (tempVY1 * (tempM1 - tempM2) + 2 * tempM2
								* tempVY2)
								/ (tempM1 + tempM2);
						newTempVY2 = (tempVY2 * (tempM2 - tempM1) + 2 * tempM1
								* tempVX1)
								/ (tempM1 + tempM2);
					}

					if ((tempY1) > (tempY2 + tempR2) && yB)
					{
						newTempVY1 = (tempVY1 * (tempM1 - tempM2) + 2 * tempM2
								* tempVY2)
								/ (tempM1 + tempM2);
						newTempVY2 = (tempVY2 * (tempM2 - tempM1) + 2 * tempM1
								* tempVX1)
								/ (tempM1 + tempM2);
					}
				}

				testOval2.setvelocityXMperS(newTempVX2);
				testOval2.setvelocityYMperS(newTempVY2);

				particles.set(ll, testOval2);
			}

			if ((tempY1 + tempR1) > box.sizeY)
			{
				newTempVY1 = -newTempVY1;
			}

			if ((tempY1 - tempR1) < 0)
			{
				newTempVY1 = -newTempVY1;
			}

			if ((tempX1 - tempR1) < 0)
			{
				newTempVX1 = -newTempVX1;
			}

			if ((tempX1 + tempR1) > box.sizeX)
			{
				newTempVX1 = -newTempVX1;
			}

			tempX1 = tempX1 + newTempVX1;
			tempY1 = tempY1 + newTempVY1;

			testOval1.setcenterOfMassXM(tempX1);
			testOval1.setcenterOfMassYM(tempY1);
			testOval1.setvelocityXMperS(newTempVX1);
			testOval1.setvelocityYMperS(newTempVY1);
			testOval1.setradiusM(tempR1);

			particles.set(kk, testOval1);
		}
	}

	@Override
	public void run()
	{
		while (animationThread != null)
		{
			try {
				Thread.sleep(10);

				while (animationThreadSuspended)
				{
					Thread.sleep(50);
				}
			}

			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			collision();
			repaint();
		}
	}

	public void start()
	{
		if (animationThread == null)
		{
			animationThread = new Thread(this);
			animationThread.start();
			animationThreadSuspended = false;
		}
	}

	public void stop()
	{
		if (animationThread != null)
		{
			animationThread = null;
		}
	}
}
