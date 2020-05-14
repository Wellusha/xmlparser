Шаги для запуска:
1. Запустить PostgreSQL в докере коммандой docker-compose up. Альтернативно можно изменить параметры datasource для любой другой БД.
2. Выполнить mvn clean package.
3. Запустить программу коммандой java -jar {имя_JAR_из_targer} {имя_файла_xml}. Например, java -jar target/xmlparser-0.0.1-SNAPSHOT.jar test.xml
4. Обращаться по http://localhost:1337 c телом запроса из Test.txt (условие задачи)