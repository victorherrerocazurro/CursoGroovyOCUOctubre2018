class ClaseContenedoraDeClosure {

    String nombre = "Victor"

    //Atributo de tipo Closure
    Closure closure = {
        println "-----Externa-----"
        println this
        println owner
        println delegate

        println nombre
        println owner.nombre
        println delegate.nombre

        Closure interna = {
            println "-----Interna-----"
            println this
            println owner
            println delegate
        }

        interna()
    }

    def ejecutar() {
        closure()
    }
}

def clase = new ClaseContenedoraDeClosure()

clase.ejecutar()

clase.closure.resolveStrategy = Closure.DELEGATE_FIRST

clase.closure.delegate = new ClaseContenedoraDeClosure(nombre: "Juan")

clase.ejecutar()

//clase.closure()

//clase.closure.call()