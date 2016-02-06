/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ginger.smarthome.sheduler.task;

import by.ginger.smarthome.network.exception.NetworkException;
import by.ginger.smarthome.network.predicate.NetworkSearchSimplePredicate;
import by.ginger.smarthome.provider.device.Device;
import by.ginger.smarthome.provider.device.actuator.Actuator;
import by.ginger.smarthome.provider.device.exception.DeviceException;
import by.ginger.smarthome.provider.device.trigger.ActuatorTrigger;
import by.ginger.smarthome.provider.device.trigger.Trigger;
import by.ginger.smarthome.provider.device.trigger.TriggerCondition;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author rusakovich
 */
public class CheckTriggerTask extends BaseTask {

    private final Log log = LogFactory.getLog(CheckTriggerTask.class);
    private final Trigger trigger;
    private final TriggerCondition condition;

    public CheckTriggerTask(Trigger trigger, TriggerCondition condition) {
        this.trigger = trigger;
        this.condition = condition;
    }

    private void setActuatorValue(String address, Object value)
            throws NetworkException, DeviceException {

        NetworkSearchSimplePredicate predicate = new NetworkSearchSimplePredicate();
        predicate.setAddress(address);

        List<Device> devices = this.networkManager.search(predicate);
        for (Device device : devices) {
            ((Actuator) device).setState(value);
        }
    }

    @Override
    public void execute() {
        if (log.isDebugEnabled()) {
            log.debug("checking trigger: " + trigger.getName());
        }

        try {
            if (!trigger.isEnabled()) {
                return;
            }

            boolean result = condition.getResult();
            if (result) {
                if (trigger instanceof ActuatorTrigger) {
                    ActuatorTrigger actTrigger = (ActuatorTrigger) trigger;

                    String address = actTrigger.getActuatorAddress();
                    Object value = actTrigger.getActuatorValue();

                    setActuatorValue(address, value);
                    return;
                }
            }

        } catch (Exception ex) {
            log.error("Error while trigger checking", ex);
        }
    }
}
