package org.femoto.click;

import java.util.List;

public class Question {

	private int id;
	private String Description;
	private String correctAnswer;
	private List<String> options;
	
	public Question(int id, String description, String correctAnswer, List<String> options) {
		super();
		this.id = id;
		this.Description = description;
		this.correctAnswer = correctAnswer;
		this.options = options;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", Description=" + Description + ", correctAnswer=" + correctAnswer + ", options="
				+ options + "]";
	}
	
}
