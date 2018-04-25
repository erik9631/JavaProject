package tests;

public class CPlusTest implements ITest
{
	private Test test;
	private final int testId = 1003;
	
	public CPlusTest()
	{
		test = new Test(false, testId);
		test.setName("C++ Test");
		
		QuestionPanel question1 = new QuestionPanel(false, testId);
		question1.setQuestion("Co umoznuje destruktor");
		question1.setAnswers("Poupratovanie triedy po jej zavloani", "Znicenie kodu aby nebol citatelny", "Cisti bufer vstupov",
							"Ani jedno");
		question1.setCorrectAnswer(0);
		
		QuestionPanel question2 = new QuestionPanel(false, testId);
		question2.setQuestion("Ktore tvrdenie o namespace je pravdive");
		question2.setAnswers("Vsetky premenne deklaraovane v namespacu su pristupne",
							 "Namespace je spristupnitenlny cez \"::\"", "Umoznuje pomenovanie tried",
							"Using namespace vnuti vyuzitie daneho namespacu");
		question2.setCorrectAnswer(1);
		
		QuestionPanel question3 = new QuestionPanel(false, testId);
		question3.setQuestion("Ktory datovy typ v C++ umoznuje ukladanie unikode charov");
		question3.setAnswers("Unsigned char",
							 "Int", "wchar_t",
							"Ani jedna moznost");
		question3.setCorrectAnswer(2);		
		
		test.addQuestion(question3);
		test.addQuestion(question2);
		test.addQuestion(question1);
		
		
		
	}
	
	@Override
	public Test getTest()
	{
		// TODO Auto-generated method stub
		return test;
	}

	@Override
	public int getTestId()
	{
		// TODO Auto-generated method stub
		return testId;
	}

}
