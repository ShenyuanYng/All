from flask import Flask
from flask import request
from flask import render_template
app = Flask(__name__)

@app.route("/", methods=['GET', 'POST'])
def main():
    if request.method == 'GET':
        return render_template('index.html')
    if request.method == 'POST':
        user = request.form.get('user')
        password = request.form.get('password')
        res = "User: %s\nPassword: %s" % (user, password)
        return res
    
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80, debug=True)
