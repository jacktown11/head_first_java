package Chapter14;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class QuizCardPlayer {
	private JTextArea display;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame fr;
	private JButton nextButton;
	private boolean isShowAnswer = true;
	
	public static void main(String[] args) {
		QuizCardPlayer qcp = new QuizCardPlayer();
		qcp.go();
	}
	
	public void go() {
		fr = new JFrame("Quiz Card Player");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		
		display = new JTextArea(10, 20);
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setEditable(false);
		
		
		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Answer");
		nextButton.addActionListener(new NextCardListener());
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("file");
		JMenuItem loadMenuItem = new JMenuItem("load");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		
		fr.setJMenuBar(menuBar);
		fr.getContentPane().add(BorderLayout.CENTER,mainPanel);
		fr.setSize(500, 600);
		fr.setVisible(true);
	}
	private class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(isShowAnswer) {
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}else {
				if(currentCardIndex < cardList.size()) {
					showNextCard();
				}else {
					display.setText("There is no more card");
					nextButton.setEnabled(false);
				}
			}
		}
	}
	private class OpenMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(fr);
			loadFile(fileOpen.getSelectedFile());
			if(cardList.size() > 0) {
				showNextCard();
			}
		}
	}
	private void loadFile(File file) {
		cardList = new ArrayList<QuizCard>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while((line = reader.readLine()) != null) {
				QuizCard qc = makeCard(line);
				cardList.add(qc);
			}
			reader.close();
		}catch(Exception ex) {
			System.out.println("Couldn't read the card file.");
			ex.printStackTrace();
		}
	}
	private QuizCard makeCard(String lineToParse) {
		String[] result = lineToParse.split("/");
		return new QuizCard(result[0], result[1]);
	}
	private void showNextCard() {
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}
	
}
