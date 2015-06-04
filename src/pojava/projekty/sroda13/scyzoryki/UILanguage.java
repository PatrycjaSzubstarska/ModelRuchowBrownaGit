package pojava.projekty.sroda13.scyzoryki;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class UILanguage extends JFrame
{
	JRadioButton setPolishButton, setEnglishButton;

	public UILanguage() throws HeadlessException
	{
		super("Model ruchów Browna");
		setSize(100, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3, 1));
		setLocationRelativeTo(null);

		JLabel languageChoosingLabel = new JLabel("Choose language:");
		languageChoosingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(languageChoosingLabel);

		setPolishButton = new JRadioButton("Polish");
		setPolishButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(setPolishButton);

		setEnglishButton = new JRadioButton("English");
		setEnglishButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(setEnglishButton);
	}

	public static void main(String[] args)
	{
		UILanguage uIL = new UILanguage();
		uIL.setVisible(true);
	}
}
