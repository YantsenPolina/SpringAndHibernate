package com.polinayantsen.springdemo.dao;

import java.util.List;

import com.polinayantsen.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("DELETE FROM Customer WHERE id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}
}











