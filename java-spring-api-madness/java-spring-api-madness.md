## We're going to party like it's 1989!

Entrepreneur Bradon Miltly misses the good ol' days of Blue Light Specials, Acid Wash Jeans (on sale at Filene's Basement of course), and GI Joe action figures from Toys 'R Us. He harkens back to his youth preparing for mall trips by playing the hit board game Mall Madness. He has a bright idea! Recreate that classic game as an app!

Help Bradon get started by completing the following:

## Meets Expectations

### Getting Started

```no-highlight
et get java-spring-api-madness
cd java-spring-api-madness
createdb mall_madness
./mvnw spring-boot:run (or start from the Maven menu)
idea .
```

### [Let's go to the Mall](https://www.youtube.com/watch?v=9mJAsgIIfNM)

```no-highlight
As a shopper
I want to view a list of stores
So that I can plan my trip to the mall
```

Acceptance Criteria:

- Using the provided schema, build a `Store` record. You will need:
  - Model
  - Rest Controller
  - Repository
  - Seeder
- When a user visits `/api/v1/stores` they should see a JSON of all of the store objects

(Just create one record in the seeder - you can use attributes of your choosing)

### Stores Come and Go, but the Mall is Forever

```no-highlight
As a user
I want to create new Stores
So that I can customize my game
```

Acceptance Criteria:

- Using the provided form create an HTTP controller to handle the post.
- Add validations to ensure that all required fields are present, and that the `average_cost` is an integer between 1-5
- Submitting your Store successfully should result in being redirected to `/stores`
  - You will have to create an HTTP endpoint to connect to the provided `index.html`

### Blue Light Special at the Fashion Boutique

```no-highlight
As a user
I want to visit a specific store
So that I can take advantage of the sale
```

Acceptance Criteria:

- Visiting `/api/v1/store/{id}` should take me to a json with information for the store with the given id

## Exceeds Expectations

### Paginate the Stores

```no-highlight
As a user
I want to view a paginated list of stores
So that I can don't get overwhelmed with information
```

Acceptance Criteria:

- Update your `/api/vi/stores` endpoint to include pagination.
- Set the default to the first page and no more than 5 stores

### Hide Data

```no-highlight
As a store owner
I want control over what is presented to users
So that they don't have sensitive information about my business
```

***For this story you can choose to implement with or without Mapstruct.***
If you choose to use Mapstruct, add the following to your `pom.xml`

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.5.1</version>
  <configuration>
    <source>${java.version}</source>
    <target>${java.version}</target>
    <annotationProcessorPaths>
      <path>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>${org.mapstruct.version}</version>
      </path>
      <path>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${org.projectlombok.version}</version>
      </path>
    </annotationProcessorPaths>
  </configuration>
</plugin>
```

Acceptance Criteria:

- Using a DTO ensure that the `id` does not appear in the JSON response for a list of stores or single store
- Translate `average_cost` to be a string based on the value
  - 1: Bargain
  - 2: Good Deals
  - 3: Good Value
  - 4: Pricey but Worth it
  - 5: Upscale
