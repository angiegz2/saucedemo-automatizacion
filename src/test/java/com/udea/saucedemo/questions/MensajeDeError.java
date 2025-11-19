package com.udea.saucedemo.questions;

import com.udea.saucedemo.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeDeError implements Question<String> {
    public static Question<String> es() {
        return new MensajeDeError();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor);
    }
}
