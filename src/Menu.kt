fun menu(){
    println("Bem vindo ao menu principal $nomelogin. O que deseja fazer?")
    while (true){
        println("1. Reserva de Quartos.\n" +
                "2. Cadastrar Hóspedes.\n" +
                "3. Eventos.\n" +
                "4. Ar condicionado.\n" +
                "5. Abastecimento,\n" +
                "6. Relatórios.\n" +
                "7. Sair.")
        var opcao = readln().toIntOrNull() ?: continue
        when (opcao){
            1 -> reservaQuartos()
            2 -> menucadastro()
            /*3 -> eventos()
            4 -> arcondicionado()
            5 -> abastecimento()
            6 -> relatorios ()*/
            7 -> { println("THE EXPRESSION MANAGE HOTEL encerrado. Até mais!")
                break}
            else ->  println("OPÇÃO INVÁLIDA. ESCOLHA UMA OPÇÃO ENTRE 1 E 7")
        }
        }
    }