package org.femoto.click;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QuestService {
	
	private static List<Question> questions;
	
	static{
		//""
	 
		Question q1=new Question(1,"What is the largest country in the world?" ,"i dont know", Arrays.asList("i know but i wont tell","i dont know","whatever","why should i tell you"));
		Question q2=new Question(2,"Who r u?" ,"shut the fuck up", Arrays.asList("i know but i wont tell","i dont know","shut the fuck up","why should i tell you"));
		Question q3=new Question(3,"How r u ?" ,"im awesome", Arrays.asList("im awesome","i dont know","whatever","why should i tell you"));
        questions=new ArrayList<>(Arrays.asList(q1,q2,q3));
	}
	
	public static List<Question> getallquestions()
	{
	
		return questions;
		
	}
	
	public static Question getquestion(int id)
	{
		for(Question q:questions)
		{
			if(q.getId()==id)
				return q;
		}
		return null;
	}
	
	
	

}
