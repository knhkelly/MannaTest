package manna.back.test;

import java.util.List;

public interface MannaService {
	public List<MannaVO> getAll();
	public MannaVO getPackage(MannaVO vo);
	public void insertPackage(MannaVO vo);
	public void updatePackage(MannaVO vo);
	public void deletePackage(MannaVO vo);
	public MannaVO getLastId();
}
