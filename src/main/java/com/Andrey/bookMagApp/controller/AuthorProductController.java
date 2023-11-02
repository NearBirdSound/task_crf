package com.Andrey.bookMagApp.controller;

import com.Andrey.bookMagApp.converter.AuthorProductConverter;
import com.Andrey.bookMagApp.dto.AuthorProductDTO;
import com.Andrey.bookMagApp.model.AuthorProduct;
import com.Andrey.bookMagApp.service.AuthorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorproduct")
public class AuthorProductController {
    private final AuthorProductService authorProductService;

    private final AuthorProductConverter authorProductConverter;
    @Autowired
    public AuthorProductController(AuthorProductService authorProductService, AuthorProductConverter authorProductConverter) {
        this.authorProductService = authorProductService;
        this.authorProductConverter = authorProductConverter;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<AuthorProductDTO> getAllAuthorProducts() {
        List<AuthorProduct> authorProducts = authorProductService.getAll();
        return authorProductConverter.toAuthorProductDTOList(authorProducts);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addAuthorProduct(@RequestBody AuthorProduct authorProduct) {
        authorProductService.add(authorProduct);
    }

    @RequestMapping(value = "/del/{authorId}/{productId}", method = RequestMethod.DELETE)
    public void deleteAuthorProduct(
            @PathVariable("authorId") int authorId,
            @PathVariable("productId") int productId
    ) {
        authorProductService.delete(authorId, productId);
    }
}