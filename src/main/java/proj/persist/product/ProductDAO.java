package proj.persist.product;

import java.util.List;

import proj.entity.products.Product;

public interface ProductDAO {
	public void insertProduct(Product prod);

	public List<Product> readProduct();

	public Product updateProduct(Product prod, int param);

	public void deleteProduct(Product prod);
}
