/**
 *     ______  ___  Play Framework Starter Guide   ___  Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______  /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \/      \_
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/____/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package models

trait Profile {

  val profile: slick.driver.ExtendedProfile
  val db: scala.slick.session.Database

}

import play.api.Play.current
import play.api.db.DB
import scala.slick.session.Database

object DAL extends EntriesComponent /* with OtherComponent */ with Profile {

  val profile = scala.slick.driver.H2Driver

  val db = Database.forDataSource(DB.getDataSource("default"))

  val ddl = Entries.ddl // ++ Other.ddl

}
