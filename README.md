#Payara micro demo
##Uber jar
Download payara micro from https://www.payara.fish/software/downloads/
```
[baptiste@DESKTOP payara-micro-demo]$ pwd
/home/baptiste/IdeaProjects/payara-micro

[baptiste@DESKTOP payara-micro-demo]$ mvn clean package
[baptiste@DESKTOP payara-micro-demo]$ cp ~baptiste/Téléchargements/payara-micro-5.192.jar ./target

[baptiste@DESKTOP payara-micro-demo]$ java -jar target/payara-micro-5.192.jar --deploy target/payara-micro-demo-1.0-SNAPSHOT.war --outputUberJar target/payara-micro-demo.jar
août 25, 2019 11:38:48 AM fish.payara.micro.impl.UberJarCreator buildUberJar
INFOS: Building Uber Jar... payara-micro.jar
août 25, 2019 11:38:48 AM fish.payara.micro.impl.UberJarCreator buildUberJar
INFOS: Built Uber Jar /home/baptiste/IdeaProjects/payara-micro/target/payara-micro.jar in 181 (ms)

[baptiste@DESKTOP payara-micro-demo]$ ls -alhs target/
total 152M
4,0K drwxrwxr-x. 9 baptiste baptiste 4,0K 25 août  11:47 .
4,0K drwxrwxr-x. 5 baptiste baptiste 4,0K 25 août  11:49 ..
4,0K drwxrwxr-x. 3 baptiste baptiste 4,0K 25 août  11:45 classes
4,0K drwxrwxr-x. 3 baptiste baptiste 4,0K 25 août  11:45 generated-sources
4,0K drwxrwxr-x. 3 baptiste baptiste 4,0K 25 août  11:45 generated-test-sources
4,0K drwxrwxr-x. 2 baptiste baptiste 4,0K 25 août  11:45 maven-archiver
4,0K drwxrwxr-x. 3 baptiste baptiste 4,0K 25 août  11:45 maven-status
 76M -rw-rw-r--. 1 baptiste baptiste  76M 25 août  11:47 payara-micro-5.192.jar
4,0K drwxrwxr-x. 4 baptiste baptiste 4,0K 25 août  11:45 payara-micro-demo-1.0-SNAPSHOT
8,0K -rw-rw-r--. 1 baptiste baptiste 5,6K 25 août  11:45 payara-micro-demo-1.0-SNAPSHOT.war
 76M -rw-rw-r--. 1 baptiste baptiste  76M 25 août  11:47 payara-micro-demo.jar
4,0K drwxrwxr-x. 3 baptiste baptiste 4,0K 25 août  11:45 test-classes


[baptiste@DESKTOP payara-micro-demo]$ java -jar target/payara-micro-demo.jar 
ready in 8 770 (ms)

curl -X PUT -H "Content-Type: application/json" -d '{"genre":"horror","author":"Jordan","title":"Murder in the kitchen"}' http://DESKTOP-FUI7H3K:8080/payara-micro-demo-1.0-SNAPSHOT/webresources/book
```
## Docker
```
[baptiste@DESKTOP payara-micro-demo]$ docker build -t payara/micro/demo:1.0.0-snapshot -f src/main/docker/Dockerfile .

[baptiste@DESKTOP payara-micro-demo]$ docker run -p 8080:8080 -d -it payara/micro/demo:1.0.0-snapshot
[baptiste@DESKTOP payara-micro-demo]$ docker ps
CONTAINER ID        IMAGE                                    COMMAND                  CREATED              STATUS                          PORTS                                                  NAMES
962ef4f763bc        payara/micro/demo:1.0.0-snapshot         "java -XX:+UnlockE..."   About a minute ago   Up About a minute               4848/tcp, 8181/tcp, 9009/tcp, 0.0.0.0:8080->8080/tcp   eager_brattain

```