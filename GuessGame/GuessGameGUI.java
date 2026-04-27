import javax.swing.*;
import java.awt.event.*;

public class GuessGameGUI {

    static int number = (int)(Math.random() * 100) + 1;
    static int attempts = 0;
    static int maxAttempts = 5;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Guess Number (1-100)");
        title.setBounds(90, 10, 200, 20);
        frame.add(title);

        JTextField input = new JTextField();
        input.setBounds(80, 40, 180, 25);
        frame.add(input);

        JButton guessBtn = new JButton("Guess");
        guessBtn.setBounds(120, 70, 100, 30);
        frame.add(guessBtn);

        JLabel result = new JLabel("");
        result.setBounds(80, 110, 250, 20);
        frame.add(result);

        JLabel attemptsLabel = new JLabel("Attempts left: 5");
        attemptsLabel.setBounds(80, 130, 200, 20);
        frame.add(attemptsLabel);

        JButton restartBtn = new JButton("Restart");
        restartBtn.setBounds(120, 160, 100, 30);
        frame.add(restartBtn);

        // Guess button logic
        guessBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(input.getText());
                    attempts++;

                    if (guess < number) {
                        result.setText("Too Low!");
                    } else if (guess > number) {
                        result.setText("Too High!");
                    } else {
                        int score = 100 - (attempts * 10);
                        result.setText("Correct! Score: " + score);
                    }

                    int left = maxAttempts - attempts;
                    attemptsLabel.setText("Attempts left: " + left);

                    if (attempts >= maxAttempts && guess != number) {
                        result.setText("Game Over! Number was: " + number);
                    }

                    input.setText("");

                } catch (Exception ex) {
                    result.setText("Enter valid number!");
                }
            }
        });

        // Restart button logic
        restartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                number = (int)(Math.random() * 100) + 1;
                attempts = 0;
                result.setText("");
                attemptsLabel.setText("Attempts left: 5");
                input.setText("");
            }
        });

        frame.setVisible(true);
    }
}
