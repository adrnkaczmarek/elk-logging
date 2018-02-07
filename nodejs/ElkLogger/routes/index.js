var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
    var loggerConfig = require('./../logger');
    loggerConfig.logger.info('Redirect to index');
    res.render('index', { title: 'Express' });
});

module.exports = router;
