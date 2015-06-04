package pojava.projekty.sroda13.scyzoryki;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class UI extends JFrame
{
	JSlider bigParticlesRadiusSlider, bigParticlesMassSlider,
	gasParticlesAmountSlider, gasParticlesTemperatureSlider,
	gasParticlesMassSlider;
	JButton startButton, pauseButton, resetButton, saveAsImageButton;
	JCheckBox bigParticlesSetVisibleCheckBox,
	bigParticlesMovesTrackSetVisibleCheckBox,
	gasParticlesSetVisibleCheckBox;
	ParticleAnimation particleAnimation;
	int particlesNumber = 100;


	void drawingPanelCreator(JPanel panel)
	{
		particleAnimation = new ParticleAnimation();
		panel.add(particleAnimation);
	}

	void toolsButtonPanelCreator(JPanel panel)
	{
		JPanel toolsButtonsPanel = new JPanel(new GridLayout(1, 3));
		startButton = new JButton("Start");
		pauseButton = new JButton("Pauza");
		resetButton = new JButton("Reset");
		toolsButtonsPanel.add(startButton);
		toolsButtonsPanel.add(pauseButton);
		toolsButtonsPanel.add(resetButton);
		panel.add(toolsButtonsPanel);

		pauseButton.addActionListener(new StopAction(particleAnimation));
		startButton.addActionListener(new StartAction(particleAnimation,
				particlesNumber));
	}

	void bigParticlesRadiusPanelCreator(JPanel panel)
	{
		JPanel bigParticlesRadiusPanel = new JPanel(new BorderLayout());
		JLabel bigParticlesRadiusLabel = new JLabel(" Promieñ: [nm] ");
		bigParticlesRadiusSlider = new JSlider();
		bigParticlesRadiusPanel.add(bigParticlesRadiusLabel, BorderLayout.WEST);
		bigParticlesRadiusPanel
		.add(bigParticlesRadiusSlider, BorderLayout.EAST);
		panel.add(bigParticlesRadiusPanel);
	}

	void bigParticlesMassPanelCreator(JPanel panel)
	{
		JPanel bigParticlesMassPanel = new JPanel(new BorderLayout());
		JLabel bigParticlesMassLabel = new JLabel(" Masa: [kg] ");
		bigParticlesMassSlider = new JSlider();
		bigParticlesMassPanel.add(bigParticlesMassLabel, BorderLayout.WEST);
		bigParticlesMassPanel.add(bigParticlesMassSlider, BorderLayout.EAST);
		panel.add(bigParticlesMassPanel);
	}

	void gassParticlesAmountPanelCreator(JPanel panel)
	{
		JPanel gasParticlesAmountPanel = new JPanel(new BorderLayout());
		JLabel gasParticlesAmountLabel = new JLabel(" Iloœæ: ");
		gasParticlesAmountSlider = new JSlider();
		gasParticlesAmountPanel.add(gasParticlesAmountLabel, BorderLayout.WEST);
		gasParticlesAmountPanel
		.add(gasParticlesAmountSlider, BorderLayout.EAST);
		panel.add(gasParticlesAmountPanel);
	}

	void gassParticlesTemperaturePanelCreator(JPanel panel)
	{
		JPanel gasParticlesTemperaturePanel = new JPanel(new BorderLayout());
		JLabel gasParticlesTemperatureLabel = new JLabel(" Temperatura: [K] ");
		gasParticlesTemperatureSlider = new JSlider();
		gasParticlesTemperaturePanel.add(gasParticlesTemperatureLabel,
				BorderLayout.WEST);
		gasParticlesTemperaturePanel.add(gasParticlesTemperatureSlider,
				BorderLayout.EAST);
		panel.add(gasParticlesTemperaturePanel);
	}

	void gassParticlesMassPanelCreator(JPanel panel)
	{
		JPanel gasParticlesMassPanel = new JPanel(new BorderLayout());
		JLabel gasParticlesMassLabel = new JLabel(" Masa: [kg] ");
		gasParticlesMassSlider = new JSlider();
		gasParticlesMassPanel.add(gasParticlesMassLabel, BorderLayout.WEST);
		gasParticlesMassPanel.add(gasParticlesMassSlider, BorderLayout.EAST);
		panel.add(gasParticlesMassPanel);
	}

	void toolsPanelCreator(JPanel panel)
	{
		JPanel toolsPanel = new JPanel(new GridLayout(8, 1));
		JLabel bigParticlesPropertiesLabel = new JLabel(
				" W³aœciwoœci du¿ej cz¹stki:");
		bigParticlesPropertiesLabel
		.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel gasParticlesPropertiesLabel = new JLabel(
				" W³aœciwoœci cz¹stek gazu:");
		gasParticlesPropertiesLabel
		.setHorizontalAlignment(SwingConstants.CENTER);
		toolsButtonPanelCreator(toolsPanel);
		toolsPanel.add(bigParticlesPropertiesLabel);
		bigParticlesRadiusPanelCreator(toolsPanel);
		bigParticlesMassPanelCreator(toolsPanel);
		toolsPanel.add(gasParticlesPropertiesLabel);
		gassParticlesAmountPanelCreator(toolsPanel);
		gassParticlesTemperaturePanelCreator(toolsPanel);
		gassParticlesMassPanelCreator(toolsPanel);
		panel.add(toolsPanel, BorderLayout.EAST);
	}

	void topPanelCreator()
	{
		JPanel topPanel = new JPanel(new BorderLayout());
		drawingPanelCreator(topPanel);
		toolsPanelCreator(topPanel);
		this.add(topPanel, BorderLayout.CENTER);
	}

	void bottomLeftPanelCreator(JPanel panel)
	{
		JPanel bottomLeftPanel = new JPanel(new GridLayout(2, 3));
		JLabel bigParticlesSetVisibleLabel = new JLabel("Du¿a cz¹stka");
		bigParticlesSetVisibleLabel
		.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel bigParticlesMovesTrackSetVisibleLabel = new JLabel(
				"Tor ruchu du¿ej cz¹stki");
		bigParticlesMovesTrackSetVisibleLabel
		.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel gasParticlesSetVisibleLabel = new JLabel("Cz¹stki gazu");
		gasParticlesSetVisibleLabel
		.setHorizontalAlignment(SwingConstants.CENTER);
		bigParticlesSetVisibleCheckBox = new JCheckBox();
		bigParticlesMovesTrackSetVisibleCheckBox = new JCheckBox();
		gasParticlesSetVisibleCheckBox = new JCheckBox();
		bottomLeftPanel.add(bigParticlesSetVisibleLabel);
		bottomLeftPanel.add(bigParticlesMovesTrackSetVisibleLabel);
		bottomLeftPanel.add(gasParticlesSetVisibleLabel);
		bigParticlesSetVisibleCheckBox
		.setHorizontalAlignment(SwingConstants.CENTER);
		bigParticlesMovesTrackSetVisibleCheckBox
		.setHorizontalAlignment(SwingConstants.CENTER);
		gasParticlesSetVisibleCheckBox
		.setHorizontalAlignment(SwingConstants.CENTER);
		bottomLeftPanel.add(bigParticlesSetVisibleCheckBox);
		bottomLeftPanel.add(bigParticlesMovesTrackSetVisibleCheckBox);
		bottomLeftPanel.add(gasParticlesSetVisibleCheckBox);
		panel.add(bottomLeftPanel, BorderLayout.WEST);
	}

	void bottomBottomPanelCreator(JPanel panel)
	{
		JPanel bottomBottomPanel = new JPanel(new BorderLayout());
		saveAsImageButton = new JButton("Eksportuj jako obraz");
		bottomBottomPanel.add(saveAsImageButton, BorderLayout.EAST);
		bottomLeftPanelCreator(bottomBottomPanel);
		panel.add(bottomBottomPanel);
	}

	void bottomPanelCreator()
	{
		JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
		JLabel setVisibleLabel = new JLabel(
				" Elementy widoczne podczas wizualizacji:");
		bottomPanel.add(setVisibleLabel);
		bottomBottomPanelCreator(bottomPanel);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}

	public UI() throws HeadlessException
	{
		super("Model ruchów Browna");
		setSize(800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		topPanelCreator();
		bottomPanelCreator();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args)
	{
		UI uI = new UI();
		uI.setVisible(true);
	}
}