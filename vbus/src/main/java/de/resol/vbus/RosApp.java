package de.resol.vbus;

public class RosApp {
	public enum AktorNr {
		None (0),
		R1(1),
		R2(2),
		R3(3),
		R4(4),
		R5(5),
		A1(6),
		A2(7),
		A3(8),
		A4(9),
		LIN(10);

		private final int aktorNr;
		AktorNr(int aktorNr) {
			this.aktorNr = aktorNr;
 		}

		public int getValue() {
			return aktorNr;
		}
	}
	
	public enum Boolean {
		No(0),
		Yes(1);

		private final int boolVal;
		Boolean(int boolVal) {
			this.boolVal = boolVal;
		}
		
		public int getValue() {
			return boolVal;
		}
	}
	
	public enum DisplayMode {
		Dark(0),
		Light(1);

		private final int displayMode;
		DisplayMode(int displayMode) {
			this.displayMode = displayMode;
		}
		
		public int getValue() {
			return displayMode;
		}
	}
	
	public enum FehlerFehler {
		AllesInOrdnung(0),
		SensorS1(1),
		SensorS2(2),
		SensorS3(3),
		SensorS4(4),
		SensorS5(5),
		SensorS6(6),
		SensorS7(7),
		SensorS8(8),
		SensorGFA1(9),
		SensorGFA2(10),
		SensordV(11),
		SensorDip(12),
		DatumUhrzeit(13),
		KommunikationsausfallVBus(14),
		KommunikationsausfallUplink(15),
		KommunikationsausfallLin(16),
		PumpenfehlerLin(17),
		ThDes_SensorDefekt(18),
		ThDes_TemperaturZuNiedrig(19),
		ThDes_TemperaturGesunken(20),
		ThDes_Keinvolumenstrom(21),
		ThDes_Erfolgreich(22),
		MagicMismatch(23),
		NotbetriebAktiv(24);

		private final int fehlerFehler;
		FehlerFehler(int fehlerFehler) {
			this.fehlerFehler = fehlerFehler;
		}
		
		public int getValue() {
			return fehlerFehler;
		}
	}
	
	public enum FehlerrelaisActivated_Vars {
		Deactivated(0),
		Activated(1);

		private final int fehlerrelaisActivatedVars;
		FehlerrelaisActivated_Vars(int fehlerrelaisActivatedVars) {
			this.fehlerrelaisActivatedVars = fehlerrelaisActivatedVars;
		}
		
		public int getValue() {
			return fehlerrelaisActivatedVars;
		}
	}
	
	public enum FunktionsblockActivated_Th {
		Deactivated(0),
		Activated(1);

		private final int funktionsblockActivatedTh;
		FunktionsblockActivated_Th(int funktionsblockActivatedTh) {
			this.funktionsblockActivatedTh = funktionsblockActivatedTh;
		}
		
		public int getValue() {
			return funktionsblockActivatedTh;
		}
	}
	
	public enum FunktionsblockActivated_Timer {
		Deactivated(0),
		Activated(1);

		private final int funktionsblockActivatedTimer;
		FunktionsblockActivated_Timer(int funktionsblockActivatedTimer) {
			this.funktionsblockActivatedTimer = funktionsblockActivatedTimer;
		}
		
		public int getValue() {
			return funktionsblockActivatedTimer;
		}
	}
	
	public enum FunktionsblockActivated_Vars {
		Deactivated(0),
		Activated(1);

		private final int funktionsblockActivatedVars;
		FunktionsblockActivated_Vars(int funktionsblockActivatedVars) {
			this.funktionsblockActivatedVars = funktionsblockActivatedVars;
		}
		
		public int getValue() {
			return funktionsblockActivatedVars;
		}
	}
	
	public enum FunktionsblockActivated_dT {
		Deactivated(0),
		Activated(1);

		private final int funktionsblockActivatedDT;
		FunktionsblockActivated_dT(int funktionsblockActivatedDT) {
			this.funktionsblockActivatedDT = funktionsblockActivatedDT;
		}
		
		public int getValue() {
			return funktionsblockActivatedDT;
		}
	}
	
	public enum Handbetrieb {
		Aus(0),
		Min(1),
		Auto(2),
		Max(3),
		Ein(4);

		private final int handbetrieb;
		
		Handbetrieb(int handbetrieb) {
			this.handbetrieb = handbetrieb;
		}
		
		public int getValue() {
			return handbetrieb;
		}
	}
	
	public enum Language {
		En(0),
		De(1),
		Fr(2);
		
		private final int language;
		Language(int language) {
			this.language = language;
		}
		
		public int getValue() {
			return language;
		}
	}
	
	public enum NachheizungActivated_Vars {
		Deactivated(0),
		Activated(1);

		private final int nachheizungActivatedVars;
		NachheizungActivated_Vars(int nachheizungActivatedVars) {
			this.nachheizungActivatedVars = nachheizungActivatedVars;
		}
		
		public int getValue() {
			return nachheizungActivatedVars;
		}
	}
	
	public enum NachheizungModus {
		Festwert(0),
		Zonenladung(1);
		
		private final int nachheizungModus;
		NachheizungModus(int nachheizungModus) {
			this.nachheizungModus = nachheizungModus;
		}
		
		public int getValue() {
			return nachheizungModus;
		}
	}
	
	public enum ParallelrelaisActivated_Vars {
		Deactivated(0),
		Activated(1);

		private final int parallelrelaisActivatedVars;
		ParallelrelaisActivated_Vars(int parallelrelaisActivatedVars) {
			this.parallelrelaisActivatedVars = parallelrelaisActivatedVars;
		}
		
		public int getValue() {
			return parallelrelaisActivatedVars;
		}
	}
	
	public enum ParallelrelaisModus {
		AND(0),
		OR(1);

		private final int parallelrelaisModus;
		ParallelrelaisModus(int parallelrelaisModus) {
			this.parallelrelaisModus = parallelrelaisModus;
		}
		
		public int getValue() {
			return parallelrelaisModus;
		}
	}
	
	public enum RLEinschichtungAchtivated_Vars{
		Deactivated(0),
		Activated(1);

		private final int rlEinschichtungAchtivatedVars;
		RLEinschichtungAchtivated_Vars(int rlEinschichtungAchtivatedVars) {
			this.rlEinschichtungAchtivatedVars = rlEinschichtungAchtivatedVars;
		}
		
		public int getValue() {
			return rlEinschichtungAchtivatedVars;
		}
	}
	
	public enum SDKarteLogMethode {
		Linear(0),
		Zyklisch(1);
		
		private final int sdKarteLogMethode;
		SDKarteLogMethode(int sdKarteLogMethode) {
			this.sdKarteLogMethode = sdKarteLogMethode;
		}
		
		public int getValue() {
			return sdKarteLogMethode;
		}
	}
	
	public enum SensorNr {
		None(0),
		S1(1),
		S2(2),
		S3(3),
		S4(4),
		S5(5),
		S6(6),
		S7(7),
		S8(8),
		Gfa1(9),
		Gfa2(10),
		Sika(11);
		
		private final int sensorNr;
		SensorNr(int sensorNr) {
			this.sensorNr = sensorNr;
		}
		
		public int getValue() {
			return sensorNr;
		}
	}
	
	public enum WarmwasserActivated_Komfort {
		Deactivated(0),
		Activated(1);

		private final int warmwasserActivatedKomfort;
		WarmwasserActivated_Komfort(int warmwasserActivatedKomfort) {
			this.warmwasserActivatedKomfort = warmwasserActivatedKomfort;
		}
		
		public int getValue() {
			return warmwasserActivatedKomfort;
		}
	}
	
	public enum WarmwasserActivated_Notbetrieb {
		Deactivated(0),
		Activated(1);

		private final int warmwasserActivatedNotbetrieb; 
		WarmwasserActivated_Notbetrieb(int warmwasserActivatedNotbetrieb) {
			this.warmwasserActivatedNotbetrieb = warmwasserActivatedNotbetrieb;
		}
		
		public int getValue() {
			return warmwasserActivatedNotbetrieb;
		}
	}
	
	public enum ZirkulationVars {
		Aus(0),
		Anforderung(1),
		Thermisch(2),
		Dauerbetrieb(3),
		Timer(4);
		
		private final int zirkulationVars;
		ZirkulationVars(int zirkulationVars) {
			this.zirkulationVars = zirkulationVars;
		}
		
		public int getValue() {
			return zirkulationVars;
		}
	}

}
