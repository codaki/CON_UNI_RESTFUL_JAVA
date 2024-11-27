import requests

class LoginController:
    @staticmethod
    def login(username, password):
        url = "http://localhost:8080/WS_CONUNI_RESTFULJAVA/webresources/login"
        payload = {
            "username": username,
            "password": password
        }
        headers = {"Content-Type": "application/json"}

        try:
            response = requests.post(url, json=payload, headers=headers)
            response.raise_for_status()

            print(f"Respuesta del servicio: {response.text}")

            if response.status_code == 200:
                user_data = response.json()
                return user_data.get("username") is not None and user_data["username"] != "null"
            else:
                print(f"Error en la respuesta del servicio. Código: {response.status_code}")
                return False
        except requests.exceptions.RequestException as e:
            print(f"Error al realizar la solicitud de login: {e}")
            return False