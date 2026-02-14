package articulo;
public class Articulo {
	
	private String codigo;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int stock;
	private int unidVendidas;

	public Articulo() {
		this.codigo = "";
		this.descripcion = "";
		this.precioCompra = 0.0;
		this.precioVenta = 0.0;
		this.stock = 0;
		this.unidVendidas = 0;
	}

	public Articulo(String codigo, String descripcion, double precioCompra, double precioVenta, int stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.unidVendidas = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public int getStock() {
		return stock;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getUnidVendidas() {
		return unidVendidas;
	}

	public void setUnidVendidas(int unidVendidas) {
		this.unidVendidas = unidVendidas;
	}

	@Override
	public String toString() {
		return String.format("""
			------------------------------------
			Código: %s
			Descripción: %s
			Precio de compra: %.2f
			Precio de venta: %.2f
			Stock: %d unidades
			------------------------------------
			""", codigo, descripcion, precioCompra, precioVenta, stock);
	}
}
