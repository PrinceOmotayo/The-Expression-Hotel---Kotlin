data class Reserva (
    var nomehospede: String,
    var registro: Int,
    var diarias: Int,
    var valortotal: Double
)
val reservas = mutableListOf<Reserva>()

fun reservaQuartos() {
    println("Informe o nome completo do hóspede:")
    var inputnome = readln().uppercase()
    println("Qual o valor da diária?")
    var valordiaria = readln().toFloat()
    if (valordiaria < 100) {
        println("O valor mínimo é 100.00$.")
        return
    }
    println("Informe a quantidade de diárias:")
    var inputdiarias = readln().toInt()
    if (inputdiarias < 1 || inputdiarias > 30) {
        println("Valor inválido, ${inputnome}")
        return
    }
    println("Qual a categoria do quarto? (S/E/L)")
    var categoria = readln().uppercase()
    var fatorquarto: Float
    while (categoria != "S" && categoria != "E" && categoria != "L") {
        println("Categoria Inexistente. Escolha uma categoria válida (S/E/L:")
        categoria = readln().uppercase()
    }
    when (categoria) {
        "S" -> fatorquarto = 1.0f
        "E" -> fatorquarto = 1.35f
        "L" -> fatorquarto = 1.65f
        else -> {
            println("...")
            return
        }
    }
    var subtotal : Float = fatorquarto * inputdiarias * valordiaria
    val taxa : Double = subtotal * 0.10
    var inputvalortotal : Double = subtotal+taxa
    println("Escolha um quarto: (1-20)")
    var inputregistro = readln().toInt()
    while (inputregistro < 1 || inputregistro > 20) {
        println("Inválido. Escolha outro quarto 1-20:")
        inputregistro = readln().toInt()
    }
    var quartoocupado = false
    for (i in reservas) {
        if (i.registro == inputregistro) {
            quartoocupado = true
        }
    }
    while (quartoocupado) {
        println("Quarto já ocupado. Escolha outro: ")
        inputregistro = readln().toInt()
        while (inputregistro < 1 || inputregistro > 20) {
            println("Número inválido. Escolha um quarto entre 1 e 20:")
            inputregistro = readln().toInt()
        }
        quartoocupado = false
        for (i in reservas) {
            if (i.registro == inputregistro) {
                quartoocupado = true
            }
        }
    }
        println("Quarto $inputregistro disponível!")
        var reserva = Reserva(
            nomehospede = inputnome,
            registro = inputregistro,
            diarias = inputdiarias,
            valortotal = inputvalortotal
        )
    println("Quarto $inputregistro selecionado.\n" +
            "A sua reserva ficou no valor de R$${reserva.valortotal}.\n " +
            "Deseja confirmar reserva?S/N")
    var confirmuser = readln().uppercase()
    while (confirmuser != "S" && confirmuser != "N"){
        println("Digite uma resposta válida: S/N?")
        confirmuser = readln().uppercase()
    }
    if (confirmuser== "S"){
    reservas.add(reserva)
    println("Reserva realizada!")}
    else if (confirmuser =="N") {
        println("Reserva não realizada.")
        menu()
    }
}