Algoritmo "Agencia_de_viagens"


Var
   Vcliente, Vdestino: vetor[1..100] de caractere
   contCadastro, cont, decisao: inteiro
   CC: caractere  // Usado somente pra melhorar a experiência na execução

procedimento cadastro()
inicio
   repita
      Escreval("________________________________________")
      Escreval("                                        |")
      Escreval("          C A D A S T R E - S E         |")
      ESCREVAL("________________________________________|")
      Escreva("Nome Completo: ")
      leia(Vcliente[contCadastro])
      Escreva("Qual destino quer viajar? ")
      leia(Vdestino[contCadastro])
      se ((Vcliente[contCadastro] = "") ou (Vdestino[contCadastro] = "")) entao
         Escreval("")
         Escreval("Existe campos vazios em seu cadastro!")
         Escreval("Por favor, preencha todos os campos.")
         Escreval("Aperte 'ENTER' pra continuar o cadastro.")
         leia(CC)
         limpatela
      fimse
   ate ((Vcliente[contCadastro] <> "") e (Vdestino[contCadastro]<> ""))
   contCadastro <- contCadastro + 1
   limpatela
fimprocedimento

procedimento consultaC()
inicio
   Escreval("___________________________________________")
   Escreval("                                           |")
   Escreval("             C A D A S T R A D O S         |")
   Escreval("___________________________________________|")
   para cont de 1 ate contCadastro -1 faça
      Escreval(cont,"- ",Vcliente[cont])
   fimpara
   Escreval("")
   Escreval("___________________________")
   Escreval("Aperte 'ENTER' para voltar!")
   leia(CC)
   limpatela
fimprocedimento

procedimento consultaD()
inicio
   Escreval("____________________________________________")
   Escreval("                                            |")
   Escreval("  D E S T I N O S    C A D A S T R A D O S  |")
   Escreval("____________________________________________|")
   para cont de 1 ate contCadastro -1 faça
      Escreval(cont,"- ",Vcliente[cont])
      Escreval("Destino: ",Vdestino[cont])
      Escreval("")
   fimpara
   Escreval("")
   Escreval("___________________________")
   Escreval("Aperte 'ENTER' para voltar!")
   leia(CC)
   limpatela
fimprocedimento

Inicio
   contCadastro <- 1
   repita
      Escreval("___________________________________________")
      Escreval("                                           |")
      Escreval("   A G Ê N C I A    D E    V I A G E N S   |")
      Escreval("___________________________________________|")
      Escreval("")
      Escreval(" Escolha uma opção ")
      Escreval(" 1 - Cadastrar;")
      Escreval(" 2 - Consultar clientes cadastrados;")
      Escreval(" 3 - Consultar destinos cadastrados;")
      Escreval(" 0 - Sair.")
      leia(decisao)

      Escolha decisao
      caso 1
         limpatela
         cadastro()
      caso 2
         limpatela
         consultaC()
      caso 3
         limpatela
         consultaD()
      outrocaso
         se (decisao <> 0) entao
            Escreval("Opção inválida!")
            Escreval("")
            Escreval("")
         fimse
      fimescolha
   ate( decisao = 0)

Fimalgoritmo