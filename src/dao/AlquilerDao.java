package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Alquiler;

public class AlquilerDao {
	private static Session session;
	private Transaction tx;
	private static AlquilerDao instancia = null;

	protected AlquilerDao() {
	}

	public static AlquilerDao getInstance() {
		if (instancia == null) {
			instancia = new AlquilerDao();
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

	public Alquiler traerAlquiler(int id) {
		Alquiler alquiler = null;
		try {
			iniciaOperacion();
			alquiler = (Alquiler) session.createQuery("from Alquiler a where a.idAlquiler=" + id).uniqueResult();
			Hibernate.initialize(alquiler.getPropiedad());
		} finally {
			session.close();
		}
		return alquiler;
	}

	@SuppressWarnings("unchecked")
	public List<Alquiler> traerAlquileres() throws HibernateException {
		List<Alquiler> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Alquiler").list();

			for (Alquiler a : lista) {
				Hibernate.initialize(a.getPropiedad());
			}

		} finally {
			session.close();
		}
		return lista;
	}

}
