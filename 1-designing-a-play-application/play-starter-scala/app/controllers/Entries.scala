/*
 *
 * Instant Play Framework Starter
 * Phone Book Example
 *   ______  ___                             ___                     ___ __
 *  /   _  \/  /__  ______  ______  ______  /  /__  ______  ______  /  /  /
 * /   ____/   _  \/   _  \/   _  \/   ___\/   _  \/   _  \/   _  \/      \
 * \__/    \__/___/\______/\__/___/\______/\______/\______/\______/\__/___/
 *
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 *
 */
package controllers

import models.{Entries => DAO}
import play.api.mvc._

object Entries extends Controller {

  def list(filter: String) = Action {
    val entries = DAO.findByName(filter.trim)
    Ok(views.html.index(entries))
  }

  def remove(id: Long) = Action {
    DAO.delete(id)
    Redirect(routes.Entries.list())
  }

  def add = TODO

  def edit(id: Long) = TODO

  def save = TODO

}
