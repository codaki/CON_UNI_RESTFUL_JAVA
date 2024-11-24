package ec.edu.monster.con_uni_restful_java_mov.models;

public class ConversionModel {
    public static class ConversionResponse {
        private double resultado;
        private String toUnit;
        private String fromUnit;
        private double valor;

        public ConversionResponse(double valorConvertido, String unidadDestino, String unidadInicial, double valorOriginal) {
            this.resultado = valorConvertido;
            this.toUnit = unidadDestino;
            this.valor = valorOriginal;
            this.fromUnit = unidadInicial;
        }

        public ConversionResponse() {
        }

        public double getResultado() {
            return resultado;
        }

        public void setResultado(double resultado) {
            this.resultado = resultado;
        }

        public String getToUnit() {
            return toUnit;
        }

        public void setToUnit(String toUnit) {
            this.toUnit = toUnit;
        }

        public String getFromUnit() {
            return fromUnit;
        }

        public void setFromUnit(String fromUnit) {
            this.fromUnit = fromUnit;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }
    public static class ConversionRequest {
        private double valor;
        private String fromUnit;
        private String toUnit;

        public ConversionRequest() {
        }


        public ConversionRequest(double valor, String fromUnit, String toUnit) {
            this.valor = valor;
            this.fromUnit = fromUnit;
            this.toUnit = toUnit;
        }


        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public String getFromUnit() {
            return fromUnit;
        }

        public void setFromUnit(String fromUnit) {
            this.fromUnit = fromUnit;
        }

        public String getToUnit() {
            return toUnit;
        }

        public void setToUnit(String toUnit) {
            this.toUnit = toUnit;
        }
    }
}
