package com.app;

import com.app.address.models.Address;
import com.app.client.models.Client;
import com.app.country.models.Country;
import com.app.shoppingcart.models.ShoppingCart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingCartApplication {
	public static void main(String[] args) throws CloneNotSupportedException {
		SpringApplication.run(ShoppingCartApplication.class, args);

		Country country = Country.builder()
				.name("Brasil")
				.build();

		Address address = Address.builder()
				.street("Rua Dom Casmurro")
				.number(55)
				.country(country)
				.build();

		Client client = Client.builder()
				.name("Pedro Hübner")
				.document("050.628.090-02")
				.address(address)
				.build();

		ShoppingCart shoppingCart = ShoppingCart.builder()
				.client(client)
				.build();

		Country newCountry = (Country) country.clone();
		Address newAddress = (Address) address.clone();
		Client newClient = (Client) client.clone();

		newCountry.setName("Argentina");
		newAddress.setStreet("Rua Camboriú");
		newAddress.setNumber(58);
		newClient.setName("Naã");

		System.out.println("País antigo: " + country.getName());
		System.out.println("País novo: " + newCountry.getName());

		System.out.println("\nNome da rua antigo: " + address.getStreet());
		System.out.println("Nome da rua novo: " + newAddress.getStreet());

		System.out.println("\nNúmero da rua antigo: " + address.getNumber());
		System.out.println("Número da rua novo: " + newAddress.getNumber());

		System.out.println("\nCliente antigo: " + client.getName());
		System.out.println("Cliente novo: " + newClient.getName());

		newClient.setAddress(newAddress);

		System.out.println(newClient.getAddress());
	}
}
