package controllers

import com.google.inject.{Inject, Singleton}
import model.{InviteeDao, _}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.{JsError, Json}
import play.api.mvc._

import scala.concurrent.Future

@Singleton
class Application @Inject()(inviteeDao: InviteeDao) extends Controller {

  def invitationsList1() = Action.async {
    inviteeDao.getInvitee().map(result => Ok(Json.toJson(result)))
  }

  def saveInvitation2() = Action.async(BodyParsers.parse.json) {
    request =>
      val i = request.body.validate[Invitee]
      i.fold(
        errors => {
          val res: Future[Result] = Future { BadRequest(Json.obj("message" -> JsError.toJson(errors)))}
          res
        },
        invitee => {
          inviteeDao.saveInvitee(invitee).map(p => Created)
        })
  }

}
