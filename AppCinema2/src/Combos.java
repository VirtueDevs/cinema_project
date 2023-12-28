import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Combos {
	
	public static ArrayList<Combo> listaCombos = new ArrayList<Combo>();
	public void loadCombos() {
		String archivoCombos = "Data/Combos.txt";
		try {
			Scanner teclado=new Scanner(new File(archivoCombos));
			while (teclado.hasNext()) {
				String registroCombos=teclado.nextLine();
				String[] campo=registroCombos.split(";");
				Combo s = new Combo();
				s.setComida(campo[0]);
				s.setBebida(campo[1]);
				s.setPostre(campo[2]);
				s.setPrecio(campo[3]);
				this.addCombo(s);
			}
			teclado.close();
		}catch (Exception e) {
			System.out.println("*** E R R O R   F A T A L ***");
		}
	}
	public static void grabarInfCombos() {			
		String archivoCombos="Data/Combos.txt";

		try {
			PrintStream salida = new PrintStream (new File(archivoCombos));
			for (Combo s:listaCombos) {
				String guardar = "";
				guardar=s.getComida()+";"+s.getBebida()+";"+s.getPostre()+";"+s.getPrecio()+"\n";
				salida.append(guardar);
			}
			salida.close();

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error, el programa no puedo abrir los archivos.");
		}
	}
	public static void ingresarCombo(){
		String mensaje="";
		String tituloVentana="Ingreso de Combos";
		mensaje=" Ingrese el nombre del producto ";
		String comida=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese el nombre de la bebida ";
		String bebida=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese el nombre del postre ";
		String postre=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		mensaje=" Ingrese el precio total del combo ";
		String precio=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);		
		Combo s = new Combo();
		s.setComida(comida);
		s.setBebida(bebida);
		s.setPostre(postre);
		s.setPrecio(precio);
		addCombo(s);
		JOptionPane.showMessageDialog(null,"Combo registrado exitosamente !!");
	}
	public void listaCombos(){
		for (int i=0;i<listaCombos.size();i++) {
			Combo s=listaCombos.get(i);
			s.printData();
		}
	}
	public static void eliminarCombo(){
		String mensaje="";
		String tituloVentana="Eliminar Combo";
		mensaje="Ingrese el producto comestible del combo";
		String comida=JOptionPane.showInputDialog(null,mensaje,tituloVentana,JOptionPane.INFORMATION_MESSAGE);
		Combo s=buscarCombo(comida);
		if (s==null) {
			mensaje="No existe el combo: "+comida;
			JOptionPane.showMessageDialog(null,mensaje);
		} else {
			mensaje=comida+" El combo está registrado";
			JOptionPane.showMessageDialog(null,mensaje);
			s.printData();
			int ans=JOptionPane.showConfirmDialog(null,"Estï¿½ seguro que desea eliminar el combo ?");
			if (JOptionPane.OK_OPTION == ans){
				System.out.println("Selecciona opción Afirmativa");
				listaCombos.remove(s);
				mensaje=comida+" y el combo ha sido eliminado de manera exitosa";
				JOptionPane.showMessageDialog(null,mensaje);
			}
			else{
				System.out.println("No ha seleccionado una respuesta");
			}
		}		
	}
	public static void addCombo(Combo s){
		listaCombos.add(s);
	}
	public static void mostrarCombos(){
		// Crear un documento HTML con una tabla de datos
		StringBuilder mensaje=new StringBuilder("<html><table>");
		mensaje.append("<tr><th>Comida</th><th>Bebida</th><th>Postre</th><th>Precio</th><tr>");
		for (Combo s:listaCombos) {
			String registro="<tr><td>"+s.getComida()+"</td><td>"+s.getBebida()+"</td><td>"+s.getPostre()+"</td><td>"+s.getPrecio()+"</td><tr\n";
			mensaje.append(registro);
		}
		mensaje.append("</table></html>");
		JOptionPane.showMessageDialog(null,new JLabel(mensaje.toString()));
	}
	public static Combo buscarCombo(String comida){
		for (Combo s:listaCombos) {
			if (s.getComida().equals(comida)) {
				return s;
			}
		}return null;
	}
}
