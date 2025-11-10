enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("${usuario.nome} já está matriculado em $nome.")
        } else {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado com sucesso em $nome!")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 45)
    val conteudo2 = ConteudoEducacional("POO com Kotlin", 60)
    val conteudo3 = ConteudoEducacional("Coleções e Funções Lambda", 50)

    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudo1, conteudo2, conteudo3)
    )

    val usuario1 = Usuario("Rodrigo")
    val usuario2 = Usuario("Ana")
    val usuario3 = Usuario("Carlos")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario1)

    println("\n=== Detalhes da Formação ===")
    println("Nome: ${formacaoKotlin.nome}")
    println("Nível: ${formacaoKotlin.nivel}")
    println("Conteúdos:")
    formacaoKotlin.conteudos.forEach {
        println(" - ${it.nome} (${it.duracao} min)")
    }

    println("\nAlunos matriculados:")
    formacaoKotlin.inscritos.forEach { println(" - ${it.nome}") }
}