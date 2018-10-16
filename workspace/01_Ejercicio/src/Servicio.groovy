interface Servicio {
    def procesarCliente(Cliente cliente)
}

class ServicioImpl implements Servicio {

    //Algoritmos que se necesitan
    Validador validador
    Notificador notificador
    Almacenador almacenador

    @Override
    def procesarCliente(Cliente cliente) {

        if(validador.validar(cliente)){
            almacenador.almacenar(cliente)
            notificador.notificar(cliente.mail)
            return cliente
        } else {
            return null
        }
    }
}