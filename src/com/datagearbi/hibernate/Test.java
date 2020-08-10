package com.datagearbi.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.datagearbi.hibernate.model.GoalAlert;
import com.datagearbi.hibernate.model.ProteinData;
import com.datagearbi.hibernate.model.User;
import com.datagearbi.hibernate.model.UserHistory;
import com.datagearbi.hibernate.model.UserTotal;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello world");
		populateSampleData();

		Session session = HibernateUtitlities.getSessionFactory().openSession();
		session.beginTransaction();

//		Query query = session.createQuery("FROM GoalAlert").setFirstResult(2).setMaxResults(1);
//		Query query = session.getNamedQuery("AllGoalAlerts");
//		Query query = session.createQuery("select new "
//				+ "com.datagearbi.hibernate.model.UserTotal(user.name, user.proteinData.total) "
//				+ "From User user");
		
//		Criteria critiria = session.createCriteria(User.class).add(Restrictions.or(
//				Restrictions.eq("name", "Jeo"),
//				Restrictions.eq("name", "Loai")
//				)).setProjection(Projections.projectionList()
//				.add(Projections.property("name"))
//				.add(Projections.property("id"))
//				);		
//		List<Object[]> users = critiria.list();
//		for (Object[] user : users) {
//			for(Object o : user)
//			System.out.println(o.toString());
//		}
		
		Query query = session.createSQLQuery("SELECT * FROM Users").addEntity(User.class);
		List<User> users = query.list();
		for(User user : users) {
			System.out.println(user.getName());
		}
		
		
		
		session.getTransaction().commit();
		HibernateUtitlities.getSessionFactory().close();
	}

	private static void populateSampleData() {
		Session session = HibernateUtitlities.getSessionFactory().openSession();
		// Save User in the dataBase...
		session.beginTransaction();

		User jeo = createUser("Joe", 500, 50, "Good Job", "You made it!");
		session.save(jeo);

		User bob = createUser("Bob", 300, 20, "Take Your time!");
		session.save(bob);

		User loai = createUser("Loai", 250, 200, "Yes!!!");
		session.save(loai);

		session.getTransaction().commit();
		session.close();
	}

	private static User createUser(String name, int goal, int total, String... alerts) {
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
		user.addHistory(new UserHistory(new Date(), "Set total to " + total));

		for (String alert : alerts) {
			user.getGoalAlert().add(new GoalAlert(alert));
		}
		return user;
	}

}
