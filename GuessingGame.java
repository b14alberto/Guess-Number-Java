package proyectopoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGame extends JFrame implements ActionListener {

    private int randomNumber;
    private int guessesRemaining = 7;
    private JLabel guessLabel, resultLabel, remainingLabel;
    private JTextField guessField;
    private JButton guessButton, newGameButton;

    public GuessingGame() {
        setTitle("Guessing Game");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        guessLabel = new JLabel("Enter your guess:");
        add(guessLabel);

        guessField = new JTextField(10);
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        add(guessButton);

        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        add(newGameButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        remainingLabel = new JLabel("Guesses remaining: " + guessesRemaining);
        add(remainingLabel);

        randomNumber = (int)(Math.random() * 100) + 1; // Generate a random number between 1 and 100
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            int guess = Integer.parseInt(guessField.getText());

            if (guess == randomNumber) {
                resultLabel.setText("You win!");
                guessButton.setEnabled(false);
                guessField.setEnabled(false);
            } else if (guess < randomNumber) {
                resultLabel.setText("Too low!");
                guessesRemaining--;
            } else {
                resultLabel.setText("Too high!");
                guessesRemaining--;
            }

            remainingLabel.setText("Guesses remaining: " + guessesRemaining);

            if (guessesRemaining == 0) {
                resultLabel.setText("You lose! The number was " + randomNumber + ".");
                guessButton.setEnabled(false);
                guessField.setEnabled(false);
            }
        } else if (e.getSource() == newGameButton) {
            randomNumber = (int)(Math.random() * 100) + 1;
            guessesRemaining = 7;
            guessButton.setEnabled(true);
            guessField.setEnabled(true);
            guessField.setText("");
            resultLabel.setText("");
            remainingLabel.setText("Guesses remaining: " + guessesRemaining);
        }
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.setVisible(true);
    }
}
