package manna.back.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mannaService")
public class MannaServiceImpl implements MannaService{
	@Autowired
	private MannaDAO mannaDAO;

	@Override
	public List<MannaVO> getAll() {
		return mannaDAO.getAll();
	}

	@Override
	public MannaVO getPackage(MannaVO vo) {
		return mannaDAO.getPackage(vo);
	}

	@Override
	public void insertPackage(MannaVO vo) {
		mannaDAO.insertPackage(vo);		
	}

	@Override
	public void updatePackage(MannaVO vo) {
		mannaDAO.updatePackage(vo);	
	}

	@Override
	public void deletePackage(MannaVO vo) {
		mannaDAO.deletePackage(vo);	
	}

	@Override
	public MannaVO getLastId() {
		return mannaDAO.getLastId();
	}

	
}
