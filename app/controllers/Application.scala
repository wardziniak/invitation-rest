package controllers

import model.Invitee._
import play.api.libs.json.{JsError, Json}
import play.api.mvc._

object Application extends Controller {

  def invitationsList() = Action {
    Ok(Json.toJson(invitees))
  }

  def saveInvitation() = Action(BodyParsers.parse.json)
  { request =>
    val i = request.body.validate[Invitee]
    i.fold(
      errors => {
        BadRequest(Json.obj("message" -> JsError.toFlatJson(errors)))
      },
      invitee => {
        addInvitee(invitee)
        Created
      })
  }
}
