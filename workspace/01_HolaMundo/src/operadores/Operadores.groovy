package operadores

def victor = new Persona(nombre: "Victor", edad: 40)

def maria = new Persona(nombre: "Maria", edad: 25)

//victor.plus(maria)
Matrimonio matrimonio = victor + maria

println matrimonio.marido.nombre