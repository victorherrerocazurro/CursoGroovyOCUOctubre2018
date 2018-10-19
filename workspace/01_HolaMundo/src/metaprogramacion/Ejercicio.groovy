package metaprogramacion

class Persona {
    String nombre
}

class BaseDeDatos {
    def procesarResultadosConsulta (String sql, Closure algoritmoProcesamiento){
        println "En el procesarConsulta de BaseDeDatos"
        algoritmoProcesamiento(sql)
    }
}

Persona.metaClass.procesarDirecciones <<
                                new BaseDeDatos()
                                        .&procesarResultadosConsulta
                                        .curry("SELECT * FROM DIRECCIONES .....")

persona = new Persona()

persona.procesarDirecciones{
    println it
}