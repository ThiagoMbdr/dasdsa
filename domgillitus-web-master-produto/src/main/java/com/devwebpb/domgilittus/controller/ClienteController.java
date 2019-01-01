package com.devwebpb.domgilittus.controller;

import com.devwebpb.domgilittus.model.Cliente;
import com.devwebpb.domgilittus.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Controller
public class ClienteController extends WebMvcConfigurerAdapter {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE", "GET", "POST");
    }

    @GetMapping("/clientes_listar")
    public ModelAndView clientes(){
        ModelAndView mv = new ModelAndView("/cliente_listagem");
        List<Cliente> clientes = clienteRepository.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    //Método para abrir tela de cadastro de cliente
    @GetMapping("/clientes_cadastro")
    public String cadastarView(@ModelAttribute("cliente") Cliente cliente){

        return "/cliente_cadastro";
    }

    //Método para salvar o cliente no banco de dados
    @PostMapping("/cliente_cadastro")
    public String cadastrar(Cliente cliente){
        clienteRepository.save(cliente);
        return "redirect:/clientes_listar";
    }

    @GetMapping("/cliente_cadastro/{id}")
    public ModelAndView atualizarView(@PathVariable(name = "id") Long id){

        Cliente cliente = clienteRepository.findById(id);
        ModelAndView mv = new ModelAndView("/cliente_cadastro");
        mv.addObject("cliente", cliente);
        return mv;

    }

    //Método para atualizar o cliente
    @PostMapping("/cliente_atualizar")
    public String atualizar(Cliente cliente){
        clienteRepository.save(cliente);
        return "redirect:/clientes_listar";
    }

    //Método para abrir tela de visualização de cliente
    @GetMapping("/cliente/{id}")
    public ModelAndView clienteView(@PathVariable(name = "id") Long id){

        Cliente cliente = clienteRepository.findById(id);
        ModelAndView mv = new ModelAndView("/cliente_view");
        mv.addObject("cliente", cliente);
        return mv;

    }
}
