package com.udea.saucedemo.tasks;

import com.udea.saucedemo.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ComprarProducto implements Task {

    private final String nombre;
    private final String apellido;
    private final String codigoPostal;

    public ComprarProducto(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public static Performable conDatos(String nombre, String apellido, String codigoPostal) {
        return instrumented(ComprarProducto.class, nombre, apellido, codigoPostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(ProductsPage.CART_ICON),
            Click.on(ProductsPage.CHECKOUT_BUTTON),
            Enter.theValue(nombre).into(ProductsPage.FIRST_NAME),
            Enter.theValue(apellido).into(ProductsPage.LAST_NAME),
            Enter.theValue(codigoPostal).into(ProductsPage.ZIP_CODE),
            Click.on(ProductsPage.CONTINUE_BUTTON),
            Click.on(ProductsPage.FINISH_BUTTON)
        );
    }
}
