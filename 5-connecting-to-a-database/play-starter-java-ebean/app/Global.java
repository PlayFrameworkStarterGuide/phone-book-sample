/*
 *     ______  ___  Play Framework Starter Guide   ___  Phone Book Example   ___ __
 *    /   _  \/  /__   ______   ______   ______   /  /__   ______   ______  /  /  /
 *   /   ____/   _  \_/   _  \_/   _  \_/   ___\_/   _  \_/   _  \_/   _  \/      \
 *   \__/    \__/___/ \______/ \__/___/ \______/ \______/ \______/ \______/\__/___/
 * Published under MIT License. Copyright (c) 2013 Daniel Dietrich, Packt Publishing
 */

import models.*;
import play.*;

public class Global extends GlobalSettings {

  @Override
  public void onStart(Application app) {

  	Entries.save(newEntry("Guillaume Bort", "+33 5 55 55 55 55"));
  	Entries.save(newEntry("Sadek Drobi", "+33 5 55 55 55 55"));

  }

  private Entry newEntry(String name, String phone) {

  	Entry entry = new Entry();
  	entry.name = name;
  	entry.phone = phone;
  	return entry;

  }
    
}
