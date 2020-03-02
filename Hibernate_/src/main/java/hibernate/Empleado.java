package hibernate;

public class Empleado {

	private int idEmpleados;
	private String nombre;
	private String apellido;
	private String departamento;

	public Empleado() {
	}

	public Empleado(int id, String nombre, String apellidos, String grupo) {
		this.idEmpleados = id;
		this.nombre = nombre;
		this.apellido = apellidos;
		this.departamento = grupo;
	}

	public int getId() {
		return idEmpleados;
	}

	public void setId(int id) {
		this.idEmpleados = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellido;
	}

	public void setApellidos(String apellidos) {
		this.apellido = apellidos;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String grupo) {
		this.departamento = grupo;
	}

	@Override
	public String toString() {
		return "Empleado{" + "id=" + idEmpleados + ", nombre='" + nombre + '\'' + ", apellidos='" + apellido + '\''
				+ ", grupo='" + departamento + '\'' + '}';
	}

}