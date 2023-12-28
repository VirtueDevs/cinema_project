import java.util.ArrayList;

public class Usuario {
	
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private String login;
	private String password;
	private String role;	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void printData(){
		System.out.println("----------------------------------");
		System.out.println(" U s e r   I n f o r m a t i o n ");
		System.out.println("----------------------------------");
		System.out.println("   Login : "+this.getLogin());
		System.out.println("Password : "+this.getPassword());
		System.out.println("    Role : "+this.getRole());
		System.out.println("----------------------------------");
	}
	
}
	
