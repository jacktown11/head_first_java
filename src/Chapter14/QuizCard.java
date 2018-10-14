package Chapter14;

import java.io.*;

public class QuizCard implements Serializable{
	private String answer;
	private String question;

	public QuizCard(String qs, String ans) {
			answer = ans;
			question = qs;		
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestion() {
		return question;
	}
}

