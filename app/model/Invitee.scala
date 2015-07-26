package model

/**
 * Created by wardziniak on 26.07.15.
 */
object Invitee {

  case class Invitee(name: String, email: String)

  var invitees = List(Invitee("Ludwig von Mises", "ludwig.mises@test.pl"), Invitee("Frédéric Bastiat", "frederic.bastiat@test.pl"))

  def addInvitee(invitee: Invitee) = invitees = invitees ::: invitees

}
