package io.github.gleissonbraga.produtosapi.controller;

import io.github.gleissonbraga.produtosapi.model.Produto;
import io.github.gleissonbraga.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Marca esta classe para ser um controlador Rest
@RequestMapping("produtos") // Para dizer qual é a url básica deste controller
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    // CRIANDO PRODUTOS
    @PostMapping
    // Para retornar o produto, necessito chamar a chasse após o public (public Class nome métod) e retornar no código
    public Produto salvar(@RequestBody Produto produto){

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        // DUAS POSSIBILIDADES DE RETORNAR UM PRODUTO

        // 1)
//        Optional<Produto> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;

        // 2)
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }
}
