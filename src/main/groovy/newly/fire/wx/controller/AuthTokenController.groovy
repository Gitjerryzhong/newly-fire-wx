package newly.fire.wx.controller

import com.sun.istack.Nullable
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.context.annotation.Value
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.types.files.StreamedFile
import newly.fire.wx.command.AuthTokenCommand
import newly.fire.wx.utils.Auth

import javax.validation.Valid

@Controller("/authTokens")
class AuthTokenController {
    @Value('${newlyfire.wxValidateFile}')
    String filesPath

    @Get("/{?authTokenCommand*}")
    def index(@Valid @Nullable AuthTokenCommand authTokenCommand) {
//        println(authTokenCommand.toString())
//        HttpStatus.OK
        def token = 'bnuz123'
        def arr = [token, authTokenCommand.timestamp, authTokenCommand.nonce]
        arr = arr.sort()
        StringBuffer sb = new StringBuffer()
        for(String s: arr) {
            sb.append(s)
        }
        def temp = Auth.getSha1(sb.toString())
        if (temp == authTokenCommand.signature) {
            authTokenCommand.echostr
        } else {
            'Error!!!'
        }
    }
    @Get("/*.txt")
    StreamedFile  getText() {
        def desFileName = 'MP_verify_Y7hOKkWY0qdulcvt.txt'
        FileInputStream inputStream = new FileInputStream("${filesPath}/${desFileName}")
        return new StreamedFile(inputStream, MediaType.TEXT_PLAIN_TYPE)
    }

    def save() {
//        def xml = new XmlParser().parse(request.reader)
//        def type = xml.MsgType.text()
//        def msg
//        if (type == 'text') {
//            msg = messageService.getTextMsg(xml)
//            messageService.log(msg)
//            def answer = messageService.getAnswer(msg)
//            if (answer) {
//                msg.content = answer
//            } else {
//                def key = msg.content
//                msg.content = null
//                if (!key.isLong()) {
//                    key = key.toLowerCase()
//                    def answers = messageService.findAnswers(key)
//                    msg.content = ''
//                    answers.eachWithIndex {a, index ->
//                        msg.content = "${msg.content == '' ? '您是不是想咨询：' : msg.content}\n${index + 1}. ${a.title}"
//                    }
//                    if (msg.content != '') {
//                        msg.content += '\n 请输入序号选择。'
//                    }
//                } else {
//                    def word = messageService.getActiveWord(msg)
//                    if (word) {
//                        def answers = messageService.findAnswers(word)
//                        if (answers) {
//                            if (answers.size() <= key.toInteger() - 1 || key.toInteger() < 1) {
//                                msg.content = '请输入相应序号。'
//                            } else {
//                                msg.content = answers.get(key.toInteger() - 1).description
//                            }
//                        }
//                    }
//                }
//                if (!msg.content) {
//                    msg.content = '感谢您的留言！'
//                }
//            }
//            render msg.send()
//        } else if (type == 'image') {
//            msg = messageService.getImageMsg(xml)
//            render msg.send()
//        } else {
//            msg = messageService.getTextMsg(xml)
//            msg.content = '感谢您的留言！'
//            render msg.send()
//        }

    }
}
