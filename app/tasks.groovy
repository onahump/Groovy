def eb = vertx.eventBus()
def sd = vertx.sharedData()
def tasks = sd.getLocalMap("tasks")
if(tasks.isEmpty()) tasks.put("data", [])
//def tasks = sd.getClusterWideMap("tasks")

eb.consumer("task.create") { message ->
  task = [
    id: UUID.randomUUID().toString(),
    description: message.body().description,
    priority: message.body().priority,
		date_created: new Date().format("dd/MM/yyyy hh:mm:ss")
  ]
  data = tasks.get("data")
  data << task
  tasks.put("data", data)
  eb.publish("task.list", data)
}