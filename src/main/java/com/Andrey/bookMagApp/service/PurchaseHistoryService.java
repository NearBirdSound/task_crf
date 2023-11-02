package com.Andrey.bookMagApp.service;

import java.util.List;

import com.Andrey.bookMagApp.model.PurchaseHistory;
import com.Andrey.bookMagApp.model.User;

public interface PurchaseHistoryService {
    void makePurchase(User user, long productId, int quantity);
    List<PurchaseHistory> getAll();
    PurchaseHistory getById(long id);
    long add(PurchaseHistory entity);
    void update(PurchaseHistory entity);
    void delete(long id);
}
