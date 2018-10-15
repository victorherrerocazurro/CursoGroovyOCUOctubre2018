def persona = new Persona()

persona.nombre = "Victor"

println "Hola ${persona.nombre}!!"

persona.setNombre("Juan")

def fecha  = new Date()

println 'Hola Mundo!!!'

persona = new Persona(nombre: "Victor")

//persona = new Persona("Victor")

persona.setApellido()

def cliente = new Cliente(nombre: "Victor", id: 1)

def (nombre, id) = cliente

assert cliente[0] == "Victor"

println( nombre)

println( id)

def funcion(){

}

def instanciaDeClaseInternaAnonima = new OnClickListener(){

    @Override
    void onClick(Object target) {
    }
}

Closure funcion = (target) <- {
    //Esta es mi logica
} as OnClickListener

funcion.call()