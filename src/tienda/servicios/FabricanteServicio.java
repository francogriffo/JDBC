package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }

    public void ingresarFabricante() throws Exception {
        Fabricante fabricante = new Fabricante();

        System.out.println("Ingrese el codigo del fabricante: ");
        fabricante.setCodigo(leer.nextInt());

        System.out.println("Ingrese el nombre: ");
        fabricante.setNombre(leer.next());


        try {
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            System.out.println("El codigo ingresado ya corresponde a otro fabricante, o uno de los campos ingresados es invalido.");
        }
        
        System.out.println("El fabricante ingresado es: " + fabricante.toString());
    }
}
