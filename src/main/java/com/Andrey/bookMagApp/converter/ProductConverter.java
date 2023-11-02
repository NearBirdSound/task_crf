package com.Andrey.bookMagApp.converter;

import com.Andrey.bookMagApp.model.Product;
import com.Andrey.bookMagApp.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductConverter {
    public ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductType(product.getProductType());
        productDTO.setTitle(product.getTitle());
        productDTO.setPurchasePrice(product.getPurchasePrice());
        productDTO.setMarkup(product.getMarkup());
        productDTO.setQuantityProducts(product.getQuantityProducts());
        return productDTO;
    }

    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductType(productDTO.getProductType());
        product.setTitle(productDTO.getTitle());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setMarkup(productDTO.getMarkup());
        product.setQuantityProducts(productDTO.getQuantityProducts());
        return product;
    }

    public List<ProductDTO> toProductDTOList(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : products) {
            ProductDTO productDTO = toProductDTO(product);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

}
