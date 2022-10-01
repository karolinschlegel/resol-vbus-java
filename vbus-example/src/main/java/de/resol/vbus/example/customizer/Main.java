/**
 * Copyright (C) 2008-2016, RESOL - Elektronische Regelungen GmbH.
 * Copyright (C) 2016, Daniel Wippermann.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package de.resol.vbus.example.customizer;

import java.net.InetAddress;
import java.util.TimeZone;

import de.resol.devices.OventropRegumaqX45;
import de.resol.vbus.ConfigurationOptimizer;
import de.resol.vbus.ConfigurationOptimizerFactory;
import de.resol.vbus.ConfigurationValue;
import de.resol.vbus.Connection;
import de.resol.vbus.ConnectionAdapter;
import de.resol.vbus.ConnectionCustomizer;
import de.resol.vbus.Datagram;
import de.resol.vbus.Packet;
import de.resol.vbus.RosApp;
import de.resol.vbus.TcpDataSource;
import de.resol.vbus.TcpDataSourceProvider;
import de.resol.vbus.configurationoptimizers.OventropRegumaqX45ConfigurationOptimizer;

public class Main {

	public static void main(String[] args) {
		try {
			Connection connection;
			
			// Create a connection to a LAN-enabled VBus device
			TcpDataSource dataSource = TcpDataSourceProvider.fetchInformation(InetAddress.getByName("192.168.50.249"), 500);
			dataSource.setLivePassword("vbus");
			connection = dataSource.connectLive(0, 0x0020);
			
			// Add a listener to the Connection to monitor state changes
			connection.addListener(new ConnectionAdapter() {
				
				@Override
				public void connectionStateChanged(Connection connection) {
					System.out.println("connection@connectionStateChanged: " + connection.getConnectionState());
				}
				
				@Override
				public void packetReceived(Connection connection, Packet packet) {
					System.out.println("connection@packetReceived: " + packet.getId());
				}
				
				@Override
				public void datagramReceived(Connection connection, Datagram dgram) {
					System.out.println("connection@datagramReceived: " + dgram.getId());
				}
								
			});
			
			// Establish the connection
			connection.connect();
		
			// Wait for the bus offering to get the address of the master device connected to the VBus
			Datagram dgram = connection.waitForFreeBus(20000);
			if (dgram != null) {
				int deviceAddress = dgram.getSourceAddress();
				
				// Try to create on optimizer for the master device
				ConfigurationOptimizer optimizer = ConfigurationOptimizerFactory.matchOptimizer(deviceAddress, null, null);
				
				// Create a Customizer using the established connection
				ConnectionCustomizer customizer = new ConnectionCustomizer(deviceAddress, optimizer, connection);
				
				// Read the values from the master device
				ConfigurationValue[] values = customizer.loadConfiguration(null, true);
				
				// Print the read out values
				for (int i = 0; i < values.length; i++) {
					ConfigurationValue value = values [i];

					System.out.println(value.getValueId() + ": " + value.getValue());
				}
				
				// Generate the set of configuration values to set the clock
				//values = optimizer.generateClockConfiguration(System.currentTimeMillis(), TimeZone.getDefault());
				
				OventropRegumaqX45ConfigurationOptimizer regu = (OventropRegumaqX45ConfigurationOptimizer) optimizer;
				
				//values = regu.setAdjustableValuesRelais(0);
				//customizer.saveConfiguration(values, null, false);
				
				//values = regu.setAdjustableValuesWater(350);
				//customizer.saveConfiguration(values, null, false);
				

				OventropRegumaqX45 x45 = new OventropRegumaqX45(values, customizer);
				x45.setWarmwasserTSoll(45);
				x45.setRelais0Handbetrieb(RosApp.Handbetrieb.Auto);
				System.out.println("New:");
				for (int i = 0; i < values.length; i++) {
					ConfigurationValue value = values [i];

					System.out.println(value.getValueId() + ": " + value.getValue());
				}
			}
			
			// Disconnect the connection
			connection.disconnect();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

}
