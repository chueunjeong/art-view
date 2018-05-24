package skhu.artview.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.model.Item;
import skhu.artview.service.MuseumService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class MuseumController {

	@Autowired
	MuseumService service;

	@RequestMapping("bookList")
		   public List<Item> bookList(Model model, HttpServletRequest request, @RequestParam(required=false)String keyword)  throws Exception {
			keyword="java";

		       return service.searchItem(keyword,1,10);
		   }
}
