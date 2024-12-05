package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Suppliers> getAllSuppliers() {
        return this.supplierRepository.findAll();
    }

    public Suppliers getSupplierById(int id) {
        return this.supplierRepository.findById(id).orElse(null);
    }

    public Suppliers addSupplier(Suppliers suppliers) {
        Suppliers s = new Suppliers();
        s.setSupplierID(suppliers.getSupplierID());
        s.setCompanyName(suppliers.getCompanyName());
        s.setContactName(suppliers.getContactName());
        s.setContactTitle(suppliers.getContactTitle());
        s.setAddress(suppliers.getAddress());
        s.setCity(suppliers.getCity());
        s.setRegion(suppliers.getRegion());
        s.setPostalCode(suppliers.getPostalCode());
        s.setCountry(suppliers.getCountry());
        s.setPhone(suppliers.getPhone());
        s.setFax(suppliers.getFax());
        s.setHomePage(suppliers.getHomePage());
        return this.supplierRepository.save(s);
    }

    public Suppliers updateSupplier(int id, Suppliers suppliers) {
        Suppliers s = getSupplierById(id);
        s.setCompanyName(suppliers.getCompanyName());
        s.setContactName(suppliers.getContactName());
        s.setContactTitle(suppliers.getContactTitle());
        s.setAddress(suppliers.getAddress());
        s.setCity(suppliers.getCity());
        s.setRegion(suppliers.getRegion());
        s.setPostalCode(suppliers.getPostalCode());
        s.setCountry(suppliers.getCountry());
        s.setPhone(suppliers.getPhone());
        s.setFax(suppliers.getFax());
        s.setHomePage(suppliers.getHomePage());
        return this.supplierRepository.save(s);
    }

    public void delete(int id) {
        this.supplierRepository.deleteById(id);
    }
}
