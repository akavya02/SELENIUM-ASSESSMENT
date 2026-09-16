package SauceDemoKeywordimplementation;

import SauceDemoKeyword.SauceDemoExecutors;

public class SauceDemomainprog {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SauceDemoExecutors a=new SauceDemoExecutors();
		a.Executors("LAUNCH_BROWSER");
		Thread.sleep(2000);
		a.Executors("OPEN_URL");
		Thread.sleep(2000);
		a.Executors("ENTER_USERNAME");
		Thread.sleep(2000);
		a.Executors("ENTER_PASSWORD");
		Thread.sleep(2000);
		a.Executors("CLICK_LOGIN");
		Thread.sleep(2000);;
		a.Executors("CLOSE_BROWSER");


	}

}
