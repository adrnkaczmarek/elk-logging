import logging
from flask import Flask, jsonify, abort, make_response, url_for


def init_logger():
    logger = logging.getLogger(__name__)
    logger.addHandler(logging.StreamHandler())
    logging.basicConfig(filename='example.log', level=logging.DEBUG)
    logger.setLevel(logging.INFO)
    open('example.log', 'w+')
    handler = logging.FileHandler('example.log')
    handler.setLevel(logging.INFO)
    formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    handler.setFormatter(formatter)
    logger.addHandler(handler)

    return logger


log = init_logger()
app = Flask(__name__)

tasks = [
    {
        'id': 1,
        'title': u'Buy groceries',
        'description': u'Milk, Cheese, Pizza, Fruit, Tylenol',
        'done': False
    },
    {
        'id': 2,
        'title': u'Learn Python',
        'description': u'Need to find a good Python tutorial on the web',
        'done': False
    }
]


@app.route('/')
def index():
    log.info("Hello world displayed")
    return "Hello, World!"


@app.route('/api/tasks', methods=['GET'])
def get_tasks():
    json = jsonify({'tasks': [make_public_task(task) for task in tasks]})
    log.info("Tasks available: " + str(json))
    return json


@app.route("/api/task/<int:task_id>", methods=['GET'])
def get_task(task_id):
    task = [task for task in tasks if task['id'] == task_id]

    if len(task) == 0:
        log.warning("Task with " + str(task_id) + " id not found")
        abort(404)

    json = jsonify({'task': task[0]})
    log.info("Task available: " + str(json))
    return json


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


def make_public_task(task):
    new_task = {}
    for field in task:
        if field == 'id':
            new_task['uri'] = url_for('get_task', task_id=task['id'], _external=True)
        else:
            new_task[field] = task[field]
    return new_task


if __name__ == '__main__':
    log.info("Flask started.")
    app.run(host='0.0.0.0', port=5080)
