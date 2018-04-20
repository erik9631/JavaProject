package tests;

public class JavaTest implements ITest
{
	Test test;
	final int testId = 1000;
	public JavaTest()
	{
		test = new Test(false, testId);
		QuestionPanel question1 = new QuestionPanel(false, testId);
		question1.setQuestion("Triedy v jazyku C++ majú pôvod v mechanizme: ");
		question1.setAnswers("Union", "Struct", "Template", "Enum");
		question1.setCorrectAnswer(1);
		
		QuestionPanel question2 = new QuestionPanel(false, testId);
		question2.setQuestion("Co v jazyku C# zodpoveda pristupovym metodam v jazyku Java");
		question2.setAnswers("Setter", "Delegate", "Accessor", "Property");
		question2.setCorrectAnswer(2);

		
		QuestionPanel question3 = new QuestionPanel(false, testId);
		question3.setQuestion("Co v jazyku C++ umoznuje emulovat spravanie rozhrani v jazyku java");
		question3.setAnswers("Virtualne metody", "Abstraktne triedy", "Namespace", "Ine");
		question3.setCorrectAnswer(1);

		QuestionPanel question4 = new QuestionPanel(false, testId);
		question4.setQuestion("Zachytenie výnimky v Jave");
		question4.setAnswers("automaticky opravuje vzniknutú chybu", "ohrozuje integritu programu", "automaticky zastavuje program", "umožňuje jej spracovanie a pokračovanie v programe");
		question4.setCorrectAnswer(3);

		
		test.addQuestion(question1);
		test.addQuestion(question2);
		test.addQuestion(question3);
		test.addQuestion(question4);
		test.setName("Java test 1");
		
	}
	
	public Test getTest()
	{
		return test;
	}
	
	public int getTestId()
	{
		return testId;
	}
}
