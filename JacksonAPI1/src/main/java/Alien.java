import java.util.Arrays;

public class Alien {

	private Integer id;
	private String name;
	private String city;
	private Course course;
	private String[] hobbies= {"Watching movies","Playing Cricket","Listening music"};
	
	public Alien(Integer id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.course = course;
		this.hobbies = hobbies;
	}

	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", city=" + city + ", course=" + course + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
	
	
}
