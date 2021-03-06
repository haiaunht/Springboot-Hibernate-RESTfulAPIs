It is finally time to bridge the gap between our front-end and back-end applications. In this article, we'll walk through how to put React applications inside your Spring codebase.

## Getting Started

```no-highlight
et get java-spring-and-react
cd java-spring-and-react
idea .
```

## Learning Goals

- Justify the need for a monorepo
- Install and configure the `frontend-maven-plugin`
- Establish full-stack filesystem conventions
- Ensure React Components render in the context of the React application

## The Need for a Monorepo

Frontend, backend, or fullstack? This is very common question among developers and their toolchains. At Launch Academy, we believe it is important for your frontend and backend applications (and teams) to be well integrated. Organizationally, it allows us to better correlate changes as we add features, solidifies our automated testing configuration, and it helps with shared ownership of the code.

So, we are strongly in favor of the **monorepo**. This means that we believe that both your frontend and backend code should exist in the same filesystem. Let's take a brief moment to explore the reasons why before we dive into building out our first monorepo with Spring and ReactJS.

### Correlating Changes in Source Code Management

Later, we'll introduce you to using `git` for source code management (SCM). Basically, this tool, and others like it, will help us keep track of how our code changes over time. Most source code management tools centralize around a concept of a **repository**, where all of our code changes are stored.

Some organizations favor keeping our backend (in our case, Spring) repositories separated from our frontend applications (in our case, React). We think this is a bad idea, because as we add more features, it's harder to orchestrate releases and see how features change over time, because they'll be in separate repositories. Having all of the code in one repository allows developers to introduce features as a coherent whole: on the backend and subsequently on the frontend.

### Continuous Integration

Later, we'll also introduce you to Continuous Integration (CI). Continuous Integration is a systemic approach to feature development. As you build new features, CI build systems will run your tests repeatedly to ensure you haven't broken existing features or cause other issues with build integrity. Having your frontend and backend integrated into the same build system ensures that they will play together nicely.

### Collective Code Ownership

Lastly, and most importantly, there exists an Agile philosophy known as Collective Code Ownership. This is a cultural value among developers, in that every developer on the team should feel comfortable in all aspects of the system. This prevents territorial fiefdoms or walls among teams, and provides the organizations developers with flexibility when it comes to assigning project teams. If frontend applications and backend applications are separated, it's easy for a team to get either a) possessive or b) passive about one end of the platform's architecture. In such a team dynamic it's not uncommon to hear things like "Someone on the frontend team will have to fix that" when a bug occurs in production or "They don't understand our architectural approach" when a frontend team is taking on a large project. Practicing collective code ownership results in a more cohesive team, and more options for product managers when they're in a pinch for team resources.

### The Case for Separate Repositories

All that being said, there are practical reasons for separating. Maybe team proficiencies align in this way, and developers don't have the prerequisite knowledge to meaningfully contribute on both sides of the stack. Sometimes, security concerns *require* that the codebases be separate. Aside from such a rare security concern, most issues are cultural and can be addressed with good team and project management.

## Configuring the Frontend Maven Plugin

Now that we've established the business benefits, let's get to the brass tax of setting up our codebase. To do so, we'll first need to install and configure a Maven plugin called `frontend-maven-plugin`.

Let's add the following to the `<plugins>` section of our `pom.xml`.

```xml
<plugin>
  <groupId>com.github.eirslett</groupId>
  <artifactId>frontend-maven-plugin</artifactId>
  <version>${frontend-plugin.version}</version>
  <configuration>
    <nodeVersion>${node.version}</nodeVersion>
    <yarnVersion>${yarn.version}</yarnVersion>
    <workingDirectory>src/main/frontend</workingDirectory>
    <installDirectory>target</installDirectory>
  </configuration>
  <executions>
    <execution>
      <id>install node and yarn</id>
      <goals>
        <goal>install-node-and-yarn</goal>
      </goals>
    </execution>
    <execution>
      <id>install dependencies</id>
      <goals>
        <goal>yarn</goal>
      </goals>
    </execution>
    <execution>
      <id>webpack build</id>
      <goals>
        <goal>webpack</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

You'll notice a few version directives that we'll have to configure. Let's put these in our `<properties>` section.

```xml
<properties>
  <java.version>11</java.version>
  <maven.compiler.source>${java.version}</maven.compiler.source>
  <maven.compiler.target>${java.version}</maven.compiler.target>
  <frontend-plugin.version>1.7.6</frontend-plugin.version>
  <node.version>v14.4.0</node.version>
  <yarn.version>v1.22.4</yarn.version>
</properties>
```

**Now, be sure to refresh your Maven imports!**

### Filesystem Conventions

Like we place our `resources` in `src/main`, we will place our frontend code in `src/main/frontend`.

### Setting Up Our React Application

We'll need our `package.json` file, which we'll place in `src/main/frontend`. We will express this directory as our frontend root moving forward.

```json
{
  "name": "java-spring-and-react",
  "version": "1.0.0",
  "description": "",
  "main": "webpack.config.js",
  "scripts": {
    "dev:client": "node_modules/.bin/webpack-dev-server --host 0.0.0.0",
    "webpack": "node_modules/.bin/webpack --config ./webpack.config.js"
  },
  "author": "",
  "license": "ISC",
  "devDependencies": {
    "babel-core": "~6.23.1",
    "babel-preset-env": "~1.6.1",
    "babel-preset-react": "~6.22.0",
    "css-loader": "^2.1.1",
    "enzyme": "~3.10.0",
    "enzyme-adapter-react-16": "^1.14.0",
    "jest": "^24.9.0",
    "jquery": "3.0.0",
    "json-loader": "^0.5.4",
    "node-sass": "^4.14.0",
    "nodemon": "^1.19.0",
    "phantomjs-prebuilt": "~2.1.14",
    "sass-loader": "^6.0.2",
    "style-loader": "^0.13.2",
    "webpack": "~2.3.1",
    "webpack-dev-server": "~2.4.2",
    "write-file-webpack-plugin": "~4.2.0"
  },
  "dependencies": {
    "@babel/core": "^7.5.5",
    "@babel/preset-env": "^7.5.5",
    "@babel/preset-react": "^7.0.0",
    "babel-jest": "^24.9.0",
    "babel-loader": "^8.0.6",
    "body-parser": "^1.19.0",
    "babel-polyfill": "^6.26.0",
    "express": "^4.16.4",
    "express-handlebars": "^3.0.2",
    "lodash": "^4.17.15",
    "morgan": "^1.9.1",
    "pg": "^7.18.2",
    "react": "~16.8.0",
    "react-dom": "~16.8.0",
    "react-router-dom": "^5.0.0",
    "whatwg-fetch": "1.0.0"
  }
}
```

We'll also need a `.babelrc` file in our frontend root.

```json
{
  "presets": ["@babel/preset-env", "@babel/preset-react"]
}
```

Next, we'll need to build our `webpack.config.js` in the frontend root.

```javascript
let WriteFilePlugin = require('write-file-webpack-plugin');

var webpack = require('webpack');

module.exports = {
  entry: {
    path: './src/main.js'
  },
  output: {
    path: __dirname + '../../resources/static',
    filename: 'bundle.js'
  },
  module: {
    rules: [{
        test: /\.scss$/,
        use: [
          "style-loader",
          "css-loader",
          "sass-loader"
        ]
      },
      {
        test: /\.jsx?$/,
        exclude: /node_modules/,
        loader: 'babel-loader'
      }
    ]
  },
  plugins: [
    new WriteFilePlugin()
  ],
  devtool: 'eval-source-map',
  devServer: {
    contentBase: './public',
    inline: true
  }
}
```

Take a moment to study the top of this file. When `spring-boot:run` starts, the maven plugin will run webpack. Based on this configuration, spring boot and webpack will work together to install the bundled JavaScript file where all of our resulting Spring assets are located (the `target` directory). This will allow us to use the transpiled `bundle.js` in the context of our Spring templates and static resources.

## Testing It All Out

Let's put it all together now.

### Creating a Simple React Application

Let's create our `src/main.js` file in our frontend root.

```javascript
// src/main/frontend/src/main.js

import React from 'react';
import ReactDOM from 'react-dom';

const App = (props) => {
  return (<h2>Hello from React</h2>);
}

ReactDOM.render(
  <App />,
  document.getElementById('app')
);
```

*If some of this seems fuzzy to you, it may be a good time to go back and review some of the React material!*

### Creating a Static `index.html`

Our resulting `bundle.js` file can be used safely in our thymeleaf templates and otherwise. To ensure everything is working, let's just add a static `index.html` in `src/main/resources/static/index.html`.

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Spring and React Sitting in a Tree</title>
  </head>
  <body>
    <div id="app">
    </div>
    <script src="/bundle.js"></script>
  </body>
</html>
```

### Running Maven Frontend Commands

Based on the way we configured our `pom.xml`, our installation and transpiling will run when we execute the `spring-boot:run` maven task. We can optionally run the `frontend:install-node-and-yarn`, `frontend:yarn`, and `frontend:webpack` maven commands if we would like.

### Development Flow

If you want to develop a bit more rapidly, you can run a webpack dev server instance in your frontend root. So, with `spring-boot:run` running actively, you'll want to open a new terminal window and execute the following:

```no-highlight
cd src/main/frontend
yarn run dev:client
```

Like we practiced in the past, running the `dev:client` task will watch the frontend application filesystem for changes, and transpile with every modification.

### Viewing our Page

Conveniently, the default behavior of Spring apps is such that anything within the `src/main/resources/static` directory will load at its path, so we can now navigate to <http://localhost:8080/index.html> to view our page. We should see "Hello from React" loading on our page. The other nice default is that `src/main/resources/static/index.html` pages will automatically load at the root path (unless instructed otherwise): so we can also simply navigate to <http://localhost:8080> and see the same!

### Building Multi-Page Apps

Should we want a multi-page React app, we know that we need to allow our `index.html` static page to load up at any URLs that are not our API endpoints. We can do that by adding a `HomeController` that takes the place of our `clientRouter` from our Express pattern. In this controller, we can add any paths that we want to render our index page and therefore our React. It will look something like this:

```java
// src/main/java/com.launchacademy.java-spring-and-react/controllers/HomeController.java

package com.launchacademy.javaspringandreact.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping(value = {"/client", "/additional-path"})
  public String forward() {
    return "forward:/";
  }
}
```

This `@GetMapping` will forward requests from any of these paths to load what would load at our root. Note that `forward` is different than redirecting: it doesn't send an additional HTTP request and change our URL, it just _loads_ what would load at the root! Here, we say that if the user goes to "/client" or "/additional-path", we should load our index page, where React Router can take over. _**Note:**_ in our `value` attribute, we will want to fill in the actual paths that we expect our user to go to -- just like we did in our `clientRouter`.

## Why This Matters

Spring is awesome. React is awesome. Spring + React = Double Awesome. On a more serious note, we now have the "bridge" between our frontend and backend applications. In a subsequent lesson, we'll start issuing fetch requests from our React application against our Spring-based API's. You're on you way to becoming a fullstack developer.
