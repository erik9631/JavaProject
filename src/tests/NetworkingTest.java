package tests;

public class NetworkingTest implements ITest
{
	private Test test;
	private final int testId = 1002;
	
	public NetworkingTest()
	{
		test = new Test(false, testId);
		test.setName("Routing and switching Chaper 1 test");
		
		QuestionPanel question1 = new QuestionPanel(false, testId);
		question1.setQuestion("Ktorá wan technológia je cell based a umožnuje prenášať zvuk a video?");
		question1.setAnswers("ATM", "Frame Relay", "ISDN", "VSAT");
		question1.setCorrectAnswer(0);
		
		QuestionPanel question2 = new QuestionPanel(false, testId);
		question2.setQuestion("Ktory geograficky scope je povazovaný za WAN scope");
		question2.setAnswers("Global", "One-to-one", "Many-to-many", "Regional");
		question2.setCorrectAnswer(2);
		
		QuestionPanel question3 = new QuestionPanel(false, testId);
		question3.setQuestion("Ktorá bezdrotova siet umoznuje pristup k internetu cez telefone zariadenia");
		question3.setAnswers("LTE", "WiMax", "Satellite", "Municipialne wifi");
		question3.setCorrectAnswer(0);
		
		QuestionPanel question4 = new QuestionPanel(false, testId);
		question4.setQuestion("Ktorá technológia je odporúčana pre podnik pripájajúci sa cez verejnú WAN infraštruktúru");
		question4.setAnswers("ATM", "ISDN", "VPN", "Municipialne wifi");
		question4.setCorrectAnswer(2);
		
		test.addQuestion(question1);
		test.addQuestion(question2);
		test.addQuestion(question3);
		test.addQuestion(question4);
		
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
