package Application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.Db;
import model.Dao.DaoFactory;
import model.Dao.SubscriberDao;
import model.Entities.Streaming;
import model.Entities.Subscriber;

public class ProgramSubscriber {

	public static void main(String[] args) {
		System.out.println("|Testing Dao|");
		SubscriberDao subsDao = DaoFactory.CreateSubscriber();
		
		List<Subscriber> list = new ArrayList<>();
		list = subsDao.findByStreaming(new Streaming(1, null, null));
		System.out.println("Test FindByStreaming ===========");
		list.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Test FindAll ===========");
		list = subsDao.findAll();
		list.forEach(System.out::println);
		System.out.println();
		
		Subscriber subs = subsDao.findById(1);
		System.out.println("Test FindById ===========");
		System.out.println(subs);
		System.out.println();
         
		System.out.println("Test Update ===========");		
		subs = subsDao.findById(3);
		subs.setName("pamella");
		subs.setSalary(1200.0);
		subsDao.update(subs);
		System.out.println(subs);
		System.out.println();
		
		System.out.println("Test Insert ===========");	
		Streaming stm = new Streaming(3,null, null);
	    subsDao.insert(new Subscriber(null, "peter", 1500.0, LocalDate.now(),stm));
	    System.out.println();
	    
	    System.out.println("Test DeleteById ===========");	
	    subsDao.deleteById(4);
	    
        Db.closeConnection();
	}

}
