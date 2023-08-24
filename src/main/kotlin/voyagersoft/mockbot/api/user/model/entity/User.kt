package voyagersoft.mockbot.api.user.model.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.jetbrains.annotations.NotNull

@Entity
@Table(
    name = "Users", indexes = [
        Index(name = "i_users_id", columnList = "id"),
    ]
)
@DynamicInsert
@DynamicUpdate
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, property = "id")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Comment("이메일")
    @NotNull
    var email: String = ""

    @Comment("이전 패스워드")
    var prePassword: String = ""

    @Comment("패스워드")
    @NotNull
    var password: String = ""

    @Comment("휴대폰번호")
    var phoneNumber: String = ""

    @Comment("회사명")
    var company: String = ""

    @Comment("사용여부")
    var useYn: String = ""

    @Comment("약관동의여부")
    var privacy: String = ""

    @Comment("마지막 로그인 일자")
    var lastLoginDt: String = ""

    @Comment("권한")
    var role: String = ""

}