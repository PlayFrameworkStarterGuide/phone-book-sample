/**
 *     ______  ___  Play Framework Starter Guide   ___  Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______  /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \/      \_
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/____/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package controllers;

import scala.collection.Seq;

import models.Entry;
import play.data.Form;
import play.mvc.*;

import static play.data.Form.form;

public class Entries extends Controller {

	final static Form<Entry> entryForm = form(Entry.class);

	public static Result list(String filter) {
		Seq<Entry> entries = models.Entries.findByName(filter);
		return ok(views.html.index.render(entries));
	}

	public static Result remove(long id) {
		models.Entries.delete(id);
		return redirect(routes.Entries.list(""));
	}

	public static Result add() {
		Form<Entry> form = entryForm.fill(new Entry());
		return ok(views.html.edit.render(form, "Add entry"));
	}

	public static Result edit(long id) {
		Entry entry = models.Entries.findById(id);
		if (entry != null) {
			Form<Entry> form = entryForm.fill(entry);
			return ok(views.html.edit.render(form, "Edit entry"));
		} else {
			return redirect(routes.Entries.list(""));
		}
	}

	public static Result save() {
		Form<Entry> form = entryForm.bindFromRequest(request());
		if (form.hasErrors()) {
			return badRequest(views.html.edit.render(form, "Correct entry"));
		} else {
			models.Entries.save(form.get());
			return redirect(routes.Entries.list(""));
		}
	}

}
