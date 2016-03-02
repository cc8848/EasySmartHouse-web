/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.easysmarthouse.scripting.device;

import net.easysmarthouse.scripting.ScriptSource;

/**
 *
 * @author rusakovich
 */
public interface ScriptableDevice {

    public void bind(ScriptSource scriptSource);
    
    public void unbind();

}
