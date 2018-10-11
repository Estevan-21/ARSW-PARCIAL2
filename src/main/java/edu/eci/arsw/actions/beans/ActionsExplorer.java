/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.actions.beans;

import java.io.IOException;
import java.util.Set;

/**
 *
 * @author estudiante
 */
public interface ActionsExplorer {
    Set getActionDaily(String act) throws IOException;
}
