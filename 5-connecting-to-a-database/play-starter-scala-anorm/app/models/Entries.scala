/*
 *     ______  ___  Play Framework Starter Guide   ___  Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______  /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \/      \
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/___/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package models

import anorm._
import anorm.SqlParser._
import play.api.Play.current
import play.api.db.DB

case class Entry(name: String = "", phone: String = "", id: Option[Long] = None)

object Entries {

  val simple = {
    get[String]("entry.name") ~
    get[String]("entry.phone") ~
    get[Option[Long]]("entry.id") map {
      case name ~ phone ~ id => Entry(name, phone, id)
    }
  }

  def delete(id: Long) = DB.withConnection {
    implicit connection =>
      SQL("delete from entry where id = {id}")
        .on('id -> id)
        .executeUpdate()
  }

  def findById(id: Long) = DB.withConnection {
    implicit connection =>
      SQL("select * from entry where id = {id}")
        .on('id -> id)
        .singleOpt(simple)
  }

  def findByName(filter: String) = DB.withConnection {
    implicit connection =>
      SQL("select * from entry where lower(name) like {filter}")
        .on('filter -> ("%"+filter.toLowerCase+"%"))
        .as(simple.*)
  }

  def save(entry: Entry) = DB.withConnection {
    implicit connection =>
      if (entry.id.isDefined) {
        SQL("update entry set name={name}, phone={phone} where id = {id}")
          .on('name -> entry.name, 'phone -> entry.phone, 'id -> entry.id)
          .executeUpdate()
      } else {
        SQL("insert into Entry(name, phone) values ({name}, {phone})")
          .on('name -> entry.name, 'phone -> entry.phone)
          .executeInsert()
      }
  }

}
