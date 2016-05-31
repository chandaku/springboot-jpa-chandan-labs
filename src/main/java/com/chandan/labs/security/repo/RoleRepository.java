package com.chandan.labs.security.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.labs.security.user.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
