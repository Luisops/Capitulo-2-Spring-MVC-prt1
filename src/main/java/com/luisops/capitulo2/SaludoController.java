package com.luisops.capitulo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaludoController {
	
	@RequestMapping("saludo")
	public String saludar() {
		return "saludo.jsp";
	}
}
