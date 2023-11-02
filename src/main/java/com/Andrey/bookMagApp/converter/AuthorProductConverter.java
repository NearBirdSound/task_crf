package com.Andrey.bookMagApp.converter;

import com.Andrey.bookMagApp.model.AuthorProduct;
import com.Andrey.bookMagApp.dto.AuthorProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorProductConverter {
    public AuthorProductDTO toAuthorProductDTO(AuthorProduct authorProduct) {
        AuthorProductDTO authorProductDTO = new AuthorProductDTO();
        authorProductDTO.setAuthorId(authorProduct.getAuthorId());
        authorProductDTO.setProductId(authorProduct.getProductId());
        return authorProductDTO;
    }

    public AuthorProduct toAuthorProduct(AuthorProductDTO authorProductDTO) {
        AuthorProduct authorProduct = new AuthorProduct();
        authorProduct.setAuthorId(authorProductDTO.getAuthorId());
        authorProduct.setProductId(authorProductDTO.getProductId());
        return authorProduct;
    }

    public List<AuthorProductDTO> toAuthorProductDTOList(List<AuthorProduct> authorProducts) {
        List<AuthorProductDTO> authorProductDTOList = new ArrayList<>();

        for (AuthorProduct authorProduct : authorProducts) {
            AuthorProductDTO authorProductDTO = toAuthorProductDTO(authorProduct);
            authorProductDTOList.add(authorProductDTO);
        }

        return authorProductDTOList;
    }

}
