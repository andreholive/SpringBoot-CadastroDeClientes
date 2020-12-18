package com.betha.system.security;

import org.springframework.security.core.Authentication;

public interface IAuthentication {
    Authentication getAuthentication();
    String getUserName();
}