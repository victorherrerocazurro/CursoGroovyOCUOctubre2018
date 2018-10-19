package ficheros

def file = new File('haiku.txt')

//Codigo para escribir

file << '''Into the ancient pond
A frog jumps
Water’s sound!'''

//Codigo para la lectura
def list = file.collect {it}

println list

def dir = new File("c:/")

dir.eachFile {
    println it.name
}

dir.eachFileMatch(~/.*\.txt/) { println it.name
}

def process = "cmd /c dir".execute()

println "${process.text}"