package com.project.payload.request.business.user;

import com.project.payload.request.abstracts.AbstractUserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor

public class UserRrquestWithoutPassword extends AbstractUserRequest {
}
