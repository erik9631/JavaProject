package tests;

public class JavaTest2 implements ITest
{
	Test test;
	final int testId = 1001;
	public  JavaTest2()
	{
		test = new Test(false, testId);
		QuestionPanel question1 = new QuestionPanel(false, testId);
		question1.setQuestion("What color do you love: ");
		question1.setAnswers("red", "white", "blue", "BLACK");
		question1.setCorrectAnswer(1);
		test.addQuestion(question1);
		test.setName("java test 2");
	}

	@Override
	public Test getTest()
	{
		return test;
	}

	@Override
	public int getTestId()
	{
		return testId;
	}

}
