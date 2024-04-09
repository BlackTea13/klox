import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size > 1) {
        println("Usage: klox [script]")
        exitProcess(64)
    }
    else if (args.size == 1) {
        runFile(args[0]);
    }
    else {
        runPrompt();
    }
}

fun runFile(path: String) {
    val bytes = File(path).readBytes() // 2 GB limit
    run(bytes.toString(Charset.defaultCharset()))
}

fun runPrompt() {
    val input = InputStreamReader(System.`in`)
    val reader = BufferedReader(input)

    while(true) {
        print("> ")
        val line = reader.readLine() ?: break
        run(line)
    }
}

fun run(source: String) {
    val scanner = Scanner(source)
    val tokens = scanner.tokens()

    for (token in tokens) {
        println(token)
    }
}
