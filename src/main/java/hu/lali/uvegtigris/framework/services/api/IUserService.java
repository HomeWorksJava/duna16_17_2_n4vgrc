/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.lali.uvegtigris.framework.services.api;

import hu.lali.uvegtigris.framework.datamodel.Users;

public interface IUserService {
    public Users getById(String pName);
}