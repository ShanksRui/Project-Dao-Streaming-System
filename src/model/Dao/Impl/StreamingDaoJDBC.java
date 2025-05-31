package model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Db;
import db.DbException;
import model.Dao.StreamingDao;
import model.Entities.Streaming;

public class StreamingDaoJDBC implements StreamingDao {

	private Connection con;
	
	public StreamingDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Streaming obj) {
     PreparedStatement ps = null;
     ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("Insert Into Streaming "
					+ "(name,price)"
					+ "Values "
					+ "(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			
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
	}
}		
	@Override
	public void update(Streaming obj) {
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("Update Streaming Set "
					+ "name = ?,price = ? "
					+ "Where id = ?");
			ps.setString(1, obj.getName());
			ps.setDouble(2, obj.getPrice());
			ps.setInt(3, obj.getId());
			
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
				ps = con.prepareStatement("Delete From Streaming Where Id = ?");
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
	public Streaming findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("Select * From Streaming Where Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			Streaming stm = null;
			
			if(rs.next()) {
			   stm = initialStreaming(rs);
			}else {
				throw new DbException("no streams found with that id");
			}			
		return  stm;
		
	}catch(SQLException e) {
		throw new DbException(e.getMessage());
	}finally {
		Db.closePrepareStatement(ps);
		Db.closeResultSet(rs);
	}
}
	@Override
	public List<Streaming> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from Streaming");
			rs = ps.executeQuery();
			
			List<Streaming> list = new ArrayList<>();
			
			while(rs.next()) {
				Streaming stm = initialStreaming(rs);
				list.add(stm);
			}		
			return list;	
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			Db.closePrepareStatement(ps);
			Db.closeResultSet(rs);
		}		
	}
	private Streaming initialStreaming(ResultSet rs) throws SQLException {
		Streaming subs = new Streaming();
		subs.setId(rs.getInt("Id"));
		subs.setName(rs.getString("Name"));
		subs.setPrice(rs.getDouble("Price"));
		return subs;
	}
}
