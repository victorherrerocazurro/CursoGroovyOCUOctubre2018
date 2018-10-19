package ficheros

import groovy.xml.MarkupBuilder

String books = '''
    <response version-api="2.0">
        <value>
            <books>
                <book available="20" id="1">
                    <title>Don Xijote</title>
                    <author id="1">Manuel De Cervantes</author>
                </book>
                <book available="14" id="2">
                    <title>Catcher in the Rye</title>
                   <author id="2">JD Salinger</author>
               </book>
               <book available="13" id="3">
                   <title>Alice in Wonderland</title>
                   <author id="3">Lewis Carroll</author>
               </book>
               <book available="5" id="4">
                   <title>Don Xijote</title>
                   <author id="1">Manuel De Cervantes</author>
               </book>
           </books>
       </value>
    </response>
'''

def response = new XmlSlurper().parseText(books)
def authorResult = response.value.books.book[0].author

def authorResultId = response.value.books.book[0].author.@id

assert authorResult.name() == 'author'

assert authorResult.text() == 'Manuel De Cervantes'

assert authorResultId.text() == '1'

assert authorResultId.toInteger() == 1

def bookId = response.'**'.find { book->
    book.author.text() == 'Lewis Carroll'
}.@id

assert bookId == 3

println "-----------------------------"

def writer = new StringWriter()
def xml = new MarkupBuilder(writer)

xml.records() {
    car(name:'HSV Maloo', make:'Holden', year:2006) {
        country('Australia')
        record(type:'speed', 'Production Pickup Truck with speed of 271kph')
    }
    car(name:'Royale', make:'Bugatti', year:1931) {
        country('France')
        record(type:'price', 'Most Valuable Car at $15 million')
    }
}

def resultado = writer.toString()

println resultado

def records = new XmlSlurper().parseText(resultado)

assert records.car.first().@name.text() == 'HSV Maloo'
assert records.car.last().@name.text() == 'Royale'