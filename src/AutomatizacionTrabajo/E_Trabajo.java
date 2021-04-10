package AutomatizacionTrabajo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_Trabajo {
	
	static WebDriver driver;
	static String dpath="C:\\chromedriver_win32\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", dpath);
		String abrirpagina="https://apprater.net/add/";
		driver= new ChromeDriver();
		driver.get(abrirpagina);
		
		sendText("myName","name","user-submitted-name","Adrian Capcha");
		sendText("myEmail","xpath","user-submitted-email","adrian.capchaq@gmail.com");		
		sendText("myProducto","css","user-submitted-title","Producto");
		sendText("myUrl","xpath","","http://Producto.com");
		sendText("Descripcion","xpath","","El producto es de buena calidad");
		
		driver.findElement(By.name("user-submitted-tags")).sendKeys("game");;
		driver.findElement(By.name("user-submitted-post")).click();
		
		//driver.close();
	}
	
	public static void sendText(String label,String selectorType,String selector,String value) {
		//NOMBRE
		if(label.equalsIgnoreCase("myName")) {
			//driver.findElement(By.xpath("//*[@id=\"usp_form\"]/div[3]/div[1]/fieldset/input")).sendKeys(value);
			driver.findElement(By.name("user-submitted-name")).sendKeys(value);;
		}
		//CORREO
		if(label.equalsIgnoreCase("myEmail")) {
			driver.findElement(By.cssSelector("input[name='user-submitted-email']")).sendKeys(value);
		}
		
		//PRODUCTO
		if(label.equalsIgnoreCase("myProducto")) {
			driver.findElement(By.cssSelector("input[name='user-submitted-title']")).sendKeys(value);
		}
		//URL
		if(label.equalsIgnoreCase("myUrl")) {
			driver.findElement(By.xpath("//*[@id=\"usp_form\"]/div[4]/fieldset/input")).sendKeys(value);
		}
		//DESCRIPCION
		if(label.equalsIgnoreCase("Descripcion")) {
			driver.findElement(By.xpath("//*[@id=\"usp_form\"]/fieldset[2]/textarea")).sendKeys(value);
		}
	}
}
