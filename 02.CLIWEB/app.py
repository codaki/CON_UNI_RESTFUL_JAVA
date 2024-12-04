from flask import Flask, render_template, request, redirect, url_for, flash
from utils.hash_util import HashUtil
from controller.LoginController import LoginController
from controller.ConversionController import ConversionController

app = Flask(__name__)
app.secret_key = 'supersecretkey'

# Controladores
login_controller = LoginController()
conversion_controller = ConversionController()

@app.route('/')
def login_page():
    return render_template('Login.html')

@app.route('/login', methods=['POST'])
def login_user():
    try:
        username = request.form['username']
        password = request.form['password']

        hashed_password = HashUtil.hash_password(password)

        is_authenticated = login_controller.login(username, hashed_password)

        if is_authenticated:
            flash(f'¡Bienvenido, {username}!')
            return redirect(url_for('conversion_page'))  
        else:
            flash('Credenciales incorrectas. Intenta nuevamente.')
            return redirect(url_for('login_page'))  
    except Exception as e:
        flash(f'Error: {str(e)}')
        return redirect(url_for('login_page'))


@app.route('/conversion')
def conversion_page():
    return render_template('Conversion.html')

@app.route('/convert', methods=['POST'])
def convert_units():
    try:
        value = float(request.form['value'])
        unit_from = request.form['unit_from']
        unit_to = request.form['unit_to']

        result = conversion_controller.convert(value, unit_from, unit_to)

        flash(f'Valor Convertido: {result["resultado"]} {result["to_unit"]}')
    except Exception as e:
        flash(f'Error: {str(e)}')

    return redirect(url_for('conversion_page'))


if __name__ == '__main__':
    app.run(debug=True)
