## Agenda:

> **_NOTE:_**  All demo sue Spring Boot 3.2.0 and Java 21
1. New Clients: JdbcClient && RestClient (**new-clients**)

* Run postgres db:
```shell
docker run --name demo_postgres \
-d --rm -p 5433:5432 \
-e POSTGRES_PASSWORD=postgres \
--health-cmd "pg_isready -U postgres" \
--health-interval=10s \
--health-timeout=10s \
--health-retries=5 \
postgres:14-alpine
```

* Create database:
```shell
docker exec -it demo_postgres \
psql -U postgres -d postgres -c "create database spring_boot_updates_db"
```

2. Supports project Loom: Virtual threads (**loom-support**)
3. Support CRaC: Coordinated Restore at Checkpoint (**crac-support**)
4. Improvements for Security with SSL (**ssl-improvements**)
5. Improvements for Observability (**observability-improvements**)