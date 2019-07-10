FROM openjdk:8-jdk-alpine
WORKDIR /
ADD /out/artifacts/mac_address_finder_master_jar/mac-address-finder-master.jar app.jar
EXPOSE 8080
CMD java -jar app.jar