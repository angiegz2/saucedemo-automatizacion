package com.udea.saucedemo.tasks;

import com.udea.saucedemo.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarDelCarrito implements Task {
    public static Performable unProducto() {
        return instrumented(EliminarDelCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductsPage.REMOVE_BACKPACK));
    }
}
