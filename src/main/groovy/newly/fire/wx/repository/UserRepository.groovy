package newly.fire.wx.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import newly.fire.wx.domain.User

@Repository
interface UserRepository  extends CrudRepository<User, Long> {
    User find(String name)
}