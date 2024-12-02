import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Collections;

public class CardGameGUI extends JFrame {
    private Deck deck;
    private ArrayList<Card> drawnCards;
    private JTextArea displayArea;
    private JPanel imagePanel;
    private JButton drawButton;
    private JButton shuffleButton;
    private JButton sortButton;
    private JButton restartButton;
    private JButton remainingCardsButton; // New button for remaining cards
    private final int MAX_CARDS = 20; // Maximum number of cards to draw

    public CardGameGUI() {
        setTitle("Card Deck Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        deck = new Deck();
        deck.shuffle();
        drawnCards = new ArrayList<>();

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.NORTH);

        imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Layout for displaying images in sequence
        add(imagePanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 5));

        drawButton = new JButton("Draw Card");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawCard();
            }
        });

        shuffleButton = new JButton("Shuffle Deck");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuffleDeck();
            }
        });

        sortButton = new JButton("Sort Drawn Cards");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortDrawnCards();
            }
        });

        restartButton = new JButton("Restart Game");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        remainingCardsButton = new JButton("Remaining Cards"); // New button for remaining cards
        remainingCardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRemainingCards();
            }
        });

        controlPanel.add(drawButton);
        controlPanel.add(shuffleButton);
        controlPanel.add(sortButton);
        controlPanel.add(restartButton);
        controlPanel.add(remainingCardsButton); // Add the new button to the control panel
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void drawCard() {
        if (drawnCards.size() >= MAX_CARDS) {
            displayArea.append("Only " + MAX_CARDS + " cards can be drawn.\n");
            return;
        }

        Card card = deck.drawCard();
        if (card != null) {
            drawnCards.add(card);
            displayArea.append("Drawn: " + card.toString() + "\n");
            displayCardImage(card); // Display the drawn card
        } else {
            displayArea.append("No cards left in the deck!\n");
        }
    }

    private void shuffleDeck() {
        deck.shuffle();
        displayArea.append("Deck shuffled.\n");
    }

    private void sortDrawnCards() {
        Collections.sort(drawnCards, new CardComparator());
        displayArea.append("Drawn cards sorted:\n");
        displayAllDrawnCards(); // Display all drawn cards in sequence
    }

    private void displayCardImage(Card card) {
        ImageIcon cardImage = new ImageIcon(resizeImage(card.getImagePath(), 100, 140)); // Resize to 100x140 pixels
        JLabel imageLabel = new JLabel(cardImage);
        imagePanel.add(imageLabel);
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    private void displayAllDrawnCards() {
        imagePanel.removeAll();
        for (Card card : drawnCards) {
            ImageIcon cardImage = new ImageIcon(resizeImage(card.getImagePath(), 100, 140)); // Resize to 100x140 pixels
            JLabel imageLabel = new JLabel(cardImage);
            imagePanel.add(imageLabel);
        }
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    private Image resizeImage(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();

            return resizedImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void restartGame() {
        deck = new Deck(); // Reset the deck
        deck.shuffle(); // Shuffle the new deck
        drawnCards.clear(); // Clear drawn cards
        displayArea.setText(""); // Clear the display area
        imagePanel.removeAll(); // Clear the image panel
        displayArea.append("Game restarted. Deck is shuffled and ready to go.\n");
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    private void showRemainingCards() {
        int remaining = deck.getDeckSize();
        displayArea.append("Remaining cards in the deck: " + remaining + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CardGameGUI gui = new CardGameGUI();
                gui.setVisible(true);
            }
        });
    }
}
