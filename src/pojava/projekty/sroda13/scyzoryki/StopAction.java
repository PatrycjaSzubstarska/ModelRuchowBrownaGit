package pojava.projekty.sroda13.scyzoryki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StopAction implements ActionListener
{
	ParticleAnimation animation;

	public StopAction(ParticleAnimation particleAnimation)
	{
		animation = particleAnimation;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		animation.stop();
	}
}
