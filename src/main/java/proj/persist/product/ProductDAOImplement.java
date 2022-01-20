package proj.persist.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proj.entity.products.Product;

public class ProductDAOImplement implements ProductDAO {


	@Override
	public void insertProduct(Product prod) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjectApp");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(prod);
		em.getTransaction().commit();
		System.out.println("inserted successfully");
		em.close();
		emf.close();
	}

	@Override
	public List<Product> readProduct() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjectApp");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
//		String queryString = "select p from products p";
		Query query=em.createQuery("select p from Product p");
		List<Product> products = null;
		try {
			products=query.getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return products;
	}

	@Override
	public Product updateProduct(Product prod, int param) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjectApp");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		Product p = em.find(Product.class,prod.getProductId());
		
		p.setCost(param);
		return p;
		
	}

	@Override
	public void deleteProduct(Product prod) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjectApp");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		Product p = em.find(Product.class, prod.getProductId());
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("inserted successfully");
		em.close();
		emf.close();
	}

	

}
