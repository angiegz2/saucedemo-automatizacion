Feature: Compra y validación de productos en SauceDemo

  Scenario: Usuario realiza compra exitosa
    Given que el usuario abre la página SauceDemo
    When inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    And agrega productos al carrito
    And elimina un producto del carrito
    Then verifica que la cantidad de productos en el carrito sea 1

  Scenario: Usuario intenta iniciar sesión con credenciales inválidas
    Given que el usuario abre la página SauceDemo
    When inicia sesión con usuario "usuario_invalido" y contraseña "clave_erronea"
    Then debe ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Usuario bloqueado intenta iniciar sesión
    Given que el usuario abre la página SauceDemo
    When inicia sesión con usuario "locked_out_user" y contraseña "secret_sauce"
    Then debe ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."

  Scenario: Proceso exitoso de compra
    Given que el usuario abre la página SauceDemo
    When inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    And agrega productos al carrito
    And compra el producto con nombre "Angie", apellido "Yarce" y código postal "05001"
    Then el usuario debería ver el mensaje "Thank you for your order!"



