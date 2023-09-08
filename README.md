# Ktor Web Service

## Introduction

Welcome to the Ktor Web Service, a simple example of a web service built using the Ktor framework. This README provides an overview of the project, how to get started, usage, available endpoints, dependencies, and contribution guidelines.

## Getting Started

### Prerequisites

Before you begin, make sure you have the following requirements in place:

- Kotlin (1.9.0 or compatible)
- Ktor (2.3.2 or compatible)
- logback-classic (compatible version)
- Java Development Kit (JDK)
- Gradle (or an equivalent build tool)

### Usage

The application includes several endpoints for various purposes:

    /greet: Displays a welcome message.
    /route: Demonstrates routing using Ktor's route and handle functions.
    /users/{name}: Handles dynamic path parameters and custom headers.
    /details: Accepts query parameters and responds with a message.
    /employee: Demonstrates response handling and error management.
    /redirect-push and /redirect-pop: Showcase URL redirection.

### Endpoints

    /: Displays a welcome message.
    /new-greet: Presents an alternate greeting message.

### Dependencies

    Ktor: The core library for building the web service.
    logback-classic: Logging framework.
    ktor-serialization: Serialization support for Ktor.
    ktor-server-content-negotiation: Content negotiation.
    ktor-serialization-kotlinx-json: Kotlinx serialization support.
    ktor-html-builder: HTML building capabilities.
    kotlin-test-junit: Testing framework for Kotlin.
