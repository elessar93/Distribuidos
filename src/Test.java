import org.rafa.dao.DAOProducto;
import org.rafa.dao.DAOUsuario;
import org.rafa.dtd.Producto;
import org.rafa.dtd.Usuario;

public class Test {
	public static void main(String[] args) {
        /*DAOProducto da = new DAOProducto();
        
        Producto p = new Producto(1, 1, 10, (float) 23.4);
        System.out.println(p);
        da.alta(p);
        System.out.println(p);*/
		DAOUsuario daou= new DAOUsuario();
		Usuario u = daou.login("rafa", "burri");
				//new Usuario("rafa", "burris", 0);
		//daou.registrar(u);
		
		System.out.println(u);
    }

}
