package voyagersoft.mockbot.api.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import voyagersoft.mockbot.api.user.model.entity.User

interface UserRepository : JpaRepository<User?, Long?>, JpaSpecificationExecutor<User?> {
    @Throws(Exception::class)
    fun findByEmail(email: String): User?
}