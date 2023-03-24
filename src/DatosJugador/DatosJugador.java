package DatosJugador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import modelo.Jugador;

public class DatosJugador {



	Conexion cx; 
	
	public DatosJugador() {
		cx = new Conexion();
	}
	
	public boolean insertarJugador(Jugador Jugador1) {
		PreparedStatement ps = null;
		try {
			ps= cx.conectar().prepareStatement("Insert INTO Plataforma VALUES (null,?,?,?,?)");
			ps.setString(1, Jugador1.getNombre());
			ps.setString(2, Jugador1.getEquipo());
			ps.setInt(3, Jugador1.getNumeroCamiseta());
			ps.setDouble(4, Jugador1.getAltura());
		    ps.executeUpdate();
		    cx.desconectar();
		    return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<Jugador> consultaJugador(){
		 ArrayList<Jugador> lista = new ArrayList<Jugador>();
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			 ps=cx.conectar().prepareStatement("SELECT * FROM Plataforma");
			 rs=ps.executeQuery();
			 while (rs.next()) {
				 Jugador Jugador1 = new Jugador();
				 Jugador1.setID_Jugador(rs.getInt("ID_Jugador"));
				 Jugador1.setNombre(rs.getString("Nombre"));	 
				 Jugador1.setEquipo(rs.getString("Equipo"));
				 Jugador1.setNumeroCamiseta(rs.getInt("NumeroCamiseta"));
				 Jugador1.setAltura(rs.getDouble("Altura"));
				 lista.add(Jugador1);
			 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return lista;
	}
	public boolean eliminarJugador(int ID_Jugador) {
		PreparedStatement ps = null;
		try {
			ps= cx.conectar().prepareStatement("DELETE FROM Plataforma WHERE ID_Jugador =?");
			ps.setInt(1, ID_Jugador);
			
		    ps.executeUpdate();
		    cx.desconectar();
		    return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
   public boolean editarJugador(Jugador Jugador1) {
	   PreparedStatement ps = null;
	   try {
		   ps= cx.conectar().prepareStatement("UPDATE Plataforma SET Nombre=?, Equipo=?, NumeroCamiseta=?, Altura=? WHERE ID_Jugador=?");
		   ps.setString(1, Jugador1.getNombre());
		   ps.setString(2, Jugador1.getEquipo());
		   ps.setInt(3, Jugador1.getNumeroCamiseta());
		   ps.setDouble(4, Jugador1.getAltura());
		   ps.setInt(5, Jugador1.getID_Jugador());
		   ps.executeUpdate();
		   cx.desconectar();
		   return true;
	   }catch (SQLException e) {
		   e.printStackTrace();
		   return false;
	   }
   }
}
