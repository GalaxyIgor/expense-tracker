package dev.galaxy.expensetracker.repository;

import dev.galaxy.expensetracker.config.DatabaseConfig;
import dev.galaxy.expensetracker.model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {

    public void save(Expense expense) {
        String sql = "INSERT INTO expenses (description, amount, category, date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, expense.getDescription());
            pstmt.setDouble(2, expense.getAmount());
            pstmt.setString(3, expense.getCategory());
            pstmt.setDate(4, Date.valueOf(expense.getDate()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Expense> findAll() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Expense exp = new Expense(
                        rs.getString("description"),
                        rs.getDouble("amount"),
                        rs.getString("category")
                );
                expenses.add(exp);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar dados: " + e.getMessage());
        }
        return expenses;
    }
}