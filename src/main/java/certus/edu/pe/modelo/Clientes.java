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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="clientes")

@Data
@AllArgsConstructor
@NoArgsConstructor

//@NamedQueries({
//	@NamedQuery(name = "Clientes.findAll", query = "SELECT p FROM Clientes p") 	, @NamedQuery(name  = "Clientes.findByIdclientes", query = "SELECT p FROM Clientes p WHERE p.idclientes = :idclientes") 	, @NamedQuery(name  = "Clientes.findByNombre", query = "SELECT p FROM Clientes p WHERE p.nombre = :nombre") , @NamedQuery(name  = "Clientes.findByDireccion", query = "SELECT p FROM Clientes p WHERE p.direccion = :direccion") , @NamedQuery(name  = "Clientes.findByNumero", query = "SELECT p FROM Clientes p WHERE p.numero = :numero") , @NamedQuery(name  = "Clientes.findByCorreo", query = "SELECT p FROM Clientes p WHERE p.correo = :correo") , @NamedQuery(name  = "Clientes.findByTipopago", query = "SELECT p FROM Clientes p WHERE p.tipopago = :tipopago") })
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
	
	
	
}
