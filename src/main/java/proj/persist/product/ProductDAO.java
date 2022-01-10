package proj.persist.product;

import proj.entity.products.Product;

public interface ProductDAO {
	public void insertProduct(Product prod);

	public Product readProduct(Product prod);

	public Product updateProduct(Product prod, int param);

	public void deleteProduct(Product prod);
}
