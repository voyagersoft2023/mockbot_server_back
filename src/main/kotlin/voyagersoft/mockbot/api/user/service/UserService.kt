package voyagersoft.mockbot.api.user.service

import jakarta.servlet.http.HttpServletResponse
import voyagersoft.mockbot.api.user.model.dto.UserRequest
import voyagersoft.mockbot.api.user.model.dto.UserResponse

interface UserService {
    @Throws(Exception::class)
    fun login(request: UserRequest, response: HttpServletResponse): UserResponse
}