//com.curso.groovy.Persona.metaClass.otro << {println "En otro metodo"}

com.curso.groovy.Persona.metaClass.constructor << {nombre -> println "En otro metodo"}

//com.curso.groovy.Persona.metaClass.static.

def persona = new com.curso.groovy.Persona()

def otra = new com.curso.groovy.Persona()

persona.metodo()

/*def miMetaClase = new ExpandoMetaClass()

miMetaClase.initialize()

miMetaClase.otro << {println "En otro metodo"}

println persona.metaClass = miMetaClase*/

println persona.metaClass

persona.metaClass.otro << {println "En otro metodo"}

persona.metaClass.nombre = "Victor"

println persona.nombre

otra.metaClass.otro << {println "Estamos en otro metodo Otro distinto"}

println persona.metaClass

//El objetivo será poder ejecutar este método sin
//añadirlo a la clase Persona
persona.otro()

otra.otro()

// -------- Nombres dinamicos ------------

def nombre = "Juan"

persona.metaClass."metodo${nombre}" << {prefijo -> println "$prefijo ${nombre}"}

persona.metodoJuan("Hola")

// -------- Prestamo de metodos ------------

persona.metaClass.prestado << "Hola Mundo!!".&toUpperCase

println persona.prestado()

// -------- Metodos de extension ----------

int i=0

5.maxRetries {
    i++
}
assert i == 1
println "i = $i"
i=0
try {
    5.maxRetries {
        i++
        throw new RuntimeException("oops")
    }
} catch (RuntimeException e) {
    println "i = $i"
    assert i == 5
}