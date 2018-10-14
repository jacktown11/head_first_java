package Chapter14;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class QuizCardBuilder {
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame fr;
	
	public static void main(String[] args) {
		QuizCardBuilder qcb = new QuizCardBuilder();
		qcb.go();
	}
	public void go() {
		fr = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		question = new JTextArea(6, 20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		answer = new JTextArea(6, 20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		
		JScrollPane aScroller = new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		nextButton.addActionListener(new NextCardListener());
		
		cardList = new ArrayList<QuizCard>();
		
		JLabel qlabel = new JLabel("question");
		JLabel alabel = new JLabel("answer");
		
		mainPanel.add(qlabel);
		mainPanel.add(qScroller);
		mainPanel.add(alabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("file");
		JMenuItem newMenuItem = new JMenuItem("new");
		newMenuItem.addActionListener(new NewMenuListener());
		JMenuItem saveMenuItem = new JMenuItem("save");
		saveMenuItem.addActionListener(new SaveMenuListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		
		fr.setJMenuBar(menuBar);
		fr.getContentPane().add(BorderLayout.CENTER,mainPanel);
		fr.setSize(500, 600);
		fr.setVisible(true);
	}
	
	private class NextCardListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			QuizCard  qc = new QuizCard(question.getText(), answer.getText());
			cardList.add(qc);
			clearCard();
		}
	}
	private class SaveMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			QuizCard  qc = new QuizCard(question.getText(), answer.getText());
			cardList.add(qc);

			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(fr);
			saveFile(fileSave.getSelectedFile());
		}		
	}
	private class NewMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cardList.clear();
			clearCard();
		}

	}
	private void saveFile(File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(QuizCard card : cardList) {
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");	
			}
			writer.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void clearCard() {
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
}
