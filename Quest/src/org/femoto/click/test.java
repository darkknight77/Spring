package org.femoto.click;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuestService service= new QuestService();
		System.out.println(service.getallquestions());
		System.out.println(service.getquestion(3));
		
		
		
	}

}
