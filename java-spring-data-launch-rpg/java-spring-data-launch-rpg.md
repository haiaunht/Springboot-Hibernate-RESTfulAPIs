## It's dangerous to go alone...

This exercise builds on what you have created in the java-spring-joins-and-associations article.

Using what you've learned so far let's add `Spells` and `Schools` to our RPG. Create entities, repositories, and include these objects in the seeder.

A spell is a magical incantation that has an effect.
Name: Charm
Description: Good for making Friends
School: Enchantment

A school is the type of magic something is.
Name: Enchantment
Description: Giving objects special powers, and influencing people.

Your spell should have the following properties

- String name
- Integer level
- String description
- Foreign Key school_id

Your School should have

- String name
- String description

Create three spells and two schools within your existing `Seeder`. Ensure that you can create the School, and associate the Spell within the same `Seeder` routine.
