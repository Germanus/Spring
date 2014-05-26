package my.ilya.controllers;

import java.util.ArrayList;
import java.util.List;

import my.ilya.model.Beer;
import my.ilya.model.Color;
import my.ilya.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BeerController {

	@RequestMapping(value = "beer/beer-input", method = RequestMethod.GET)
	public void beerAdvice(Model model) {

		model.addAttribute(new Color());

	}

	@RequestMapping(value = "beer/beer-advice", method = RequestMethod.POST)
	public void simple(@ModelAttribute Color color, Model model) {
		List<String> beers = new ArrayList<String>();
		beers.add("fff");
		beers.add("fefef");
		model.addAttribute("beers", beers);

	}

}