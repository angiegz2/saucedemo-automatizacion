package com.udea.saucedemo.questions;

import com.udea.saucedemo.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeDeCompra implements Question<String> {
    public static Question<String> es() {
        return new MensajeDeCompra();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.COMPLETE_MESSAGE).answeredBy(actor);
    }
}