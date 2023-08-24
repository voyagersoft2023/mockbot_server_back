package voyagersoft.mockbot.jwt.service.impl

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import voyagersoft.mockbot.api.user.model.entity.User
import voyagersoft.mockbot.api.user.repository.UserRepository
import voyagersoft.mockbot.config.CommonException
import voyagersoft.mockbot.jwt.service.JwtService
import java.security.Key
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

@Service
class JwtServiceImpl : JwtService {

    @Value("\${jwt.access.key}")
    private lateinit var secretKey: String

    private lateinit var signatureAlgorithm: SignatureAlgorithm

    private lateinit var signingKey: Key

    @Autowired
    private lateinit var userRepository: UserRepository

    @PostConstruct
    @Throws(Exception::class)
    fun init() {
        // 2023.02.23[gjpark]: 암호화 기법 설정
        signatureAlgorithm = SignatureAlgorithm.HS512

        // 2023.02.23[gjpark]: 암호키 설정(보안으로 인해 프로퍼티에 설정)
        val secretKeyBytes = DatatypeConverter.parseBase64Binary(secretKey)
        signingKey = SecretKeySpec(secretKeyBytes, signatureAlgorithm.jcaName)
    }

    @Throws(Exception::class)
    override fun createAccessToken(user: User): String {
        return Jwts.builder()
            .claim("id", user.id) // (5)
            .signWith(signatureAlgorithm, signingKey)
            .setExpiration(Date(System.currentTimeMillis() + 3600 * 1000))
            .compact()
    }

    @Throws(Exception::class)
    override fun createRefreshToken(): String {
        return Jwts.builder()
            .signWith(signatureAlgorithm, signingKey)
            .setExpiration(Date(System.currentTimeMillis() + 5 * 24 * 60 * 60 * 1000))
            .compact()
    }

    @Throws(Exception::class)
    override fun checkToken(token: String?): Map<String, Any> {
        if (!"".equals(token)) {
            return Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .body
        } else {
            throw CommonException("1001")   //TOKEN 존재 하지 않을 때
        }
    }
}
