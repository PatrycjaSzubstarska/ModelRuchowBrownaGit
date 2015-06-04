package pojava.projekty.sroda13.scyzoryki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StartAction implements ActionListener
{
	ParticleAnimation animation;
	int number;

	public StartAction(ParticleAnimation particleAnimation, int particlesNumber)
	{
		animation = particleAnimation;
		number = particlesNumber;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		animation.addParticle(number);
		animation.start();
	}
}
