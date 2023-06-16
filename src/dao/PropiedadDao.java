package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Propiedad;

public class PropiedadDao {
	private static Session session;
	private Transaction tx;
	private static PropiedadDao instancia = null;

	protected PropiedadDao() {
	}

	public static PropiedadDao getInstance() {
		if (instancia == null) {
			instancia = new PropiedadDao();
		}
		return instancia;
	}

	/*------------------------------------------------------------------------------*/

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	/*------------------------------------------------------------------------------*/

	@SuppressWarnings("unchecked")
	public List<Propiedad> traerPropiedad() throws HibernateException {
		List<Propiedad> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Propiedad").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
}
