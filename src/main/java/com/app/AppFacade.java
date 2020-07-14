package com.app;

import com.app.address.models.Address;
import com.app.address.services.AddressService;
import com.app.client.models.Client;
import com.app.client.services.ClientService;
import com.app.country.models.Country;
import com.app.country.services.CountryService;
import com.app.product.models.Product;
import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.services.ShoppingCartService;
import com.app.shoppingcartproducts.services.ShoppingCartProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AppFacade {

    private final ClientService clientService;
    private final AddressService addressService;
    private final CountryService countryService;
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartProductsService shoppingCartProductsService;

    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    public Optional<Product> findProductById(Long id) {
        return productService.findProductById(id);
    }

    public void deleteProductById(Long id) {
        productService.deleteProductById(id);
    }

    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartService.createShoppingCart(shoppingCart);
    }

    public Optional<ShoppingCart> findShoppingCartById(Long id) {
        return shoppingCartService.findShoppingCartById(id);
    }

    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCartById(id);
    }

    public Client createClient(Client client) {
        return clientService.createClient(client);
    }

    public void deleteClient(Long id) {
        clientService.deleteClientById(id);
    }

    public Address createAddress(Address address) {
        return addressService.createAddress(address);
    }

    public void deleteAddress(Long id) {
        addressService.deleteAddressById(id);
    }

    public Country createCountry(Country country) {
        return countryService.createCountry(country);
    }

    public void deleteCountry(Long id) {
        countryService.deleteCountryById(id);
    }

    public ShoppingCart addProductToShoppingCart(Long cartId, Long productId) {
        return shoppingCartProductsService.addProductToShoppingCart(cartId, productId);
    }

    public ShoppingCart removeProductFromShoppingCart(Long cartId, Long productId) {
        return shoppingCartProductsService.removeProductFromShoppingCart(cartId, productId);
    }
}
