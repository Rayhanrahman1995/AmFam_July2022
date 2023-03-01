package test.Units;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.testng.annotations.Test;
import com.utils.PojoData;

public class UnitTests {

	@Test(enabled = false)
	public void unitTestForPojo() {
		PojoData pojoData=new PojoData("Title", null, "City State");
		System.out.println(pojoData.getLandingPageTitle());
	}
	
	@Test(enabled = false)
	public void unitTestForOS() {
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("java.home"));
	}
	
	@Test(enabled = false)
	public void folderTest() {
		File folder=new File("screenShots");
		System.out.println(folder.getAbsolutePath());
		System.out.println(folder.exists());
        if (!folder.exists()) {
			folder.mkdir();
		}
        System.out.println(folder.exists());
	}
	
	@Test(enabled = true)
	public void DateTest() {
		Date date=new Date();
	//	System.out.println(date);
	//	Instant time=Instant.now();
	//	System.out.println(time);
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM:dd:yyyy_hh:mm:ss");
		System.out.println(dateFormat.format(date));
	}
	
	
	
	
}
