package voyagersoft.mockbot.api.user.controller

import jakarta.servlet.http.HttpServletResponse
import oogaday.commons.enums.StatusCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import voyagersoft.mockbot.api.user.model.dto.UserRequest
import voyagersoft.mockbot.api.user.service.UserService
import voyagersoft.mockbot.common.model.entity.ResponseStructure
import voyagersoft.mockbot.config.CommonException

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/login")
    @Throws(CommonException::class)
    fun login(
        @RequestBody request: UserRequest,
        httpServletResponse: HttpServletResponse
    ): ResponseEntity<ResponseStructure> {
        val response = ResponseStructure()
        response.code = StatusCode.OK.code
        response.data = userService.login(request, httpServletResponse)
        response.message = StatusCode.OK.message
        return ResponseEntity.ok(response)
    }
}