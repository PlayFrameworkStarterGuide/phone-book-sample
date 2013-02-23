/**
 *     ______  ___  Play Framework Starter Guide   ___  Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______  /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \/      \_
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/____/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */

import models.{DAL, Entry}, DAL._
import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {

    import DAL.profile.simple._

    DAL.db withSession { implicit s: Session =>
      ddl.create
      Entries.save(Entry("Guillaume Bort", "+33 5 55 55 55 55"))
      Entries.save(Entry("Sadek Drobi", "+33 5 55 55 55 55"))
    }

  }

}
