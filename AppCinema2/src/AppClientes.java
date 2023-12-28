import java.util.ArrayList;

import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

public class AppClientes {


	// Attributes
	private String title;
	public static ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	public static ArrayList<Combo> listaCombos = new ArrayList<Combo>();
	public static ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	// Constructors
	public AppClientes(String title) {
		super();
		this.title = title;

		listaUsuarios=new ArrayList<Usuario>();
		listaPeliculas = new ArrayList<Pelicula>();
		listaCombos = new ArrayList<Combo>();
		listaSalas = new ArrayList<Sala>();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	/***********************************************
	 *  Programa Principal                         *
	 ***********************************************/
	public static void main(String[] args) {
		// Crear una aplicación
		Peliculas Peliculas = new Peliculas();
		Peliculas.loadPeliculas();

		Usuarios Usuarios = new Usuarios();
		Usuarios.loadUsers();

		Combos Combos = new Combos();
		Combos.loadCombos();

		Salas Salas = new Salas();
		Salas.loadSalas();

		AppClientes miApp= new AppClientes("Sistema de Información");
		miApp.login();
	}
	public void login() {
		// Entrar el sistema dado un usuario y una contraseña
		ImageIcon icono1=new ImageIcon("imagenes/user.png");
		ImageIcon icono2=new ImageIcon("imagenes/password.png");
		String mensaje="Ingrese su usuario :";
		String titulo="Usuario ";
		String usuario=(String) JOptionPane.showInputDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE,icono1,null,"");
		mensaje="Contraseña ";
		String password=(String) JOptionPane.showInputDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE,icono2,null,"");	
		// Verificar
		Usuario llamada=new Usuario();
		Usuario u= Usuarios.buscarUsuario(usuario,password);
		if (u==null) {
			JOptionPane.showMessageDialog(null,"Datos incorrectos");
		} else {
			// 
			if (u.getRole().equals("admin")) {
				menuAdmin();
			} else {
				menuClientes();
			}			
		}

	}
	public void darDespedida() {
		System.out.println("Gracias por usar el aplicativo.");
		System.exit(0);
	}
	public void menuAdmin(){
		ImageIcon icono1=new ImageIcon("imagenes/admin.png");
		String titulo="Sistema de Información";	
		StringBuilder opciones=new StringBuilder(" M E N U   P R I N C I P A L\n");
		opciones.append(" 1. Administración de Películas\n");
		opciones.append(" 2. Administración de Clientes \n");
		opciones.append(" 3. Administración de Alimentos\n");
		opciones.append(" 4. Administración de Salas\n");
		opciones.append(" 5. Salir del Sistema\n");
		int opcion=0;
		System.out.println(opcion);
		while (opcion!=5) {
			opcion=Integer.parseInt((String) JOptionPane.showInputDialog(null,opciones,titulo,JOptionPane.INFORMATION_MESSAGE,icono1,null,""));
			switch (opcion) {
			case 1:
				menuPeliculas();				
				break;
			case 2:
				menuAdminClientes();
				break;
			case 3:
				menuCombos();
				break;
			case 4:
				menuSalas();
				break;
			case 5:
				darDespedida();
				break;
			}
		}
	} 
	public void menuClientes(){
		ImageIcon icono1=new ImageIcon("imagenes/cliente.png");
		String titulo="Sistema de Información";	
		StringBuilder opciones=new StringBuilder(" M E N U   P R I N C I P A L\n");
		opciones.append(" 1. Ver peliculas en cartelera \n");
		opciones.append(" 2. Ver Sedes y estados de las Salas\n");
		opciones.append(" 3. Ver carta de Combos\n");
		opciones.append(" 4. Realizar una reserva\n");
		opciones.append(" 6. Salir del Sistema\n");
		int opcion=0;
		System.out.println(opcion);
		while (opcion!=6) {
			opcion=Integer.parseInt((String) JOptionPane.showInputDialog(null,opciones,titulo,JOptionPane.INFORMATION_MESSAGE,icono1,null,""));
			switch (opcion) {
			case 1:
				Peliculas.mostrarPeliculas();
				break;
			case 2:
				Salas.mostrarSalas();
				break;
			case 3:
				Combos.mostrarCombos();
				break;
			case 4:
				Reserva.realizarReserva();				
				break;
			case 5: 
				darDespedida();
				break;
			
			}
		}
	} 
	//__________________________________________________P E L I C U L A S________________________________________________________________
	public void menuPeliculas() {
		ImageIcon icono1=new ImageIcon("imagenes/movies.png");
		String titulo="Sistema de Informacion";	
		StringBuilder opciones=new StringBuilder(" M E N U  C I N E M A\n");
		opciones.append("1.Agregar Peliculas\n");
		opciones.append("2.Buscar Peliculas\n");
		opciones.append("3.Lista de Peliculas\n");
		opciones.append("4.Eliminar una Pelicula\n");
		opciones.append("5.Grabar Información\n");
		opciones.append("6.Volver al menú\n");
		opciones.append("Por favor digite una de las opciones anteriores.\n");
		int option=0;

		System.out.println(option);
		while (option!=6) {
			option=Integer.parseInt((String) JOptionPane.showInputDialog(null,opciones,titulo,JOptionPane.INFORMATION_MESSAGE,icono1,null,""));
			switch (option) {
			case 1:
				Peliculas.ingresarPelicula();
				break;
			case 2:
				Peliculas.consultarPelicula();
				break;
			case 3:
				Peliculas.mostrarPeliculas();
				break;
			case 4:
				Peliculas.eliminarUnaPelicula();
				break;
			case 5:
				Peliculas.grabarInfoMovies();
				break;
			case 6:
				menuAdmin();
				break;
			}
		}
	}

	// ________________________________________ A D M I N I S T R A C I Ó N   D E  C L I E N T E S_________________________________________
	public void menuAdminClientes() {
		ImageIcon icono1=new ImageIcon("imagenes/adminusers.png");
		String titulo="Sistema de Información";	
		StringBuilder opciones=new StringBuilder(" ADMINISTRACION DE CLIENTES\n");
		opciones.append("1.Agregar Cliente\n");
		opciones.append("2.Buscar Cliente\n");
		opciones.append("3.Listar Clientes\n");
		opciones.append("4.Eliminar Cliente\n");
		opciones.append("5. Guardar cambios realizados\n");
		opciones.append("6.Salir del Programa\n");
		opciones.append("Por favor digite una de las opciones anteriores.\n");
		int option=0;
		System.out.println(option);
		while (option!=7) {
			option=Integer.parseInt((String) JOptionPane.showInputDialog(null,opciones,titulo,JOptionPane.INFORMATION_MESSAGE,icono1,null,""));
			switch (option) {
			case 1:
				Usuarios.ingresaUsuario();
				break;
			case 2:
				Usuarios.consultarUsuario();
				break;
			case 3:
				Usuarios.mostrarUsuarios();
				break;
			case 4:
				Usuarios.eliminarUnUsuario();
				break;
			case 5:
				Usuarios.grabarInfo();
				break;
			case 6:
				menuAdmin();
				break;
			}
		}
	}
	//------------------------------------------------------COMIDAS Y SNACKS--------------------------------------------
	public void menuCombos() {
		ImageIcon icono1=new ImageIcon("imagenes/fast.jpg");
		String titulo="Sistema de Informaciï¿½n";	
		StringBuilder opciones=new StringBuilder(" ADM   COMIDAS / SNACKS\n");
		opciones.append("1.Agregar Combo\n");
		opciones.append("2.Listar Combos\n");
		opciones.append("3.Eliminar Combos\n");
		opciones.append("4.Guardar Datos\n");
		opciones.append("5.Volver al menú principal\n");
		opciones.append("Por favor digite una de las opciones anteriores.\n");
		int option=0;
		System.out.println(option);
		while (option!=7) {
			option=Integer.parseInt((String) JOptionPane.showInputDialog(null,opciones,titulo,JOptionPane.INFORMATION_MESSAGE,icono1,null,""));
			switch (option) {
			case 1:
				Combos.ingresarCombo();
				break;
			case 2:
				Combos.mostrarCombos();
				break;
			case 3:
				Combos.eliminarCombo();
				break;
			case 4:
				Combos.grabarInfCombos();
				break;
			case 5:
				menuAdmin();
				break;
			}
		}
	}
	//-------------------------------------------- ADMINISTRACIï¿½N SALAS---------------------------------------------------------------
	public void menuSalas() {
		ImageIcon icono1=new ImageIcon("imagenes/cineadmin.png");
		String titulo="Sistema de Informaciï¿½n";	
		StringBuilder opciones=new StringBuilder(" A D M   D E  S A L A S\n");
		opciones.append("1.Agregar Sala\n");
		opciones.append("2.Listar / Ver Salas\n");
		opciones.append("3.Eliminar Sala\n");
		opciones.append("4.Guardar datos\n");
		opciones.append("5.Volver al menú\n");
		opciones.append("Por favor digite una de las opciones anteriores.\n");
		int option=0;
		System.out.println(option);
		while (option!=7) {
			option=Integer.parseInt((String) JOptionPane.showInputDialog(null,opciones,titulo,JOptionPane.INFORMATION_MESSAGE,icono1,null,""));
			switch (option) {
			case 1:
				Salas.ingresarSala();
				break;
			case 2:
				Salas.mostrarSalas();
				break;
			case 3:
				Salas.eliminarSala();
				break;
			case 4:
				Salas.grabarInfSalas();
				break;
			case 5:
				menuAdmin();
				break;
			}
		}
	}
}





