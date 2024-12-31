package com.example.Invoice.API.Repository;

import com.example.Invoice.API.Modal.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, Long> {

}
