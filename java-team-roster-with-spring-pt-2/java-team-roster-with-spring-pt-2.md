The Olympic Committee has hired you to migrate their system to Spring. Lucky you!

## Getting Started

Pick up where you left off with part 1!

## Learning Objectives

- Implement Spring Data
- Create a Seeder for Player Data
- Create a form for New Players

## Core User Stories

1. Create a database called `spring_rosters`
1. Following the `Spring Data` article, update your POM and Application Properties (make sure to import the POM changes)
1. Using the Team bean as your guide, create a migration for the `teams` table
1. Using the Player bean as your guide, create a migration for the `players` table
1. Implement repositories for both `Player` and `Team`
  1. Make sure to put them in their own package called `repositories`
1. Using the data from the `League` entity create seeder files for both `Player` and `Team`
  1. Make sure to put them in their own package called `seeders`
  1. Since we aren't working with associations yet think about how you can seed the data so that a `League` uses Teams from the `teams` table and players from the `players` table.
  1. ***Hint: Custom Queries could be very helpful here...***

## Non-Core User Stories

These will require that you complete the non-core stories from pt-2

1. Using the Position bean as your guide, create a migration for the `positions` table
1. Implement a `PositionRepository`
1. Create a seeder for `position`
1. Update your seeder file
1. Create a form for new players
  1. This will also require you to update your controller to allow for posted data
  1. Persist the new players in the database
1. Implement a `Leagues` table which can store a `league_name` and also has a column for `team_id`.
  1. Research how to implement associations in Spring Data and tie together the League, Team, and Players using associations.
