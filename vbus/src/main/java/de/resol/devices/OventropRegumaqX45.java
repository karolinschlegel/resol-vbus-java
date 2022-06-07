package de.resol.devices;

import de.resol.vbus.ConfigurationValue;
import de.resol.vbus.Customizer;
import de.resol.vbus.RosApp;
import de.resol.vbus.configurationoptimizers.OventropRegumaqX45ConfigurationOptimizer;

public class OventropRegumaqX45 extends OventropRegumaqX45ConfigurationOptimizer {
	private ConfigurationValue[] configurationValues;
	private Customizer customizer;
	
	private int search(String valueID) throws Exception {
		for (int i = 0; i < configurationValues.length; i++) {
			if (configurationValues[i].getValueId() == valueID) {
				return i;
			}
		}
		throw new Exception("Value not found for " + valueID);
	}
	
	public OventropRegumaqX45(ConfigurationValue[] configurationValues, Customizer customizer) {
		this.configurationValues = configurationValues;
		this.customizer = customizer;
	}
	
	public ConfigurationValue[] getValues() {
		return configurationValues;
	}
	
	public int getWarmwasserTSoll() {
		try {
			int index = search("WarmwasserTSoll");
			return configurationValues[index].getValue();
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
	public void setWarmwasserTSoll(int temp) {
		int index;
		try {
			index = search("WarmwasserTSoll");
			int currentVal = configurationValues[index].getValue();
			if (currentVal != temp*10) {
				this.configurationValues[index].setValue(temp*10);
				customizer.saveConfiguration(configurationValues, null, false);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public int getRelais0Handbetrieb() {
		try {
			int index = search("Relais0Handbetrieb");
			return configurationValues[index].getValue();
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
	public void setRelais0Handbetrieb(RosApp.Handbetrieb ident) {
		int index;
		try {
			index = search("Relais0Handbetrieb");
			int currentVal = configurationValues[index].getValue();
			if (currentVal != ident.getValue()) {
				this.configurationValues[index].setValue(ident.getValue());
				customizer.saveConfiguration(configurationValues, null, false);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
