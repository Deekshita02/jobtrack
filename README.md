# JobTrack

A full-stack job application tracker built to manage and monitor job applications across different stages of the recruitment process — application, interview, offer, or rejection.

## Features

- **User authentication** — secure registration and login using JWT (JSON Web Tokens), with passwords hashed via BCrypt
- **Full CRUD** for job applications — create, view, update, and delete entries
- **Status tracking and filtering** — filter applications by stage (Applied, Interviewing, Offer, Rejected)
- **Protected API** — all application data endpoints require a valid authentication token; unauthenticated requests are rejected

## Tech Stack

**Backend:** Java · Spring Boot · Spring Security · Spring Data JPA · PostgreSQL · JWT (jjwt)
**Frontend:** [React.js — see jobtrack-frontend](https://github.com/Deekshita02/jobtrack-frontend)
**Database:** PostgreSQL (hosted on Neon)

## Architecture

- `SecurityConfig` — configures CORS, disables session-based auth in favor of stateless JWT, and defines which routes require authentication
- `JwtAuthFilter` — intercepts incoming requests, validates the JWT from the `Authorization` header, and sets the authenticated user in Spring's security context
- `AuthController` — handles `/api/auth/register` and `/api/auth/login`
- `JobApplicationController` — handles CRUD operations on job applications, protected behind authentication

## Running Locally
1. Clone the repo
2. Copy `src/main/resources/application.properties.example` to `application.properties` and fill in your own PostgreSQL connection details
3. Run the application:
4. The API will be available at `http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|--------------|----------------|
| POST | `/api/auth/register` | Register a new user | No |
| POST | `/api/auth/login` | Log in and receive a JWT | No |
| GET | `/api/applications` | List all applications | Yes |
| GET | `/api/applications/{id}` | Get a specific application | Yes |
| GET | `/api/applications/status/{status}` | Filter by status | Yes |
| POST | `/api/applications` | Create a new application | Yes |
| PUT | `/api/applications/{id}` | Update an application | Yes |
| DELETE | `/api/applications/{id}` | Delete an application | Yes |

## Status

Backend and frontend are both complete and fully integrated — authentication, protected routes and full CRUD are working end to end locally. Live deployment in progress.
