import requests
from model.ConversionModel import ConversionModel

class ConversionController:
    def __init__(self):
        self.base_url = 'http://localhost:8080/WS_CONUNI_RESTFULJAVA/webresources/conversion'

    def convert(self, value, unit_from, unit_to):
        payload = {
            "valor": value,
            "fromUnit": unit_from,
            "toUnit": unit_to
        }

        response = requests.post(self.base_url, json=payload)

        if response.status_code == 200:
            return ConversionModel.parse_response(response.json())
        else:
            raise Exception(f"Error al convertir unidades. Código de estado: {response.status_code}")
