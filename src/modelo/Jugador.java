package modelo;

public class Jugador {
	

	private int ID_Jugador;
	private String Nombre, Equipo;
	private int NumeroCamiseta;
	private double Altura;
	
	public Jugador() {
		
	}
	public int getID_Jugador() {
		return ID_Jugador;
	}
	public void setID_Jugador(int iD_Jugador) {
		ID_Jugador = iD_Jugador;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEquipo() {
		return Equipo;
	}
	public void setEquipo(String equipo) {
		Equipo = equipo;
	}
	public int getNumeroCamiseta() {
		return NumeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		NumeroCamiseta = numeroCamiseta;
	}
	public double getAltura() {
		return Altura;
	}
	public void setAltura(double altura) {
		Altura = altura;
	}

		
	}


