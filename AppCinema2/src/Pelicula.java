import java.util.ArrayList;

public class Pelicula {

	public static ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	private String nombrePelicula;
	private String genero;
	private String clasificacion;
	private String fecha;
	private String duracion;
	private String puntuacion;

	public String getNombrePelicula() {
		return nombrePelicula;
	}
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}
	public void printData(){
		
		
		System.out.println("----------------------------------");
		System.out.println(" M O V I E S    I N F O R M A T I O N ");
		System.out.println("----------------------------------");
		System.out.println("     Pelicula : "+this.getNombrePelicula());
		System.out.println("       Genero : "+this.getGenero());
		System.out.println("Clasificación : "+this.getClasificacion());
		System.out.println("        Fecha : "+this.getFecha());
		System.out.println("     Duración : "+this.getDuracion());
		System.out.println("   Puntuación : "+this.getPuntuacion());
		System.out.println("----------------------------------");
		
	}
	
}