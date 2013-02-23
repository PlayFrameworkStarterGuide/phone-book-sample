/*
 *
 * Play Framework Starter Guide
 * Phone Book Example
 *   ______  ___                             ___                     ___ __
 *  /   _  \/  /__  ______  ______  ______  /  /__  ______  ______  /  /  /
 * /   ____/   _  \/   _  \/   _  \/   ___\/   _  \/   _  \/   _  \/      \
 * \__/    \__/___/\______/\__/___/\______/\______/\______/\______/\__/___/
 *
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 *
 */
package models

import scala.collection.concurrent.TrieMap
import java.util.concurrent.atomic.AtomicLong

case class Entry(name: String = "", phone: String = "", id: Option[Long] = None)

object Entries {

  val entries = TrieMap[Long, Entry]()

  val uuid: AtomicLong = new AtomicLong()

  def delete(id: Long) = entries.remove(id)

  def findById(id: Long) = entries.get(id)

  def findByName(filter: String) = entries.values.filter {
    _.name.toLowerCase.contains(filter.toLowerCase)
  }.toSeq

  def save(entry: Entry) =
    ( if (entry.id.isDefined) entry
      else entry.copy(id = Some(uuid.incrementAndGet()))
    ) match {
      case e@Entry(_, _, Some(id)) => entries += (id -> e)
    }

}
