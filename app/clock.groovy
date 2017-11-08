
def eb = vertx.eventBus()

vertx.setPeriodic(1000, { v ->

  println "${new Date()}"
  eb.send("clock-address", "${new Date()}")

})