class ConversionModel:
    @staticmethod
    def parse_response(response_json):
        try:
            resultado = response_json.get('resultado')
            valor = response_json.get('valor')
            from_unit = response_json.get('fromUnit')
            to_unit = response_json.get('toUnit')

            return {
                "resultado": resultado,
                "valor": valor,
                "from_unit": from_unit,
                "to_unit": to_unit
            }
        except KeyError as e:
            raise Exception(f"Error al procesar la respuesta JSON: {str(e)}")
