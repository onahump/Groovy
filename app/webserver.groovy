import io.vertx.ext.web.Router
import io.vertx.core.Vertx
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.ext.web.handler.sockjs.SockJSHandler
import io.vertx.ext.web.handler.sockjs.BridgeOptions
import io.vertx.ext.web.handler.sockjs.PermittedOptions

// Ya cree el Webserver!!!
def server = vertx.createHttpServer()
// Aqui creo mi router para direccionar toooodoooo el tráfico, de cualquier tipo
// es decir, http o ws
def router = Router.router(vertx)

// Creo las BridgeOption para mi puente
BridgeOptions options = new BridgeOptions()
// Defino que entra y que sale
//outuboundAddresses = ["clock-client", "clock-status", "system-status"]
options.addInboundPermitted(new PermittedOptions().setAddress("clock-address"))
options.addInboundPermitted(new PermittedOptions().setAddress("task.create"))
options.addOutboundPermitted(new PermittedOptions().setAddress("clock-address"))
// Definir mi handler de SockJS
sockjsHandler = SockJSHandler.create(vertx).bridge(options)
// Creo la ruta para este bridge
router.route("/eventbus/*").handler(sockjsHandler)

// Ya cree el manejo de css, js y html
router.route("/static/*").handler(StaticHandler.create().setCachingEnabled(false))

// Inicio el server
server.requestHandler(router.&accept).listen(8181)

// Despliego otro verticle
vertx.deployVerticle("clock.groovy")