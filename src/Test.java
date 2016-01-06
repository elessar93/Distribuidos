import java.util.List;

import org.rafa.dao.DAOProducto;
import org.rafa.dao.DAOTipoUnidad;
import org.rafa.dao.DAOUnidad;
import org.rafa.dao.DAOUsuario;
import org.rafa.dtd.Producto;
import org.rafa.dtd.TipoUnidad;
import org.rafa.dtd.Unidad;
import org.rafa.dtd.UnidadId;
import org.rafa.dtd.Usuario;

public class Test {
	public static void main(String[] args) {
        /*DAOProducto da = new DAOProducto();
        
        Producto p = new Producto(1, 1, 10, (float) 23.4);
        System.out.println(p);
        da.alta(p);
        System.out.println(p);*/
		DAOUsuario daou= new DAOUsuario();
		Usuario u = daou.usuarioById(1);
				//new Usuario("rafa", "burris", 0);
		//daou.registrar(u);
		DAOTipoUnidad dtu = new DAOTipoUnidad();
		//TipoUnidad tu = new TipoUnidad("Dimension", "Mide tamaño de objetos");
		List<TipoUnidad> tus = dtu.getAll();
		for(TipoUnidad tu : tus){
			System.out.println(tu);
		}
		DAOUnidad dau = new DAOUnidad();
		UnidadId uid = new UnidadId();
		uid.setIdTipo(1);
		Unidad u1 = new Unidad(uid,dtu.getById(1), "mile", "mi");
		dau.alta(u1);
		System.out.println(u1.getId());
    }

}
