/**
 *     ______  ___  Play Framework Starter Guide   ___   Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______   /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \_/     \_
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/____/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package controllers

import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Redirect(routes.Entries.list())
  }
  
}
