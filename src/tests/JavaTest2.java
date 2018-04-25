package tests;

public class JavaTest2 implements ITest
{
	Test test;
	final int testId = 1001;
	public  JavaTest2()
	{
		test = new Test(false, testId);
		QuestionPanel question1 = new QuestionPanel(false, testId);
		question1.setQuestion("Čo je enkapsulácia");
		question1.setAnswers("Umožnuje polymorfyzmus", "Uzatvára triedy do \"black boxu\" a skryva vlastnosti kodu pred programatorom",
							 "Prostrednictvom keywordu public a private mozeme uzatvarat triedy", "Ine");
		question1.setCorrectAnswer(1);
		
		QuestionPanel question2 = new QuestionPanel(false, testId);
		question2.setQuestion("Čo je abstrakcia");
		question2.setAnswers("Iniciovane tried dediacich od typu objekt", "Dedenie", "Vseobecne zadefinovanie triedy ktore neskôr konkretizujeme",
							 "Vyuzivanie rozhraní");
		question2.setCorrectAnswer(2);
		
		QuestionPanel question3 = new QuestionPanel(false, testId);
		question3.setQuestion("Ktore tvrdenie o virtualnej triede je pravdive");
		question3.setAnswers("Virtualna trieda moze byt prekonana", "Virtualna trieda je staticka", "Virtualna trieda moze byt len v abstraktnej triede",
							 "Je podstatnou sucastou rozhrani");
		question3.setCorrectAnswer(0);
		
		QuestionPanel question4 = new QuestionPanel(false, testId);
		question4.setQuestion("Čo umožnuje keyword transient");
		question4.setAnswers("Podobne ako final, zakazuje prepisovanie premennych za spravnych podmienok",
							 "Zabespecuje ze pri multithreadingu k premennej bude pristupovat len jeden thread", 
							 "Premenna sa nebude zobrazovat aj ked je public",
							 "Pri serializácii sa hodnota bude ignorovať");
		question4.setCorrectAnswer(3);
		
		test.addQuestion(question1);
		test.addQuestion(question2);
		test.addQuestion(question3);
		test.addQuestion(question4);
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
