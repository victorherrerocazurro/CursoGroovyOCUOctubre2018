//No hacer uso de ServicioImpl

def algoritmoProcesarCliente = {
    Validador validador,
    Notificador notificador,
    Almacenador almacenador,
    Cliente cliente  ->
    if (validador.validar(cliente)) {
        almacenador.almacenar(cliente)
        notificador.notificar(cliente.mail)
        return cliente
    } else {
        return null
    }
}

def validadorBasico = {cliente ->
    println "Validando"
    true
} as Validador

def procesarClienteConValidacionBasica = algoritmoProcesarCliente.curry(validadorBasico)

def notificadorConsola = {mail ->
    println "Notificando"
} as Notificador

def procesarClienteConValidacionBasicaYNotificacionPorConsola = procesarClienteConValidacionBasica.curry(notificadorConsola)

def almacenadorMemoria = {cliente ->
    println "Almacenando"
} as Almacenador

def procesarClienteConValidacionBasicaYNotificacionPorConsolaYAlmacenEnMemoria =
        procesarClienteConValidacionBasicaYNotificacionPorConsola.curry(almacenadorMemoria)

def procesarCliente = procesarClienteConValidacionBasicaYNotificacionPorConsolaYAlmacenEnMemoria

Cliente cliente = new Cliente()

def resultado = procesarCliente(cliente)

assert cliente == resultado
