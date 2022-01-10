package proj.persist.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import proj.entity.users.User;

public class UserDAOImplement implements UserDAO {
	EntityManagerFactory emf;
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("in userdao-1");
		emf= Persistence.createEntityManagerFactory("ProjectApp");
		EntityManager em=emf.createEntityManager();
		System.out.println("database connected");
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		System.out.println("inserted successfully");
		em.close();
		emf.close();
	}
	@Override
	public User readUser(User user) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjAppn");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		User u = em.find(User.class,user.getUserId());
		return u;
	}
	@Override
	public User updateUser(User user, String password) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjAppn");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		User u = em.find(User.class,user.getUserId());
		u.setPassword(password);
		return u;
	}
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProjAppn");
		System.out.println("database connected");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		User u = em.find(User.class,user.getUserId());
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("inserted successfully");
		em.close();
		emf.close();
	}

}
