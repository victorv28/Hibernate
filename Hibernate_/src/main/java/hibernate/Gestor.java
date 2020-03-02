package hibernate;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import hibernate.bdd.BDDHibernate;

public class Gestor {

	public static void main(String[] args) {

		int opcion;
		BDDHibernate BDD = new BDDHibernate();

		do {

			System.out.println();
			System.out.println("1. Mostrar todo");
			System.out.println("2. Mostrar alumno");
			System.out.println("3. Crear alumno");
			System.out.println("4. Modificar alumno");
			System.out.println("5. Eliminar alumno");
			System.out.println("6. Salir");

			System.out.println();

			opcion = Select(1, 6);

			switch (opcion) {

			case 1:

				BDD.SearchAll();

				break;

			case 2:

				BDD.SearchOne(Id());

				break;

			case 3:

				BDD.CreateEmpleado(ReturnEmpleado());

			case 4:
				System.out.println("Introduce el ID del alumno");
				BDD.ModifyEmpleado(Id(), ReturnEmpleado());

				break;

			case 5:
				System.out.println("Introduce el ID del alumno");
				BDD.DeleteEmpleado(Id());

				break;
			}

		} while (opcion != 6);

	}

	public static int Select(int min, int max) {

		Scanner scanner = new Scanner(System.in);
		int num;

		System.out.print("Opción: ");
		try {
			num = scanner.nextInt();
			if (num < min || num > max) {
				System.out.println("Opción no válida");
				num = Select(min, max);
			}

		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println("Opción no válida");
			num = Select(min, max);
		}
		return num;
	}

	public static int Id() {

		Scanner scanner = new Scanner(System.in);
		int opcion;

		System.out.print("ID: ");
		try {
			opcion = scanner.nextInt();
		} catch (InputMismatchException e) {

			scanner.next();
			System.out.println("ID no válido");
			opcion = Id();
		}
		return opcion;
	}

	public static String Nombre() {

		Scanner scanner = new Scanner(System.in);
		String nombre;

		System.out.print("Nombre: ");
		try {
			nombre = scanner.nextLine();
		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println("Nombre no válido");
			nombre = Nombre();
		}
		return nombre;
	}

	public static String Apellidos() {

		Scanner scanner = new Scanner(System.in);
		String apellidos;

		System.out.print("Apellidos: ");
		try {
			apellidos = scanner.nextLine();
		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println("Apellido no válido");
			apellidos = Apellidos();
		}
		return apellidos;
	}

	public static String Grupo() {

		System.out.println("Grupo:");
		System.out.println("1. Marketing");
		System.out.println("2. Producción");
		System.out.println("3. Recursos Humanos");

		switch (Select(1, 3)) {
		case 1:
			return "Marketing";
		case 2:
			return "Producción";
		case 3:
			return "Recursos Humanos";
		}
		return null;
	}

	public static Empleado ReturnEmpleado() {
		return new Empleado(Id(), Nombre(), Apellidos(), Grupo());
	}
}
