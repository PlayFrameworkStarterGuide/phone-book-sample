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

import models.{Entry, Entries => DAO}
import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {

    DAO.save(Entry("Guillaume Bort", "+33 5 55 55 55 55"))
    DAO.save(Entry("Sadek Drobi", "+33 5 55 55 55 55"))

  }

}
