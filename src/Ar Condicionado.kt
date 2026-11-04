data class Orcamento(
    val empresa: String,
    val total: Double
)

fun arcondicionado() {
    println("=[Ar-Condicionado]=")

    val orcamentos = mutableListOf<Orcamento>()
    while (true) {
        print("Empresa: ")
        val empresa = readln()

        print("Valor por aparelho: ")
        val valorAparelho = readln().toDouble()

        print("Quantidade de aparelhos: ")
        val quantidade = readln().toInt()

        print("Desconto (%): ")
        val descontoPercentual = readln().toDouble()

        print("Mínimo para desconto: ")
        val minimoDesconto = readln().toInt()

        print("Deslocamento: ")
        val deslocamento = readln().toDouble()

        val bruto = valorAparelho * quantidade

        val desconto = if (quantidade >= minimoDesconto) {
            bruto * (descontoPercentual / 100)
        } else {
            0.0
        }

        val total = bruto - desconto + deslocamento

        orcamentos.add(
            Orcamento(
                empresa = empresa,
                total = total
            )
        )

        println("O serviço de $empresa custará R$ %.2f".format(total))
        print("Deseja informar novos dados, $nomelogin? (S/N): ")
        var opcao = readln().uppercase()
        if (opcao == "N") {
            break
        }
    }
    val menor = orcamentos.minBy { it.total }
    val maior = orcamentos.maxBy { it.total }
    val diferencaPercentual =
        ((maior.total - menor.total) / menor.total) * 100
    println("==Resumo dos orçamentos==")
    println("Melhor orçamento: ${menor.empresa} — R$ %.2f".format(menor.total))
    println("Maior orçamento: ${maior.empresa} — R$ %.2f".format(maior.total))
    println("Diferença percentual: %.2f%%".format(diferencaPercentual))
}