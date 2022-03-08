package tienda.menu;

import java.util.Scanner;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

public class Menu {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    

    public void MenuInicial() throws Exception {
        
    ProductoServicio productoServicio = new ProductoServicio();
    FabricanteServicio fabricanteServicio = new FabricanteServicio();

        System.out.println("Bienvenido/a al menu de la tienda!");

        boolean x = true;

        do {

            System.out.println("OPCION 1: Listar nombre de todos los productos."
                + "\n" + "OPCION 2: Listar nombre y precio de todos los productos."
                + "\n" + "OPCION 3: Listar productos cuyo precio esten entre 120 y 202."
                + "\n" + "OPCION 4: Listar todos los Portatiles."
                + "\n" + "OPCION 5: Listar el nombre y el precio del producto mas barato."
                + "\n" + "OPCION 6: Ingresar un producto a la base de datos."
                + "\n" + "OPCION 7: Ingresar un fabricante a la base de datos."
                + "\n" + "OPCION 8: Editar un producto."
                + "\n" + "OPCION 9: Salir."
                + "\n" + "Elija una opcion:");
            int opcion = leer.nextInt();

            while (opcion <= 0 || opcion >= 10) {
                System.out.println("El numero ingresado no corresponde a ninguna opcion. Intente nuevamente:");
                opcion = leer.nextInt();
            }

                switch (opcion) {

                    case 1:
                        try {
                            productoServicio.mostrarNombreProductos();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 2:
                        try {
                            productoServicio.mostrarProductos();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 3:
                        try {
                            productoServicio.mostrarPorPrecio();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 4:
                        try {
                            productoServicio.mostrarNombrePortatil();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 5:
                        try {
                            productoServicio.mostrarPrecioMinimo();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 6:
                        try {
                            productoServicio.ingresarProducto();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 7:
                        try {
                            fabricanteServicio.ingresarFabricante();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 8:
                        try {
                            productoServicio.editarProducto();
                            System.out.println("");
                        } catch (Exception e) {
                            throw e;
                        }
                        break;

                    case 9:
                        System.out.println("Muchas gracias, hasta luego!");
                        x = false;

                }
            } while (x == true);

        } 
    }
