package com.udea.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {

    public static final Target ADD_BACKPACK = Target.the("botón para agregar mochila")
            .located(By.id("add-to-cart-sauce-labs-backpack"));

    public static final Target ADD_BIKE_LIGHT = Target.the("botón para agregar lámpara")
            .located(By.id("add-to-cart-sauce-labs-bike-light"));

    public static final Target REMOVE_BACKPACK = Target.the("botón para eliminar mochila")
            .located(By.id("remove-sauce-labs-backpack"));

    public static final Target CART_BADGE = Target.the("contador del carrito")
            .located(By.className("shopping_cart_badge"));

    public static final Target PRODUCT_PRICE = Target.the("precio del producto")
            .located(By.cssSelector(".inventory_item_price"));

    public static final Target CART_ICON = Target.the("icono del carrito")
            .located(By.className("shopping_cart_link"));

    public static final Target CHECKOUT_BUTTON = Target.the("botón checkout")
            .located(By.id("checkout"));

    public static final Target FIRST_NAME = Target.the("nombre")
            .located(By.id("first-name"));

    public static final Target LAST_NAME = Target.the("apellido")
            .located(By.id("last-name"));

    public static final Target ZIP_CODE = Target.the("código postal")
            .located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON = Target.the("botón continuar")
            .located(By.id("continue"));

    public static final Target FINISH_BUTTON = Target.the("botón finalizar")
            .located(By.id("finish"));

    public static final Target COMPLETE_MESSAGE = Target.the("mensaje de compra completa")
            .located(By.className("complete-header"));

    public static final Target REMOVE_BIKE_LIGHT = Target.the("botón para eliminar lámpara")
            .located(By.id("remove-sauce-labs-bike-light"));

}
