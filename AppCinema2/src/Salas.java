import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Salas {
	
	public static ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	
	public void loadSalas() {
		String archivoSalas = "Data/Salas.txt";
		try {
			Scanner teclado=new Scanner(new File(archivoSalas));
			while (teclado.hasNext()) {
				String registroSalas=teclado.nextLine();
				String[] campo=registroSalas.split(";");
				Sala s = new Sala();
				s.setTeatro(campo[0]);
				s.setSala(campo[1]);
				s.setCapacidad(campo[2]);
				s.setEstado(campo[3]);
				s.setId(campo[4]);
				this.addSala(s);
			}
			teclado.close();
		}catch (Exception e) {
			System.out.println("*** E R R O R   F A T A L ***");
		}
	}
	public static void grabarInfSalas() {			
		String archivoSalas="Data/Salas.txt";

		try {
			PrintStream salida = new PrintStream (new File(archivoSalas));
			for (Sala r:listaSalas) {
				String guardar = "";
				guardar=r.getId()+";"+r.getTeatro()+";"+r.getSala()+";"+r.getCapacidad()+";"+r.getEstado()+"\n";
				salida.append(guardar);
			}
			salida.close();

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error, el programa no puedo abrir los archivos.");
		}
	}
	public static void ingresarSala(){
		String mensaje="";
		String tituloVentana="Ingreso de Salas";
		mensaje=" Ingrese el número de identificación de la sala ";
		String id=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);	
		mensaje=" Ingrese el nombre del teatro ";
		String teatro=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese el número de la sala ";
		String sala=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese el número de sillas totales de la sala ";
		String capacidad=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese el estado de la sala actualmente ";
		String estado=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		Sala r = new Sala();
		r.setId(id);
		r.setTeatro(teatro);
		r.setSala(sala);
		r.setCapacidad(capacidad);
		r.setEstado(estado);
		addSala(r);
	
		JOptionPane.showMessageDialog(null,"Sala registrada de manera correcta.");
	}
	public void listaSalas(){
		for (int i=0;i<listaSalas.size();i++) {
			Sala r=listaSalas.get(i);
			r.printData();
		}
	}
	public static void eliminarSala(){
		String mensaje="";
		String tituloVentana="Eliminar sala";
		mensaje=" Ingrese el id ";
		String id=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);

		Sala r=buscarSala(id);
		if (r==null) {
			mensaje="No existe el identificador"+id;
			JOptionPane.showMessageDialog(null,mensaje);
		} else {
			mensaje=id+" El identificador está registrado";
			JOptionPane.showMessageDialog(null,mensaje);
			r.printData();
			int ans=JOptionPane.showConfirmDialog(null,"Está seguro que desea eliminar la sala?");
			if (JOptionPane.OK_OPTION == ans){
				System.out.println("Selecciona ");
				listaSalas.remove(r);
				mensaje=id+" Se ha eliminado de manera correcta";
				JOptionPane.showMessageDialog(null,mensaje);
			}
			else{
				System.out.println("No ha seleccionado una respuesta");
			}
		}		
	}
	public static void addSala(Sala r){
		listaSalas.add(r);
	}
	public static void mostrarSalas(){
		StringBuilder mensaje=new StringBuilder("<html><table>");
		mensaje.append("<tr><th>Capacidad</th><th>Id</th><th>Numero Sala</th><th>Teatro</th><th>Estado</th><tr>");
		for (Sala r:listaSalas) {
			String registro="<tr><td>"+r.getId()+"</td><td>"+r.getTeatro()+"</td><td>"+r.getEstado()+"</td><td>"+r.getSala()+"</td><td>"+r.getCapacidad()+"</td><tr\n";
			mensaje.append(registro);
		}
		mensaje.append("</table></html>");
		JOptionPane.showMessageDialog(null,new JLabel(mensaje.toString()));
	}
	public static Sala buscarSala(String id){
		for (Sala r:listaSalas) {
			if (r.getId().equals(id)) {
				return r;
			}
		}return null;
	}	

}
