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
package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import static play.data.validation.Constraints.*;

@Entity
public class Entry extends Model {

	@Id
	public Long id;

	@Required
	@MinLength(value = 2)
	public String name;

	@Required
	@Pattern(
		value = "\\+?[0-9\\s]+",
		message = "Optional +, followed by digits & spaces"
	)
	public String phone;

	public Entry() {}

	public static Finder<Long,Entry> find =
		new Finder<Long,Entry>(Long.class, Entry.class);

}
