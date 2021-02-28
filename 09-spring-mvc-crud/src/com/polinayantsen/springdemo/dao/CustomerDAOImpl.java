package com.polinayantsen.springdemo.dao;

import com.polinayantsen.springdemo.entity.Customer;
import com.polinayantsen.springdemo.util.SortUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(int sortField) {
        Session currentSession = sessionFactory.getCurrentSession();
        String fieldName = null;
        switch (sortField) {
            case SortUtils.FIRST_NAME:
                fieldName = "firstName";
                break;
            case SortUtils.EMAIL:
                fieldName = "email";
                break;
            case SortUtils.LAST_NAME:
            default:
                fieldName = "lastName";
        }
        Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY " + fieldName, Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Customer WHERE id =: customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query;
        if (searchName != null && searchName.trim().length() > 0) {
            query = currentSession.createQuery(
                    "FROM Customer WHERE LOWER(firstName) LIKE :name OR LOWER(lastName) LIKE :name", Customer.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        } else {
            query = currentSession.createQuery("FROM Customer", Customer.class);
        }
        return query.getResultList();
    }
}
