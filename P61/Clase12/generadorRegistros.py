#Se omiten tildes para evitar inconvenientes de codificacion

#Librerias requeridas
import sqlite3
from sqlite3 import Error
import pandas as pd
import numpy as np
import sys
import random

#Definir separador para la carga de los archivos CSV
separador = ";"

#Funciones para generacion de campos aleatorios

#Funcion para generacion de correos a partir de nombres y apellidos
def generarCorreo(nombre,primerApellido,segundoApellido):
  #Tuplas base para generacion aleatoria
  dominios = ('gmail.com','hotmail.com','utp.edu.co','yahoo.com','mintic.gov.co','latinmail.com')
  modos = (1,2,3)
  modoElegido = random.choice(modos)
  if modoElegido == 1:
    return nombre+'.'+primerApellido+'@'+random.choice(dominios)
  elif modoElegido == 2:
    return nombre+str(random.randint(1940,2018))+'_'+segundoApellido+'@'+random.choice(dominios)
  elif modoElegido == 3:
    return nombre+'.'+primerApellido+'.'+segundoApellido+'0'+str(random.randint(1,999))+'@'+random.choice(dominios)  

#Funcion para generacion de ids de cajeros aleatorios
def generarId(tamañoCodigo=7):
    letras = "ABCDEFGHIJKLMNOPQURSTUVWXYZabcdefghijklmnoprstuvwxyz"
    numeros = "1234567890"
    listaCaracteresCodigo = [str()]*tamañoCodigo
    for i in range(len(listaCaracteresCodigo)):#Realizar el proceso cinco veces        
        #Decidir si es numero o letra
        if random.randint(0, 1):
            listaCaracteresCodigo[i] = letras[ random.randint(0, len(letras)-1)  ]#Letra
        else:
            listaCaracteresCodigo[i] = numeros[ random.randint(0, len(numeros)-1)  ]#Numero en formato str

    #Decidir si es del banco principal o si es de un banco adquirido
    if random.randint(0, 1):
        listaCaracteresCodigo.append('BP') #Banco principal
    else:
        listaCaracteresCodigo.append('FI') #Firma bancaria integrada (comprada)

    #Convertir el listado a string
    idGenerado = "".join(listaCaracteresCodigo)
    
    #Retornar id tipo str
    return idGenerado

#Conexion a base de datos SQLite -> Si la base de datos no existe, se crea una nueva
def crearConexion(rutaArchivoBD):    
  conn = None
  try:
    conn = sqlite3.connect(rutaArchivoBD)
    print("Conexion/Creacion Exitosa")
    print("Version SQLite3: ",sqlite3.version)        
  except Error as e:
    print(e)    
  return conn

#Funcion para relacionar el tipo de dato de una serie pandas con los tipos de SQLite3
def relacionarTipos(seriePandas):
  if seriePandas.dtype == np.int64:
    return "INTEGER"
  elif seriePandas.dtype == np.float64:
    return "REAL"
  elif seriePandas.dtype == 'object':
    try:
        seriePandas = pd.to_datetime(seriePandas)        
        return "DATETIME"
    except:
      if isinstance(seriePandas[0],str):        
        return "VARCHAR(45)"
      else:          
        return "Objeto no identificado"      
  else:   
    return "Tipo de dato NO IDENTIFICADO"  

#Funcion para crear la tabla a partir de la sentencia recibida como argumento
def crearTabla(conn, sql_creacionTabla):
  try:
    c = conn.cursor()
    c.execute(sql_creacionTabla)
  except Error as e:
    print(e)

#Funcion para insertar registros a la tabla creada
def insertarRegistro(conn, sql_crearRetistro, tuplaRegistro):
  cur = conn.cursor()
  cur.execute(sql_crearRetistro, tuplaRegistro)
  conn.commit()
  return cur.lastrowid

#Funcion para generar tablas de tipos (tipo de producto, servicio, proyecto, publicacion, etc)
def generarTablaExplicita(rutaTablaCSV,conn):  
  
  #Carga del CSV en un dataframe de pandas
  try:
      df = pd.read_csv(rutaTablaCSV,sep=separador)
  except:
    print("Error al leer el archivo CSV de la tabla")
    sys.exit1(1)#Terminar prematuramente el procedimiento

  #Obtener el nombre de la tabla
  nombreTabla = rutaTablaCSV.split('.')[0]
  
  #Iterar por cada columna del dataframe para la especificacion de los campos de la tabla
  sqlCreacionCampos = f""" ID_{nombreTabla} INTEGER NOT NULL, \n """
  for i,columna in enumerate(df):
    sqlCreacionCampos += f""" {columna}  {relacionarTipos(df[columna])} NOT NULL, \n """
  sqlCreacionCampos += f""" PRIMARY KEY ( ID_{nombreTabla} )"""  
  
  #Sentencia con la construccion de la tabla
  sql_creacionTabla = f"""CREATE TABLE  {nombreTabla}  (
                      {sqlCreacionCampos});
                  """
  #Salida de diagnostico
  print(sql_creacionTabla)  

  #Proceder a crear la tabla
  crearTabla(conn, sql_creacionTabla)

  #Una vez creada la tabla insertar todas las filas alojadas en el dataframe  

  #Por cada una de las filas
  for _, fila in df.iterrows():
    #Inicializar coleccion de valores del registro
    coleccionValores = list()
    #Inicializar la consulta
    sqlInsertarFila = f"INSERT INTO {nombreTabla}("
    #Inicializar sucesion de tokens para la insercion
    tokens = ""  
    #Añadir los nombres de las columnas a la insercion
    fila = list(fila)
    for i,columna in enumerate(df):
      sqlInsertarFila += f"{columna},"
      #coleccionValores.append(fila[columna])
      coleccionValores.append(fila[i])
      tokens += "?,"
    #Cambio de la coma y cierre de los nombres
    sqlInsertarFila = sqlInsertarFila[:-1] + f") VALUES({tokens[:-1]})"
    #Convertir la coleccion a tupla para la insercion
    coleccionValores = tuple(coleccionValores)

    #Salida de diagnostico, previo al envio a traves de la conexion
    print()
    print("Antes de enviar:")
    print("Consulta-> ",sqlInsertarFila)
    print("Valores-> ",coleccionValores)
    ##input()

    #Realizar la insercion
    insertarRegistro(conn,sqlInsertarFila,coleccionValores)
  
  #Retornar el nombre de la tabla creada
  return nombreTabla

#Funcion para generar documento de identidad alfanumerico
def generarCodigo(numCaracteres=7):
    alfanumericos = "abcdefghijklmnopqrstuvwxyz1234567890"
    primerCaracter = 'CC'
    listaSeleccion = [ random.choice(alfanumericos) for _ in range(numCaracteres) ]
    listaSeleccion.insert(0,primerCaracter)
    return ''.join(listaSeleccion)

#Funcion para generacion de listado de fechas
def generadorFechas(añoInicial,añoFinal):
    #añosConsiderados = (2020,2021)
    añosConsiderados = tuple([x for x in range(añoInicial,añoFinal+1)])
    contenedorFechasDias = []
    for año in añosConsiderados:    
        for mes in range(1,13):
            for dia in range(1,29):
                #Limitar las transacciones hasta una fecha actual (final de junio de 2021)
                if año == 2021 and mes >= 7:                
                    break                
                else:
                    strDia = str(dia)
                    if dia < 10:
                        strDia = '0'+ str(dia)
                    strMes = str(mes)
                    if mes < 10:
                        strMes = '0'+ str(mes)  
                    strAño = str(año)
                    #contenedorFechasDias.append(f"{strDia}-{strMes}-{strAño}")
                    #contenedorFechasDias.append(f"{strDia}/{strMes}/{strAño}")
                    contenedorFechasDias.append(f"{strAño}-{strMes}-{strDia}")
    return contenedorFechasDias

#Funcion para generar tabla de usuarios/clientes/responsables a partir de los campos y dominios generados en el CSV recibido
def generarTablaUsuario(rutaTablaCSV,conn,numeroRegistros):    
  
  #Carga del CSV en un dataframe de pandas
  try:
      df = pd.read_csv(rutaTablaCSV,sep=separador)
  except:
    print("Error al leer el archivo CSV de la tabla")
    sys.exit1(1)#Terminar prematuramente el procedimiento

  #Contenedor para fechas de nacimiento del usuario para hacer una seleccion aleatoria
  coleccionFechasNacimiento = generadorFechas(1940,2002)

  #Obtener el nombre de la tabla
  nombreTabla = rutaTablaCSV.split('.')[0]
  
  #Iterar por cada columna del dataframe para la especificacion de los campos de la tabla
  sqlCreacionCampos = f""" ID_{nombreTabla} INTEGER NOT NULL, \n """
  for i,columna in enumerate(df):
    sqlCreacionCampos += f""" {columna}  {relacionarTipos(df[columna])} NOT NULL, \n """
  
  #Agregar campos especificos tabla usuario
  sqlCreacionCampos += f""" Documento_Identidad  VARCHAR(12) NOT NULL, \n """
  sqlCreacionCampos += f""" Fecha_Nacimiento  DATETIME NOT NULL, \n """

  #Cierre de la tabla
  sqlCreacionCampos += f""" PRIMARY KEY ( ID_{nombreTabla} )"""  
  
  #Sentencia con la construccion de la tabla
  sql_creacionTabla = f"""CREATE TABLE  {nombreTabla}  (
                      {sqlCreacionCampos});
                  """
  #Salida de diagnostico
  print(sql_creacionTabla)  

  #Proceder a crear la tabla
  crearTabla(conn, sql_creacionTabla)

  #Una vez creada la tabla insertar todas las filas alojadas en el dataframe
  
  # #Salida de diagnostico
  # [print( list(df[columna].dropna()) ) for columna in df]
  # #input()#Pausa para revisar consola

  #Construir el numero de registros/filas indicados en el argumento correspondiente
  for _ in range(numeroRegistros):

    #Generar tupla para la consulta, seleccionando valores aleatorios    
    coleccionValores = [ random.choice( list(df[columna].dropna()) ) for columna in df ]

    #Adicionar los campos especificos de usuario
    coleccionValores.append(generarId()[:-2])
    coleccionValores.append(random.choice(coleccionFechasNacimiento))

    #Convertir la coleccion en tupla para generar la sentencia insert
    coleccionValores = tuple(coleccionValores)

    #Inicializar la consulta
    sqlInsertarFila = f"INSERT INTO {nombreTabla}("
    #Inicializar sucesion de tokens para la insercion
    tokens = ""  
    #Añadir los nombres de las columnas a la insercion
    for columna in df:
      sqlInsertarFila += f"{columna},"      
      tokens += "?,"    
    #Adicionar tokens por cada campo particular de usuario
    tokens += "?,"
    tokens += "?,"
    #Cambio de la coma y cierre de los nombres para el caso de usuario
    sqlInsertarFila = sqlInsertarFila[:-1] + f", Documento_Identidad, Fecha_Nacimiento) VALUES({tokens[:-1]})"
    
    #Salida de diagnostico, previo al envio a traves de la conexion
    print()
    print("Antes de enviar:")
    print("Consulta-> ",sqlInsertarFila)
    print("Valores-> ",coleccionValores)
    ##input()

    #Realizar la insercion
    insertarRegistro(conn,sqlInsertarFila,coleccionValores)
  
  #Al terminar el prooceso, retornar el nombre de la tabla para realizar consultas de enlazado
  return nombreTabla

#Funcion que retorna el listado de tuplas de todos los usuarios/responsables/clientes
def seleccionarUsuarios(conn,nombreTablaUsuarios):
  cur = conn.cursor()
  cur.execute(f"SELECT * FROM {nombreTablaUsuarios}")
  rows = cur.fetchall()
  # #Salida de diagnostico
  # for row in rows:
  #     print(row)
  return rows

#Funcion que retorna el listado de tuplas de todos los tipos
def seleccionarTipos(conn,nombreTablaTipos):
  cur = conn.cursor()
  cur.execute(f"SELECT * FROM {nombreTablaTipos}")
  rows = cur.fetchall()
  # #Salida de diagnostico
  # for row in rows:
  #     print(row)
  return rows 

#Funcion para obtener todos los registros de una tabla 
def seleccionarTodos(conn,nombreTabla):
  cur = conn.cursor()
  cur.execute(f"SELECT * FROM {nombreTabla}")
  rows = cur.fetchall()
  # #Salida de diagnostico
  # for row in rows:
  #     print(row)
  return rows 

#Funcion para generar tabla producto/servicio/proyecto a partir de los campos y dominios generados en el CSV recibido
def generarTablaProductoServicio(rutaTablaCSV,conn,numeroRegistros,nombreTablaTipos,nombreTablaUsuarios):    
  
  #Carga del CSV en un dataframe de pandas
  try:
      df = pd.read_csv(rutaTablaCSV,sep=separador)
  except:
    print("Error al leer el archivo CSV de la tabla")
    sys.exit1(1)#Terminar prematuramente el procedimiento

  #Contenedor para fechas de nacimiento del usuario para hacer una seleccion aleatoria
  coleccionFechasNacimiento = generadorFechas(1940,2002)

  #Obtener el nombre de la tabla
  nombreTabla = rutaTablaCSV.split('.')[0]
  
  #Iterar por cada columna del dataframe para la especificacion de los campos de la tabla
  sqlCreacionCampos = f""" ID_{nombreTabla} INTEGER NOT NULL, \n """
  for i,columna in enumerate(df):
    sqlCreacionCampos += f""" {columna}  {relacionarTipos(df[columna])} NOT NULL, \n """

  #Agregar campos especificos tabla usuario
  sqlCreacionCampos += f""" Serial  VARCHAR(12) NOT NULL, \n """
  #sqlCreacionCampos += f""" Fecha_Nacimiento  DATETIME NOT NULL, \n """
  
  #Adicionar los campos que seran llaves foraneas
  sqlCreacionCampos += f""" ID_{nombreTablaTipos} INTEGER NOT NULL, \n """
  sqlCreacionCampos += f""" ID_{nombreTablaUsuarios}  INTEGER NOT NULL, \n """ 

  #Cierre de la tabla -> Establecer cuales son las llaves foraneas y la llave primaria
  sqlCreacionCampos += f""" FOREIGN KEY (ID_{nombreTablaTipos}) REFERENCES {nombreTablaTipos} (ID_{nombreTablaTipos}), \n """
  sqlCreacionCampos += f""" FOREIGN KEY (ID_{nombreTablaUsuarios}) REFERENCES {nombreTablaUsuarios} (ID_{nombreTablaUsuarios}), \n """  
  sqlCreacionCampos += f""" PRIMARY KEY (ID_{nombreTabla})"""
  
  #Sentencia con la construccion de la tabla
  sql_creacionTabla = f"""CREATE TABLE  {nombreTabla}  (
                      {sqlCreacionCampos});
                  """
  #Salida de diagnostico
  print(sql_creacionTabla)  

  #Proceder a crear la tabla
  crearTabla(conn, sql_creacionTabla)

  #Salida de diagnostico
  print("Tabla creada exitosamente")
  #input()#Pausar salida de consola  

  #Consultas para las llaves foraneas
  usuarios = seleccionarUsuarios(conn, nombreTablaUsuarios)
  idsUsuarios = list( map(lambda x:x[0],usuarios) )
  tipos = seleccionarUsuarios(conn, nombreTablaTipos)
  idsTipos = list( map(lambda x:x[0],tipos) )

  #Salida de diagnostico
  print("Tabla foranea tipos: ")
  print(tipos)
  print("Extraer listado de ids")
  print(idsTipos)  
  #input()
  print("Tabla foranea Usuarios: ")
  print(usuarios)
  print("Extraer listado de usuarios")
  print(idsUsuarios)  
  #input()

  #Una vez creada la tabla insertar todas las filas alojadas en el dataframe
  
  # #Salida de diagnostico
  # [print( list(df[columna].dropna()) ) for columna in df]
  # #input()#Pausa para revisar consola

  #Construir el numero de registros/filas indicados en el argumento correspondiente
  for _ in range(numeroRegistros):

    #Generar tupla para la consulta, seleccionando valores aleatorios    
    coleccionValores = [ random.choice( list(df[columna].dropna()) ) for columna in df ]

    #Adicionar los campos especificos de usuario
    coleccionValores.append(generarId())
    #coleccionValores.append(random.choice(coleccionFechasNacimiento))

    #Adicionar los campos foraneos
    coleccionValores.append(random.choice(idsTipos))
    coleccionValores.append(random.choice(idsUsuarios))    

    #Convertir la coleccion en tupla para generar la sentencia insert
    coleccionValores = tuple(coleccionValores)

    #Inicializar la consulta
    sqlInsertarFila = f"INSERT INTO {nombreTabla}("
    #Inicializar sucesion de tokens para la insercion
    tokens = ""  
    #Añadir los nombres de las columnas a la insercion
    for columna in df:
      sqlInsertarFila += f"{columna},"      
      tokens += "?,"    
    #Adicionar tokens por cada campo particular de usuario
    tokens += "?,"
    #tokens += "?,"
    #Adicionar tokens por cada campo correspondiente a las llaves foraneas
    tokens += "?,"
    tokens += "?,"
    #Cambio de la coma y cierre de los nombres para el caso de usuario
    sqlInsertarFila = sqlInsertarFila[:-1] + f", Serial, ID_{nombreTablaTipos},ID_{nombreTablaUsuarios}) VALUES({tokens[:-1]})"
    
    #Salida de diagnostico, previo al envio a traves de la conexion
    print()
    print("Antes de enviar:")
    print("Consulta-> ",sqlInsertarFila)
    print("Valores-> ",coleccionValores)
    ##input()

    #Realizar la insercion
    insertarRegistro(conn,sqlInsertarFila,coleccionValores)
  
  return nombreTabla

#Funcion para generar la tabla que implementa la relacion N a N entre el producto o servicio y sus componentes
def generarTablaComponenteProducto(rutaTablaCSV,conn,numeroRegistros,nombreTablaProducto,nombreTablaComponente):    
  
  #Carga del CSV en un dataframe de pandas
  try:
      df = pd.read_csv(rutaTablaCSV,sep=separador)
  except:
    print("Error al leer el archivo CSV de la tabla")
    sys.exit1(1)#Terminar prematuramente el procedimiento

  #Contenedor para fechas de compras o relacionamiento entre el producto y sus componentes
  coleccionFechas = generadorFechas(2020,2021)

  #Obtener el nombre de la tabla
  nombreTabla = rutaTablaCSV.split('.')[0]
  
  #Iterar por cada columna del dataframe para la especificacion de los campos de la tabla
  sqlCreacionCampos = f""" ID_{nombreTabla} INTEGER NOT NULL, \n """
  for i,columna in enumerate(df):
    sqlCreacionCampos += f""" {columna}  {relacionarTipos(df[columna])} NOT NULL, \n """

  #Agregar campo especifico (decha)
  sqlCreacionCampos += f""" Fecha DATETIME NOT NULL, \n """  

  #Adicionar los campos que seran llaves foraneas
  sqlCreacionCampos += f""" ID_{nombreTablaProducto} INTEGER NOT NULL, \n """
  sqlCreacionCampos += f""" ID_{nombreTablaComponente}  INTEGER NOT NULL, \n """ 

  #Cierre de la tabla -> Establecer cuales son las llaves foraneas y la llave primaria
  sqlCreacionCampos += f""" FOREIGN KEY (ID_{nombreTablaProducto}) REFERENCES {nombreTablaProducto} (ID_{nombreTablaProducto}), \n """
  sqlCreacionCampos += f""" FOREIGN KEY (ID_{nombreTablaComponente}) REFERENCES {nombreTablaComponente} (ID_{nombreTablaComponente}), \n """  
  sqlCreacionCampos += f""" PRIMARY KEY (ID_{nombreTabla})"""
  
  #Sentencia con la construccion de la tabla
  sql_creacionTabla = f"""CREATE TABLE  {nombreTabla}  (
                      {sqlCreacionCampos});
                  """
  #Salida de diagnostico
  print(sql_creacionTabla)  

  #Proceder a crear la tabla
  crearTabla(conn, sql_creacionTabla)

  #Salida de diagnostico
  print("Tabla creada exitosamente")
  #input()#Pausar salida de consola  

  #Consultas para las llaves foraneas
  productos = seleccionarTodos(conn, nombreTablaProducto)
  idsProductos = list( map(lambda x:x[0],productos) )
  componentes = seleccionarTodos(conn, nombreTablaComponente)
  idsComponentes = list( map(lambda x:x[0],componentes) )

  #Salida de diagnostico
  print("Tabla foranea productos: ")
  print(productos)
  print("Extraer listado de ids")
  print(idsProductos)  
  #input()
  print("Tabla foranea componentes: ")
  print(componentes)
  print("Extraer listado de usuarios")
  print(idsComponentes)  
  #input()

  #Una vez creada la tabla insertar todas las filas alojadas en el dataframe
  
  # #Salida de diagnostico
  # [print( list(df[columna].dropna()) ) for columna in df]
  # #input()#Pausa para revisar consola

  #Construir el numero de registros/filas indicados en el argumento correspondiente
  for _ in range(numeroRegistros):

    #Generar tupla para la consulta, seleccionando valores aleatorios    
    coleccionValores = [ random.choice( list(df[columna].dropna()) ) for columna in df ]

    #Adicionar los campos especificos de la tabla NN
    coleccionValores.append(random.choice(coleccionFechas))  

    #Adicionar los campos foraneos
    coleccionValores.append(random.choice(idsProductos))
    coleccionValores.append(random.choice(idsComponentes))    

    #Convertir la coleccion en tupla para generar la sentencia insert
    coleccionValores = tuple(coleccionValores)

    #Inicializar la consulta
    sqlInsertarFila = f"INSERT INTO {nombreTabla}("
    #Inicializar sucesion de tokens para la insercion
    tokens = ""  
    #Añadir los nombres de las columnas a la insercion
    for columna in df:
      sqlInsertarFila += f"{columna},"      
      tokens += "?,"    
    #Adicionar tokens por cada campo particular de usuario
    tokens += "?,"    
    #Adicionar tokens por cada campo correspondiente a las llaves foraneas
    tokens += "?,"
    tokens += "?,"
    #Cambio de la coma y cierre de los nombres para el caso de usuario
    sqlInsertarFila = sqlInsertarFila[:-1] + f", Fecha, ID_{nombreTablaProducto},ID_{nombreTablaComponente}) VALUES({tokens[:-1]})"
    
    #Salida de diagnostico, previo al envio a traves de la conexion
    print()
    print("Antes de enviar:")
    print("Consulta-> ",sqlInsertarFila)
    print("Valores-> ",coleccionValores)
    ##input()

    #Realizar la insercion
    insertarRegistro(conn,sqlInsertarFila,coleccionValores)
  

#Seccion principal
if __name__ == '__main__':


  ##########################################################
  #Establecer aqui parametros para generar la base de datos#
  #(tildes omitidas para evitar errores de codificacion)   #
  ##########################################################

  #1) Especificar nombre de la base de datos
  nombreBaseDatos = "BaseDatosGenerada"

  #2) Especificar el archivo base para tabla que tendra los Usuarios/Responsables/Compradores
  #->Creacion por dominios especificados en el CSV
  #->Campos fijos de la tabla (se generaran automaticamente): 
  #   Documento_Identidad  VARCHAR(12) NOT NULL
  #   Fecha_Nacimiento  DATETIME NOT NULL  
  rutaTablaUsuario = "Usuario.csv"
  numeroFilasUsuario = 30#Numero correspondiente de Usuarios/Responsables/Compradores   

  #3) Especificar el archivo base para tabla que tendra los Tipos/Clasificaciones del Producto/Servicio
  #->Creacion explicita: tal como se especifique la tabla en el CSV
  rutaTablaTipo = "TipoProductoServicio.csv"

  #4) Especificar el archivo base para tabla que tendra los Productos/Servicios/Entidad Principal
  #->Creacion por dominios especificados en el CSV
  #->Campos fijos de la tabla (se generaran automaticamente): 
  #   Serial  VARCHAR(12) NOT NULL  
  rutaTablaProductoServicio = "Proyecto.csv"
  numeroFilasProductoServicio = 100#Numero correspondiente de Productos/Servicios/Entidad Principal

  #5) Especificar el archivo base para tabla que tendra los Componentes/Partes de los Productos/Servicios
  #->Creacion explicita: tal como se especifique la tabla en el CSV
  rutaTablaComponente = "MaterialConstruccion.csv"

  #6) Especificar el archivo base para tabla que resuelve relacion N a N 
  #   entre Productos/Servicios/Entidad Principal y sus Componentes/Partes de los Productos/Servicios
  #->Creacion por dominios especificados en el CSV
  #->Campos fijos de la tabla (se generaran automaticamente): 
  #   Fecha DATETIME NOT NULL   
  rutaTablaComponenteProducto = "Proyecto_Material_NN.csv"
  numeroFilasTablaComponenteProducto = 300#Numero correspondiente de registros que relacionan NN

  #Observaciones:
  #- Todos los campos son NOT NULL
  #- Evitar tildes o caracteres especiales
  #- Los nombres de las tablas son generados a partir del nombre del archivo CSV
  #- A todas las tablas se les genera una llave primaria con el nombre ID_NombreTabla y es de tipo entero
  #- Las relaciones y llaves foraneas son generadas automaticamente
  #- Este script requiere numpy, sqlite3 (tanto en Python como en el sistema) 
  #  y pandas correctamente instalados.  

  ##########################################################
  #Final de seccion de especificacion                      #
  ##########################################################

  # #Conectarse/Crear base de datos
  # conn = crearConexion(nombreBaseDatos+".db")

  # #Mientras se tenga la conexion abierta
  # with conn:
  #   #Generar cada tabla del modelo    
  #   nombreTablaTipo = generarTablaExplicita(rutaTablaTipo,conn)
  #   nombreTablaUsuario = generarTablaUsuario(rutaTablaUsuario,conn,numeroFilasUsuario)    
  #   nombreTablaProductoServicio = generarTablaProductoServicio(rutaTablaProductoServicio,conn,numeroFilasProductoServicio,nombreTablaTipo,nombreTablaUsuario) 
  #   nombreTablaComponenteProducto = generarTablaExplicita(rutaTablaComponente,conn)
  #   nombreTablaNN = generarTablaComponenteProducto(rutaTablaComponenteProducto,conn,numeroFilasTablaComponenteProducto,nombreTablaProductoServicio,nombreTablaComponenteProducto)


#Imprimir consultas

# proveedores = ['Globo','Colombia','VariedadesAlgo','La14','Rappi']
# direcciones  = ['Call 1','Cra 14','Barrio Hola','Sitio','Otro Sitio']
# inserciones = []
# for i in range(len(direcciones)):
#   inserciones.append(f"""INSERT INTO Proveedor (Nombre,NIT,Direccion) 
# VALUES ('{proveedores[i]}','{generarId()}','{direcciones[i]}');""")
# [ print(x) for x in inserciones]

productos = ['Granola','Kummis','Kummis','Chocorramo','brownie','banano','heldo de chocolate']
precios = [1500,2000,1800,2300]
id_proveedores = list(range(1,5))
inserciones = []
for i in range(len(productos)):
  inserciones.append(f"""INSERT INTO Producto    (Nombre,Codigo,Precio_Unitario, ID_Empresa, ID_Proveedor ) 
        VALUES          ('{productos[i]}','{generarId(5)}',{random.choice(precios)},1,{random.choice(id_proveedores)});""")
[print(x) for x in inserciones]





