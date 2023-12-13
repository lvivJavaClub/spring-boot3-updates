FROM ubuntu:22.04

ENV JAVA_HOME /opt/jdk
ENV PATH $JAVA_HOME/bin:$PATH
ENV JDK_TAR_GZ_PATH /opt/jdk/jdk.tar.gz

RUN apt-get update -y

# for x64
ADD "https://cdn.azul.com/zulu/bin/zulu17.46.27-ca-crac-jdk17.0.9-linux_x64.tar.gz" $JAVA_HOME/jdk.tar.gz
RUN tar --extract --file "$JDK_TAR_GZ_PATH" --directory "$JAVA_HOME" --strip-components 1; rm "$JDK_TAR_GZ_PATH" && \
    mkdir -p opt/crac-files

COPY target/crac.jar /opt/app/crac.jar
EXPOSE 8888