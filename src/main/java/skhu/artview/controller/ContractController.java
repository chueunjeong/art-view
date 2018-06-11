package skhu.artview.controller;

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

import skhu.artview.dto.Grouping;
import skhu.artview.dto.P_exhibition;
import skhu.artview.mapper.ExhibitionMapper;
import skhu.artview.mapper.P_exhibitionMapper;
import skhu.artview.mapper.GroupingMapper;
import skhu.artview.model.MypageSummary;


@RestController
@CrossOrigin
@RequestMapping("api")
public class ContractController {

	@Autowired
	GroupingMapper groupingMapper;
	
	@Autowired
	ExhibitionMapper exhibitionMapper;
	
	@Autowired
	P_exhibitionMapper p_exhibitionMapper;
	
	
	/*@RequestMapping("contract/{id}")
	public  String makeContract (@PathVariable("id") int space_id,Model model, Authentication auth) {
	
		P_exhibition  p_exhibition = p_exhibitionMapper.findOne(p_exhibition_id)
		

				Grouping grouping = groupingMapper.findOne(p_exhibition.getId());
				Space 
		
		return "계약 완료";
	}
	*/
	
	
}
