package com.app;

import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcartproducts.services.ShoppingCartProductsService;

import java.util.concurrent.Semaphore;

public class CartThread implements Runnable{

    private final Long cartId;
    private final Long productId;
    private final Semaphore semaphore;
    private final ShoppingCartProductsService shoppingCartProductsService;

    public CartThread(Semaphore semaphore, ShoppingCartProductsService shoppingCartProductsService, Long productId, Long cartId) {
        this.semaphore = semaphore;
        this.shoppingCartProductsService = shoppingCartProductsService;
        this.productId = productId;
        this.cartId = cartId;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " foi inicializada");

            semaphore.acquire();

            System.out.println(Thread.currentThread().getName() + " pegou a permissão");

            Thread.sleep(1000);

            shoppingCartProductsService.addProductToShoppingCart(cartId, productId);
            System.out.println(Thread.currentThread().getName() + " foi executada");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " liberou permissão");
        }
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCartProductsService.addProductToShoppingCart(cartId, productId);
    }
}
