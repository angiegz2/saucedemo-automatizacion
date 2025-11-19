package com.udea.saucedemo.questions;

import com.udea.saucedemo.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CantidadEnCarrito implements Question<String> {
    public static Question<String> es() {
        return new CantidadEnCarrito();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.CART_BADGE).answeredBy(actor);
    }
}
