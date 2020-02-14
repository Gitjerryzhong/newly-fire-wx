package newly.fire.wx.command

import io.micronaut.core.annotation.Introspected

@Introspected
class AuthTokenCommand {
    Long timestamp
    String nonce
    String signature
    String echostr

    String toString() {
        "timestamp: ${timestamp}, nonce: ${nonce}, signature: ${signature}, echostr: ${echostr}"
    }
}
