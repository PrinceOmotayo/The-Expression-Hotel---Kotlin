import kotlin.String

data class Evento(
    val contratante: String,
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
    var auditoriosugerido = ""
    var cadeirasextras = 0
    if (convidadosevento == null || convidadosevento <= 0 || convidadosevento >=350){
        println("Quantidade de convidados inválida!")
    }
    if (convidadosevento <=150){
        println("O auditório Laranja é o mais recomendado!")
        auditoriosugerido = "Laranja"
    }
    else if (convidadosevento <= 220){
        auditoriosugerido = "Laranja"
        cadeirasextras += convidadosevento - 150
        println("O auditório Laranja é o mais recomendado! \n" +
                "Adicionaremos $cadeirasextras cadeiras. ")
    }
        else {
        println("O auditório Colorado é o mais recomendado!")
        auditoriosugerido = "Colorado"
    }
    //AGENDAMENTO
    println("Informe o dia da semana:")
    val datafesta = readln().lowercase()
    val limites = when (datafesta){
        "segunda", "terca", "quarta", "quinta", "sexta" -> 23
        "sabado", "domingo" -> 15
        else -> {
            println("Dia inválido!")
            return
        }
    }
    println("Informe o horário de início: (7 às $limites)")
    val horaevento = readln().toIntOrNull()

    if (horaevento == null || horaevento<7 || horaevento>= limites){
        println("Horário inválido.")
        return
    }

    println("Informe a duração do evento: (1h-12h)")
    val tempoevento = readln().toIntOrNull()
    //(duracao !in 1..12) verifica entre 1 e 12
    if (tempoevento == null || tempoevento !in 1..12){
        println("Duração inválida.")
        return
    }
    val horatermino = tempoevento + horaevento
    if (horatermino > limites){
        println("Evento fora do horário permitido!")
        return
    }

    println("Informe o nome do Locatário:")
    val locatario = readln()

    val eventoconfirmado = Evento(
         contratante = locatario,
         dataevento = datafesta,
         horaInicio = horaevento,
         duracao = tempoevento,
         convidados = convidadosevento,
         auditorio = auditoriosugerido
    )
    println("Evento registrado:\n" +
            "Auditório ${eventoconfirmado.auditorio}\n" +
            "Data - ${eventoconfirmado.dataevento} às ${eventoconfirmado.horaInicio}\n" +
            "Contratante: ${eventoconfirmado.contratante}\n" +
            "Duração: ${eventoconfirmado.duracao}\n" +
            "Número de convidados: ${eventoconfirmado.convidados}")
    //GARÇONS(Gs) PARA EVENTOS

    val baseGs = convidadosevento/12
    val reforcoGs = tempoevento / 2
    val totalGs = baseGs + reforcoGs
    val custoGs = totalGs *  tempoevento * 10.50

    println("=[EQUIPE DE GARÇONS]=\n" +
            "Integrantes : $totalGs garçons \n" +
            "Custo de equipe: R$$custoGs reais.")

    //BUFFET
    val lcafe = convidadosevento * 0.2
    val custocafe = lcafe * 0.80
    val lagua = convidadosevento * 0.5
    val custoagua = lagua * 0.4
    val salgados = convidadosevento * 7
    val cxsalgados = salgados / 100
    val custosalgados = cxsalgados * 34
    val custobuffet = custosalgados + custocafe + custoagua
    val custoevento = custobuffet + custoGs
    println("Buffet: \n" +
            "Água - $lagua litros (R$$custoagua reais.\n" +
            "Café - $lcafe litros (R$$custocafe reais.\n" +
            "Salgados - $salgados unidades (R$$custosalgados reais.")

    //RELATÓRIO
    println("===[RESUMO CONTRATO]===\n" +
            "\nConvidados: $convidadosevento\n" +
            "Auditório: $auditoriosugerido\n" +
            "\n" +
            "Dia: $datafesta\n" +
            "Hora de Início: $horaevento\n" +
            "Duração: $tempoevento\n" +
            "Locatário: $locatario\n" +
            "\n" +
            "Garçons necessários: $totalGs\n" +
            "Custo com garçons: R$$custoGs reais\n" +
            "\n" +
            "=[BUFFET]=\n" +
            "Café: $lcafe L \n" +
            "Água: $lagua L \n" +
            "Salgados: $salgados un \n" +
            "Custo Buffet: R$$custobuffet \n" +
            "\n" +
            "Total do evento: R$$custoevento reais.\n ")
    println("Deseja confirmar reserva?(S/N)")
    val opcao = readln().uppercase()
    if (opcao == "S"){
        println("Reserva efetuada com sucesso.")
    }






}