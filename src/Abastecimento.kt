data class Abastecimento(
    val posto: String,
    val combustivel: String,
    val total: Double
)

fun abastecimento() {

    println("==[Abastecimento]==")

    val tanque = 42.0

    print("Wayne Oil - preço do álcool: ")
    val alcoolWayne = readln().toDouble()

    print("Wayne Oil - preço da gasolina: ")
    val gasolinaWayne = readln().toDouble()

    print("Stark Petrol - preço do álcool: ")
    val alcoolStark = readln().toDouble()

    print("Stark Petrol - preço da gasolina: ")
    val gasolinaStark = readln().toDouble()

    val combustivelWayne: String
    val precoWayne: Double

    if (alcoolWayne <= gasolinaWayne * 0.70) {
        combustivelWayne = "Álcool"
        precoWayne = alcoolWayne
    } else {
        combustivelWayne = "Gasolina"
        precoWayne = gasolinaWayne
    }

    val combustivelStark: String
    val precoStark: Double

    if (alcoolStark <= gasolinaStark * 0.70) {
        combustivelStark = "Álcool"
        precoStark = alcoolStark
    } else {
        combustivelStark = "Gasolina"
        precoStark = gasolinaStark
    }

    val totalWayne = tanque * precoWayne
    val totalStark = tanque * precoStark

    println()
    println(
        "Wayne Oil: melhor opção = $combustivelWayne | " +
                "Total (42L) = R$ %.2f".format(totalWayne)
    )

    println(
        "Stark Petrol: melhor opção = $combustivelStark | " +
                "Total (42L) = R$ %.2f".format(totalStark)
    )

    println()

    if (totalWayne < totalStark) {
        println("$nomelogin, é mais barato abastecer com $combustivelWayne no posto Wayne Oil.")
    } else if (totalStark < totalWayne) {
        println("$nomelogin, é mais barato abastecer com $combustivelStark no posto Stark Petrol.")
    } else {
        println("$nomelogin, os dois postos possuem o mesmo valor.")
    }
}