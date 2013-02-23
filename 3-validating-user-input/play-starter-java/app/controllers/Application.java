/*
 *     ______  ___  Play Framework Starter Guide   ___  Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______  /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \/      \
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/___/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */
package controllers;

import play.mvc.*;

public class Application extends Controller {
  
    public static Result index() {
        return redirect(routes.Entries.list(""));
    }
  
}
