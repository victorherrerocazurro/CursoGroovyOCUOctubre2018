def fib

fib = { int n ->
    if (n <= 2) {
        1
    } else {
        fib(n - 1) + fib(n - 2)
    }
}

init = new Date().getTime()

def resultadoSinCache = fib(35)

sincache = new Date().getTime()

println "Se obtiene $resultadoSinCache en ${sincache - init}"

//Habilitar la cache
fib = fib.memoize()

def resutladoConCache = fib(35)

concache = new Date().getTime() - sincache

println "Se obtiene $resutladoConCache en $concache"

