val nomehotel: String = "The Expression Hotel."
var nomelogin: String = ""
val senha = 2334
var tentativas = 0
fun main (){
    println("Bem vindo ao $nomehotel")
    println("Digite o seu nome:")
    nomelogin = readln().replaceFirstChar { it.uppercase() }
    println("Digite sua senha:")
    var inputsenha = readln().toIntOrNull()
    if (inputsenha == senha ){
            menu()
    }
    while (inputsenha != senha){
        println("Senha incorreta. Digite sua senha:")
        inputsenha = readln().toIntOrNull()
        tentativas++
        if (tentativas == 3){
            println("Exedeu o limite de tentativas!")
            break
        }
    }
}