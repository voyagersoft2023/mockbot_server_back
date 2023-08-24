package voyagersoft.mockbot.config

import oogaday.commons.enums.StatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import voyagersoft.mockbot.common.model.entity.ResponseStructure


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(CommonException::class)
    fun commonExceptionHandler(e: RuntimeException): ResponseEntity<*> {
        val response = ResponseStructure()
        val status = StatusCode.values().find {
            it.code == e.message.toString().toInt()
        } ?: StatusCode.Unknown

        response.code = status.code
        response.data = ""
        response.message = status.message
        return ResponseEntity.ok<Any>(response)
    }
}