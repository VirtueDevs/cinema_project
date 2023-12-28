import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Peliculas {

	public static ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	
	public void loadPeliculas() {
		
		String archivoPeliculas = "Data/Peliculas.txt";
		try {
			Scanner teclado=new Scanner(new File(archivoPeliculas));
			while (teclado.hasNext()) {
				String registroPeliculas=teclado.nextLine();
				String[] campo=registroPeliculas.split(";");
				Pelicula p = new Pelicula();
				p.setNombrePelicula(campo[0]);
				p.setGenero(campo[1]);
				p.setClasificacion(campo[2]);
				p.setFecha(campo[3]);
				p.setDuracion(campo[4]);
				p.setPuntuacion(campo[5]);
				this.addPelicula(p);
			}
	}catch (Exception e) {
		System.out.println("*** E R R O R   F A T A L ***");
}
	}
	
	private static void addPelicula(Pelicula p){
		listaPeliculas.add(p);
}
	public static void listarPeliculas(){
		for (int i=0;i<listaPeliculas.size();i++) {
			Pelicula p=listaPeliculas.get(i);
			p.printData();
		}
	}
	public static void mostrarPeliculas(){
		// Crear un documento HTML con una tabla de datos
		StringBuilder mensaje=new StringBuilder("<html><table>");
		mensaje.append("<tr><th>Pelicula</th><th>Genero</th><th>Clasificacion</th><th>Fecha</th><th>Duracion</th><th>Puntuacion></th><tr>");
		for (Pelicula p:listaPeliculas) {
			String registro="<tr><td>"+p.getNombrePelicula()+"</td><td>"+p.getGenero()+"</td><td>"+p.getClasificacion()+"</td><td>"+p.getFecha()+"</td><td>"+p.getDuracion()+"</td><td>"+p.getPuntuacion()+"</td><tr\n";
			mensaje.append(registro);
		}
		mensaje.append("</table></html>");
		JOptionPane.showMessageDialog(null,new JLabel(mensaje.toString()));
	}

	public static void ingresarPelicula(){
		String mensaje="";
		String tituloVentana="Ingreso de Peliculas";
		mensaje=" Ingrese el nombre de la película ?";
		String nombrePelicula=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese el genero ?";
		String genero=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese la clasificación:";
		String clasificacion=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" la fecha de lanzamiento:";
		String fecha=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);	
		mensaje=" Ingrese la duración:";
		String duracion=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);	
		mensaje=" Ingrese la puntuación:";
		String puntuacion=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);

		Pelicula p = new Pelicula();
		p.setNombrePelicula(nombrePelicula);
		p.setGenero(genero);
		p.setClasificacion(clasificacion);
		p.setFecha(fecha);
		p.setDuracion(duracion);
		p.setPuntuacion(puntuacion);
		addPelicula(p);
	
		JOptionPane.showMessageDialog(null,"Película registrada exitosamente !!");
	}
	public static Pelicula buscarPelicula(String nombre){
		for (Pelicula p:listaPeliculas) {
			if (p.getNombrePelicula().equals(nombre)) {
				return p;
			}
		}
		return null; // 
	}
	public static void consultarPelicula(){
		String mensaje="";
		String tituloVentana="Consulta de Información";
		mensaje=" Ingrese el nombre de la película a consultar ?";
		// ImageIcon icono1=new ImageIcon("imagenes/InfoIcon.png");
		String nombre=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);
		Pelicula p=buscarPelicula(nombre);
		if (p==null) {
			mensaje="No existe un pelicula con el nombre "+nombre;
			JOptionPane.showMessageDialog(null,mensaje);
		} else {
			mensaje=nombre+" Si existe en la lista";
			JOptionPane.showMessageDialog(null,mensaje);
			p.printData();			
		}	
	}
	public static void eliminarUnaPelicula(){
		String mensaje="";
		String tituloVentana="Eliminar Datos";
		mensaje=" Ingrese el nombre de la Pelicula a eliminar ?";
		String nombre=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);
		Pelicula p=buscarPelicula(nombre);
		if (p==null) {
			mensaje="No existe la Pelicula: "+nombre;
			JOptionPane.showMessageDialog(null,mensaje);
		} else {
			mensaje=nombre+" Si está registrado";
			JOptionPane.showMessageDialog(null,mensaje);
			p.printData();
			int resp=JOptionPane.showConfirmDialog(null,"Estás seguro que desea eliminar ?");
			if (JOptionPane.OK_OPTION == resp){
				System.out.println("Selecciona opción Afirmativa");
				listaPeliculas.remove(p);
				mensaje=nombre+" fue eliminado de manera exitosa";
				JOptionPane.showMessageDialog(null,mensaje);
			}
			else{
				System.out.println("No ha seleccionado una respuesta");
			}
		}		
	}
	public static void grabarInfoMovies() {			
		String archivoPeliculas="Data/Peliculas.txt";

		try {
			PrintStream salida = new PrintStream (new File(archivoPeliculas));
			for (Pelicula p:listaPeliculas) {
				String guardar = "";
				guardar=p.getNombrePelicula()+";"+p.getGenero()+";"+p.getClasificacion()+";"+p.getFecha()+";"+p.getDuracion()+";"+p.getPuntuacion()+"\n";
				salida.append(guardar);
			}
			salida.close();

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error, el programa no puedo abrir los archivos.");
		}
	}
}
