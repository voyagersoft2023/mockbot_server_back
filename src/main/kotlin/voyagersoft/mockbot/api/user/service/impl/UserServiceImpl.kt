package voyagersoft.mockbot.api.user.service.impl

import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.mindrot.jbcrypt.BCrypt
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import voyagersoft.mockbot.api.user.model.dto.UserRequest
import voyagersoft.mockbot.api.user.model.dto.UserResponse
import voyagersoft.mockbot.api.user.model.entity.User
import voyagersoft.mockbot.api.user.repository.UserRepository
import voyagersoft.mockbot.api.user.service.UserService
import voyagersoft.mockbot.config.CommonException
import voyagersoft.mockbot.jwt.service.JwtService

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var modelMapper: ModelMapper

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var jwtService: JwtService

    /* 2023.08.23[gjpark]: 아이디, 비밀번호 체크 후 토큰발행 */
    override fun login(request: UserRequest, response: HttpServletResponse): UserResponse {
        val user: User? = userRepository.findByEmail(request.email)
        var userResponse: UserResponse

        if (user === null) {
            throw CommonException("1000")
        } else {
            if (BCrypt.checkpw(request.password, user.password)) {
                var jwtAccessToken = jwtService.createAccessToken(user)

                userResponse = modelMapper.map(user, UserResponse::class.java)
                val cookie = Cookie("token", jwtAccessToken)
                cookie.setMaxAge(1000 * 60 * 60 * 24 * 7)
                cookie.setPath("/");
                cookie.setHttpOnly(false)
                response.addCookie(cookie);
            } else {
                throw CommonException("1000")
            }
        }

        return userResponse
    }
}