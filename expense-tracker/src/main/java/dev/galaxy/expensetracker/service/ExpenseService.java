package dev.galaxy.expensetracker.service;

import dev.galaxy.expensetracker.model.Expense;
import dev.galaxy.expensetracker.repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.List;

public class ExpenseService {
    private ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addExpense(String description, double amount, String category) {
        if (amount <= 0) {
            System.out.println("Erro: O valor deve ser maior que zero!");
            return;
        }
        Expense newExpense = new Expense(description, amount, category);
        repository.save(newExpense);
    }

    // Calcular o total acumulado
    public double calculateTotal() {
        List<Expense> allExpenses = repository.findAll();
        double total = 0;
        for (Expense e : allExpenses) {
            total += e.getAmount();
        }
        return total;
    }

    // Apenas repassa a listagem
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }
}
