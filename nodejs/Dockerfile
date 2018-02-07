FROM node:carbon

WORKDIR /usr/src/app

ADD filebeat.tar.gz /usr/src/app

ADD filebeat.yml /usr/src/app

COPY ElkLogger/. .

RUN npm install

EXPOSE 3000

CMD [ "tar", "-zxvf", "/usr/src/app/filebeat.tar.gz" ]

CMD [ "npm", "start" ]
