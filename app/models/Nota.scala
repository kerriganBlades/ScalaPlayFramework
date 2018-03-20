package models

import play.api.libs.json.Json

case class Nota (name : String, text : String, date : String)

object Nota{

  implicit val notaFormat = Json.format[Nota]

}
