package webTable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/table.html");
		WebElement table = driver.findElementByXPath("//table");
		List<ListOfTable> ls = new ArrayList<>();
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size(); j++) {
				ls.add(new ListOfTable(col.get(0).getText(), col.get(1).getText()));
			}
		}
		System.out.println(ls);
		System.out.println(ls.size());
	}
}
