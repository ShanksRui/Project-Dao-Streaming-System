package Application;

import java.util.ArrayList;
import java.util.List;

import model.Dao.DaoFactory;
import model.Dao.StreamingDao;
import model.Entities.Streaming;

public class ProgramStreaming {

	public static void main(String[] args) {
	 StreamingDao stmDao = DaoFactory.CreateStreaming();
	 Streaming stm = new  Streaming();
	 
	 System.out.println("Test FindById ===========");	
	 stm = stmDao.findById(2);
	 System.out.println(stm);
	 System.out.println();
	 
	 System.out.println("Test Insert ==========="); 
	 stmDao.insert(new Streaming(null, "disney", 23.90));
	 
	 System.out.println("Test FindAll ===========");
	 List<Streaming> list = new ArrayList<>();
	 list = stmDao.findAll();
	 list.forEach(System.out::println);
	 System.out.println();
	 
	 System.out.println("Test Update ===========");
	 stm = stmDao.findById(1);
	 stm.setName("Spotify");
	 stm.setPrice(12.99);
	 stmDao.update(stm);
	 System.out.println(stm);
	 
	 System.out.println("Test DeleteById ===========");
     System.out.println("has referential integrity security for subscribers associated with certain streaming services ");
     System.out.println("i'm going to create a Streaming with no associated subscribers so I can run deleteById "
     		+ "without triggering my referential integrity exception");
     
     stmDao.insert(new Streaming(null, "disney", 23.90)); //line7
     stmDao.deleteById(7);
     
     System.out.println("tests completed");
	}

}
