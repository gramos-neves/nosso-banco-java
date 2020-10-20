

Criar o usuario

http://localhost:8080/people

Json 

{
    "name": "guilherme",
    "lastName": "Neves",
    "email": "gui@gui.com",
    "dateBirth": "1987-02-02",
    "cpf": "341.341.487-65"
}



Criar Endereço 

http://localhost:8080/address

Json

{
  	"cep" : "03579-250",
	"street" : "rua padre vitor mariano",
	"neighborhood" : "conjuto habitacional",
	"complement" : "apt 4",
	"city" : "sp",
	"state": "são paulo",
	"people_id" : "1"
	
}


Enviar Imagem 

http://localhost:8080/photos

form-data 

  photo -> imagemm 
  people_id -> id