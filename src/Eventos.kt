data class Evento(
    val produtora: String,
    val dataevento: String,
    val horaInicio: Int,
    val duracao: Int,
    val convidados: Int,
    val auditorio: String)
fun eventos(){
    println("-[MENU DE EVENTOS]-\n" +
            "Nosso hotel contém dois auditórios: \n" +
            "Auditório Laranja - Capacidade 150 lugares + 70 extras (220) \n" +
            "Auditório Colorado - Capacidade 350 lugares \n" +
            "Digite o número de convidados para o evento:"
    )
    val convidadosevento = readln().toInt()
    if (convidadosevento == null || convidadosevento <= 0 || convidadosevento >=350){
        println("Quantidade de convidados inválida!")
    }
    if (convidadosevento >=220){
        println("O auditório Laranja é o mais recomendado!")
    } else {
        println("O auditório Colorado é o mais recomendado!")
    }
    println("")






}