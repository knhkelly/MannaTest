package manna.back.test;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MannaDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<MannaVO> getAll() {
		return mybatis.selectList("MannaDAO.getAll");
	}
	
	public MannaVO getPackage(MannaVO vo) {
		return mybatis.selectOne("MannaDAO.getPackage", vo);
	}
	
	public void insertPackage(MannaVO vo) {
		mybatis.insert("MannaDAO.insertPackage", vo);
	}
	
	public void updatePackage(MannaVO vo) {
		mybatis.update("MannaDAO.updatePackage", vo);
	}
	
	public void deletePackage(MannaVO vo) {
		mybatis.delete("MannaDAO.deletePackage", vo);
	}
	
	public MannaVO getLastId() {
		return mybatis.selectOne("MannaDAO.getLastId");
	}
	
}
