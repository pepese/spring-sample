Spring BootでAPサーバにデプロイ可能なwarの作成
===

Spring Boot 1.4.2.RELEASEで動確した。

# 作成物とポイント

- pom.xml
  - Maven設定ファイル／POM
  - POMのdependencyに ```spring-boot-starter-*``` が含まれること
  - POMのbuild -> pluginsに ```spring-boot-maven-plugin``` が含まれること
	  - ```mvn package``` 実行時に適切にデプロイ可能warを作成してくれる
  - POMのpackagingをwarにすること
  - POMのspring-boot-starter-tomcatの組み込み系APサーバのscopeをprovidedにすること
	  - tomcatに限らずjetty等組み込み系APサーバは全て
- src/main/java/com/pepese/sample/Application.java
  - Spring Bootアプリケーション起動クラス
  - ```@SpringBootApplication``` アノテーションを付与すること
    - ```@Configuration``` 、 ```@EnableAutoConfiguration``` 、 ```@ComponentScan``` をまとめたもの
- src/main/java/com/pepese/sample/ServletInitializer.java
  - web.xmlのSpring Boot版
  - ```SpringBootServletInitializer```が継承されていること
    - web.xmlのSpring MVC版である ```WebApplicationInitializer``` を継承している
  - ```configure``` メソッドをオーバーライドし、Spring Bootアプリケーション起動クラスをロードすること
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

# 補足

```SpringBootServletInitializer``` はSpring Bootの起動クラスに継承してもよい。下記の通り。

```java
package com.pepese.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
```

# 参考

http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html