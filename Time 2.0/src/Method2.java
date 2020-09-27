import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class Method2 {

	public void OnMe() throws InterruptedException {
	//public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srija\\Downloads\\Software Testing Tools\\Selenium WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://neosuitetestuat.neeyamo.com/login"); // NTest URL
		driver.findElement(By.id("user")).sendKeys("103748"); // User Name
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform(); // Enter
		driver.findElement(By.id("password")).sendKeys("Neeyamo@123"); // Password
		act.sendKeys(Keys.ENTER).build().perform(); // Enter
		Thread.sleep(6000);
		driver.findElement(By.xpath("//img[@src = '../../../assets/servicedesk/viewQuery.png']")).click(); // View Query
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[contains(text(), 'On Me')]")).click(); // On Me
		Thread.sleep(6000);
		driver.findElement(By.xpath("//img[@src='../../../assets/servicedesk/list.png']")).click(); //List View
		Thread.sleep(8000);
		driver.findElement(By.id("viewTicketConfigureColumnDropdown")).click(); //Configurable column 
		Thread.sleep(3000);

		//Open Count 
		String Open_statusName= driver.findElement(By.cssSelector("div.filterCol_Open.buzzerPointer")).getText(); //Filter Open
		String Open_actualCount = Open_statusName.replaceAll("[^0-9]", "");        
		String Open_b = Open_actualCount;
		System.out.println("Open Status:: " +Open_b);
		int open_b1 = Integer.parseInt(Open_b);
		
		//Accepted Count
		String Accepted_statusName= driver.findElement(By.cssSelector("div.filterCol_Accepted.buzzerPointer")).getText(); //Filter Accepted
		String Accepted_actualCount = Accepted_statusName.replaceAll("[^0-9]", "");        
		String Accepted_b = Accepted_actualCount;
		System.out.println("Accepted Status:: " +Accepted_b);
		int Accepted_b1 = Integer.parseInt(Accepted_b);

		//WIP Count
		String WIP_statusName= driver.findElement(By.cssSelector("div.filterCol_WIP.buzzerPointer")).getText(); //Filter WIP
		String WIP_actualCount = WIP_statusName.replaceAll("[^0-9]", "");        
		String WIP_b = WIP_actualCount;
		System.out.println("WIP Status:: " +WIP_b);
		int WIP_b1 = Integer.parseInt(WIP_b);
		
		driver.findElement(By.id("filterStatusDropdown")).click(); // Click on More Button
		Thread.sleep(5000);
		
		//Reopen Count
		String Reopen_statusName = driver.findElement(By.xpath("//ul[@id='viewTicket_moreDropdown'] //*[contains(text(),'Reopen')]")).getText(); //Reopen
		String Reopen_actualCount = Reopen_statusName.replaceAll("[^0-9]", "");        
		String Reopen_b = Reopen_actualCount;
		System.out.println("Reopen Status:: " +Reopen_b);
		int Reopen_b1 = Integer.parseInt(Reopen_b);
		
		//Reassign Count
		String Reassign_statusName = driver.findElement(By.xpath("//ul[@id='viewTicket_moreDropdown'] //*[contains(text(),'Reassign')]")).getText(); //Reassign
		String Reassign_actualCount = Reassign_statusName.replaceAll("[^0-9]", "");        
		String Reassign_b = Reassign_actualCount;
		System.out.println("Reassign Status:: " +Reassign_b);
		int Reassign_b1 = Integer.parseInt(Reassign_b);
		
		//AWT Count
		String AWT_statusName = driver.findElement(By.xpath("//ul[@id='viewTicket_moreDropdown'] //*[contains(text(),'Awaiting Response')]")).getText(); //AWT
		String AWT_actualCount = AWT_statusName.replaceAll("[^0-9]", "");        
		String AWT_b = AWT_actualCount;
		System.out.println("AWT Status:: " +AWT_b);
		int AWT_b1 = Integer.parseInt(AWT_b);
		
		//Resolved Count
		String Resolved_statusName = driver.findElement(By.xpath("//ul[@id='viewTicket_moreDropdown'] //*[contains(text(),'Resolved')]")).getText(); //Resolved
		String Resolved_actualCount = Resolved_statusName.replaceAll("[^0-9]", "");        
		String Resolved_b = Resolved_actualCount;
		System.out.println("Resolved Status:: " +Resolved_b);
		int Resolved_b1 = Integer.parseInt(Resolved_b);		
		
		//Closed Count
		String Closed_statusName = driver.findElement(By.xpath("//ul[@id='viewTicket_moreDropdown'] //*[contains(text(),'Closed')]")).getText(); //Closed
		String Closed_actualCount = Closed_statusName.replaceAll("[^0-9]", "");        
		String Closed_b = Closed_actualCount;
		System.out.println("Closed Status:: " +Closed_b);
		int Closed_b1 = Integer.parseInt(Closed_b);
		
		//Rejected Count
		String Rejected_statusName = driver.findElement(By.xpath("//ul[@id='viewTicket_moreDropdown'] //*[contains(text(),'Rejected')]")).getText(); //Rejected
		String Rejected_actualCount = Rejected_statusName.replaceAll("[^0-9]", "");        
		String Rejected_b = Rejected_actualCount;
		System.out.println("Rejected Status:: " +Rejected_b);
		int Rejected_b1 = Integer.parseInt(Rejected_b);
		
		//Cancelled Count
		String Cancelled_statusName = driver.findElement(By.xpath("//ul[@id='viewTicket_moreDropdown'] //*[contains(text(),'Cancelled')]")).getText(); //Cancelled
		String Cancelled_actualCount = Cancelled_statusName.replaceAll("[^0-9]", "");        
		String Cancelled_b = Cancelled_actualCount;
		System.out.println("Cancelled Status:: " +Cancelled_b);
		int Cancelled_b1 = Integer.parseInt(Cancelled_b);
		
		int b1 = open_b1 + Accepted_b1 + WIP_b1 + Reopen_b1 + Reassign_b1 + AWT_b1 + Resolved_b1 + Closed_b1 + Rejected_b1 + Cancelled_b1; //Adding all the ticket count
		
		System.out.println("Total High ticket filter count:: " +b1);		
		
		for(int i=1; i<=b1; i++)
		{
			if(b1<=6)
			{
				List<WebElement> QueryID = driver.findElements(By.cssSelector
						("li.row.card.buzzerPointer.pinkBlockQuote.ticketListCard div:nth-child(1) span b")); //Query ID
				String[] TicketID = new String[QueryID.size()];
								
				//Get Text In Array
				for(int j=0; j<QueryID.size();i++)
				{
					TicketID[j] = driver.findElement(By.cssSelector
							("li.row.card.buzzerPointer.pinkBlockQuote.ticketListCard div:nth-child(1) span b")).getText().trim();
					System.out.println("Original Query ID: " +TicketID[j]);
				}			
			}
			else if(i==b1)
			{
				List<WebElement> QueryID = driver.findElements(By.cssSelector
						("li.row.card.buzzerPointer.pinkBlockQuote.ticketListCard div:nth-child(1) span b")); //Query ID
				String[] TicketID = new String[QueryID.size()];
				
				//Get Text In Array
				for(int j=0; j<QueryID.size();i++)
				{
					TicketID[j] = driver.findElement(By.cssSelector
							("li.row.card.buzzerPointer.pinkBlockQuote.ticketListCard div:nth-child(1) span b")).getText().trim();
					System.out.println("Original Query ID: " +TicketID[j]);
				}
				
			}
			
			else if(i%6==0)
			{
				List<WebElement> QueryID = driver.findElements(By.cssSelector
						("li.row.card.buzzerPointer.pinkBlockQuote.ticketListCard div:nth-child(1) span b")); //Query ID
				String[] TicketID = new String[QueryID.size()];
				
				//Get Text In Array
				for(int j=0; j<QueryID.size();i++)
				{
					TicketID[j] = driver.findElement(By.cssSelector
							("li.row.card.buzzerPointer.pinkBlockQuote.ticketListCard div:nth-child(1) span b")).getText().trim();
					System.out.println("Original Query ID: " +TicketID[j]);
				}
				
				act.sendKeys(Keys.PAGE_DOWN).build().perform(); 
				driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click(); // Next Button				
				Thread.sleep(2000);		
			}
				
		}
		
		Thread.sleep(4000);		

		act.sendKeys(Keys.PAGE_UP).build().perform(); //Scrolling the page up. 
		Thread.sleep(5000);
		
		driver.close();	
}
}