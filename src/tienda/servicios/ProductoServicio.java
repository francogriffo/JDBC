package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }

    public void mostrarNombreProductos() throws Exception {

        try {
            Collection<Producto> productos = dao.listarProductos();
            System.out.println("Nombre de los productos: ");
            for (Producto producto : productos) {

                System.out.println(producto.getNombre());

            }

        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> retornarProductos() throws Exception {

        try {
            Collection<Producto> productos = dao.listarProductos();
            return productos;

        } catch (Exception e) {
            throw e;
        }

    }

    public void mostrarPorPrecio() throws Exception {

        System.out.println("Los productos con precio entre 180 a 202 son: ");
        dao.buscarProductoPorPrecio().forEach((producto) -> System.out.println(producto.toString()));

    }

    public void mostrarProductos() throws Exception {

        System.out.println("Los productos con todas sus caracteristicas: ");
        retornarProductos().forEach((producto) -> System.out.println(producto.toString()));

//         Collection<Producto> productos = retornarProductos();
//         
//         System.out.println("Los productos son: ");
//         productos.forEach((producto) -> {
//             System.out.println(producto.toString());
//         });
    }

    public void mostrarNombrePortatil() throws Exception {

        System.out.println("Los productos donde se encuentra la palabra portatil son:");
        dao.buscarProductoPorNombre().forEach((producto) -> System.out.println(producto.toString()));
    }

    public void mostrarPrecioMinimo() throws Exception {

        System.out.println("El producto con el precio mas barato es: " + dao.buscarProductoPorPrecioMinimo());

    }

    public void ingresarProducto() throws Exception {
      
  
        Producto producto = new Producto();

        System.out.println("Ingrese el codigo del producto: ");
        producto.setCodigo(leer.nextInt());
        
       while(producto.getCodigo() <= 0){
           System.out.println("El codigo debe ser mayor a 0. Intente nuevamente:");
           producto.setCodigo(leer.nextInt());
       }

        System.out.println("Ingrese el nombre: ");
        producto.setNombre(leer.next());
        
        while(producto.getNombre() == null || producto.getNombre().trim().isEmpty()){
            System.out.println("Debe indicar el nombre del producto. Intente nuevamente:");
            producto.setNombre(leer.next());
        }

        System.out.println("Ingrese el precio: ");
        producto.setPrecio(leer.nextDouble());
        
        while(producto.getPrecio() <= 0){
            System.out.println("Debe indicar un precio. Intente nuevamente:");
            producto.setPrecio(leer.nextDouble());
        }

        System.out.println("Ingrese el codigo del fabricante: ");
        producto.setCodigoFabricante(leer.nextInt());
        
         while(producto.getCodigoFabricante()<= 0){
           System.out.println("El codigo debe ser mayor a 0. Intente nuevamente:");
           producto.setCodigoFabricante(leer.nextInt());
       }
         
        if(dao.buscarProductoPorCodigo(producto.getCodigo()) != null){
             throw new Exception("El codigo ingresado ya corresponde a un producto de la tabla.");
         } 
    
        try {
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
        
        System.out.println("El producto ingresado es: " + producto.toString());
    }
    
    public void editarProducto() throws Exception {
        Producto producto = new Producto();
        
        System.out.println("Ingrese el codigo del producto que quiere modificar:");
        producto.setCodigo(leer.nextInt());
        
        while(producto.getCodigo() <= 0){
           System.out.println("El codigo debe ser mayor a 0. Intente nuevamente:");
           producto.setCodigo(leer.nextInt());
       }
        
        System.out.println("Ingrese el nuevo nombre:");
        producto.setNombre(leer.next());
        
        while(producto.getNombre() == null || producto.getNombre().trim().isEmpty()){
            System.out.println("Debe indicar el nombre del producto. Intente nuevamente:");
            producto.setNombre(leer.next());
        }
        
        System.out.println("Ingrese el precio:");
        producto.setPrecio(leer.nextDouble());
        
         while(producto.getPrecio() <= 0){
            System.out.println("Debe indicar un precio. Intente nuevamente:");
            producto.setPrecio(leer.nextDouble());
        }
        
        System.out.println("Ingrese el codigo del fabricante:");
        producto.setCodigoFabricante(leer.nextInt());
        
         while(producto.getCodigoFabricante()<= 0){
           System.out.println("El codigo debe ser mayor a 0. Intente nuevamente:");
           producto.setCodigoFabricante(leer.nextInt());
       }
        
         if(dao.buscarProductoPorCodigo(producto.getCodigo()) == null){
             throw new Exception("El codigo ingresado no corresponde a ningun producto.");
         }
        try {
            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("El nuevo producto es " + producto.toString());
    }
}

    