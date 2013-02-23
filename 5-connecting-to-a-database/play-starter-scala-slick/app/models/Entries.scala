/**
 *     ______  ___  Play Framework Starter Guide   ___   Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______   /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \_/     \_
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/____/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package models

case class Entry(name: String = "", phone: String = "", id: Option[Long] = None)

trait EntriesComponent { self: Profile =>

  import profile.simple._
  import Database.threadLocalSession

  object Entries extends Table[Entry]("ENTRY") {

    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def name = column[String]("NAME")
    def phone = column[String]("PHONE")

    def * = name ~ phone ~ id.? <> (Entry, Entry.unapply _)

    def delete(id: Long) = db withSession {
      Query(this).where(_.id is id).delete
    }

    def findById(id: Long) = db withSession {
      Query(this).where(_.id is id).firstOption
    }

    def findByName(filter: String) = db withSession {
      val search = "%"+filter.toLowerCase+"%"
      Query(this).where(_.name.toLowerCase like search).list
    }

    def save(entry: Entry) = db withSession {
      entry.id.fold {
        this.insert(entry)
      }{ id =>
        Query(this).where(_.id is id).update(entry)
      }
    }

  }

}
