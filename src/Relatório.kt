fun relatorios(
    reservas: MutableList<Reserva>,
    quartosOcupados: MutableSet<Int>,
    hospedes: MutableList<Hospede>,
    eventosregistrados: MutableList<Evento>,
) {

    println(" ===[RELATÓRIOS OPERACIONAIS]===")

    val totalReservas = reservas.size
    val ocupacao = (quartosOcupados.size / 20.0) * 100

    println("Reservas confirmadas: $totalReservas")
    println("Taxa de ocupação: %.2f%%".format(ocupacao))

    println("\nHóspedes cadastrados: ${hospede.size}")
    println("Eventos confirmados: ${eventosregistrados.size}")

    val receitaHospedagem = reservas.sumOf { it.valortotal }
    val receitaeventos = eventosregistrados.sumOf { it.valordoevento}
    val receitatotal = receitaeventos + receitaHospedagem
    println("==[Receitas]==")
    println("Hospedagem: R$ %.2f".format(receitaHospedagem))
    println("Eventos: R$ ${receitaeventos}")
    println("Total geral: R$$receitatotal ")
}