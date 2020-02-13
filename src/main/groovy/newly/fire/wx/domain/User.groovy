package newly.fire.wx.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(
        schema = "newly_fire",
        name = "system_user"
)
class User {
    @Id
    @GeneratedValue
    Long id
    String name
    String password
    String OpenId
    /**
     * type: 0 版主， 1 一般用户
     */
    Integer type
    Date dateCreated
    Boolean enabled
}
