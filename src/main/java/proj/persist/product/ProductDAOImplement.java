package proj.persist.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proj.entity.products.Product;

public class ProductDAOImplement implements ProductDAO {


	@Override
	public void insertProduct(Product prod) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjAppn");
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
	public Product readProduct(Product prod) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjAppn");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		Product p = em.find(Product.class,prod.getProdId());
		
		return p;
	}

	@Override
	public Product updateProduct(Product prod, int param) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjAppn");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		Product p = em.find(Product.class,prod.getProdId());
		
		p.setCost(param);
		return p;
		
	}

	@Override
	public void deleteProduct(Product prod) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjAppn");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		Product p = em.find(Product.class, prod.getProdId());
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("inserted successfully");
		em.close();
		emf.close();
	}

	

}
