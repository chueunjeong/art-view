package skhu.artview.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.model.Space;
import skhu.artview.service.SpaceService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class SpaceController {
	
	@Autowired
	SpaceService spaceService;
	
	
	@RequestMapping(value = "spaceDetail" , method= RequestMethod.GET)
	   public List<Space> bookList(Model model, HttpServletRequest request)  throws Exception {
			
	       return spaceService.searchSpace(10,1);
	   }


}
