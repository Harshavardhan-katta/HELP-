Helpdesk Spring Boot project (final)
Run:
1. Ensure JDK 17+ and Maven installed.
2. mvn spring-boot:run
3. Open http://localhost:8080/

Agent login page: http://localhost:8080/AgentLogin.html
After login you'll be redirected to Helpdesk.html (agent-only page).

Default agent credentials:
 - username: agent1
 - password: password

Public APIs used by your frontend (no auth required):
 - POST /api/lost  (script.js posts here)
 - POST /api/found
 - POST /api/contact

Agent APIs (require login):
 - GET /agent/api/lost
 - DELETE /agent/api/lost/{id}
 - GET /agent/api/found
 - DELETE /agent/api/found/{id}
 - GET /agent/api/contacts
 - DELETE /agent/api/contacts/{id}

H2 console: http://localhost:8080/h2-console (JDBC: jdbc:h2:mem:helpdeskdb)
