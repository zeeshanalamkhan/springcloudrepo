package novelhealthcare;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dotridge.domain.Hospital;
import com.dotridge.util.SessionFactoryUtil;

public class HibernateCacheTesting 
{
	public static void main(String[] args) 
	{
		HibernateCacheTesting.firstLevelCache();
	}
	public static void firstLevelCache()
	{
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		/*Hospital hospital1 = (Hospital) session.get(Hospital.class, 1);
		session.close();
		
		Session session2 = sessionFactory.openSession();
		Hospital hospital2 = (Hospital) session2.get(Hospital.class, 1);
		session2.close();*/
		
		Query query = session.createQuery("from Hospital");
		query.setCacheable(true);
		List<Hospital> hospitals = query.list();
		
		session.close();
		
		Session session2 = sessionFactory.openSession();
		Query query2 = session2.createQuery("from Hospital");
		query2.setCacheable(true);
		List<Hospital> hospitals2 = query2.list();
		
		session2.close();
	}
}
