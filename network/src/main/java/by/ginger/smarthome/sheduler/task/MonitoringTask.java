/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ginger.smarthome.sheduler.task;

import by.ginger.smarthome.network.predicate.NetworkSearchSimplePredicate;
import by.ginger.smarthome.provider.device.Device;
import by.ginger.smarthome.provider.device.sensor.PlainSensor;
import by.ginger.smarthome.provider.device.sensor.Sensor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author rusakovich
 */
public class MonitoringTask extends BaseTask {

    private final Sensor sensor;
    private final Log log = LogFactory.getLog(MonitoringTask.class);

    public MonitoringTask(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void execute() {

        try {
            NetworkSearchSimplePredicate predicate = new NetworkSearchSimplePredicate();
            predicate.setAddress(sensor.getAddress());

            final Device device = networkManager.search(predicate).get(0);

            System.out.println(sensor.getLabel());

            if (log.isDebugEnabled()) {
                log.debug("Task monitor executing");
            }

            PlainSensor plain = (PlainSensor) sensor;

            if (device instanceof Sensor) {
                Sensor current = (Sensor) device;

                log.info(current.getLabel() + ":" + current.getValue());

                plain.setValue(current.getValue());
            }
        } catch (Exception ex) {
            log.error(ex);
        }
    }

}
