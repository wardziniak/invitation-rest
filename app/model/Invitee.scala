package model


import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 * Created by wardziniak on 26.07.15.
 */
object Invitee {

  case class Invitee(name: String, email: String)

  var invitees = List(Invitee("Ludwig von Mises", "ludwig.mises@test.pl"), Invitee("Frédéric Bastiat", "frederic.bastiat@test.pl"))

  def addInvitee(invitee: Invitee) = invitees = invitees ::: List(invitee)

  implicit val inviteeWriters: Writes[Invitee] = (
    (__ \ "invitee").write[String] and
      (__ \ "email").write[String]
    ) (unlift(Invitee.unapply))

  implicit val inviteeReaders: Reads[Invitee] = (
    (__ \ "invitee").read[String] and
      (__ \ "email").read[String]
    ) (Invitee.apply _)
}
