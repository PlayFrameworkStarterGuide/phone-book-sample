/*
 *     ______  ___  Play Framework Starter Guide   ___  Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______  /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \/      \
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/___/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package controllers;

import scala.collection.Seq;

import models.Entry;
import play.mvc.*;

public class Entries extends Controller {

	public static Result list(String filter) {
		Seq<Entry> entries = models.Entries.findByName(filter);
		return ok(views.html.index.render(entries));
	}

	public static Result remove(long id) {
		models.Entries.delete(id);
		return redirect(routes.Entries.list(""));
	}

	public static Result add() {
		return TODO;
	}

	public static Result edit(long id) {
		return TODO;
	}

	public static Result save() {
		return TODO;
	}

}
