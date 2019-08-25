mvn clean package
cp ~baptiste/Téléchargements/payara-micro-5.192.jar ./target
java -jar target/payara-micro-5.192.jar --deploy target/payara-micro-demo-1.0-SNAPSHOT.war --outputUberJar target/payara-micro-demo.jar
java -jar target/payara-micro-demo.jar
curl -X PUT -H "Content-Type: application/json" -d '{"genre":"horror","author":"Jordan","title":"Murder in the kitchen"}' http://DESKTOP-FUI7H3K:8080/payara-micro-demo-1.0-SNAPSHOT/webresources/book