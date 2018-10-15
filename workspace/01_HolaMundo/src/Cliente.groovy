class Cliente {
    String nombre
    int  id

    def getAt(Integer i){
        switch (i){
            case 0: return nombre
            case 1: return id
        }
    }

}
