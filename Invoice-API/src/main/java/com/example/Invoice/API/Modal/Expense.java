package com.example.Invoice.API.Modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@Entity
@Table(name = "companyexpenses")
public class Expense {

//    @Setter
//    @Getter
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotEmpty(message = "Expense type is required")
//    @Column(name = "expense_type")  // Explicit column name mapping
//    private String expenseType;
//
//    @NotEmpty(message = "Expense description is required")
//    @Column(name = "expense_description")  // Explicit column name mapping
//    private String expenseDescription;
//
//    @NotNull(message = "Expense amount is required")
//    @Column(name = "expense_amount")  // Explicit column name mapping
//    private Double expenseAmount;
//
//    @Setter
//    @Getter
//    @Column(nullable = false, unique = true)
//    private String invoiceNumber; // Added invoice number field
//
//    @PrePersist
//    public void generateInvoiceNumber() {
//        this.invoiceNumber = "INV-" + System.currentTimeMillis() + "-" + (int) (Math.random() * 10000);
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Expense type is required")
    @Column(name = "expense_type")
    private String expenseType;

    @NotEmpty(message = "Expense description is required")
    @Column(name = "expense_description")
    private String expenseDescription;

    @NotNull(message = "Expense amount is required")
    @Column(name = "expense_amount")
    private Double expenseAmount;

    @Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;

    @PrePersist
    public void prePersist() {
        if (this.invoiceNumber == null || this.invoiceNumber.isEmpty()) {
            this.invoiceNumber = generateInvoiceNumber();
        }
    }

    private String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String datePart = dateFormat.format(new Date());
        String randomPart = String.format("%04d", (int) (Math.random() * 10000));
        return "INV-" + datePart + "-" + randomPart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Expense type is required") String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(@NotEmpty(message = "Expense type is required") String expenseType) {
        this.expenseType = expenseType;
    }

    public @NotEmpty(message = "Expense description is required") String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(@NotEmpty(message = "Expense description is required") String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public @NotNull(message = "Expense amount is required") Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(@NotNull(message = "Expense amount is required") Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
