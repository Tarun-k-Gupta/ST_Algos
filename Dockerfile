FROM openjdk:11
COPY ./target/calculatorSPE-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD [“java”,”-cp”,” calculatorSPE-1.0-SNAPSHOT-jar-with-dependencies.jar”,”com.example.Main”]
