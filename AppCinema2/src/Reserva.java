import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Reserva {
	public static ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();
	static String nombre;
    static String documento;
	static String telefono;
	String teatro;
	String sala;
	String silla;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		Reserva.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		Reserva.documento = documento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		Reserva.telefono = telefono;
	}
	public String getTeatro() {
		return teatro;
	}
	public void setTeatro(String teatro) {
		this.teatro = teatro;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getSilla() {
		return silla;
	}
	public void setSilla(String silla) {
		this.silla = silla;
	}
	
	public static void realizarReserva() {

		ImageIcon icon1=new ImageIcon("imagenes/ticket.png");
		String mensaje="Está en la sección de reservación";
		String tituloVentana="Reserva";
		mensaje=" Ingrese su nombre ";
		nombre=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" ingrese su documento ";
		documento=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);	

		String[] peliculas = {
				"Sonic the Hedgehog",
				"El viaje de Chihiro",
				"Aves de Presa",

		};
		ImageIcon icono2=new ImageIcon("imagenes/pelicula.png");
		String resp = (String) JOptionPane.showInputDialog(null, "Seleccione una Pelicula", "Película", JOptionPane.DEFAULT_OPTION, icono2, peliculas, peliculas[0]);
		
		String[] dia = {
				"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
				"22","23","24","25","26","27","28","29","30","31"};
		
		ImageIcon icono0=new ImageIcon("imagenes/pelicula.png");
		String res = (String) JOptionPane.showInputDialog(null, "Seleccione un día", "Día", JOptionPane.DEFAULT_OPTION, icono0, dia, dia[0]);
		

		String[] horario = {
				"12:00","12:30","14:00","14:30","16:00","16:30","18:00","18:30","20:00","20:30","22:00","22:30",
		};
		ImageIcon icono3=new ImageIcon("imagenes/hora.png");
		String ans = (String) JOptionPane.showInputDialog(null, "Seleccione un horario", "Hora", JOptionPane.DEFAULT_OPTION, icono3, horario, horario[0]);
		
		mensaje="por favor ingrese su número de telefono.";
		telefono=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);
		
		String[] silla = {
				"A01","A02","A03","A04","A05","A06","A07","A08","A09","A10","B11","B12","B13","B14","B15","B16","B17","B18","B19","B20","C21",
				"C22","C23","C24","C25","C26","C27","C28","C29","C30","C30"};
		
		ImageIcon icono5=new ImageIcon("imagenes/pelicula.png");
		String re = (String) JOptionPane.showInputDialog(null, "Seleccione una silla", "Asiento", JOptionPane.DEFAULT_OPTION, icono5, silla, silla[0]);

		String[] teatro = {
				"Teatro Colón",
				"Salitre Plaza"};
		
		ImageIcon icon2=new ImageIcon("imagenes/pelicula.png");
		String answ = (String) JOptionPane.showInputDialog(null, "Seleccione una sede", "Sedes", JOptionPane.DEFAULT_OPTION, icono5, teatro, teatro[0]);
		
		JOptionPane.showMessageDialog(null,"Reserva realizada de manera correcta, por favor pase a recoger sus tickets a la sede elegida");
	}
	
	
}
