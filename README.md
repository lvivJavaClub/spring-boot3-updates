## Agenda:

> **_NOTE:_**  All demo sue Spring Boot 3.2.0 and Java 21 and 17(CRaC)
* New Clients: JdbcClient && RestClient (**new-clients**)

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
* Supports project Loom: Virtual threads for Spring Boot v3.2.0 (**loom-support**)

* Support CRaC: Coordinated Restore at Checkpoint (**crac-support**)
  * Build an app
  ```shell
  mvn clean package -DskipTests && \
  docker build -t crac-demo .
  ```
  * run with privilege
  ```shell
    docker run -it --rm --privileged -p 8889:8888 --name crac-demo crac-demo
   ```
  
  * run java in container
  ```shell
    java -XX:CRaCCheckpointTo=/opt/crac-files -jar /opt/app/crac.jar
    ```
  * open new terminal, and execute docker image with crac ( check start time, ~ 2.2 sec)
    ```shell
     docker exec -it crac-demo bash
    ```
  * run java command for call checkpoint using PID of app
   ```shell
       # ( 9 in this example is PID)
       jcmd 9 JDK.checkpoint 
   ```
  * for start killed checkpoint need to run next command ( check start time, ~ 280ms sec)
  ```shell
       java -XX:CRaCRestoreFrom=/opt/crac-files/
   ```
* Improvements for Security with SSL (**ssl-improvements**)
  * Release in v3.1.1 **spring bundle**
  * Create self-signed certs for demo
  ```shell
      openssl req -x509 -subj "/CN=javaclub-demo" -keyout javaclub.key -out javaclub.crt -sha256 -days 365 -nodes -newkey ed25519
  ```

Resources:
1. https://github.com/spring-projects/spring-boot/wiki/Supported-Versions
2. https://spring.io/blog/2023/11/23/spring-boot-3-2-0-available-now
3. https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.2-Release-Notes
4. https://docs.spring.io/spring-framework/reference/integration/rest-clients.html
5. https://spring.io/blog/2022/10/11/embracing-virtual-threads
6. https://docs.spring.io/spring-framework/reference/integration/checkpoint-restore.html
7. https://github.com/CRaC/docs
8. https://wiki.openjdk.org/display/crac