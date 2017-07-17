<h1>Spring async task example</h1>

<h3>pom.xml</h3>

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>4.3.9.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>4.3.9.RELEASE</version>
</dependency>
```

<h3>Location.java</h3>

```java
@Component
public class Location {

    public String getLocation(){
        return "Trantor";
    }
}
```

<h3>Asyncron component</h3>

```java
@Component
public class AsyncBean {

    @Autowired
    private Location location;

    @Async
    public void runAsyncTask(String name, long sleepTime){
        System.out.println("Start running:"+name+" on location:"+location.getLocation());
        try {
            Thread.sleep(sleepTime);
            System.out.println("End running:"+name+" on location:"+location.getLocation());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

<h3>Application confirguration file</h3>

```java
@Configuration
@EnableAsync
@ComponentScan(basePackages = "com.pethoalpar.beans")
public class AppConfig {

    //Only if you want to use task executor
    @Bean
    public TaskExecutor taskExecutor(){
        //the maxumum number of threads.
        return new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3));
    }
}
```

<h3>Main.java</h3>

```java
public class Main {

    public static void main(String [] args){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AsyncBean b1 = context.getBean(AsyncBean.class);
        AsyncBean b2 = context.getBean(AsyncBean.class);
        AsyncBean b3 = context.getBean(AsyncBean.class);
        AsyncBean b4 = context.getBean(AsyncBean.class);
        AsyncBean b5 = context.getBean(AsyncBean.class);

        b1.runAsyncTask("1",7000);
        b2.runAsyncTask("2",1000);
        b3.runAsyncTask("3",3000);
        b4.runAsyncTask("4",4000);
        b5.runAsyncTask("5",6000);
    }
}
```
