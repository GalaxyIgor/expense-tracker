package dev.galaxy.expensetracker.repository;

import dev.galaxy.expensetracker.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {
    // Lista de despesas
    private List<Expense> expenses = new ArrayList<>();

    // Add
    public void save(Expense expense) {
        expenses.add(expense);
    }

    // Lista Completa
    public List<Expense> findAll() {
        return new ArrayList<>(expenses);
    }

    // Remove
    public boolean delete(int index) {
        if(index >= 0 && index < expenses.size()){
            expenses.remove(index);
            return true;
        }
        return false;
    }
}
