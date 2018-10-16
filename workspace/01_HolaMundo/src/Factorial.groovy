def factorial

factorial = { int n, BigInteger acc = 1 ->
    if(n == 1){
        acc
    } else {
        factorial.trampoline(n-1, n * acc)
    }
}.trampoline()

println factorial(10)

println factorial(1000)