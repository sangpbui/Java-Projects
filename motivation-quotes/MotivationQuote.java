// Motivation Quote

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MotivationQuote extends JFrame implements ActionListener {
	private static final EasySound ding = new EasySound("ding.wav");

	// Declare an array of "fortunes" (strings):
	String[] fortunes = {"Hope but never expect, look forward but never wait.", 
						"Just because it took you longer, doesn't mean you failed. Remember that!", 
						"Overthinking kills happiness.", 
						"In the end, we only regret the chance that we didn't take.",
						"Sometimes, you need to step outside, get some fresh air, and remind yourself \n"
						+ "who you are and who you want to be.",
						"The first to apologize is the bravest. The first to forgive is the strongest. \n"
						+ "The first to forgive is the happiness",
						"Sometimes your heart needs more time to accept what your mind already knows.",
						"I'm thankful for my struggle because without it I wouldn't have stumbled across my strength",
						"Trust takes years to build, seconds to break and forever to repair!",
						"Be with some one who brings out the best in you, not the stress in you",
						"It hurts when you are being ignored by the person whose attention is the only thing you want in the world",
						"At some point, you have to realize that some people can stay in your heart but not in your life",
						"The most fucked up joke the universe will play on you is letting you meet the right person at the wrong time",
						"Accept it, change it, leave it. If you can't accept it, change it. If you can't change it, then leave it",
						"The people that are quick to walk away are the ones who never intended to stay",
						"Sometimes, it's not the person you miss. It's the feeling you had when you were them"};

	private JTextField display;

	public MotivationQuote() {
		super("Motivation Quote");

		display = new JTextField("  Press \"Next\" to find your motivation...", 60);
		display.setBackground(Color.WHITE);
		display.setEditable(true);

		JButton go = new JButton("Next");
		go.addActionListener(this);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(display);
		c.add(go);
	}

	public void actionPerformed(ActionEvent e) {
		// Pick and display a random fortune:
		String fortune = fortunes[(int) (fortunes.length * Math.random())];
		display.setText("  " + fortune);
		ding.play();
	}

	public static void main(String[] args) {
		JFrame window = new MotivationQuote();
		window.setBounds(400, 400, 750, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
}