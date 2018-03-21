package example


import scala.xml._
import spray.json._
import spray.json.DefaultJsonProtocol._



object Transform extends App {

  implicit object NodeFormat extends JsonFormat[Node] {
    def write(node: Node) =
      if (node.child.count(_.isInstanceOf[Text]) == 1)
        JsString(node.text)
      else
        JsObject(node.child.collect {
          case e: Elem => e.label -> write(e)
        }: _*)

    def read(jsValue: JsValue) = null // not implemented
  }

  val fruits =
    <fruits>
      <fruit>
        <name>apple</name>
        <taste>
          <sweet>true</sweet>
          <juicy>true</juicy>
        </taste>
      </fruit>
      <fruit>
        <name>banana</name>
        <taste>better</taste>
      </fruit>
    </fruits>

 // val json = """[{"name":"apple","taste":{"sweet":"true","juicy":"true"}},{"name":"banana","taste":"better"}]"""
println((fruits \\ "fruit").toSeq.toJson.toString)
//  assert((fruits \\ "fruit").toSeq.toJson.toString == json)


}
