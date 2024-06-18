package manna.back.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MannaController {
	@Autowired
	private MannaService MannaService;
	
	
	@RequestMapping("")
	public String getAll(MannaVO vo, Model model) {
		model.addAttribute("packageList", MannaService.getAll());

		return " ";
	}
	
	@RequestMapping("")
	public String getPackage(MannaVO vo, Model model) {
		model.addAttribute("package", MannaService.getPackage(vo));

		return " ";
	}
	
	
	@RequestMapping("")
	public String insertPackage(MannaVO vo, Model model) {
		int trackingNO = vo.getTrackingNo(); //운송장번호는 의존성주입을 통해 자동으로 입력되었을 것이라 가정
		
		String[] images = vo.getImages(); //이미지 관련 파일들은 프론트단에서 ["파일명1, 타입", "파일명2, 타입", ... ] 형태로 들어왔을 것이라 가정
		for(String image : images) {
			MannaVO lastPKG = MannaService.getLastId();
			int id = lastPKG.getId() + 1;
			vo.setId(id);
			vo.setImage(image);
			MannaService.insertPackage(vo);
		}
		
		return " ";
	}
	
	@RequestMapping("")
	public String updatePackage(MannaVO vo, Model model) {
		//운송장번호로 조회한 배송목록 중 일부 상품을 수정하는 경우를 가정
		MannaService.updatePackage(vo);
		
		//전체 목록이 뜬 페이지로 돌아갈 것이라고 가정
		model.addAttribute("packageList", MannaService.getAll());
		
		return " ";
	}

	@RequestMapping("")
	public String deletePackage(MannaVO vo, Model model) {
		MannaService.deletePackage(vo);
		
		//전체 목록이 뜬 페이지로 돌아갈 것이라고 가정
		model.addAttribute("packageList", MannaService.getAll());
		
		return " ";
	}
}
