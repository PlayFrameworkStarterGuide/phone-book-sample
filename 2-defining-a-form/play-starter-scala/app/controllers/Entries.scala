/**
 *     ______  ___  Play Framework Starter Guide   ___   Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______   /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \_/     \_
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/____/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package controllers

import models.{Entry, Entries => DAO}
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

object Entries extends Controller {

  val entryForm = Form(
    mapping(
      "name" -> text,
      "phone" -> text,
      "id" -> optional(longNumber)
    )(Entry.apply)(Entry.unapply))

  def list(filter: String) = Action {
    val entries = DAO.findByName(filter.trim)
    Ok(views.html.index(entries))
  }

  def remove(id: Long) = Action {
    DAO.delete(id)
    Redirect(routes.Entries.list())
  }

  def add = Action {
    val form = entryForm.fill(Entry())
    Ok(views.html.edit(form, "Add entry"))
  }

  def edit(id: Long) = Action {
    DAO.findById(id) map { entry =>
      val form = entryForm.fill(entry)
      Ok(views.html.edit(form, "Edit entry"))
    } getOrElse {
      Redirect(routes.Entries.list())
    }
  }

  def save = Action { implicit request =>
    val entry = entryForm.bindFromRequest.get
    DAO.save(entry)
    Redirect(routes.Entries.list())
  }

}
