def sumarNumeros = {a, b -> a+b}

def resultado12_14 = sumarNumeros 12, 14
println resultado12_14

def  sumar12 = sumarNumeros.curry(12)

println sumar12(14)

println sumar12(47)