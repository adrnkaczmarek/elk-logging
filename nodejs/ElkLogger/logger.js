var winston = require('winston');

var logger = new (winston.Logger)({
    transports: [
        new (winston.transports.Console)({ json: false, timestamp: true }),
        new winston.transports.File({ filename: __dirname + '/example.log', json: false })
    ],
    exitOnError: false
});

module.exports.logger = logger;
logger.info('Node.js logging works!!');