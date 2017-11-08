import io.vertx.ext.web.Router
import io.vertx.core.Vertx
import io.vertx.ext.web.handler.StaticHandler

def server = vertx.createHttpServer()
def router = Router.router(vertx)

router.route("/static/*").handler(StaticHandler.create().setCachingEnabled(false))

server.requestHandler(router.&accept).listen(8181)