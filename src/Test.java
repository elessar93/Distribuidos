import java.util.Date;
import java.util.List;

import org.rafa.dao.DAOCompra;
import org.rafa.dao.DAODetalle;
import org.rafa.dao.DAOEstatusCompra;
import org.rafa.dao.DAOProducto;
import org.rafa.dao.DAOTipoUnidad;
import org.rafa.dao.DAOUnidad;
import org.rafa.dao.DAOUsuario;
import org.rafa.dtd.Compra;
import org.rafa.dtd.Detalle;
import org.rafa.dtd.DetalleId;
import org.rafa.dtd.Producto;
import org.rafa.dtd.TipoUnidad;
import org.rafa.dtd.Unidad;
import org.rafa.dtd.UnidadId;
import org.rafa.dtd.Usuario;

public class Test {
	
	public static void main(String[] args) {
		DAOCompra daco = new DAOCompra();
		DAODetalle daode = new DAODetalle();
		DAOProducto daop = new DAOProducto();
		DAOUsuario dau = new DAOUsuario();
		DAOEstatusCompra daec = new DAOEstatusCompra();
		List<Producto> p =daop.prodctosByCategoria(1);
		/*for(Producto paux:p){
			System.out.println(paux);
		}*/
       
    }
	public Compra comprar(Producto[] lp,Usuario u){
		DAOCompra daco = new DAOCompra();
		DAODetalle daode = new DAODetalle();
		DAOProducto daop = new DAOProducto();
		DAOUsuario dau = new DAOUsuario();
		DAOEstatusCompra daec = new DAOEstatusCompra();
		Compra c = new Compra(daec.getById(1) , u);
		c.setFhInicio(new Date());
		daco.nuevo(c);
		for(Producto aux : lp){
			Producto auxp = daop.produtoById(aux.getIdProducto());
			if(aux.getNuExistencia()>auxp.getNuExistencia()){
				return null;
			}
			DetalleId did = new DetalleId();
			did.setCompra(c.getIdCompra());
			Detalle daux=new Detalle(did, c, aux,aux.getNuExistencia() );
			daode.nuevo(daux);
			auxp.setNuExistencia(auxp.getNuExistencia()-aux.getNuExistencia());
			daop.update(auxp);
		}
		return c;
		
	}

}
