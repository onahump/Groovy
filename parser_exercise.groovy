factura = new XmlSlurper().parse("ESY032314.xml")
factura.declareNamespace(fa:'http://www.sat.gob.mx/cfd/3')
factura.declareNamespace(cfdi:'http://www.itcomplements.com/cfd/v1')

println factura.Detalle.'cfdi:Addenda'.'fa:Detalle'each { println it.'@descripcion' }