import java.util.ArrayList;

public class Combo {
	
	public static ArrayList<Combo> listaCombos = new ArrayList<Combo>();
	String comida;
	String bebida;
	String postre;
	String precio;
	

	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public String getPostre() {
		return postre;
	}

	public void setPostre(String postre) {
		this.postre = postre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public void printData(){
		System.out.println("----------------------------------");
		System.out.println("           C O M B O S  ");
		System.out.println("----------------------------------");
		System.out.println("   Comidas : "+this.getComida());
		System.out.println("   Bebidas : "+this.getBebida());
		System.out.println("   Postres : "+this.getPostre());
		System.out.println("     Precio: "+this.getPrecio());
		System.out.println("----------------------------------");
	}
	
}
