/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ginger.smarthome.network.predicate;

import by.ginger.smarthome.provider.device.DeviceType;

/**
 *
 * @author rusakovich
 */
public interface PredicateVisitor {

    public String getAddress(NetworkSearchPredicate predicate);

    public String getLabel(NetworkSearchPredicate predicate);

    public DeviceType getDeviceType(NetworkSearchPredicate predicate);

    public boolean getSignaling(NetworkSearchPredicate predicate);

}
