package model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.Db;
import db.DbException;
import model.Dao.SubscriberDao;
import model.Entities.Streaming;
import model.Entities.Subscriber;

public class SubscriberDaoJDBC implements SubscriberDao{

	private Connection con;
	
	public SubscriberDaoJDBC(Connection con) {
		this.con = con;
	}	
	@Override
	public void insert(Subscriber obj) {
      PreparedStatement ps = null;
	  ResultSet rs = null;
		try {
			ps = con.prepareStatement("Insert Into Subscriber "
					+ "(name,salary,start_of_subscription,StreamingId) "
					+ "Values "
					+ "(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getName());
			ps.setDouble(2, obj.getSalary());
			ps.setDate(3, java.sql.Date.valueOf(obj.getStartSubscription()));
			ps.setInt(4, obj.getStreaming().getId());
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				rs = ps.getGeneratedKeys();			
			if(rs.next()) {
				int id = rs.getInt(1);
				obj.setId(id);
				System.out.println("key: "+obj.getId());
			}else {
				throw new DbException("no lies inserted");
			}
	}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			Db.closePrepareStatement(ps);
			Db.closeResultSet(rs);
		}		
	}
	@Override
	public void update(Subscriber obj) {
          PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("Update Subscriber set "
					+ "name = ?,salary = ?,start_of_subscription = ?,StreamingId = ? "
					+ "Where Id = ?");	

		    ps.setString(1, obj.getName());
		    ps.setDouble(2, obj.getSalary());
		    ps.setDate(3, java.sql.Date.valueOf(obj.getStartSubscription()));
		    ps.setInt(4, obj.getStreaming().getId());
		    ps.setInt(5, obj.getId());
		    
		    ps.execute();
		
	}catch(SQLException e) {
		throw new DbException(e.getMessage());
	}finally {
		Db.closePrepareStatement(ps);
	}
}
	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("Delete From Subscriber Where id = ?");	
		    ps.setInt(1, id);
		    int rows = ps.executeUpdate();
		    
		    if(rows > 0) {
		    	System.out.println("line deleted");
		    }else {
		    	System.out.println("no lines affected");
		    }
		    
	}catch(SQLException e) {
	       throw new DbException(e.getMessage());
		}finally {
			Db.closePrepareStatement(ps);
}
	}
	@Override
	public Subscriber findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("Select Subscriber.*, Streaming.name as stName,price as stPrice "
					+ "from Subscriber inner join Streaming on "
					+ " Subscriber.StreamingId = Streaming.Id "
					+ "Where Subscriber.Id = ?");	
			ps.setInt(1, id);
			rs = ps.executeQuery();
			Subscriber subs = null;
			if(rs.next()) {
				Streaming stm = initiateStreaming(rs);
				subs = initiateSubscriber(rs, stm);
			}			
		return subs;	
		
	}catch(SQLException e) {
	       throw new DbException(e.getMessage());
		}finally {
			Db.closePrepareStatement(ps);
			Db.closeResultSet(rs);
}
	}
	@Override
	public List<Subscriber> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select subscriber.*, Streaming.name as stName,price as stPrice"
					+ " from subscriber inner join streaming "
					+ " on subscriber.StreamingId = streaming.Id ");
		
		rs = ps.executeQuery();
		List<Subscriber> list = new ArrayList<>();
		Map<Integer,Streaming> map = new HashMap<>();
		
		while(rs.next()) {
			Streaming stm = map.get(rs.getInt("StreamingId"));
			
			if(stm == null) {
				stm = initiateStreaming(rs);
				map.put(rs.getInt("StreamingId"), stm);
			}
			Subscriber subs = initiateSubscriber(rs, stm);
			list.add(subs);
		}
		return list;
		
		
	}catch(SQLException e) {
       throw new DbException(e.getMessage());
	}finally {
		Db.closePrepareStatement(ps);
		Db.closeResultSet(rs);
	}
}
	@Override
	public List<Subscriber> findByStreaming(Streaming streaming) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select subscriber.*, Streaming.name as stName,price as stPrice"
					+ " from subscriber inner join streaming "
					+ " on subscriber.StreamingId = streaming.Id "
					+ " WHERE StreamingId = ?");
			
			ps.setInt(1, streaming.getId());
			rs = ps.executeQuery();
			List<Subscriber> list = new ArrayList<>();
			
			if(rs.next()) {
		        Streaming st = initiateStreaming(rs);			 
			 do{
				Subscriber subs = initiateSubscriber(rs, st);
				list.add(subs);		
				
			 }while(rs.next());
		}	
			return list;	
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			Db.closePrepareStatement(ps);
			Db.closeResultSet(rs);
		}		
	}
	
	private Subscriber initiateSubscriber(ResultSet rs, Streaming strm) throws SQLException {
		Subscriber sb = new Subscriber();
		sb.setId(rs.getInt("id"));
		sb.setName(rs.getString("name"));
		sb.setSalary(rs.getDouble("salary"));
		sb.setStartSubscription(rs.getDate("start_of_subscription").toLocalDate());
		sb.setStreaming(strm);
		return sb;
	}
	private Streaming initiateStreaming(ResultSet rs) throws SQLException {
		Streaming subs = new Streaming();
		subs.setId(rs.getInt("StreamingId"));
		subs.setName(rs.getString("stName"));
		subs.setPrice(rs.getDouble("stPrice"));
		return subs;
}
 } 
