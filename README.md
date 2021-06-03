# carControl
Desafio Orange Talents - API REST para controle de veículos de usuários.

Sumário
=================
<!--ts-->
   * [Estrutura do Projeto](#Estrutura-do-Projeto)
   * [Funcionalidades](#Funcionalidades)
   * [Utilizando a Aplicação](#Utilizando-a-Aplicação)
<!--te-->
 
 # Estrutura do Projeto
 
 O projeto foi estruturado dividindo as classes de acordo com as camadas ou categorias: <b>Package by Layer</b> 
 
 * <b>CarControlApplication:</b> <i> Main da aplicação</i>
 * <b>controller:</b> <i> Package contendo os controllers da aplicação</i>
 * <b>DTO:</b> <i> Package contendo as classes de Transferência de Dados</i>
 * <b>exception</b> <i> Package contendo as classes de exceções</i>
     -  <b>exceptionHandler</b> <i> Package contendo as classes de tratamento das exceções</i>
 * <b>model:</b> <i> Package contendo as classes e mapeamento destas no banco</i>
 * <b>repository:</b> <i> Package contendo as interfaces que realizam as operações no banco de dados</i>
 * <b>service:</b> <i> Package contendo os services da aplicação e as chamadas da API FIPE, intermediando a comunicação do controller com o repository</i>

 
 # Funcionalidades
 - Adicionar Usuário
 - Adicionar Veículo
 - Listar Usuário e seus Veículos
 
 
# Utilizando a Aplicação
- Adicionar Usuário:\
    Efetuar POST em ```localhost:8081/usuario``` com os seguintes campos:
    ```
    {
      "nome": "Usuario de Exemplo",
      "email": "exemplo@exemplo.com",
      "cpf": "00000000000",
      "dataNascimento": "1999-01-01"
    }
    ```
- Adicionar Veículo:\
  Efetuar POST em ```localhost:8081/usuario/{idUsuario}/veiculo``` com os seguintes campos:
  ```
  {
    "marca": "Fiat",
    "modelo": "Palio Weekend Adventure 1.8 8V 103cv 4p",
    "ano": "2004"
  }
  ```
- Listar Usuário e seus Veículos:\
  Efetuar GET em ```localhost:8081/usuario/{idUsuario}```.\
  Retorno:
  ```
  {
    "id": 1,
    "nome": "Usuario de Exemplo",
    "email": "exemplo@exemplo.com",
    "cpf": "00000000000",
    "dataNascimento": "1999-01-01"
    "veiculos": [
        {
            "idVeiculo": 1,
            "Valor": "R$ 16.422,00",
            "Marca": "Fiat",
            "Modelo": "Palio Weekend Adventure 1.8 8V 103cv 4p",
            "AnoModelo": "2004",
            "Combustivel": "Gasolina",
            "idProprietario": 1,
            "diaRodizio": "Quarta-feira",
            "rodizioAtivo": false
        }
    ]
  }
  ```
