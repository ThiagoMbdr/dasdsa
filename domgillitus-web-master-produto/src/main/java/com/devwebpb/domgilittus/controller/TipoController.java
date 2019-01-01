package com.devwebpb.domgilittus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.devwebpb.domgilittus.model.Tipo;
import com.devwebpb.domgilittus.repository.TipoRepository;


public class TipoController extends WebMvcConfigurerAdapter {

	@Autowired
	private TipoRepository tr;

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE", "GET", "POST");
	}

	// Listar todos os tipo de produtos
	@GetMapping("/tipo_listar")
	public ModelAndView Tipo() {
		ModelAndView mv = new ModelAndView("/tipo_listagem");
		List<Tipo> tipo = tr.findAll();
		mv.addObject("tipo", tipo);
		return mv;
	}

	// Método para abrir tela de cadastro de tipo de Produto
	@GetMapping("/tipo_cadastro")
	public String cadastarView(@ModelAttribute("tipo") Tipo tipo) {

		return "/tipo_cadastro";
	}

	// Método para salvar o tipo de produto no banco de dados
	@PostMapping("/tipo_cadastro")
	public String cadastrar(Tipo tipo) {
		tr.save(tipo);
		return "redirect:/tipo_listar";
	}

	@GetMapping("/tipo_cadastro/{id}")
	public ModelAndView atualizarView(@PathVariable(name = "id") Long id) {

		Tipo tipo = tr.findById(id);
		ModelAndView mv = new ModelAndView("/tipo_cadastro");
		mv.addObject("tipo", tipo);
		return mv;

	}

	// Método para atualizar o tipo de produto
	@PostMapping("/tipo_atualizar")
	public String atualizar(Tipo tipo) {
		tr.save(tipo);
		return "redirect:/tipo_listar";
	}

	// Método para abrir tela de visualização de tipo de produto
	@GetMapping("/tipo/{id}")
	public ModelAndView TipoView(@PathVariable(name = "id") Long id) {

		Tipo tipo = tr.findById(id);
		ModelAndView mv = new ModelAndView("/tipo_view");
		mv.addObject("tipo", tipo);
		return mv;

	}

	// Método para remover um tipo de produto
	@GetMapping("/tipo/remover/{id}")
	public String remover(@PathVariable("id") Long id) {
		tr.delete(id);
		return "/tipo_listagem";
	}

}