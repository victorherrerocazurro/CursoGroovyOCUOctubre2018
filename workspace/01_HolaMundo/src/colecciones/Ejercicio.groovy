package colecciones

//l.getAt(n..l.size()-1)

//tail

def borrarNElementos(List l, int n){
    switch (n){
        case 0:
            return l
        default:
            borrarNElementos(l.tail(),n-1)
    }
}

