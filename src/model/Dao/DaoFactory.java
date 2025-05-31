package model.Dao;

import db.Db;
import model.Dao.Impl.StreamingDaoJDBC;
import model.Dao.Impl.SubscriberDaoJDBC;

public class DaoFactory {

	public static StreamingDao CreateStreaming() {
		return new StreamingDaoJDBC(Db.getConnection());
	}
	public static SubscriberDao CreateSubscriber() {
		return new SubscriberDaoJDBC(Db.getConnection());
	}
	
}
