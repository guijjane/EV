package com.example.projetffspring.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserRequest {
    private String username;
    private String password;
    private Long idRole;
}
