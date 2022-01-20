package proj.persist.admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proj.entity.admin.Admin;

public class AdminDAOImplement implements AdminDAO {
	EntityManagerFactory emf;
	
	@Override
	public Admin readAdmin(String emailId) {
		// TODO Auto-generated method stub
		System.out.println("in admindao");
		emf= Persistence.createEntityManagerFactory("ProjectApp");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		Admin u = em.find(Admin.class,emailId);
		return u;
	}

}
