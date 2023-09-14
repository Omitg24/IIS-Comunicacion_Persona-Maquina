package logica;

import java.util.*;

/**
 * Titulo: Clase Pedido
 * 
 * @author Omitg
 * @version 23/09/2021
 */
public class Pedido {
	/**
	 * Atributo listaPedido
	 */
	private List<Articulo> listaPedido;
	/**
	 * Atributo codigo
	 */
	private String codigo;
	
	/**
	 * Constructor del pedido
	 */
	public Pedido(){
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	/**
	 * M�todo que inicializa
	 */
	public void inicializar(){
		listaPedido.clear();
		generarCodigo();
	}
	
	/**
	 * M�todo que a�ade articulos
	 * 
	 * @param articuloDelCatalogo
	 * @param unidades
	 */
	public void add(Articulo articuloDelCatalogo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : listaPedido){
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo()))
			{
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}
		
		if (articuloEnPedido == null){
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}
		
	}
	
	/**
	 * M�todo que devuelve el total
	 * 
	 * @return precio
	 */
	public float getTotal() {
		float precio = 0;
		for (Articulo a : listaPedido){
			precio += a.getPrecio()* a.getUnidades();
		}
		return precio;
	}
	
	/**
	 * M�todo que graba el pedido
	 */
	public void grabarPedido(){
		FileUtil.saveToFile(codigo, listaPedido);
	  }
	
	/**
	 * M�todo que devuelve el codigo
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo que genera codigo
	 */
	private void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for(int i=0; i<longitudCodigo;i++){ 
			int numero = (int)(Math.random()*(base.length())); 
			codigo += base.charAt(numero);
		}
	}
}

