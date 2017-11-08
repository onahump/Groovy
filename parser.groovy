//entrenamientoParser = new XmlParser().parse('makingdevs.xml')
//entrenamientoParser = new XmlParser().parse('makingdevs.xml')
entrenamientoParser = new XmlSlurper().parse('makingdevs.xml')
 println "Entrenamiento en ${entrenamientoParser.'@organization'}"
 entrenamientoParser.roadmap.category.each { category ->
   println "- ${category.'@name'}"
   category.course.each { course ->
     println "\t-${course.text().trim()} (${course.'@duration'} hrs. / ${course.'@sessions'} sessions)"
   }
 }