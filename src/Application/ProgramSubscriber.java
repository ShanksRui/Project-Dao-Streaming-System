package Application;

import java.util.ArrayList;
import java.util.List;

import model.Dao.DaoFactory;
import model.Dao.SubscriberDao;
import model.Entities.Streaming;
import model.Entities.Subscriber;

public class ProgramSubscriber {

	public static void main(String[] args) {
		SubscriberDao subsDao = DaoFactory.CreateSubscriber();
		List<Subscriber> list = new ArrayList<>();
		Streaming str = new Streaming(2, "youtube", 23.00);
		list = subsDao.findByStreaming(str);
		list.forEach(System.out::println);
	}

}
