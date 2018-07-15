package skhu.artview.controller;
/*전민선 :
 * 전시회 내용 작성
 *  Project 게시글 생성 
 *  		->  Project의 id가 Grouping_id가 되어 P_exhibition 내용 채워지면
 *  						P_exhibition 저장
 *  										-> 공간 계약 내용까지 채워지면
 *  											 Contract 저장
 *  														->전시일, 전시공간이 완전 확정되고 진행완료 후 작성 후 
 *  															 Exhibition 저장됨.
 *  
 * 
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.Contract;
import skhu.artview.dto.Grouping;
import skhu.artview.dto.P_exhibition;
import skhu.artview.mapper.ExhibitionMapper;
import skhu.artview.mapper.P_exhibitionMapper;
import skhu.artview.mapper.GroupingMapper;
import skhu.artview.model.MypageSummary;
import skhu.artview.service.ContractService;


@RestController
@CrossOrigin
@RequestMapping("api")
public class ContractController {

	
	
	@Autowired
	ContractService contractService;
	
	//1.기획서 작성 페이지 (프로젝트 게시글 내용으로 자동채움)
	@RequestMapping("p_exhition/{project_id}")		
	public  P_exhibition showP_exhibition (@PathVariable("id") int project_id,Model model, Authentication auth) {
	
		return contractService.bringProjectArticle(project_id);//프로젝트 내용 불러오기

	}
	
	//2. 기획서 저장
	@RequestMapping(value = "p_exhibition", method=RequestMethod.POST)		
	public String showP_exhibition (@RequestBody P_exhibition p_exhi ,Model model, Authentication auth) {
	
		 contractService.saveP_exhibition(p_exhi);
		 return "저장 완료";
	}
	
	//3. 공간계약 작성 페이지 (프로젝트 기획서 내용과 공간 자동채움)
	@RequestMapping("contract/{project_id}/{space_id}")		//계약서 작성 페이지 자동채움 
	public  Contract makeContract (@PathVariable("project_id") int project_id, Model model,@PathVariable("space_id") int space_id, Authentication auth) {
	
		return contractService.bringP_exhibitionAndSpace(project_id, space_id);
	}
	
	//4. 계약 완료: 공간 계약 정보까지 채워지면 contract에 저장
	@RequestMapping(value = "contract", method=RequestMethod.POST)		
	public String showP_exhibition (@RequestBody Contract cont ,Model model, Authentication auth) {
	
		 contractService.saveContract(cont);
		 return "저장 완료";
	}
	
	
	
	
	
	
}
