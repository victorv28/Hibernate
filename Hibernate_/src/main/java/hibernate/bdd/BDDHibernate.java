package hibernate.bdd;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import hibernate.Empleado;
import hibernate.Gestor;

import java.util.Iterator;

public class BDDHibernate {

	private static SessionFactory factory;

	public BDDHibernate() {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
		}

	}

	public void SearchAll() {
		Session session = factory.openSession();
		List<Empleado> empleados = session.createQuery("FROM Empleado").list(); // OJO! Es el nombre de la clase (en
																				// mayúscula), no el nombre de la tabla
		session.close();

		System.out.println(empleados.toString());
	}

	public void SearchOne(int id) {
		Session session = factory.openSession();
		Empleado empleado = session.get(Empleado.class, id);
		session.close();
	}

	public void CreateEmpleado(Empleado empleado) {
		Session session = factory.openSession();
		session.save(empleado);
		session.close();

		System.out.println("Empleado creado");
	}

	public int ModifyEmpleado(int id, Empleado alumno) {

		Session session = factory.openSession();
		Empleado alumnoAntiguo = session.get(Empleado.class, id);
		int retorno = 0;

		if (alumnoAntiguo != null) {

			// Para que los cambios se realicen es necesario utilizar un Transaction
			Transaction transaction = session.beginTransaction();

			alumnoAntiguo.setNombre(alumno.getNombre());
			alumnoAntiguo.setApellidos(alumno.getApellidos());
			alumnoAntiguo.setDepartamento(alumno.getDepartamento());
			session.update(alumnoAntiguo);
			transaction.commit();

			System.out.println("empleado modificado");
		} else {
			System.out.println("no existe empleado con ese id");
		}

		session.close();
		return retorno;
	}

	public void DeleteEmpleado(int id) {

		Session session = factory.openSession();
		Empleado empleado= session.get(Empleado.class, id);
		int retorno = 0;

		if (empleado != null) {

			// Para que los cambios se realicen es necesario utilizar un Transaction
			Transaction transaction = session.beginTransaction();

			session.delete(empleado);
			transaction.commit();

			System.out.println("empleado borrado");
		}else {
		System.out.println("no existe empleadocon ese id");	
		}
		
		session.close();
		

	}
}
