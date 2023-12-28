import java.util.ArrayList;

public class Sala {
	
	public static ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	String id;
	String teatro;
	String capacidad;
	String estado;
	String sala;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeatro() {
		return teatro;
	}
	public void setTeatro(String teatro) {
		this.teatro = teatro;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public void printData(){
		System.out.println("----------------------------------");
		System.out.println(" I N F O R M A C I Ó N   D E   S A L A S ");
		System.out.println("----------------------------------");
		System.out.println("       Id :"+this.getId());		
		System.out.println("   Teatro : "+this.getTeatro());
		System.out.println("     Sala : "+this.getSala());
		System.out.println("Capacidad : "+this.getCapacidad());
		System.out.println("   Estado : "+this.getEstado());
		System.out.println("----------------------------------");
	}
	
}

