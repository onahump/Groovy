import io.vertx.ext.web.Router
import io.vertx.core.Vertx
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.ext.web.handler.sockjs.SockJSHandler
import io.vertx.ext.web.handler.sockjs.BridgeOptions
import io.vertx.ext.web.handler.sockjs.PermittedOptions

def eb = vertx.eventBus()

// Ya cree el Webserver!!!
def server = vertx.createHttpServer()
// Aqui creo mi router para direccionar toooodoooo el tráfico, de cualquier tipo
// es decir, http o ws
def router = Router.router(vertx)

// Creo las BridgeOption para mi puente
BridgeOptions options = new BridgeOptions()
// Defino que entra y que sale
//outuboundAddresses = ["clock-client", "clock-status", "system-status"]
options.addInboundPermitted(new PermittedOptions().setAddress("sala1"))
options.addInboundPermitted(new PermittedOptions().setAddress("sala.chat"))
options.addOutboundPermitted(new PermittedOptions().setAddress("sala1"))
// Definir mi handler de SockJS
sockjsHandler = SockJSHandler.create(vertx).bridge(options)
// Creo la ruta para este bridge
router.route("/eventbus/*").handler(sockjsHandler)

// Ya cree el manejo de css, js y html
router.route("/static/*").handler(StaticHandler.create().setCachingEnabled(false))

router.route("/send/*").handler { routingContext ->
  def request  =  routingContext.request()
  //println request.params()
  def msg = [ user: request.getParam("name"), msg: request.getParam("msg") ]
  //println msg
  eb.send("sala1", msg)

  def response = routingContext.response()
  response.putHeader("content-type", "text/plain")
  response.end("Hello world ${new Date()}")
}

eb.consumer("sala.chat"){ message ->
  println message.properties
  eb.publish("sala1", message.body())
}


// Inicio el server
server.requestHandler(router.&accept).listen(7070)

// Despliego otro verticle
//vertx.deployVerticle("clock.groovy")

//Despliego vertical de una sala
//vertx.deployVerticle("chat_server.groovy")