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
@Table(name="ordenes")
@NamedQueries({
	@NamedQuery(name = "Ordenes.findAll", query = "SELECT p FROM Ordenes p")
	, @NamedQuery(name  = "Ordenes.findByIdorden", query = "SELECT p FROM Ordenes p WHERE p.idorden = :idorden")
	, @NamedQuery(name  = "Ordenes.findByIdcliente", query = "SELECT p FROM Ordenes p WHERE p.idcliente = :idcliente")
	, @NamedQuery(name  = "Ordenes.findByFecha", query = "SELECT p FROM Ordenes p WHERE p.fecha = :fecha")
	, @NamedQuery(name  = "Ordenes.findByPlato", query = "SELECT p FROM Ordenes p WHERE p.platos = :platos")
	, @NamedQuery(name  = "Ordenes.findByTotal", query = "SELECT p FROM Ordenes p WHERE p.total = :total")
})
public class Ordenes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=true)
   private Integer idorden;
	
	@Basic(optional = false)
	
   @Column(name = "idcliente")
   private Integer idcliente;
	
	@Column(name = "fecha")
   private String fecha;
	
	@Column(name = "platos")
   private String platos;
	
	@Column(name = "total")
   private Integer total;

	public Ordenes() {
		
	}
	
	public Ordenes(Integer idcliente, String fecha, String platos, Integer total) {
		super();
		this.idcliente = idcliente;
		this.fecha = fecha;
		this.platos = platos;
		this.total = total;
	}

	public Integer getIdorden() {
		return idorden;
	}

	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPlatos() {
		return platos;
	}

	public void setPlatos(String platos) {
		this.platos = platos;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Ordenes [idorden=" + idorden + "]";
	}
	
}
