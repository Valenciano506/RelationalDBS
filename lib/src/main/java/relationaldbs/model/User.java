/**
 * 
 */
package relationaldbs.model;

/*
 *
 * @author Valenciano
 * 8 abr 2026
 */
public class User {
	
	//fields
	private String name;

	private String password;
	
	//The money that the user has in his account
	private double balance;
	
	private long id;
	
	private long dni;
	
	private String email;
	
	private int age;
	
	private long tlf;
	
	private String adress;
	
	//methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getTlf() {
		return tlf;
	}

	public void setTlf(long tlf) {
		this.tlf = tlf;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	//constructors
	public User(String name, String password, double balance, long id, long dni, String email, int age, long tlf, String adress) {
		super();
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.id = id;
		this.dni = dni;
		this.email = email;
		this.age = age;
		this.tlf = tlf;
		this.adress = adress;
	}
	
}
