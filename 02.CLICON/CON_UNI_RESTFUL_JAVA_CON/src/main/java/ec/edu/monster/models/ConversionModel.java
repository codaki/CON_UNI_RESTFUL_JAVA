/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.models;

/**
 *
 * @author danie
 */
public class ConversionModel {
    public static class ConversionRequest {
        private double value;
        private String fromUnit;
        private String toUnit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
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

    public static class ConversionResponse {
        private double result;
        private String fromUnit;
        private String toUnit;

        public double getResult() {
            return result;
        }

        public void setResult(double result) {
            this.result = result;
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