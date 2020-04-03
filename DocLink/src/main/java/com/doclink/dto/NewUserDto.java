package com.doclink.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class NewUserDto {
        @NotNull(message ="email is required")
        private String email;

        @NotNull(message ="password is required")
        private String password;

        public NewUserDto(String password, String email) {
            this.password = password;
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

}
