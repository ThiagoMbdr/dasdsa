package com.devwebpb.domgilittus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.devwebpb.domgilittus.model.Produtos;
import com.devwebpb.domgilittus.repository.ProdutosRepository;

@Controller
public class ProdutoController extends WebMvcConfigurerAdapter {

	@Autowired
	private ProdutosRepository pr;

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE", "GET", "POST");
	}

	// Listar todos os Produtos
	@GetMapping("/produtos_listar")
	public ModelAndView Produtos() {
		ModelAndView mv = new ModelAndView("/produtos_listagem");
		List<Produtos> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}

	// Método para abrir tela de cadastro de Produto
	@GetMapping("/produtos_cadastro")
	public String cadastarView(@ModelAttribute("produtos") Produtos produtos) {

		return "/produtos_cadastro";
	}

	// Método para salvar os produtos no banco de dados
	@PostMapping("/produtos_cadastro")
	public String cadastrar(Produtos produtos) {
		pr.save(produtos);
		return "redirect:/produtos_listar";
	}

	@GetMapping("/produtos_cadastro/{id}")
	public ModelAndView atualizarView(@PathVariable(name = "id") Long id) {

		Produtos produtos = pr.findById(id);
		ModelAndView mv = new ModelAndView("/produtos_cadastro");
		mv.addObject("produtos", produtos);
		return mv;

	}

	// Método para atualizar os produtos
	@PostMapping("/produtos_atualizar")
	public String atualizar(Produtos produtos) {
		pr.save(produtos);
		return "redirect:/produtos_listar";
	}

	// Método para abrir tela de visualização dos produtos
	@GetMapping("/produtos/{id}")
	public ModelAndView ProdutoView(@PathVariable(name = "id") Long id) {

		Produtos produtos = pr.findById(id);
		ModelAndView mv = new ModelAndView("/produtos_view");
		mv.addObject("produtos", produtos);
		return mv;

	}

	// Método para remover o produto
	@GetMapping("/produtos/remover/{id}")
	public String remover(@PathVariable("id") Long id) {
		pr.delete(id);
		return "/produtos_listagem";
	}

}
