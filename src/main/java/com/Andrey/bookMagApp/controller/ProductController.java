package com.Andrey.bookMagApp.controller;

import com.Andrey.bookMagApp.converter.ProductConverter;
import com.Andrey.bookMagApp.dto.ProductDTO;
import com.Andrey.bookMagApp.model.Product;
import com.Andrey.bookMagApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    private final ProductConverter productConverter;
    @Autowired
    public ProductController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    //Get products By Author Id

    @RequestMapping(value = "/by-author/{authorId}", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDTO> getByAuthorId(@PathVariable("authorId") int authorId) {
        return productConverter.toProductDTOList(productService.getProductsByAuthorId(authorId));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ProductDTO> getAllProducts() {
        return productConverter.toProductDTOList(productService.getAll());
    }

    @RequestMapping(value = "/one/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public ProductDTO getProductById(@PathVariable("productId") int productId) {
        return productConverter.toProductDTO(productService.getById(productId));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        productService.add(product);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateProduct(@RequestBody Product product) {
        productService.update(product);
    }

    @RequestMapping(value = "/del/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("productId") int productId) {
        productService.delete(productId);
    }

}
