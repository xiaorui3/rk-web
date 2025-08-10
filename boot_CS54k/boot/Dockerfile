FROM swr.cn-north-4.myhuaweicloud.com/ddn-k8s/docker.io/openjdk:17

CMD mkdir /mydir
CMD cd /mydir

ADD ./target/boot.jar /mydir/

CMD java -jar /mydir/boot.jar

EXPOSE 7658