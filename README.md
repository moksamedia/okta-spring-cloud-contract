## Spring Cloud Contract

This example app demonstrates how to use Spring Cloud Contract to make testing microservices easy and more error free, as well as how to integrate Okta as an OIDC & OAuth 2.0 provider.

Please read [the blog post](http://need.a.link) to see how this app was created.

## Prerequisites

Before you get started, you'll need to make sure you have a few tools installed.

- **Okta CLI**: The Okta CLI is an easy way to create projects that use Okta for security. Follow the installation instructions on the [Okta CLI project website](https://cli.okta.com/manual/#installation). You should log in to your existing account or register for a new account using the CLI before continuing with the tutorial.

- **Java 11**: This project uses Java 11. OpenJDK 11 will work just as well.  Instructions are found on the [OpenJDK website](https://openjdk.java.net/install/). OpenJDK can also be installed using [Homebrew](https://brew.sh/). Alternatively, [SDKMAN](https://sdkman.io/) is another excellent option for installing and managing Java versions.

- **HTTPie**: This is a powerful command-line HTTP request utility you'll use to test both Spring Boot resource servers. Install it according to [the docs on their site](https://httpie.org/doc#installation).

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://<need.a.link> spring-boot-contract
cd spring-boot-contract
```

There are two separate Spring Boot projects in this repo.
- `producer`: a producer server that serves Hat objects
- `consumer`: a consumer server that takes requests for hats and retrieves them from the producer server

## Run the Producer App

In a Bash shell, navigate to the `producer` subdirectory (probably `cd producer` if you're still in the shell you cloned the repo).

Open `src/main/resources/application.properties` and add your Okta issuer URI for the `okta.oauth2.issuer` property.

```yml
okta.oauth2.issuer={yourIssuerUri}
```

Your Issuer URI will look like this: `https://dev-123456.okta.com/oauth2/default` (it's your Okta domain plus `oauth2/default`). You can find your Okta domain in the Bash shell by using the command `okta login`. Assuming you've already logged in, this command will show you your Okta domain.

Next you need to run `./mvnw install` to generate the contract test stubs and install them in your local `.m2` cache.

Now you can run the app using `./mvnw spring-boot:run`.

## Run the Consumer App

Open a new Bash shell. Navigate to the `consumer` subdirectory of the project.

Start the Spring Boot app using `./mvnw spring-boot:run`.

That's it!

## Test the App

The consumer app is secured using JWT auth, so to test it you need to use the [OIDC Debugger](oauth2/default) project to generate a valid JWT.

Once you have a valid JWT, store it in a Bash shell.
```bash
TOKEN=eyJraWQiOiJDVkdzamc2MDBCNVFXR3VSdVRDckJuLVhLa2J...
```
Then test the authenticated application using the token.

```bash
http :8080/hat/1 "Authorization: Bearer $TOKEN"
```


