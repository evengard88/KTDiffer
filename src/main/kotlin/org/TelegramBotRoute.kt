package org
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.telegram.TelegramConstants
import org.apache.camel.component.telegram.model.IncomingMessage
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TelegramBotRoute : RouteBuilder() {

    override fun configure() {
        from("telegram:bots/123s")
            .filter { exchange -> exchange.getIn().getBody(IncomingMessage::class.java)?.text?.startsWith("/hello") == true }
            .setHeader(TelegramConstants.TELEGRAM_CHAT_ID, simple("\${body.message.chat.id}"))
            .setBody(simple("Hello, \${body.message.chat.firstName}!"))
            .to("telegram:bots/123")
    }
}