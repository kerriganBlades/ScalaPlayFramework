package controllers

import play.api._
import javax.inject._
import models.Nota
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Lesly's blog."))
  }

  val notaForm: Form[Nota] = Form {
    mapping(
      "name" -> text,
      "text" -> text,
      "date" -> text
    )(Nota.apply)(Nota.unapply)
  }

  def addNota = Action {implicit request =>
    val nota = notaForm.bindFromRequest.get
    //db.save(nota)
    Redirect(routes.HomeController.index())
  }

  def getNotas = Action {
    //val notas = db.query[Nota].fetch
    Ok(Json.toJson("Nueva nota"))
  }

}
