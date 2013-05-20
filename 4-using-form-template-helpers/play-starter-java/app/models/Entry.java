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

import static play.data.validation.Constraints.*;

public class Entry {

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

}
