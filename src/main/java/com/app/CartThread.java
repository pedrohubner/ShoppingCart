package com.app;

import com.app.shoppingcartproducts.services.ShoppingCartProductsService;

import java.util.concurrent.Semaphore;

public class CartThread implements Runnable {

    private final Long cartId;
    private final Long productId;
    private final Semaphore semaphore;
    private final ShoppingCartProductsService shoppingCartProductsService;

    CartThread(Semaphore semaphore, ShoppingCartProductsService shoppingCartProductsService, Long cartId,
               Long productId) {
        this.semaphore = semaphore;
        this.shoppingCartProductsService = shoppingCartProductsService;
        this.cartId = cartId;
        this.productId = productId;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + " está esperando permissão");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " conseguiu permissão");

            Thread.sleep(3000);

            shoppingCartProductsService.addProductToShoppingCart(cartId, productId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " foi executada");
            System.out.println(Thread.currentThread().getName() + " liberou permissão");
            semaphore.release();
        }
    }
}
