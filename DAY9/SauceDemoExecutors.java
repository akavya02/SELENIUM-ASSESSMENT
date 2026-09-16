package SauceDemoKeyword;

public class SauceDemoExecutors {
	
	SauceDemoimplementation s=new SauceDemoimplementation();
	public void Executors(String keyword)
	{
		if(keyword.equals("LAUNCH_BROWSER"))
		{
			s.launchBrowser();
		}
		else if(keyword.equals("OPEN_URL"))
		{
			s.openUrl();
		}
		else if(keyword.equals("ENTER_USERNAME"))
		{
			s.Username();
		}
		else if(keyword.equals("ENTER_PASSWORD"))
		{
			s.password();
		}
		else if(keyword.equals("CLICK_LOGIN"))
		{
			s.login();
		}
		else 
		{
			s.closeBrowser();
		}
	}

}
