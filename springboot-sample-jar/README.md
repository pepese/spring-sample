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

# 参考

http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html