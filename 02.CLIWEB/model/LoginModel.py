class LoginModel:
    @staticmethod
    def parse_response(response_json):

        try:
            username = response_json.get('username')
            password = response_json.get('password')

            if username and password:
                return {
                    "username": username,
                    "password": password
                }
            else:
                raise Exception("Error: Respuesta incompleta del servicio")
        except KeyError as e:
            raise Exception(f"Error al procesar la respuesta JSON: {str(e)}")
