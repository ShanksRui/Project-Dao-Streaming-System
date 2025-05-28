package model.Dao;

import java.util.List;

import model.Entities.Streaming;

public interface StreamingDao {

	void insert(Streaming obj);
	void update(Streaming obj);
	void deleteById(Integer id);
	Streaming findById(Integer id);
	List<Streaming> findAll();
}
