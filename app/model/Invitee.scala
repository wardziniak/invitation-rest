package model

import com.evojam.mongodb.client.MongoClient
import com.evojam.mongodb.play.json._
import com.google.inject.{Inject, Singleton}
import play.api.Play.current
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._

import scala.concurrent.Future


/**
 * Created by wardziniak on 26.07.15.
 */
case class Invitee(invitee: String, email: String)

object Invitee {
  implicit val format = Json.format[Invitee]
}

@Singleton
class InviteeDao @Inject()(mongo: MongoClient) {

  val collectionName = current.configuration.getString("invitees.collection.default.name").getOrElse("invitees")

  def getInvitee(): Future[List[Invitee]] = {
    mongo.database().collection(collectionName).find().collect[Invitee]
  }

  def saveInvitee(invitee: Invitee) = {
    mongo.database().collection(collectionName).insert(invitee)
  }
}
