package newly.fire.wx.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import newly.fire.wx.domain.User
import newly.fire.wx.repository.UserRepository

import javax.inject.Inject
import javax.print.attribute.standard.Media

@Controller("/hello")
class HelloController {
    @Inject UserRepository userRepository
    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        userRepository.saveAll(Arrays.asList(
                new User(name: '张三', password: '123', dateCreated: new Date(), enabled: true),
                new User(name: '李四', password: '123', dateCreated: new Date(), enabled: true),
                new User(name: '王五', password: '123', dateCreated: new Date(), enabled: true),
                new User(name: '马六', password: '123', dateCreated: new Date(), enabled: true),
                new User(name: '鬼脚七', password: '123', dateCreated: new Date(), enabled: true)
        ))
        'hello world'
    }
}
