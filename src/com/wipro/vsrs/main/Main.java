package com.wipro.vsrs.main; 
 
import java.util.ArrayList; 
import com.wipro.vsrs.entity.*; 
import com.wipro.vsrs.service.VehicleServiceRecordService; 
import com.wipro.vsrs.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
 
        ArrayList<Vehicle> vehicles = new ArrayList<>(); 
        vehicles.add(new Vehicle("TN10AX1234", "Praveen Kumar", "Honda City")); 
        vehicles.add(new Vehicle("TN22BB9876", "Lakshmi Devi", "Hyundai Creta")); 
 
        ArrayList<ServiceRecord> services = new ArrayList<>(); 
 
        VehicleServiceRecordService service = new VehicleServiceRecordService(vehicles, services); 
 
        try { 
            // Create service record 
            ArrayList<PartUsed> parts1 = new ArrayList<>(); 
            parts1.add(new PartUsed("Oil Filter", 450)); 
            parts1.add(new PartUsed("Engine Oil", 1200)); 
 
            ServiceRecord sr1 = new ServiceRecord( "S001", "TN10AX1234", "2025-08-10", "General service and engine oil replacement", 1500, parts1, 0 ); 
 
            service.addServiceRecord(sr1); 
 
            // Update charges 
            service.updateServiceCharges("S001", 1800); 
 
            // Service history 
            System.out.println("--- Service History for TN10AX1234 ---"); 
            for (ServiceRecord r : service.getServiceHistory("TN10AX1234")) { 
                System.out.println(r.getNotes()); 
            } 
 
            // Summary 
            System.out.println("\n--- Vehicle Summary ---"); 
            System.out.println(service.generateServiceSummary("TN10AX1234")); 
 
        } catch (Exception ex) { 
            System.out.println(ex); 
        } 
    } 
} 
