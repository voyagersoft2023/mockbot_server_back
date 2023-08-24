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
        Index(name = "Users", columnList = "id"),
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

    @Comment("패스워드")
    @NotNull
    var password: String = ""
}