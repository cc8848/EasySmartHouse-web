/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ginger.smarthome.ui.webui.client.history;

/**
 *
 * @author mirash
 */
public interface HistoryChangeListener {

    public void fireHistoryChange(String token);
    
}
