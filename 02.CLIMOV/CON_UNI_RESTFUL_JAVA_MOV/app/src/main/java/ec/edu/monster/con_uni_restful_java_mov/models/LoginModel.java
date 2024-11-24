package ec.edu.monster.con_uni_restful_java_mov.models;

public class LoginModel {
    public static class ConversionRequestL {

        private String username;
        private String password;

        public ConversionRequestL() {
        }

        public ConversionRequestL(String username, String password) {
            this.username = username;
            this.password = password;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

    public static class ConversionResponseL{
        private String username;
        private String password;

        public ConversionResponseL() {
        }

        public ConversionResponseL(String username, String password){
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
