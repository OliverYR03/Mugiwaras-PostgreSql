package certus.edu.pe.modelo;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="platos")
@NamedQueries({
	@NamedQuery(name = "Platos.findAll", query = "SELECT p FROM Platos p")
	, @NamedQuery(name  = "Platos.findByIdPlato", query = "SELECT p FROM Platos p WHERE p.idplato = :idplato")
	, @NamedQuery(name  = "Platos.findByNombre", query = "SELECT p FROM Platos p WHERE p.nombre = :nombre")
	, @NamedQuery(name  = "Platos.findByDescripcion", query = "SELECT p FROM Platos p WHERE p.descripcion = :descripcion")
	, @NamedQuery(name  = "Platos.findByPrecio", query = "SELECT p FROM Platos p WHERE p.precio = :precio")
	, @NamedQuery(name  = "Platos.findByTipoPlato", query = "SELECT p FROM Platos p WHERE p.tipoplato = :tipoplato")
	, @NamedQuery(name  = "Platos.findByImagen", query = "SELECT p FROM Platos p WHERE p.imagen = :imagen")
})
public class Platos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = true)
	private Integer idplato;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Integer precio;
	
	@Column(name = "tipoplato")
	private String tipoplato;
	
	@Column(name = "imagen")
	private String imagen;
	
	public Platos() {
		
	}
	
	public Platos(Integer idplato, String nombre, String descripcion, Integer precio, String tipoplato,
			String imagen) {
		super();
		this.idplato = idplato;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipoplato = tipoplato;
		this.imagen = imagen;
	}

	public Integer getIdplato() {
		return idplato;
	}

	public void setIdplato(Integer idplato) {
		this.idplato = idplato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getTipoplato() {
		return tipoplato;
	}

	public void setTipoplato(String tipoplato) {
		this.tipoplato = tipoplato;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Platos [idplato=" + idplato + "]";
	}
	
	
	
	
	

}
