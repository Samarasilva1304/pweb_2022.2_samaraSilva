package br.com.samara.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.samara.cadpessoas.model.Pessoa;
import br.com.samara.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {
   
    @Autowired
    PessoaRepository pessoaRepo;

    public PessoaController(PessoaRepository pessoaRepo){
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping
    public String index(){
        return "index.html";
    }
    @GetMapping("/listarPessoas")
  public ModelAndView listarPessoas() {
    List<Pessoa> pessoas = pessoaRepo.findAll();
    ModelAndView mv = new ModelAndView("listarPessoas");
    mv.addObject("pessoas", pessoas);
    return mv;
  }

  // Página de Adicionar Pessoa
  @GetMapping("/adicionarPessoa")
  public ModelAndView formularioAdicionarPessoa() {
    ModelAndView mv = new ModelAndView("adicionarPessoa");
    mv.addObject("pessoa", new Pessoa());
    return mv;
  }
    @PostMapping("/adicionarPessoa")
    public String adicionarPessoa(Pessoa p){
        this.pessoaRepo.save(p);
        return "redirect:/listarPessoas";
    }
    @GetMapping("/remover/{id}")
   public ModelAndView removerPessoa(@PathVariable("id")long id){
    Pessoa aRemover = pessoaRepo.findById(id)
    .orElseThrow(()-> new IllegalArgumentException("inválido" + id));
    
    pessoaRepo.delete(aRemover);
    return new ModelAndView("redirect:/listarPessoas");
   }
    
   @GetMapping("/editar/{id}")
  public ModelAndView formularioEditarPessoas(@PathVariable("id")long id) {
    Pessoa aEditar = pessoaRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("inválido" + id));
    ModelAndView modelAndView = new ModelAndView("editarPessoa");
    modelAndView.addObject(aEditar);
    return modelAndView;
  }
  @PostMapping("/editar{id}")
  public String EditarPessoa(@PathVariable("id")long id, Pessoa p){
      this.pessoaRepo.save(p);
      return "redirect:/listarPessoas";
  }
    }

   
  


    
