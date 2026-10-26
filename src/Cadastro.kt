import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
//Menu cadastro
data class Hospede(
    val nome: String,
    val dataCadastro: LocalDateTime
)
val hospede = mutableListOf<Hospede>()
fun menucadastro() {
    println("$nomelogin esse é o Menu de Registro de Hóspedes. O que deseja fazer?")
    while (true) {
        println(
            "1. Cadastrar.\n" +
                    "2. Pesquisar exato.\n" +
                    "3. Pesquisar prefixo.\n" +
                    "4. Listar A-Z.\n" +
                    "5. Atualizar,\n" +
                    "6. Remover.\n" +
                    "7. Voltar."
        )
        var opcao = readln().toIntOrNull() ?: continue
        when (opcao) {
            1 -> Cadastrar()
            2 -> pesquisarExato()
            3 -> pesquisarpref()
            4 -> listarAZ()
            5 -> atualizar()
            /*6 -> Relatórios ()*/
            7 -> {
                println("Voltando ao menu principal")
                return
            }

            else -> println("OPÇÃO INVÁLIDA. ESCOLHA UMA OPÇÃO ENTRE 1 E 7")
        }
    }
}

fun Cadastrar() {
    while (true) {
        if (hospede.size >= 15) {
            println("Estamos com lotação máxima! Não é possível adicionar mais hóspedes")
            return
        }
        println("Digite o nome do hóspede:")
        val nomecadastro = readln()
        if (hospede.any { it.nome.equals(nomecadastro, ignoreCase = true) }) {
            println("Hóspede já está na lista")
        } else {
            val novocadastro = Hospede(
                nome = nomecadastro,
                dataCadastro = LocalDateTime.now()
            )
            hospede.add(novocadastro)
            println("Hóspede Cadastrado!")
        }
        println("Deseja cadastrar mais hóspedes?S/N")
        var opcao = readln().first().uppercaseChar()
        if (opcao == 'N') {
            return
        } else if (opcao != 'S') {
            println("Opção inválida!!!")
        }
    }
}

fun pesquisarExato() {
    while (true) {
        println("Digite o nome que está procurando:")
        var listagem = readln()
        val encontrado = hospede.find { it.nome.equals(listagem, ignoreCase = true) }
        //O .any verifica se pelo menos um elemento da lista atende à condição. O it representa cada hóspede analisado.
        if (hospede != null) {
            println("Hóspede encontrado!\n $listagem")
        } else {
            println("Hóspede não encontrado.")
        }
        println("Deseja continuar pesquisando?S/N")
        var opcao = readln().uppercase()
        if (opcao == "N")
            return
    }
}

fun pesquisarpref() {
    while (true) {
        println("Faça sua busca:")
        var prefixo = readln()
        /*
        It. nome = cada nome de hóspede analisado
        startsWith = verifica se começa com...
        (prefix ou char = é o que eu estou procurando
        ignoreCase = ignorar maiúsculas e minúsculas
         */
        val busca = hospede.filter { it.nome.startsWith(prefixo, ignoreCase = true) }
        /*
        busca.isNotEmpty() :
        "." acessa uma propriedade ou função do objeto
        isNotEmpty() verifica se a lista não está vazia
        forEachIndexed percorre elementos da lista, fornecendo o índice de cada elemento
        {indice, nome ->
        indice: recebe a posição do elemento, começa em 0
        nome:"variavél rápida" que recebe o nome do hóspede naquela posição
        -> separa parâmetros das instruções
        {indice + 1} = age como contador de indices
         */
        if (busca.isNotEmpty()) {
            println("Resultados:")
            busca.forEachIndexed { indice, hospede ->
                println("[${indice + 1}]${hospede.nome}")
            }
        } else {
            println("Nenhum hóspede encontrado!")
            return
        }
        println("Deseja continuar a sua pesquisa? S/N")
        val opcao = readln().uppercase()
        if (opcao =="N"){
            return
        }
    }
}

fun listarAZ(){
        println("Lista de hóspedes:")
    /*
    hospede.sortedBy{it.lowercase()} cria uma lista em ordem alfabética
    e ignora diferenças entre maiúsculas e minúsculas.
    val ordenados: recebe essa lista acima
    .sortedBy não altera a lista original, apenas devolve uma nova lista
    por isso preciso criar a variavel ordenados
    val formato = modela o tipo de data
     */
 val formato = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm")
 val ordenados = hospede.sortedBy{ it.nome.lowercase() }
    ordenados.forEachIndexed {indice, hospede ->
        val data = hospede.dataCadastro.format(formato)
        println("[${indice + 1}]${hospede.nome} | Cadastro: $data")
    }
}

fun atualizar(){
println("Qual o nome do hospede que deseja atualizar?")
    val nomebuscado = readln()
    val indice = hospede.indexOfFirst { it.nome.equals(nomebuscado,ignoreCase = true) }
        //Verifica se o nome tem um indidce
    if (indice == -1){
        println("Hóspede não encontrado.")
        return
    }
    println("Digite o novo nome:")
    val nomeatt = readln()
    /*
    hospede[indice] acessa o hóspede que encontramos na lista pelo indice
    .dataCadastro acessa a data que já estavam salvas nesse hóspede
     */
    hospede[indice] = Hospede(
        nome = nomeatt,
        dataCadastro = hospede[indice].dataCadastro
    )
    println("Nome atualizado com sucesso!")
}
