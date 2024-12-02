*Card Deck Game*

Overview
This project is a Java-based card deck game with a graphical user interface (GUI). It simulates drawing, sorting, and shuffling cards from a standard deck of 52 cards. The game allows users to draw up to 20 cards, shuffle the deck, sort drawn cards, and restart the game. The drawn cards are displayed as images on the GUI.

Features
1. Draw Cards: Draw up to 20 cards from the deck.
2. Shuffle Deck: Shuffle the deck at any time.
3. Sort Drawn Cards: Sort the drawn cards based on suit and rank.
4. Restart Game: Restart the game to shuffle a new deck and clear drawn cards.
5. Card Display: Cards are displayed as images and resized to fit the GUI.


Requirements
Java Development Kit (JDK) 8 or higher
Java Extension Pack installed

Project Structure
1. Card.java: Represents a single card with suit and rank.
2. Deck.java: Manages the deck of cards, including shuffling and drawing.
3. CardComparator.java: Custom comparator for sorting cards by color, suit, and rank.
4. CardGameGUI.java: Main GUI class that handles user interactions and displays cards.


Compile the Java Files:

Run in terminal
javac *.java

Run the Application:

Run in terminal
java CardGameGUI


Usage
* Draw Card Button: Draw a card from the deck and display it.
* Shuffle Deck Button: Shuffle the deck to reset the order of cards.
* Sort Drawn Cards Button: Sort and display the drawn cards in sequence.
* Restart Game Button: Restart the game, shuffle a new deck, and clear all drawn cards.

Images
Ensure that the card images are placed in the same directory as the CardGameGUI class or adjust the image paths in the code accordingly. The images should follow the naming convention:

* A-S for Ace of Spades
* 4-C for 4 of Clubs
* Q-D for Queen of Diamonds
* K-H for King of Hearts
And so on...


Example Image Naming
* Ace of Spades: A-S.png
* 4 of Clubs: 4-C.png
* Queen of Diamonds: Q-D.png
* King of Hearts: K-H.png


Code Explanation
1. Card Class: Defines the properties and methods for a playing card.
2. Deck Class: Handles the deck of 52 cards, including shuffling and drawing.
3. CardComparator Class: Provides a way to sort cards by color, suit, and rank.
4. CardGameGUI Class: The main GUI application that allows interaction with the deck and displays cards.

Troubleshooting
* No Images Displayed: Ensure the image paths are correct and that the image files are in the expected directory.
* Cards Not Resizing Properly: Adjust the dimensions in the resizeImage method to better fit your display requirements.