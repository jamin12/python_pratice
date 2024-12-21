package section8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("예외 발생 ${throwable}")
    }

    CoroutineScope(Dispatchers.IO).launch(CoroutineName(name = "Coroutine1")) {
        launch(CoroutineName(name = "Coroutine2") + exceptionHandler) {
            throw Exception("Coroutine2에 예외가 발생했습니다")
        }
    }

    delay(timeMillis = 1000L)
}
