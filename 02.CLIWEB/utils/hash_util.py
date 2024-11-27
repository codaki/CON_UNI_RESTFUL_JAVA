import hashlib

class HashUtil:
    @staticmethod
    def hash_password(password):
        """
        Hashea la contraseña usando SHA-256 y la convierte a formato hexadecimal.
        """
        # Crear instancia del algoritmo de hash
        digest = hashlib.sha256()
        digest.update(password.encode('utf-8'))  # Convertir a bytes y hashear

        # Convertir los bytes del hash a formato hexadecimal
        return digest.hexdigest()
