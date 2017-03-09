Spring MVC（XML Based Configuration）
===

Spring BOM 2.0.8.RELEASEで動確した。  
ViewはThymeleaf。  
ログインできるだけのサンプル。  
Spring Securityで認証機能を、Spring SessionでセッションをRedis管理にしている。
ログイン時のパスワードは ```password``` 。ユーザ名はなんでもいい。

# 作成物とポイント

- pom.xml
- src/main/java/com/pepese/sample/controller/HelloController.java
  - 動作確認用のコントローラクラス
- src/main/java/com/pepese/sample/service/HelloService.java
  - DIなどの動作確認用のサービスクラス（このアプリではまだ使用していない）
- src/main/java/com/pepese/sample/service/security/\*.java
  - Spring Securityの認証ロジック
- src/main/resources/META-INF/spring/applicationContext.xml
  - Redisのホスト名・ポート変更などはここで
- src/main/resources/META-INF/spring/spring-mvc.xml
- src/main/resources/META-INF/spring/spring-security.xml
  - Spring Securityの設定
- src/main/resources/META-INF/spring/spring-session.xml
  - Spring Sessionの設定
- src/main/webapp/WEB-INF/web.xml

# ビルド方法

```
$ mvnw package -Dmaven.test.skip=true
```

# 参考

http://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html
