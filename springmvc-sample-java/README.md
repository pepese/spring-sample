Spring MVC（Java Based Configuration）
===

Spring BOM 2.0.8.RELEASEで動確した。

# 作成物とポイント

- pom.xml
- src/main/java/com/pepese/sample/config/AppConfig.java
  - Spring設定クラス
    - DIやAOPなどの設定に使用する
  - ```@Configuration``` アノテーションを付与すること
  - 必要に応じて```@ComponentScan```を指定してコンポーネントスキャン領域を指定すること
- src/main/java/com/pepese/sample/config/WebMvcConfig.java
  - Spring MVC設定クラス
    - コンテンツネゴシエーションなどSpring MVCの```DispatcherServlet```に関する設定に使用する
  - ```WebMvcConfigurerAdapter``` が継承されていること
  - ```@Configuration``` アノテーションを付与すること
  - ```@EnableWebMvc``` アノテーションを付与すること
- src/main/java/com/pepese/sample/config/WebInitializer.java
  - web.xmlのJava Based Configuration
  - ```AbstractAnnotationConfigDispatcherServletInitializer```を継承すること
    - ```WebApplicationInitializer```の実装クラス
- src/main/java/com/pepese/sample/controller/HelloController.java
  - 動作確認用のコントローラクラス
- src/main/java/com/pepese/sample/service/HelloService.java
  - DIなどの動作確認用のサービスクラス

# 参考

http://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html
