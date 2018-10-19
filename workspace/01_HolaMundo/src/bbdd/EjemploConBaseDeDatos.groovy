package bbdd

import groovy.sql.Sql


@Grab('org.apache.derby:derbyclient:10.14.2.0')
@GrabConfig(systemClassLoader=true)
//def url = 'jdbc:hsqldb:mem:yourDB'
def url = 'jdbc:derby://localhost:1527/myDB;create=true'
def user = 'sa'
def password = 'sa'
//def driver = 'org.hsqldb.jdbcDriver'
def driver = 'org.apache.derby.jdbc.ClientDriver'

Sql.withInstance(url, user, password, driver) { sql ->

    //Ejecucion de una consula generica

    sql.execute '''
    CREATE TABLE Author (
    id          INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    firstname   VARCHAR(64),
    lastname    VARCHAR(64)
    )
    '''

    //Ejecucion de una consuta de insercion, obteniendo las clave generadas en BD

    def insertSql = 'INSERT INTO Author (firstname, lastname) VALUES (?,?)'
    def params = ['Jon', 'Skeet']
    def keys = sql.executeInsert insertSql, params
    assert keys[0] == [1]

    //Consulta de seleccion

    def expected = ['Dierk Koenig', 'Jon Skeet', 'Guillaume Laforge']

    rowNum = 0
    sql.eachRow('SELECT firstname, lastname FROM Author') { row ->
        def first = row[0] //Formato de acceso tipo mapa
        def last = row.lastname //Formato e acceso tipo objeto
        assert expected[rowNum++] == "$first $last"
    }

    List authors = sql.rows('SELECT firstname, lastname FROM Author')
    assert authors.size() == 3
    assert authors.collect { "$it.FIRSTNAME ${it[-1]}" } == expected


}