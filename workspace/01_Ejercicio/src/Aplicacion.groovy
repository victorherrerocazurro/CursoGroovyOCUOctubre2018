def validador = {cliente ->
    println "Validando"
    true
} as Validador

def notificador = new Notificador() {
    String estado
    @Override
    void notificar(String mail) {
        println "Notificando"
    }
}

def almacenador = new AlmacenadorMemoria()

def servicio = new ServicioImpl(
        validador: validador,
        notificador: notificador,
        almacenador: almacenador)

//Necsitamos cubrir las necesidades del objeto ServicioImpl

Cliente cliente = new Cliente()

def resultado = servicio.procesarCliente(cliente)

assert cliente == resultado

