Spring Bootで実行可能jarの作成
===

Spring Boot 1.4.2.RELEASEで動確した。

# 作成物とポイント

- pom.xml
  - Maven設定ファイル／POM
  - POMのdependencyに ```spring-boot-starter-*``` が含まれること
  - POMのbuild -> pluginsに ```spring-boot-maven-plugin``` が含まれること
    - ```mvn package``` 実行時に適切に実行可能jarを作成してくれる
- src/main/java/com/pepese/sample/Application.java
  - Spring Bootアプリケーション起動クラス
  - ```@SpringBootApplication``` アノテーションを付与すること
    - ```@Configuration``` 、 ```@EnableAutoConfiguration``` 、 ```@ComponentScan``` をまとめたもの
- src/main/java/com/pepese/sample/config/AppConfig.java
  - Spring設定クラス
    - DIやAOPなどの設定に使用する
  - ```@Configuration``` アノテーションを付与すること
- src/main/java/com/pepese/sample/config/WebMvcConfig.java
  - Spring MVC設定クラス
    - コンテンツネゴシエーションなどSpring MVCの```DispatcherServlet```に関する設定に使用する
  - ```WebMvcConfigurerAdapter``` が継承されていること
  - ```@Configuration``` アノテーションを付与すること
  - Spring Bootの場合、 ```@EnableWebMvc``` を付与する必要はない
    - Spring Bootを利用しないSpring MVCアプリケーションを作成する場合には付与する
- src/main/java/com/pepese/sample/controller/HelloController.java
  - 動作確認用のコントローラクラス
- src/main/java/com/pepese/sample/service/HelloService.java
  - DIなどの動作確認用のサービスクラス

# 実行

Docker 単体で実行。

```bash
$ mvn clean package -Dmaven.test.skip=true
$ docker build .
$ docker images
REPOSITORY                                 TAG                 IMAGE ID            CREATED             SIZE
<none>                                     <none>              a1800de8996f        11 hours ago        987MB
$ docker run -d -p 8000:8000 --name springboot a1800de8996f
$ curl localhost:8000
Hello, PePeSe !
```

k8s で実行。  
ローカルイメージ拾えないから動かないので、プライベード Docker レジストリ `localhost:5000/pepese/springboot:1.0.0` にあるテイで書く。

```bash
$ kubectl run springboot --image=localhost:5000/pepese/springboot:1.0.0
$ kubectl expose deployment springboot --port 8000 --type LoadBalancer
$ curl localhost:8000
Hello, PePeSe !
```

# 参考

http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html