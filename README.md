# JVM Memory Metrics Demo
This is a simple demo that uses __[Spring-boot's actuators](https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector)__ to expose the JVM memory metrics.

__NOTE:__ This demo supports the explanation provided in the article published at __TBD__.


The application just resizes an image every 60 seconds just to increase memory usage, then the __spring-boot actuators__ can be accessed via:

* __jvm.memory.used__: [http://localhost:8080/actuator/metrics/jvm.memory.used](http://localhost:8080/actuator/metrics/jvm.memory.used) 
* __jvm.memory.committed__: [http://localhost:8080/actuator/metrics/jvm.memory.committed](http://localhost:8080/actuator/metrics/jvm.memory.committed)
* __jvm.memory.max__: [http://localhost:8080/actuator/metrics/jvm.memory.max](http://localhost:8080/actuator/metrics/jvm.memory.max)

Currently the application has set the following memory limits inside `pom.xml`:

```
     <jvmArguments>
        -Xmx128m
        -XX:MaxMetaspaceSize=64m
     </jvmArguments>
```

## Run it

Just run: `mvnw spring-boot:run` or `./mvnw spring-boot:run` depending on your platform.

