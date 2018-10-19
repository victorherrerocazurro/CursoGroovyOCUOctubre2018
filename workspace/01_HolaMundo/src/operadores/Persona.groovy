package operadores

class Persona {

    String nombre
    int edad

    def plus(Persona conyuge){
        new Matrimonio(marido: this, mujer: conyuge)
    }

}
