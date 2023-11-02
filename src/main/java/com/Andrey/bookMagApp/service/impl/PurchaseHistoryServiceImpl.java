package com.Andrey.bookMagApp.service.impl;

import com.Andrey.bookMagApp.dao.impl.PurchaseHistoryDAOimpl;
import com.Andrey.bookMagApp.model.Product;
import com.Andrey.bookMagApp.model.PurchaseHistory;
import com.Andrey.bookMagApp.model.User;
import com.Andrey.bookMagApp.service.PurchaseHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


/**
 * Сервис с логикой истории покупки.
 */
@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    //здесь должна еще быть конвертация из ДТО в модель

    private final ProductServiceImpl productServiceImpl;
    private final PurchaseHistoryDAOimpl purchaseHistoryDAO;

    @Autowired
    public PurchaseHistoryServiceImpl(ProductServiceImpl productServiceImpl, PurchaseHistoryDAOimpl purchaseHistoryDAOimpl) {
        this.productServiceImpl = productServiceImpl;
        this.purchaseHistoryDAO = purchaseHistoryDAOimpl;
    }

    //Buying products

    @Override
    @Transactional
    public void makePurchase(User user, long productId, int quantity) {
        Product product = productServiceImpl.getById(productId);

        if (product == null) {

        }

        if (quantity <= 0) {

        }

        if (product.getQuantityProducts() < quantity) {

        }

        BigDecimal totalCost = product.getPurchasePrice().multiply(BigDecimal.valueOf(quantity));

        totalCost = totalCost.add(totalCost.multiply(product.getMarkup()));

        if (user.getDiscount() != null) {
            totalCost = totalCost.multiply(BigDecimal.ONE.subtract(user.getDiscount()));
        }


        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setUserId(user.getUserId());
        purchaseHistory.setProductId(productId);
        purchaseHistory.setQuantity(quantity);
        purchaseHistory.setCost(totalCost);
        purchaseHistory.setPurchaseDate(new Date(System.currentTimeMillis()));

        int currentQuantity = product.getQuantityProducts();
        product.setQuantityProducts(currentQuantity - quantity);
        productServiceImpl.update(product);

        purchaseHistoryDAO.add(purchaseHistory);
    }


    @Override
    public List<PurchaseHistory> getAll() {
        return this.purchaseHistoryDAO.getAll();
    }


    @Override
    public PurchaseHistory getById(long id) {
        return this.purchaseHistoryDAO.getById(id);
    }


    @Override
    public long add(PurchaseHistory entity) {
        return this.purchaseHistoryDAO.add(entity);
    }


    @Override
    public void update(PurchaseHistory entity) {
        this.purchaseHistoryDAO.update(entity);
    }

    @Override
    public void delete(long id) {
        this.purchaseHistoryDAO.delete(id);
    }

}
