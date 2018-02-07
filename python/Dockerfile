FROM python:3

WORKDIR /usr/src/app

ADD filebeat.tar.gz /usr/src/app

ADD filebeat.yml /usr/src/app

ADD logger.py /usr/src/app

RUN pip install flask

EXPOSE 5080

CMD [ "tar", "-zxvf", "/usr/src/app/filebeat.tar.gz" ]

CMD [ "python", "./logger.py" ]

