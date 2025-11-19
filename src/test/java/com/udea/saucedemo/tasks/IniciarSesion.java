package com.udea.saucedemo.tasks;

import com.udea.saucedemo.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Task {
    private final String usuario;
    private final String contrasena;

    public IniciarSesion(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static Performable conCredenciales(String usuario, String contrasena) {
        return instrumented(IniciarSesion.class, usuario, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(usuario).into(LoginPage.USERNAME_FIELD),
            Enter.theValue(contrasena).into(LoginPage.PASSWORD_FIELD),
            Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
