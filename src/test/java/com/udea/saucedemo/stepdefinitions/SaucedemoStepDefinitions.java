package com.udea.saucedemo.stepdefinitions;

import com.udea.saucedemo.questions.CantidadEnCarrito;
import com.udea.saucedemo.questions.MensajeDeCompra;
import com.udea.saucedemo.questions.MensajeDeError;
import com.udea.saucedemo.questions.PrecioProducto;
import com.udea.saucedemo.tasks.AgregarAlCarrito;
import com.udea.saucedemo.tasks.ComprarProducto;
import com.udea.saucedemo.tasks.EliminarDelCarrito;
import com.udea.saucedemo.tasks.IniciarSesion;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SaucedemoStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver suNavegador;

    Actor angie = Actor.named("Angie");

    @Before
    public void configurar() {
        angie.can(BrowseTheWeb.with(suNavegador));
    }

    @Given("que el usuario abre la página SauceDemo")
    public void abrirPagina() {
        suNavegador.get("https://www.saucedemo.com/");
    }

    @When("inicia sesión con usuario {string} y contraseña {string}")
    public void iniciarSesion(String usuario, String contrasena) {
        angie.attemptsTo(IniciarSesion.conCredenciales(usuario, contrasena));
    }

    @When("agrega productos al carrito")
    public void agregarProductos() {
        angie.attemptsTo(AgregarAlCarrito.productos());
    }

    @When("elimina un producto del carrito")
    public void eliminarProducto() {
        angie.attemptsTo(EliminarDelCarrito.unProducto());
    }

    @And("compra el producto con nombre {string}, apellido {string} y código postal {string}")
    public void comprarProducto(String nombre, String apellido, String zipcode) {
        angie.attemptsTo(ComprarProducto.conDatos(nombre, apellido, zipcode));
    }

    @Then("verifica que la cantidad de productos en el carrito sea {int}")
    public void verificarCantidad(int cantidad) {
        angie.should(seeThat(CantidadEnCarrito.es(), equalTo(String.valueOf(cantidad))));
    }

    @Then("debe ver el mensaje de error {string}")
    public void verificarError(String mensajeEsperado) {
        angie.should(seeThat(MensajeDeError.es(), equalTo(mensajeEsperado)));
    }

    @Then("verifica que el precio mostrado sea {string}")
    public void verificarPrecio(String precioEsperado) {
        angie.should(seeThat(PrecioProducto.es(), equalTo(precioEsperado)));
    }

    @Then("el usuario debería ver el mensaje {string}")
    public void validarMensajeDeCompra(String mensajeEsperado) {
        angie.should(seeThat(MensajeDeCompra.es(), equalTo(mensajeEsperado)));
    }
}