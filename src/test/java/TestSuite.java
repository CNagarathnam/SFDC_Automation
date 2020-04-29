
public class TestSuite extends BrowserUtil {

	public static void main(String[] args) throws Exception {

		LoginPage.run();
		CreateAccount.run();
		CreateOpportunities.run();
		Leads.run();
		Contacts.run();
		UserMenu.run();
		RandomScenario.run();
	}

}
