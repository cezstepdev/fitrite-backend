package com.fitrite.api.security.registration.token;

import com.fitrite.api.security.user.User;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tokens")
public class ConfirmationToken {

    @Id
    private String id;
    @NonNull
    private String token;
    @NonNull
    private LocalDateTime createdAt;
    @NonNull
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;

    @DBRef
    @NonNull
    private User user;

    public ConfirmationToken(@NonNull String token, @NonNull LocalDateTime createdAt, @NonNull LocalDateTime expiresAt, @NonNull User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
