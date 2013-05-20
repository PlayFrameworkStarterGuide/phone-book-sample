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
package models;

import static play.libs.Scala.toSeq;

import scala.collection.Seq;

public class Entries {

	public static void delete(long id) {
        Entry.find.ref(id).delete();
	}

	public static Entry findById(long id) {
		return Entry.find.byId(id);
	}
	
	public static Seq<Entry> findByName(String filter) {
        return toSeq(Entry.find
				.where()
				.ilike("name", "%"+filter+"%")
				.findList());
	}

	public static void save(Entry entry) {
        if (entry.id == null) {
            entry.save();
        } else {
            entry.update();
        }
	}

}
