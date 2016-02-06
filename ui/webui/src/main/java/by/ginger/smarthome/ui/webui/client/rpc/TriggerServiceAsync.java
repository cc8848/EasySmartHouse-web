/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ginger.smarthome.ui.webui.client.rpc;

import by.ginger.smarthome.provider.device.trigger.Trigger;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

/**
 *
 * @author mirash
 */
public interface TriggerServiceAsync {

    public void getTriggers(AsyncCallback<List<Trigger>> asyncCallback);

    public void setEnabled(String name, boolean enabled, AsyncCallback<Void> callback);
}
