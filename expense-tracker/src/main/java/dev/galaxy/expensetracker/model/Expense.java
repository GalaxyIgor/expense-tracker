package dev.galaxy.expensetracker.model;

import java.time.LocalDate;

public class Expense {
    private String description;
    private double amount;
    private String category;
    private LocalDate date;

    // Construtor
    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = java.time.LocalDate.now();
    }

    // Getters (para ler os dados)
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return String.format("[%s] %s: R$ %.2f (%s)", date, description, amount, category);
    }
}
