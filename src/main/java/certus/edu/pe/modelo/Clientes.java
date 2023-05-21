package certus.edu.pe.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="clientes")
@NamedQueries({
	@NamedQuery(name = "Clientes.findAll", query = "SELECT p FROM Clientes p")
	, @NamedQuery(name  = "Clientes.findByIdclientes", query = "SELECT p FROM Clientes p WHERE p.idclientes = :idclientes")
	, @NamedQuery(name  = "Clientes.findByNombre", query = "SELECT p FROM Clientes p WHERE p.nombre = :nombre")
	, @NamedQuery(name  = "Clientes.findByDireccion", query = "SELECT p FROM Clientes p WHERE p.direccion = :direccion")
	, @NamedQuery(name  = "Clientes.findByNumero", query = "SELECT p FROM Clientes p WHERE p.numero = :numero")
	, @NamedQuery(name  = "Clientes.findByCorreo", query = "SELECT p FROM Clientes p WHERE p.correo = :correo")
	, @NamedQuery(name  = "Clientes.findByTipopago", query = "SELECT p FROM Clientes p WHERE p.tipopago = :tipopago")
})
public class Clientes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = true)
	private Integer idclientes;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "tipopago")
	private String tipopago;
	
	public Clientes() {
		
	}
	
	public Clientes(String nombre, String direccion, Integer numero, String correo,
			String tipopago) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.correo = correo;
		this.tipopago = tipopago;
	}

	

	public Integer getIdclientes() {
		return idclientes;
	}

	public void setIdclientes(Integer idclientes) {
		this.idclientes = idclientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Clientes [idclientes=" + idclientes + "]";
	}

	
	
}
