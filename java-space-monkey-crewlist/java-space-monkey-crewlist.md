# Java Space Monkey Crew List

## Getting Started

```no-highlight
et get java-space-monkey-crewlist
cd java-space-monkey-crewlist
createdb monkey_crewlist
idea .
```

Take a moment to familiarize yourself with the project's controller, model, schema, repository and views.

## Smells like cats...

The Great Space Captain has new task for you! Now that you have proven yourself as a Space Monkey Engineer, the Great Captain wants you to join the command team! The first task he wants you to accomplish as a newly promoted Ensign is to go over new crew signups for the new tour of duty! There has been talk about undercover cats from The Feline Alliance trying to sneak aboard!

## Signup Form for Proper Dignified Anthropoids

We need a way to have crewmembers signup!

- First, create a form to record a prospective monkey's `name`, `hobby`, `rank`, and `toursAboard`.
- Next, you will need to add the proper methods in the controller so that you can both see the new form and use the form to submit a monkey's information.

## Validating our Anthropoids

The signup form so far isn't good enough - we need to make sure the prospective crew members fill in the form all the way! We need to be able to get more good crew members like CatMcCatFace and DefinitelyNotACat to fill in the forms correctly.

- Add validations to our CrewMember model to make sure their name, hobby and rank is filled in.
- The Great Captain only wants members with 1 or more tours under their belt! Add a validation to prevent those with fewer tours from signing up.
- Update the controller so that it can handle our JPA validations!
- Update our form so that if a monkey fills out the form incorrectly that they are shown their errors!
