package model.Dao;

import java.util.List;

import model.Entities.Streaming;
import model.Entities.Subscriber;

public interface SubscriberDao {

	
	void insert(Subscriber obj);
	void update(Subscriber obj);
	void deleteById(Integer id);
	Subscriber findById(Integer id);
	List<Subscriber> findAll();
	List<Subscriber> findByStreaming(Streaming streaming);
	
}

