package voyagersoft.mockbot.jwt.service

import voyagersoft.mockbot.api.user.model.entity.User

interface JwtService {
    @Throws(Exception::class)
    fun createAccessToken(user: User): String

    @Throws(Exception::class)
    fun createRefreshToken(): String

    @Throws(Exception::class)
    fun checkToken(token: String?): Map<String, Any>
}