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
