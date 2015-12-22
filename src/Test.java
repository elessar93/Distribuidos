import org.rafa.dao.DAOProducto;
import org.rafa.dtd.Producto;

public class Test {
	public static void main(String[] args) {
        DAOProducto da = new DAOProducto();
        
        Producto p = new Producto(1, 1, 10, (float) 23.4);
        System.out.println(p);
        da.alta(p);
        System.out.println(p);
    }

}
