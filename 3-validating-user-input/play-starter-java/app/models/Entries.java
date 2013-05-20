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

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import scala.collection.Seq;

public class Entries {

	private static Map<Long, Entry> entries = new ConcurrentHashMap<Long, Entry>();

	private static AtomicLong uuid = new AtomicLong();

	public static void delete(long id) {
		entries.remove(id);
	}

	public static Entry findById(long id) {
		return entries.get(id);
	}
	
	public static Seq<Entry> findByName(String filter) {
		List<Entry> result = new ArrayList<Entry>();
		for (Entry entry : entries.values()) {
			if (entry.name.toLowerCase().contains(filter.toLowerCase())) {
				result.add(entry);
			}
		}
		return toSeq(result);
	}

	public static void save(Entry entry) {
		if (entry.id == null) {
			entry.id = uuid.incrementAndGet();
		}
		entries.put(entry.id, entry);
	}

}
