package com.seconlevelcache.SecondLevelCachingEg;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.seconlevelcache.SecondLevelCachingEg.Entity.SecondCache;

//import jakarta.transaction.Transaction;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SecondCache cx=null;
    	Configuration con=new Configuration().configure().addAnnotatedClass(SecondCache.class);
        ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf=con.buildSessionFactory(sr);
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();
        cx=(SecondCache)session.get(SecondCache.class, 1);
        System.out.println(cx);
        //since same data is needed from the same session(session1) the same data will be extracted using the same query using the same sessio
        cx=(SecondCache)session.get(SecondCache.class, 1);
        System.out.println(cx);
        //ew query will be created 
        cx=(SecondCache)session.get(SecondCache.class, 2);
        System.out.println(cx);
        List<SecondCache> resultList = session.createQuery("from SecondCache", SecondCache.class).list();

        for (SecondCache entity : resultList) {
            System.out.println(entity);
        }
        for (SecondCache entity : resultList) {
            System.out.println(entity);
        }
        tx.commit();
        Session session1=sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        cx=(SecondCache)session1.get(SecondCache.class, 1);
        System.out.println(cx);
        //since same data is needed from the same session(session1) the same data will be extracted using the same query using the same sessio
        cx=(SecondCache)session1.get(SecondCache.class, 1);
        System.out.println(cx);
        //ew query will be created 
        cx=(SecondCache)session1.get(SecondCache.class, 2);
        System.out.println(cx);
        List<SecondCache> resultList1 = session1.createQuery("from SecondCache", SecondCache.class).list();
        Query result = session1.createQuery("from SecondCache WHERE ID=1");
        result.setCacheable(true);
        System.out.println("result of uique set:" +result.uniqueResult());
        for (SecondCache entity : resultList1) {
            System.out.println(entity);
        }
        for (SecondCache entity : resultList1) {
            System.out.println(entity);
        }
        tx1.commit();
        Session session11=sf.openSession();
        Transaction tx11 = session11.beginTransaction();
        cx=(SecondCache)session11.get(SecondCache.class, 1);
        System.out.println(cx);
        //since same data is needed from the same session(session1) the same data will be extracted using the same query using the same sessio
        cx=(SecondCache)session11.get(SecondCache.class, 1);
        System.out.println(cx);
        //ew query will be created 
        cx=(SecondCache)session11.get(SecondCache.class, 2);
        System.out.println(cx);
        List<SecondCache> resultList11 = session11.createQuery("from SecondCache", SecondCache.class).list();
        Query result1 = session11.createQuery("from SecondCache WHERE ID=1");
        result.setCacheable(true);
        System.out.println("result of uique set:" 		+result1.uniqueResult());
        for (SecondCache entity : resultList11) {
            System.out.println(entity);
        }
        for (SecondCache entity : resultList11) {
            System.out.println(entity);
        }
        tx11.commit();
    }
}
