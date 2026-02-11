import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LaunchJacksonAPI1 {
	public static void main(String[] args) throws IOException {
		Alien alien = new Alien(702, "Hrashith", "Warangal");
		Alien alien1 = new Alien(752, "Rathan", "Warangal");
		Alien alien2 = new Alien(763, "Lokesh", "Warangal");
		
		Course c1=new Course(101,"Java", 33.3);
		Course c2=new Course(102, "Python", 42.5);
		Course c3=new Course(103, "JS", 45.7);
		
		alien.setCourse(c1);
		alien1.setCourse(c2);
		alien2.setCourse(c3);
		
		List<Alien> aliens=new ArrayList<>();
		aliens.add(alien);
		aliens.add(alien1);
		aliens.add(alien2);
		
		// Java Object to JSON
		
		ObjectMapper objectMapper = new ObjectMapper();
		//String json = objectMapper.writeValueAsString(alien);
		String alienJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(alien);
		System.out.println(alienJson);
		System.out.println("============");
		String aliensJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(aliens);
		System.out.println(aliensJson);
		System.out.println("============");
		
		// JSON to Java Object
		
//		Alien val = objectMapper.readValue(new File("json/sample.json"), Alien.class);
//		System.out.println(val);
		
		Alien val = objectMapper.readValue(new File("json/complex_sample.json"), Alien.class);
		System.out.println(val);
	}

}
