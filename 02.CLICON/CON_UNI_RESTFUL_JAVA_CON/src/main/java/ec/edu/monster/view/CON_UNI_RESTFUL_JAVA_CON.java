/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.monster.view;

import ec.edu.monster.controllers.ConversionController;
import ec.edu.monster.controllers.LoginController;
import java.util.Scanner;
import java.security.*;

/**
 *
 * @author danie
 */
public class CON_UNI_RESTFUL_JAVA_CON {

  
    private static final Scanner scanner = new Scanner(System.in);
    private static final LoginController loginController = new LoginController();
    private static final ConversionController conversionController = new ConversionController();
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        System.out.println("=== Sistema de Conversión de Unidades ===");
        
        while (true) {
            if (!isLoggedIn) {
                if (mostrarMenuLogin()) {
                    mostrarMenuPrincipal();
                }
            } else {
                mostrarMenuPrincipal();
            }
        }
    }
/**
 * Hashes the input string using SHA-256.
 *
 * @param input the string to hash
 * @return the hashed string in hexadecimal format
 * @throws NoSuchAlgorithmException if the SHA-256 algorithm is not available
 */
private static String hashPassword(String input) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hashBytes = digest.digest(input.getBytes());
    StringBuilder hexString = new StringBuilder();

    for (byte b : hashBytes) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) {
            hexString.append('0');
        }
        hexString.append(hex);
    }

    return hexString.toString();
}


    private static boolean mostrarMenuLogin() {
        System.out.println("\n=== Login ===");
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        try {
              String hashedPassword = hashPassword(password);
            isLoggedIn = loginController.autenticar(username, hashedPassword);
            if (isLoggedIn) {
                System.out.println("¡Login exitoso!");
                return true;
            } else {
                System.out.println("Credenciales incorrectas. Por favor, intente nuevamente.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error durante el login: " + e.getMessage());
            return false;
        }
    }

    private static void mostrarMenuPrincipal() {
        while (isLoggedIn) {
            try {
                System.out.println("\n=== Menú Principal ===");
                System.out.println("1. Realizar conversión de presión");
                System.out.println("2. Cerrar sesión");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1":
                        realizarConversion();
                        break;
                    case "2":
                        isLoggedIn = false;
                        System.out.println("Sesión cerrada exitosamente.");
                        return;
                    case "3":
                        System.out.println("¡Gracias por usar el sistema!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void realizarConversion() {
    try {
        System.out.println("\n=== Conversión de Presión ===");
        System.out.println("Seleccione las unidades disponibles:");
        System.out.println("1. Pascal (pa)");
        System.out.println("2. Bar (bar)");
        System.out.println("3. Psi (psi)");
        System.out.println("4. Atmósfera (atm)");
        System.out.println("5. Milimetros de mercurio (mmhg)");

        // Ingresar el valor a convertir
        System.out.print("Ingrese el valor a convertir: ");
        double valor = Double.parseDouble(scanner.nextLine());

        // Seleccionar la unidad de origen
        System.out.print("Seleccione la unidad de origen (1-5): ");
        int opcionOrigen = Integer.parseInt(scanner.nextLine());
        String unidadOrigen = obtenerUnidad(opcionOrigen);
        if (unidadOrigen == null) {
            System.out.println("Opción no válida para la unidad de origen.");
            return;
        }

        // Seleccionar la unidad de destino
        System.out.print("Seleccione la unidad de destino (1-5): ");
        int opcionDestino = Integer.parseInt(scanner.nextLine());
        String unidadDestino = obtenerUnidad(opcionDestino);
        if (unidadDestino == null) {
            System.out.println("Opción no válida para la unidad de destino.");
            return;
        }

        // Validar y realizar la conversión
        if (!conversionController.isValidPressureUnit(unidadOrigen) || 
            !conversionController.isValidPressureUnit(unidadDestino)) {
            System.out.println("Error: Unidades no válidas");
            return;
        }

        double resultado = conversionController.convertPressureValue(valor, unidadOrigen, unidadDestino);
        System.out.printf("Resultado: %.4f %s = %.4f %s%n", 
            valor, unidadOrigen, resultado, unidadDestino);

    } catch (NumberFormatException e) {
        System.out.println("Error: Por favor ingrese un valor numérico válido.");
    } catch (Exception e) {
        System.out.println("Error durante la conversión: " + e.getMessage());
    }
}

/**
 * Obtiene la unidad correspondiente a la opción seleccionada.
 * @param opcion número de la opción seleccionada
 * @return el nombre de la unidad o null si la opción no es válida
 */
private static String obtenerUnidad(int opcion) {
    switch (opcion) {
        case 1: return "pa";
        case 2: return "bar";
        case 3: return "psi";
        case 4: return "atm";
        case 5: return "mmhg";
        default: return null;
    }
}

}

