/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MlrUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class UsuariosDAO extends AbstractDAO{

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
        Criteria criteria = session.createCriteria(MlrUsuarios.class);
        criteria.add(Restrictions.eq("mlr_id_usuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrUsuarios.class);
        criteria.add(Restrictions.like("mlrNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listCpf(String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrUsuarios.class);
        criteria.add(Restrictions.like("mlrCpf", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeCpf(String nome, String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrUsuarios.class);
        criteria.add(Restrictions.like("mlrNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("mlrCpf", cpf ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
      public MlrUsuarios Login(String apelido, String senha) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrUsuarios.class);
        criteria.add(Restrictions.eq("mlrApelido", apelido));
        criteria.add(Restrictions.eq("mlrSenha", senha));
        MlrUsuarios usuarios = (MlrUsuarios)criteria.uniqueResult();
        session.getTransaction().commit();        
        return usuarios;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MlrUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.listAll();
    }
}
