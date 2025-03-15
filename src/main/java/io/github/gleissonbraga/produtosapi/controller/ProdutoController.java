package io.github.gleissonbraga.produtosapi.controller;

import io.github.gleissonbraga.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marca esta classe para ser um controlador Rest
@RequestMapping("produtos") // Para dizer qual é a url básica deste controller
public class ProdutoController {

    @PostMapping
    // Para retornar o produto, necessito chamar a chasse após o public (public Class nome métod) e retornar no código
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);
        return produto;
    }
}
