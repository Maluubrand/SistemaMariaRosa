/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MlrVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class VendasDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrVendas.class);
        criteria.add(Restrictions.eq("mlr_id_vendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    
    public Object listClientes(String nomeCliente) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(MlrVendas.class);
    Criteria clienteCrit = criteria.createCriteria("mlrClientes");
    clienteCrit.add(Restrictions.like("nome", "%" + nomeCliente + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();      
    return lista;
}
    public Object listFuncionarios(String nomeFuncionario) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrVendas.class);
        Criteria funcionarioCrit = criteria.createCriteria("mlrFuncionarios"); 
        funcionarioCrit.add(Restrictions.like("mlrNome", "%" + nomeFuncionario + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();      
        return lista;
}
    public Object listTotal(double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrVendas.class);
        criteria.add(Restrictions.ge("mlrTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    } 
    
    public Object listFuncCliTotal(String nomeCliente, String nomeFuncionario, double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrVendas.class);
        Criteria clienteCrit = criteria.createCriteria("mlrClientes");
        clienteCrit.add(Restrictions.like("mlrNome", "%" + nomeCliente + "%"));
        Criteria funcionarioCrit = criteria.createCriteria("mlrFuncionarios");
        funcionarioCrit.add(Restrictions.like("mlrNome", "%" + nomeFuncionario + "%"));
        criteria.add(Restrictions.ge("mlrTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();      
        return lista;
}

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.listAll();
    }
}
