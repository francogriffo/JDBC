package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void guardarProducto(Producto producto) throws Exception {
 
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }

            String sql = "INSERT INTO Producto (codigo, nombre, precio, codigo_fabricante)"
                    + "VALUES ( " + producto.getCodigo() + " , '" + producto.getNombre() + "' , " + producto.getPrecio() + " , " + producto.getCodigoFabricante() + " );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + " nombre = '" + producto.getNombre() + "' , precio = " + producto.getPrecio() + " , codigo_fabricante = " + producto.getCodigoFabricante()
                    + " WHERE codigo = " + producto.getCodigo() + "";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {

            String sql = "DELETE FROM Producto WHERE codigo = '" + codigo + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Producto> buscarProductoPorNombre() throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE nombre LIKE '%portatil%'";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(3));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> buscarProductoPorPrecio() throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE precio BETWEEN 120 AND 202";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM Producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Producto buscarProductoPorPrecioMinimo() throws Exception {
        try {

            String sql = "SELECT * FROM Producto ORDER BY precio ASC LIMIT 1 ";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
